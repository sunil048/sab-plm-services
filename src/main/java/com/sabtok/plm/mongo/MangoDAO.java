/**
 * 
 */
package com.sabtok.plm.mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sabtok.plm.AppConstants;
import com.sabtok.plm.PlmException;

import antlr.StringUtils;

/**
 * @author Sunil
 *
 * MangoDAO.java Aug 6, 2020 11:50:21 AM
 */
@Repository
public class MangoDAO<T> implements BaseDAO<T> {

	MongoClient connection = null;
	private String dbName;
	private String collectionName;
	
	
	
	public String getCollectionName() {
		return collectionName;
	}


	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}


	public void setConnection(MongoClient connection) {
		this.connection = connection;
	}


	public String getDbName() {
		return dbName;
	}


	public void setDbName(String dbName) {
		this.dbName = dbName;
	}


	/* (non-Javadoc)
	 * @see com.sabtok.plm.mongo.BaseDAO#insertOne(org.bson.Document)
	 */
	@Override
	public String insertOne(Document inputDocument) throws PlmException {
		try{
			Document insertDocument = inputDocument;
			getCollection().insertOne(insertDocument);
		}catch(Exception e) {
			throw new PlmException(e);
		} finally {
			closeConnection();
		}
		return String.format("Uploaded Document %d successfully"+inputDocument.get("_id").toString());
	}

	
	private MongoClient getConnection(String dbName) {
		if (getDbName().equalsIgnoreCase("test"))
			connection = MyMongoClientPool.getConnection(AppConstants.MONGODB);
		else
			connection = MyMongoClientPool.getConnection(AppConstants.MONGODB);
		return connection;
	}
	
	private MongoCollection<Document> getCollection(){
		MongoDatabase dataBase = getConnection().getDatabase(getDbName());
		return dataBase.getCollection(getCollectionName());
	}

	@Override
	public MongoClient getConnection() {
		return connection = connection==null?getConnection(getDbName()):connection;
	}
	
	private void closeConnection() {
		if (connection != null) {
			connection.close();
		}
	}


	/* (non-Javadoc)
	 * @see com.sabtok.plm.mongo.BaseDAO#findByQuery(com.mongodb.BasicDBObject)
	 */
	@Override
	public List<T> findByQuery(BasicDBObject filter) {
		final List<T> reult = new ArrayList<T>();
		try {
			FindIterable<T> documents = (FindIterable<T>) getCollection().find(filter);
			documents.forEach(new Block<T>() {
				/* (non-Javadoc)
				 * @see com.mongodb.Block#apply(java.lang.Object)
				 */
				@Override
				public void apply(T t) {
					reult.add(t);
					
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		return reult;
	}
	
}
