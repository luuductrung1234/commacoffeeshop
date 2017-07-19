/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author DELL
 */
public class ReceiptNoteDetails {
    private String rn_id, fm_id;
    private int quan;
    private float item_price;
    private String note;

    public ReceiptNoteDetails() {
    }

    public ReceiptNoteDetails(String rn_id, String fm_id, int quan, float item_price, String note) {
        this.rn_id = rn_id;
        this.fm_id = fm_id;
        this.quan = quan;
        this.item_price = item_price;
        this.note = note;
    }

    public String getRn_id() {
        return rn_id;
    }

    public String getFm_id() {
        return fm_id;
    }

    public int getQuan() {
        return quan;
    }

    public float getItem_price() {
        return item_price;
    }

    public String getNote() {
        return note;
    }

    public void setRn_id(String rn_id) {
        this.rn_id = rn_id;
    }

    public void setFm_id(String fm_id) {
        this.fm_id = fm_id;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public void setItem_price(float item_price) {
        this.item_price = item_price;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
