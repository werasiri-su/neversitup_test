package utils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class GlobalUtils {
    public static <T> Object getObjectFromJsonString(String gsonString, Class<?> classType) {
        try {
            Gson gson = new Gson();
            Object object = gson.fromJson(gsonString, classType);
            return object;
        } catch (Exception var4) {
            return null;
        }
    }

    public static String getStringJsonFromObject(Object object) {
        try {
            Gson gson = new Gson();
            return gson.toJson(object);
        } catch (Exception var2) {
            return null;
        }
    }

    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            try {
                String hostname;
                Runtime runtime = Runtime.getRuntime();
                Process process = runtime.exec("hostname");
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                hostname = br.readLine();
                process.getErrorStream().close();
                process.getOutputStream().close();
                br.close();
                return hostname;
            } catch (Exception ex) {
                return "UNKNOWN_HOSTNAME";
            }
        }
    }
}
