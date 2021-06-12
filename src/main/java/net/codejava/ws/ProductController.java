package net.codejava.ws;

import OrderManager.Order_Utils;
import ProductManager.Product_Utils;
import model.Product;
import utils.Atomic;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;

@WebService(serviceName = "product")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ProductController {
    @WebMethod(operationName = "create")
    public Boolean createProduct(@WebParam( name = "name") String name, @WebParam( name = "price") float price,
                                 @WebParam( name = "stock") int stock){
        try {
            Product product = new Product("product"+Atomic.getNum(),name, price, stock);
            Product_Utils.createProduct(product);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @WebMethod(operationName = "update")
    public Boolean updateProduct(@WebParam( name = "productNo") String productNo,
                                 @WebParam( name = "name") String name, @WebParam( name = "price") float price,
                                 @WebParam( name = "stock") int stock, @WebParam( name = "createDate") Date createDate){
        try {
            Product product = new Product(productNo, name, price, stock, createDate);
            Product_Utils.updateProduct(product);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @WebMethod(operationName = "read")
    public Product readProduct(@WebParam( name = "productNo") String productNo){
        try {
            return Product_Utils.readProduct(productNo);
        } catch (Exception e){
            return null;
        }
    }

    @WebMethod(operationName = "delete")
    public Boolean deleteProduct(@WebParam( name = "name") String name){
        try {
            Product_Utils.deleteProduct(name);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @WebMethod(operationName = "delete")
    public Boolean listHistoryOrder(@WebParam( name = "name") String name){
        try {
            Order_Utils.findHistoryOrder(name);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @WebMethod(operationName = "delete")
    public Boolean listAllProduct(@WebParam( name = "name") String name){
        try {
            Order_Utils.findHistoryOrder(name);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
