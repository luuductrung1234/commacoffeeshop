/*

 */
package entities;

import java.util.*;

public class Customer {
    private String cus_id, name;
    private int dis_percent;

    public Customer() {
    }

    public Customer(String cus_id, String name, int dis_percent) {
        this.cus_id = cus_id;
        this.name = name;
        this.dis_percent = dis_percent;
    }
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(cus_id);
        v.add(name);
        v.add(dis_percent);
        
        return v;
    }

    public String getCus_id() {
        return cus_id;
    }

    public String getName() {
        return name;
    }

    public int getDis_percent() {
        return dis_percent;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDis_percent(int dis_percent) {
        this.dis_percent = dis_percent;
    }
    
}
