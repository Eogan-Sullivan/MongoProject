import java.awt.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class mongoOperation {
	
	private MongoClient mongoClient;
	private MongoDatabase database;	
	private MongoCollection<Document> collection;
	private Document doc;
	public mongoOperation() {
		
		mongoClient = new MongoClient();
	}
	
	public mongoOperation(String dbName, String collectionName) {		 
		mongoClient = new MongoClient();
		database = mongoClient.getDatabase(dbName);
		collection = database.getCollection(collectionName);
	
	}
	
	public void Create(Document document ){		
			collection.insertOne(document);
	}	
	public Document Read(String summary)
	{

	BasicDBObject query = new BasicDBObject();
	query.put("summary", summary);
    Document document  = collection.find(query).iterator().next();
    return document;
	}
	
	
	public void Update(Document appendedDoc,String id) {
		
	
		BasicDBObject query = new BasicDBObject();
		query.put("_id", id);
	    Document document  = collection.find(query).iterator().next();
	   collection.replaceOne(query, appendedDoc);		
	}
	
	public void Delete(String summary) {
		
		BasicDBObject query = new BasicDBObject();
		query.put("summary", summary);
	    Document document  = collection.find(query).iterator().next();
	    if( document.getBoolean("resolved").booleanValue())
	    {
	    	collection.deleteOne(document);
	    	JOptionPane.showMessageDialog(null,"Notice Deleted");
	    }
	    else
	    	JOptionPane.showMessageDialog(null,"Notice not resolved cannot delete");
	    
		
	}

}
