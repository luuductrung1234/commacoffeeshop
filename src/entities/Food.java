/*

 */
package entities;

import java.util.*;

public class Food {
    private String food_id, name, info;
    private int price;
    private Byte isdrink;

    public Food() {
    }

    public Food(String food_id, String name, String info, int price, Byte isdrink) {
        this.food_id = food_id;
        this.name = name;
        this.info = info;
        this.price = price;
        this.isdrink = isdrink;
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

    public int getPrice() {
        return price;
    }

    public Byte getIsdrink() {
        return isdrink;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIsdrink(Byte isdrink) {
        this.isdrink = isdrink;
    }
    
}
