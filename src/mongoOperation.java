import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class mongoOperation {
	
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;
	Document doc;
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
	
	public void Read(String value)
	{
		//collection.find();
		
	}
	
	public void Update(Document Updateddoc) {
		
	//	collection.updateOne(doc, Updateddoc);
		
		
	}
	
	public void Delete() {
		
		collection.deleteOne(doc);
		
	}

}
