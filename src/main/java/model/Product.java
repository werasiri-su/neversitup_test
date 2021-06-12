package model;

import java.util.Date;

public class Product {
    private transient String _id;
    private String productNo;
    private String name;
    private float price;
    private int stock;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;

    public Product(String productNo, String name, float price, int stock, Date createDate) {
        this.productNo = productNo;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.createDate = createDate;
    }

    public Product(String productNo, String name, float price, int stock) {
        this.productNo = productNo;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
