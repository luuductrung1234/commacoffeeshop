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
public class EmpSchedule {
    private String sche_id, em_id;
    private java.sql.Date workday;
    private int starthour, startminute, endhour, endminute;
    private String result_salary;

    public EmpSchedule() {
    }

    public EmpSchedule(String sche_id, String em_id, Date workday, int starthour, int startminute, int endhour, int endminute, String result_salary) {
        this.sche_id = sche_id;
        this.em_id = em_id;
        this.workday = workday;
        this.starthour = starthour;
        this.startminute = startminute;
        this.endhour = endhour;
        this.endminute = endminute;
        this.result_salary = result_salary;
    }
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(this.sche_id);
        v.add(this.em_id);
        v.add(this.starthour);
        v.add(this.startminute);
        v.add(this.endhour);
        v.add(this.endminute);
        v.add(this.result_salary);
        
        return v;
    }

    public String getResult_salary() {
        return result_salary;
    }

    public void setResult_salary(String result_salary) {
        this.result_salary = result_salary;
    }

    
    
    public String getSche_id() {
        return sche_id;
    }

    public String getEm_id() {
        return em_id;
    }

    public Date getWorkday() {
        return workday;
    }

    public int getStarthour() {
        return starthour;
    }

    public int getStartminute() {
        return startminute;
    }

    public int getEndhour() {
        return endhour;
    }

    public int getEndminute() {
        return endminute;
    }

    public void setSche_id(String sche_id) {
        this.sche_id = sche_id;
    }

    public void setEm_id(String em_id) {
        this.em_id = em_id;
    }

    public void setWorkday(Date workday) {
        this.workday = workday;
    }

    public void setStarthour(int starthour) {
        this.starthour = starthour;
    }

    public void setStartminute(int startminute) {
        this.startminute = startminute;
    }

    public void setEndhour(int endhour) {
        this.endhour = endhour;
    }

    public void setEndminute(int endminute) {
        this.endminute = endminute;
    }
    
    
}
