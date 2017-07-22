/*

 */
package entities;

import java.util.*;

public class FoodDetails implements java.io.Serializable{
    private String fd_id, food_id, fm_id, unit_use;
    private float quan;

    public FoodDetails() {
    }

    public FoodDetails(String fd_id, String food_id, String fm_id, String unit_use, float quan) {
        this.fd_id = fd_id;
        this.food_id = food_id;
        this.fm_id = fm_id;
        this.unit_use = unit_use;
        this.quan = quan;
    }
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(fd_id);
        v.add(food_id);
        v.add(fm_id);
        v.add(quan);
        v.add(unit_use);
        
        return v;
    }

    public String getFd_id() {
        return fd_id;
    }

    public String getFood_id() {
        return food_id;
    }

    public String getFm_id() {
        return fm_id;
    }

    public String getUnit_use() {
        return unit_use;
    }

    public float getQuan() {
        return quan;
    }

    public void setFd_id(String fd_id) {
        this.fd_id = fd_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public void setFm_id(String fm_id) {
        this.fm_id = fm_id;
    }

    public void setUnit_use(String unit_use) {
        this.unit_use = unit_use;
    }

    public void setQuan(float quan) {
        this.quan = quan;
    }
    
}
