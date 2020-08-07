/**
 * 
 */
package com.sabtok.plm.mongo;

import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.sabtok.plm.PlmException;

/**
 * @author Sunil
 *
 * BaseDAO.java Aug 6, 2020 11:48:28 AM
 */
public interface BaseDAO<T> {

	public List<T> findByQuery(BasicDBObject filter);
	public String insertOne(Document insertDocument) throws PlmException;
	public Object getConnection();
	
}
