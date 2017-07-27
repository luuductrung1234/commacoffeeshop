/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.admin;

import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class OrderDetailsReport {
    private String order_id, food_name;
    private int quan;

    public OrderDetailsReport() {
    }

    public OrderDetailsReport(String order_id, String food_name, int quan) {
        this.order_id = order_id;
        this.food_name = food_name;
        this.quan = quan;
    }
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(this.order_id);
        v.add(this.food_name);
        v.add(this.quan);
        
        return v;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public int getQuan() {
        return quan;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }
    
    
}
