/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author DELL
 */
public class Order implements java.io.Serializable{
    private String order_id, cus_id;
    private int ordertable;
    private java.sql.Date ordertime;
    private float price, customerpay, payback;

    public Order() {
    }

    public Order(String order_id, String cus_id, int ordertable, Date ordertime, float price, float customerpay, float payback) {
        this.order_id = order_id;
        this.cus_id = cus_id;
        this.ordertable = ordertable;
        this.ordertime = ordertime;
        this.price = price;
        this.customerpay = customerpay;
        this.payback = payback;
    }
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(this.order_id);
        v.add(this.cus_id);
        v.add(this.ordertable);
        v.add(this.ordertime);
        v.add(this.price);
        v.add(this.customerpay);
        v.add(this.payback);
        
        return v;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getCus_id() {
        return cus_id;
    }

    public int getOrdertable() {
        return ordertable;
    }

    public Date getOrdertime() {
        return ordertime;
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

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public void setOrdertable(int ordertable) {
        this.ordertable = ordertable;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
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
