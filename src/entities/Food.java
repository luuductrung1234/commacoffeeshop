/*

 */
package entities;

import java.util.*;

public class Food implements java.io.Serializable{
    private String food_id, name, info;
    private float price;
    private Byte isdrink;
    private int deleted;

    public Food() {
    }

    public Food(String food_id, String name, String info, float price, Byte isdrink, int deleted) {
        this.food_id = food_id;
        this.name = name;
        this.info = info;
        this.price = price;
        this.isdrink = isdrink;
        this.deleted = deleted;
    }
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(food_id);
        v.add(name);
        v.add(info);
        v.add(price);
        v.add(isdrink);
        
        return v;
    }

    public String getFood_id() {
        return food_id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public float getPrice() {
        return price;
    }

    public Byte getIsdrink() {
        return isdrink;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setIsdrink(Byte isdrink) {
        this.isdrink = isdrink;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    
}
