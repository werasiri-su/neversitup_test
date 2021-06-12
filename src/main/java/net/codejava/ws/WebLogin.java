package net.codejava.ws;

import ProfileManager.Profile_Utils;
import model.Profile;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(serviceName = "webLogin")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class WebLogin {

    @WebMethod(operationName = "login")
    public Boolean login(@WebParam(name = "email") String email, @WebParam(name = "email") String password) {
        Profile profile = Profile_Utils.readProfile(email);
        return profile.getPassword().equals(password);
    }

}
