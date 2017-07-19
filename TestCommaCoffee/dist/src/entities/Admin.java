/*

 */
package entities;

import java.util.*;

public class Admin {
    private String ad_id, username, pass, name;

    public Admin() {
    }

    public Admin(String ad_id, String username, String pass, String name) {
        this.ad_id = ad_id;
        this.username = username;
        this.pass = pass;
        this.name = name;
    }
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(ad_id);
        v.add(username);
        v.add(pass);
        v.add(name);
        
        return v;
    }

    public String getAd_id() {
        return ad_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
