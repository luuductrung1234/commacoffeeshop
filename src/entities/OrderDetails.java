/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Vector;

/**
 *
 * @author DELL
 */
public class OrderDetails {
    private String order_id, food_id;
    private int quan;

    public OrderDetails() {
    }

    public OrderDetails(String order_id, String food_id, int quan) {
        this.order_id = order_id;
        this.food_id = food_id;
        this.quan = quan;
    }
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(this.order_id);
        v.add(this.food_id);
        v.add(this.quan);
        
        return v;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getFood_id() {
        return food_id;
    }

    public int getQuan() {
        return quan;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }
    
    
}
