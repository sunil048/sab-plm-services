package com.sabtok.plm.exception;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class HystrixExceptionDecoder {

    private Logger log = LogManager.getLogger(this.getClass());

    public ExceptionObject handleHistrixExacption(HystrixRuntimeException e) {
        if (e.getCause() instanceof FeignException) {
            FeignException feignException = (FeignException) e.getCause();
            return this.getMessageFromFeignException(feignException);
        } else {
            return this.createGenericException(500, Collections.singleton(e.getMessage()));
        }
    }

    private ExceptionObject createGenericException(int errorCode, Set<String> errors) {
        return new ExceptionObject(errorCode,errors);
    }

    private ExceptionObject getMessageFromFeignException(FeignException feignException) {

        if (feignException.status() == 404){
            return this.createGenericException(feignException.status(),Collections.singleton(feignException.getMessage()));
        } else {
            byte[] content = feignException.contentUTF8().getBytes();
            if (content == null) {
                return this.getFException(feignException);
            } else {
                return this.createGenericException(feignException.status(),Collections.singleton(feignException.getMessage()));
            }
        }
    }

    private ExceptionObject getFException(FeignException feignException) {

        return feignException.getMessage() != null ? this.createGenericException(feignException.status(),Collections.singleton(feignException.getMessage()))
                : this.createGenericException(feignException.status(), Collections.singleton(feignException.getCause() != null
        && feignException.getMessage() != null ?feignException.getCause().getMessage() : "UNKNOWN"));
    }
}
