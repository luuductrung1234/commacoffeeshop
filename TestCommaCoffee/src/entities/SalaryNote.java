/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author DELL
 */
public class SalaryNote {
    private String sn_id, em_id;
    private java.sql.Date date_pay;
    private float salary_value, work_hour;
    private int for_month, for_year;
    private Byte is_paid;

    public SalaryNote() {
    }

    public SalaryNote(String sn_id, String em_id, Date date_pay, float salary_value, float work_hour, int formonth, int foryear, Byte is_paid) {
        this.sn_id = sn_id;
        this.em_id = em_id;
        this.date_pay = date_pay;
        this.salary_value = salary_value;
        this.work_hour = work_hour;
        this.for_month = formonth;
        this.for_year = foryear;
        this.is_paid = is_paid;
    }
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(this.sn_id);
        v.add(this.em_id);
        v.add(this.date_pay);
        v.add(this.salary_value);
        v.add(this.work_hour);
        v.add(this.for_month);
        v.add(this.for_year);
        v.add(this.is_paid);
        
        return v;
    }

    public String getSn_id() {
        return sn_id;
    }

    public String getEm_id() {
        return em_id;
    }

    public Date getDate_pay() {
        return date_pay;
    }

    public float getSalary_value() {
        return salary_value;
    }

    public float getWork_hour() {
        return work_hour;
    }

    public int getFor_month() {
        return for_month;
    }

    public int getFor_year() {
        return for_year;
    }

    public Byte getIs_paid() {
        return is_paid;
    }

    public void setSn_id(String sn_id) {
        this.sn_id = sn_id;
    }

    public void setEm_id(String em_id) {
        this.em_id = em_id;
    }

    public void setDate_pay(Date date_pay) {
        this.date_pay = date_pay;
    }

    public void setSalary_value(float salary_value) {
        this.salary_value = salary_value;
    }

    public void setWork_hour(float work_hour) {
        this.work_hour = work_hour;
    }

    public void setFor_month(int for_month) {
        this.for_month = for_month;
    }

    public void setFor_year(int for_year) {
        this.for_year = for_year;
    }

    public void setIs_paid(Byte is_paid) {
        this.is_paid = is_paid;
    }
    
    
}
