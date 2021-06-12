package OrderManager;

import DatabaseManager.DatabaseService;
import model.Order;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.getInstance;
import static utils.GlobalUtils.getHostName;

public class Order_Utils {
    public static void createOrder(Order order){
        BasicDBObject query = new BasicDBObject();
        try {
            Calendar calendar = getInstance();
            Date date = calendar.getTime();
            calendar.setTime(date);
            calendar.add(HOUR_OF_DAY, 25);
            String host = getHostName();

            query.put("_id", order.getOrderNo());
            query.put("orderNo", order.getOrderNo());
            query.put("email", order.getEmail());
            query.put("product", order.getProductIds());
            query.put("totalPrice", order.getTotalPrice());
            query.put("status", order.getStatus());

            query.put("updateDate", date);
            query.put("createDate", date);
        } catch (Exception e) {
            System.out.println("mongo error");
        }
        DatabaseService.createOrder(query);
    }

    public static void updateOrder(Order order){
        BasicDBObject query = new BasicDBObject();
        DBObject mod = new BasicDBObject();
        BasicDBObject onInsert = new BasicDBObject();
        try {
            Calendar calendar = getInstance();
            Date date = calendar.getTime();
            calendar.setTime(date);

            query.put("orderNo", order.getOrderNo());
            query.put("email", order.getEmail());

            BasicDBObject set = new BasicDBObject();
            set.put("productId", order.getProductIds());
            set.put("totalPrice", order.getTotalPrice());
            set.put("status", order.getStatus());
            set.put("updateDate", date);

            onInsert.put("createDate", date);
            onInsert.put("_id", order.getOrderNo());

            mod.put("$set", set);
            mod.put("$setOnInsert", onInsert);

        } catch (Exception e) {
            System.out.println("mongo error");
        }
        DatabaseService.updateOrder(query, mod);
    }

    public static void deleteOrder(String orderNo) {
        BasicDBObject query = new BasicDBObject();
        query.put("orderNo", orderNo);
        DatabaseService.deleteOrder(query);
    }

    public static Order findHistoryOrder(String email){
        BasicDBObject query = new BasicDBObject();
        query.put("email", email);
        return DatabaseService.readOrder(query);
    }

    public static Order readOrder(String orderNo){
        BasicDBObject query = new BasicDBObject();
        query.put("orderNo", orderNo);
        return DatabaseService.readOrder(query);
    }
}
