/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author SIEU THI SO 4G
 */
public class Product {
    int productID=0, supplierID=0, categoryID=0, unitInStock,unitOnOrder,reOrderLevel;
    double unitPrice;
    boolean disContinued;
    String productName, quantityPerUnit;

    public Product() {
    }
    //thêm 1 phương thức khởi dựng với 4 tham số
    public Product(int productID, String productName,  String quantityPerUnit) {
        this.productID=productID;
        //this.unitPrice = unitPrice;
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
    }
//    public Product(int unitInStock, int unitOnOrder, int reOrderLevel, double unitPrice, String productName, String quantityPerUnit) {
//        this.unitInStock = unitInStock;
//        this.unitOnOrder = unitOnOrder;
//        this.reOrderLevel = reOrderLevel;
//        this.unitPrice = unitPrice;
//        this.productName = productName;
//        this.quantityPerUnit = quantityPerUnit;
//    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public int getUnitOnOrder() {
        return unitOnOrder;
    }

    public void setUnitOnOrder(int unitOnOrder) {
        this.unitOnOrder = unitOnOrder;
    }

    public int getReOrderLevel() {
        return reOrderLevel;
    }

    public void setReOrderLevel(int reOrderLevel) {
        this.reOrderLevel = reOrderLevel;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isDisContinued() {
        return disContinued;
    }

    public void setDisContinued(boolean disContinued) {
        this.disContinued = disContinued;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }
    
}
