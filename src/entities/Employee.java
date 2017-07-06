/*

 */
package entities;

import java.util.*;

public class Employee {
    private String em_id, name, addr, email, phone, manager, pass;
    private Date startday;
    private int em_role, age;

    public Employee() {
    }

    public Employee(String em_id, String name, Date startday, String addr, String email, String phone, int em_role, String manager, String pass, int age) {
        this.em_id = em_id;
        this.pass = pass;
        this.name = name;
        this.age = age;
        this.startday = startday;
        this.addr = addr;
        this.email = email;
        this.phone = phone;
        this.em_role = em_role;
        this.manager = manager;
    }
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(em_id);
        v.add(pass);
        v.add(name);
        v.add(age);
        v.add(startday);
        v.add(addr);
        v.add(email);
        v.add(phone);
        v.add(em_role);
        v.add(manager);
        
        return v;
    }

    public String getEm_id() {
        return em_id;
    }

    public String getName() {
        return name;
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

    public String getPass() {
        return pass;
    }

    public Date getStartday() {
        return startday;
    }

    public int getEm_role() {
        return em_role;
    }

    public int getAge() {
        return age;
    }

    public void setEm_id(String em_id) {
        this.em_id = em_id;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setStartday(Date startday) {
        this.startday = startday;
    }

    public void setEm_role(int em_role) {
        this.em_role = em_role;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
