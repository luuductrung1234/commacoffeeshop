/*

 */
package entities;

import java.util.Vector;

public class Customer {
    private String cus_id, name, phone, email;
    private int discount;

    public Customer() {
    }

    public Customer(String cus_id, String name, String phone, String email, int discount) {
        this.cus_id = cus_id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.discount = discount;
    }
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(this.cus_id);
        v.add(this.name);
        v.add(this.phone);
        v.add(this.email);
        v.add(discount);
        
        return v;
    }

    public String getCus_id() {
        return cus_id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getDiscount() {
        return discount;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    
}
