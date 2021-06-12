package net.codejava.ws;

import javax.xml.ws.Endpoint;

public class WebServiceServer {

    public static void main(String[] args) {
        String uri= "http://localhost:12123/webLogin/enterName";
        System.out.println("Hello World!");
        WebLogin webLogin = new WebLogin();
        Endpoint.publish(uri, webLogin.login("eiei","1234"));

        System.out.println("Web service start " + uri);
    }
}
