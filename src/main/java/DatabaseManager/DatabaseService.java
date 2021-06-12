package DatabaseManager;

import model.Order;
import model.Product;
import model.Profile;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import utils.GlobalUtils;

import java.util.ArrayList;

public class DatabaseService {
    private static MongoClient mongoClient;
    private static String PROFILE_DB = "profileDB";
    private static String PRODUCT_DB = "productDB";
    private static String ORDER_DB = "orderDB";
    private static String profileCollection = "profile";
    private static String productCollection = "product";
    private static String orderCollection = "order";

    public static void connectDB() {
        if (mongoClient == null) mongoClient = DatabaseManager.getMongoClient();
    }
    //======================model.Profile===========================

    public static void createProfile(BasicDBObject query) {
        connectDB();
        mongoClient.getDB(PROFILE_DB).getCollection(profileCollection).insert(query);
    }

    public static Profile readProfile(BasicDBObject query) {
        Profile profile = null;
        connectDB();
        DBCursor dbCursor = DatabaseManager.mongoClient.getDB(PROFILE_DB).getCollection(profileCollection).find(query);
        if (dbCursor.hasNext()) {
            BasicDBObject res = (BasicDBObject) dbCursor.iterator().next();
            profile = (Profile) GlobalUtils.getObjectFromJsonString(GlobalUtils.getStringJsonFromObject(res), Profile.class);
            dbCursor.close();
        }
        return profile;
    }

    public static void updateProfile(BasicDBObject query, DBObject mod) {
        connectDB();
        mongoClient.getDB(PROFILE_DB).getCollection(profileCollection).update(query, mod, true, false);
    }

    public static void deleteProfile(BasicDBObject query) {
        connectDB();
        mongoClient.getDB(PROFILE_DB).getCollection(profileCollection).remove(query);
    }

    //======================model.Product===========================

    public static void createProduct(BasicDBObject query) {
        connectDB();
        mongoClient.getDB(PRODUCT_DB).getCollection(productCollection).insert(query);
    }

    public static void updateProduct(BasicDBObject query, DBObject mod) {
        connectDB();
        mongoClient.getDB(PRODUCT_DB).getCollection(productCollection).update(query, mod, true, false);
    }

    public static void deleteProduct(BasicDBObject query) {
        connectDB();
        mongoClient.getDB(PRODUCT_DB).getCollection(productCollection).remove(query);
    }

    public static ArrayList<Product> listAllProduct() {
        ArrayList<Product> productlist = new ArrayList<Product>();
        connectDB();
        DBCursor dbCursor = DatabaseManager.mongoClient.getDB(PRODUCT_DB).getCollection(productCollection).find();
        while (dbCursor.hasNext()) {
            BasicDBObject res = (BasicDBObject) dbCursor.iterator().next();
            Product product = (Product) GlobalUtils.getObjectFromJsonString(GlobalUtils.getStringJsonFromObject(res), Product.class);
            productlist.add(product);
        }
        dbCursor.close();
        return productlist;
    }

    public static Product readProduct() {
        Product product = null;
        connectDB();
        DBCursor dbCursor = DatabaseManager.mongoClient.getDB(PRODUCT_DB).getCollection(productCollection).find();
        if (dbCursor.hasNext()) {
            BasicDBObject res = (BasicDBObject) dbCursor.iterator().next();
            product = (Product) GlobalUtils.getObjectFromJsonString(GlobalUtils.getStringJsonFromObject(res), Product.class);
            dbCursor.close();
        }
        return product;
    }

    //======================model.Order===========================

    public static void createOrder(BasicDBObject query) {
        connectDB();
        mongoClient.getDB(ORDER_DB).getCollection(orderCollection).insert(query);
    }

    public static Order readOrder(BasicDBObject query) {
        Order order = null;
        connectDB();
        DBCursor dbCursor = DatabaseManager.mongoClient.getDB(ORDER_DB).getCollection(orderCollection).find(query);
        if (dbCursor.hasNext()) {
            BasicDBObject res = (BasicDBObject) dbCursor.iterator().next();
            order = (Order) GlobalUtils.getObjectFromJsonString(GlobalUtils.getStringJsonFromObject(res), Order.class);
            dbCursor.close();
        }
        return order;
    }

    public static void updateOrder(BasicDBObject query, DBObject mod) {
        connectDB();
        mongoClient.getDB(ORDER_DB).getCollection(orderCollection).update(query, mod, true, false);
    }

    public static void deleteOrder(BasicDBObject query) {
        connectDB();
        mongoClient.getDB(ORDER_DB).getCollection(orderCollection).remove(query);
    }

}

