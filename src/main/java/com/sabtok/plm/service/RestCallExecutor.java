package com.sabtok.plm.service;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.sabtok.plm.exception.ExceptionObject;
import com.sabtok.plm.exception.HystrixExceptionDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Supplier;


@Service
public class RestCallExecutor {

    private Logger log = LogManager.getLogger(this.getClass());

    private HystrixExceptionDecoder hystrixExceptionDecoder;

    public RestCallExecutor(HystrixExceptionDecoder hystrixExceptionDecoder) {
        this.hystrixExceptionDecoder = hystrixExceptionDecoder;
    }

    public <T> T execute(Supplier<T> s, Set<String> errors, boolean throwException, String logPrefix){
        try {
            return s.get();
        } catch (HystrixRuntimeException e) {
            ExceptionObject hystrixErrors = this.hystrixExceptionDecoder.handleHistrixExacption(e);
            return null;
        }
    }

    public <T> T execute(Supplier<T> s) {

        try {
            return s.get();
        } catch (HystrixRuntimeException e) {
            ExceptionObject hystrixErrors = this.hystrixExceptionDecoder.handleHistrixExacption(e);
            return null;
        }
    }
}
