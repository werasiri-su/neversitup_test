package DatabaseManager;

import com.mongodb.*;
import com.mongodb.MongoClientOptions.Builder;

import static com.mongodb.MongoClientOptions.builder;
import static com.mongodb.MongoCredential.createCredential;
import static java.util.Collections.singletonList;

public class DatabaseManager {
    public static MongoClient mongoClient;

    public DatabaseManager() {
        try {
            System.out.println("[CONNECTION] Check connection MongoDB : NOT_FOUND");
            String[] dbURLSplit = "localhost:27017".split(":");;
            String username = "test";
            String password = "1234";
            String url = dbURLSplit[0];
            int port = Integer.parseInt(dbURLSplit[1]);
            int connectTimeout = 2000;
            int selectTimeout = 2000;
            int socketTimeout = 2000;
            String databaseName = "dbName";
            Builder optionsBuilder = builder()
                    .connectTimeout(connectTimeout)
                    .serverSelectionTimeout(selectTimeout)
                    .socketTimeout(socketTimeout)
                    .minConnectionsPerHost(0)
                    .connectionsPerHost(1000)
                    .threadsAllowedToBlockForConnectionMultiplier(10000);
            MongoClientOptions options = optionsBuilder.build();
/*            AFLog.d("[CONNECTION] username : " + username + " , password : " + password);
            MongoCredential credential = createCredential(username, databaseName, password.toCharArray());
            mongoClient = new MongoClient(new ServerAddress(url, port), singletonList(credential), options);*/

            System.out.println("[CONNECTION] username : " + username + " , password : " + password);
            MongoCredential credential = createCredential(username, databaseName, password.toCharArray());
            mongoClient = new MongoClient(new ServerAddress(url, port), singletonList(credential), options);
            mongoClient.getDB(databaseName).getCollectionNames();
            System.out.println("[CONNECTION] Connect Mongodb success .");
        } catch (MongoSecurityException e) {
            System.out.println("[CONNECTION] Connect Mongodb wrong user or password - " + e.getStackTrace()[0]);
        } catch (Exception e) {
            System.out.println("[CONNECTION] Connect Mongodb Error  - " + e.getStackTrace()[0]);
        }
    }

    public static MongoClient getMongoClient() {
        new DatabaseManager();
        return mongoClient;
    }

}
