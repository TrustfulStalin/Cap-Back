import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBExample {
    public static void main(String[] args) {
        // Configure the connection string
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        // Configure MongoClient settings
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        // Create MongoClient
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            // Get database
            MongoDatabase database = mongoClient.getDatabase("mydatabase");

            // Perform operations with the database
            // Example: List all collections
            database.listCollectionNames().forEach(System.out::println);
        }
    }
}