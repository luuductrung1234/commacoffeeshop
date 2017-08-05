/*

 */
package entities;

import java.util.*;

public class Employee implements java.io.Serializable{
    private String em_id, username, pass, name, addr, email, phone, manager;
    private java.sql.Date birth, startday;
    private int hour_wage;
    private int em_role;
    private int deleted = 0;

    public Employee() {
    }

    public Employee(String em_id, String username, String pass, String name, String addr, String email, String phone, String manager, java.sql.Date birth, java.sql.Date startday, int hour_wage, int em_role) {
        this.em_id = em_id;
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.addr = addr;
        this.email = email;
        this.phone = phone;
        this.manager = manager;
        this.birth = birth;
        this.startday = startday;
        this.hour_wage = hour_wage;
        this.em_role = em_role;
    }

    
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(this.em_id);
        v.add(this.username);
        v.add(this.pass);
        v.add(this.name);
        v.add(this.birth);
        v.add(this.startday);
        v.add(this.hour_wage);
        v.add(this.addr);
        v.add(this.email);
        v.add(this.phone);
        v.add(this.em_role);
        v.add(this.manager);
        
        return v;
    }

    public int getHour_wage() {
        return hour_wage;
    }

    public void setHour_wage(int hour_wage) {
        this.hour_wage = hour_wage;
    }

    
    
    public String getEm_id() {
        return em_id;
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

    public java.sql.Date getBirth() {
        return birth;
    }

    public java.sql.Date getStartday() {
        return startday;
    }

    public String getAddr() {
        return addr;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getManager() {
        return manager;
    }

    public int getEm_role() {
        return em_role;
    }

    public void setEm_id(String em_id) {
        this.em_id = em_id;
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

    public void setBirth(java.sql.Date birth) {
        this.birth = birth;
    }

    public void setStartday(java.sql.Date startday) {
        this.startday = startday;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setEm_role(int em_role) {
        this.em_role = em_role;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    
}
