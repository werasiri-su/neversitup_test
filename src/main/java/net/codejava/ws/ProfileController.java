package net.codejava.ws;

import OrderManager.Order_Utils;
import ProfileManager.Profile_Utils;
import model.Profile;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(serviceName = "profile")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ProfileController {

    @WebMethod(operationName = "create")
    public Boolean createProfile(@WebParam( name = "email") String email, @WebParam( name = "role") String role,
                                @WebParam( name = "firstName") String firstName, @WebParam( name = "lastName") String lastName,
                                @WebParam( name = "address") String address, @WebParam( name = "tel") String tel,
                                @WebParam( name = "password") String password){
        try {
            Profile profile = new Profile(email, role, firstName, lastName, address, tel, password);
            Profile_Utils.createProfile(profile);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @WebMethod(operationName = "update")
    public Boolean updateProfile(@WebParam( name = "email") String email, @WebParam( name = "role") String role,
                                 @WebParam( name = "firstName") String firstName, @WebParam( name = "lastName") String lastName,
                                 @WebParam( name = "address") String address, @WebParam( name = "tel") String tel,
                                 @WebParam( name = "password") String password){
        try {
            Profile profile = new Profile(email, role, firstName, lastName, address, tel, password);
            Profile_Utils.updateProfile(profile);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @WebMethod(operationName = "read")
    public Profile readProfile(@WebParam( name = "email") String email){
        try {
            Profile profile = Profile_Utils.readProfile(email);
            return profile;
        } catch (Exception e){
            return null;
        }
    }

    @WebMethod(operationName = "delete")
    public Boolean deleteProfile(@WebParam( name = "email") String email){
        try {
            Profile_Utils.deleteProfile(email);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @WebMethod(operationName = "delete")
    public Boolean listHistoryOrder(@WebParam( name = "email") String email){
        try {
            Order_Utils.findHistoryOrder(email);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
