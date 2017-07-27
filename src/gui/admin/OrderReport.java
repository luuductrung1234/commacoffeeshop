/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.admin;

import java.sql.Date;
import java.util.Vector;



public class OrderReport {
    private String order_id, cus_name;
    private int discount;
    private float price, customerpay, payback;

    public OrderReport() {
    }

    public OrderReport(String order_id, String cus_name, int discount, float price, float customerpay, float payback) {
        this.order_id = order_id;
        this.cus_name = cus_name;
        this.discount = discount;
        this.price = price;
        this.customerpay = customerpay;
        this.payback = payback;
    }
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(this.order_id);
        v.add(this.cus_name);
        v.add(this.discount);
        v.add(this.price);
        v.add(this.customerpay);
        v.add(this.payback);
        
        return v;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public int getDiscount() {
        return discount;
    }

    public float getPrice() {
        return price;
    }

    public float getCustomerpay() {
        return customerpay;
    }

    public float getPayback() {
        return payback;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCustomerpay(float customerpay) {
        this.customerpay = customerpay;
    }

    public void setPayback(float payback) {
        this.payback = payback;
    }
    
}
