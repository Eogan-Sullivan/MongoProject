import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class mongoOperation {
	
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;
	public mongoOperation() {
		
		mongoClient = new MongoClient();
	}
	
	public mongoOperation(String dbName, String collectionName) {
		 
		mongoClient = new MongoClient();
		database = mongoClient.getDatabase(dbName);
		collection = database.getCollection(collectionName);
		
		
	}
	
	
	public void Create(String _id, String summary,String email, Boolean resolved ){
		
			Document doc = new Document("_id",_id)
						.append("summary", summary)
						.append("email",email)
						.append("resolved",resolved);
			
			collection.insertOne(doc);
	}
	
	public void Read()
	{
		collection.find();
	}

}
