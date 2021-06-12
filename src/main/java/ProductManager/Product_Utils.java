package ProductManager;

import DatabaseManager.DatabaseService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import model.Product;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.getInstance;
import static utils.GlobalUtils.getHostName;

public class Product_Utils {
    public static void createProduct(Product product){
        BasicDBObject query = new BasicDBObject();
        try {
            Calendar calendar = getInstance();
            Date date = calendar.getTime();
            calendar.setTime(date);
            calendar.add(HOUR_OF_DAY, 25);
            String host = getHostName();

            query.put("_id", product.getProductNo());
            query.put("productNo", product.getProductNo());
            query.put("name", product.getName());
            query.put("product", product.getProductNo());
            query.put("totalPrice", product.getPrice());
            query.put("stock", product.getStock());

            query.put("updateBy", host);
            query.put("updateDate", date);
            query.put("createBy", host);
            query.put("createDate", date);
        } catch (Exception e) {
            System.out.println("mongo error");
        }
        DatabaseService.createProduct(query);
    }

    public static void updateProduct(Product product){
        BasicDBObject query = new BasicDBObject();
        DBObject mod = new BasicDBObject();
        BasicDBObject onInsert = new BasicDBObject();
        try {
            Calendar calendar = getInstance();
            Date date = calendar.getTime();
            calendar.setTime(date);
            String host = getHostName();

            query.put("productNo", product.getProductNo());

            BasicDBObject set = new BasicDBObject();
            set.put("name", product.getName());
            set.put("price", product.getPrice());
            set.put("stock", product.getStock());
            set.put("updateBy", host);
            set.put("updateDate", date);

            onInsert.put("createBy", host);
            onInsert.put("createDate", date);
            onInsert.put("_id", product.getProductNo());

            mod.put("$set", set);
            mod.put("$setOnInsert", onInsert);

        } catch (Exception e) {
            System.out.println("mongo error");
        }
        DatabaseService.updateProduct(query, mod);
    }

    public static void deleteProduct(String productNo) {
        BasicDBObject query = new BasicDBObject();
        query.put("productNo", productNo);
        DatabaseService.deleteProduct(query);
    }

    public static Product readProduct(String productNo){
        BasicDBObject query = new BasicDBObject();
        query.put("productNo", productNo);
        return DatabaseService.readProduct(query);
    }
}
