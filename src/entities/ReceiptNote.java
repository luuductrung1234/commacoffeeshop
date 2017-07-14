/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class ReceiptNote {
    private String rn_id, em_id;
    private java.sql.Date rday;
    private float total_amount;

   	public ReceiptNote(){
   	}

   	public ReceiptNote(String rn_id, String em_id, java.sql.Date rday, float total_amount){
   		this.rn_id = rn_id;
   		this.em_id = em_id;
   		this.rday = rday;
   		this.total_amount = total_amount;
   	}

   	public java.util.Vector toVector(){
   		java.util.Vector v = new java.util.Vector();
   		v.add(this.rn_id);
   		v.add(this.em_id);
   		v.add(this.rday);
   		v.add(this.total_amount);

   		return v;
   	}

    public String getRn_id() {
        return rn_id;
    }

    public String getEm_id() {
        return em_id;
    }

    public Date getRday() {
        return rday;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setRn_id(String rn_id) {
        this.rn_id = rn_id;
    }

    public void setEm_id(String em_id) {
        this.em_id = em_id;
    }

    public void setRday(Date rday) {
        this.rday = rday;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    
}
