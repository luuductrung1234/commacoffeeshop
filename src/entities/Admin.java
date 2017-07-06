/*

 */
package entities;

import java.util.*;

public class Admin {
    private String ad_id, pass, name;
    private int ad_role;

    public Admin() {
    }

    public Admin(String ad_id, String pass, String name, int ad_role) {
        this.ad_id = ad_id;
        this.pass = pass;
        this.name = name;
        this.ad_role = ad_role;
    }
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(ad_id);
        v.add(pass);
        v.add(name);
        v.add(ad_role);
        
        return v;
    }

    public String getAd_id() {
        return ad_id;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public int getAd_role() {
        return ad_role;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAd_role(int ad_role) {
        this.ad_role = ad_role;
    }
    
    
    
}
