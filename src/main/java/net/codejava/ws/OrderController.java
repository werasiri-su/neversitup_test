package net.codejava.ws;

import OrderManager.Order_Utils;
import constants.EStatus;
import model.Order;
import utils.Atomic;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(serviceName = "order")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class OrderController {
    @WebMethod(operationName = "create")
    public Boolean createOrder(@WebParam( name = "email") String email,
                                 @WebParam( name = "productId") String[] productIds, @WebParam( name = "totalPrice") String totalPrice,
                                 @WebParam( name = "status") String status){
        try {
            Order order = new Order("order"+Atomic.getNum(), email, productIds, totalPrice, EStatus.ORDER.getStatus());
            Order_Utils.createOrder(order);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @WebMethod(operationName = "update")
    public Boolean updateOrder(@WebParam( name = "orderNo") String orderNo, @WebParam( name = "email") String email,
                                 @WebParam( name = "productId") String[] productIds, @WebParam( name = "totalPrice") String totalPrice,
                                 @WebParam( name = "status") String status){
        try {
            Order order = new Order(orderNo, email, productIds, totalPrice, status);
            Order_Utils.updateOrder(order);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @WebMethod(operationName = "read")
    public Order readOrder(@WebParam( name = "orderNo") String orderNo){
        try {
            Order order = Order_Utils.readOrder(orderNo);
            return order;
        } catch (Exception e){
            return null;
        }
    }

    @WebMethod(operationName = "delete")
    public Boolean deleteOrder(@WebParam( name = "orderNo") String orderNo){
        try {
            Order_Utils.deleteOrder(orderNo);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @WebMethod(operationName = "cancel")
    public Boolean cancelOrder(@WebParam( name = "orderNo") String orderNo, @WebParam( name = "email") String email,
                               @WebParam( name = "productId") String[] productIds, @WebParam( name = "totalPrice") String totalPrice){
        try {
            Order order = new Order(orderNo, email, productIds, totalPrice, EStatus.CANCEL.getStatus());
            Order_Utils.updateOrder(order);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
