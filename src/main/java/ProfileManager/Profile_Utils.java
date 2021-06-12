package ProfileManager;

import DatabaseManager.DatabaseService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import model.Profile;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.getInstance;

public class Profile_Utils {
    public static void createProfile(Profile profile){
        BasicDBObject query = new BasicDBObject();
        try {
            Calendar calendar = getInstance();
            Date date = calendar.getTime();
            calendar.setTime(date);
            calendar.add(HOUR_OF_DAY, 25);

            query.put("_id", profile.getEmail());
            query.put("email", profile.getEmail());
            query.put("role", profile.getRole());
            query.put("firstName", profile.getFirstName());
            query.put("lastName", profile.getLastName());
            query.put("address", profile.getAddress());
            query.put("tel", profile.getTel());
            query.put("password", profile.getPassword());

            query.put("updateDate", date);
            query.put("createDate", date);
        } catch (Exception e) {
            System.out.println("mongo error");
        }
        DatabaseService.createProfile(query);
    }

    public static void updateProfile(Profile profile){
        BasicDBObject query = new BasicDBObject();
        DBObject mod = new BasicDBObject();
        BasicDBObject onInsert = new BasicDBObject();
        try {
            Calendar calendar = getInstance();
            Date date = calendar.getTime();
            calendar.setTime(date);

            query.put("email", profile.getEmail());

            BasicDBObject set = new BasicDBObject();
            set.put("role", profile.getRole());
            set.put("firstName", profile.getFirstName());
            set.put("lastName", profile.getLastName());
            set.put("updateDate", date);
            set.put("address", profile.getAddress());
            set.put("tel", profile.getTel());
            set.put("password", profile.getPassword());

            onInsert.put("createDate", date);
            onInsert.put("_id", profile.getEmail());

            mod.put("$set", set);
            mod.put("$setOnInsert", onInsert);

        } catch (Exception e) {
            System.out.println("mongo error");
        }
        DatabaseService.updateProfile(query, mod);
    }

    public static void deleteProfile(String email) {
        BasicDBObject query = new BasicDBObject();
        query.put("email", email);
        DatabaseService.deleteProfile(query);
    }

    public static Profile readProfile(String email){
        BasicDBObject query = new BasicDBObject();
        query.put("email", email);
        return DatabaseService.readProfile(query);
    }
}
