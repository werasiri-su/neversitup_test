package model;

import java.util.Date;

public class Order {
    private transient String _id;
    private String orderNo;
    private String email;
    private String[] productIds;
    private String totalPrice;
    private String status;
    private Date createDate;
    private Date updateDate;

    public Order(String orderNo, String email, String[] productIds, String totalPrice, String status) {
        this.orderNo = orderNo;
        this.email = email;
        this.productIds = productIds;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getProductIds() {
        return productIds;
    }

    public void setProductIds(String[] productIds) {
        this.productIds = productIds;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
