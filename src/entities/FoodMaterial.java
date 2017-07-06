/*

 */
package entities;

import java.util.*;

public class FoodMaterial {
    private String fm_id, name, info, kind, unit_buy, supply_contact;
    private Byte isfordrink, fm_status;
    private int price_unit_buy;
    private float weight_unit_buy, stock_weight;

    public FoodMaterial() {
    }

    public FoodMaterial(String fm_id, String name, String info, Byte isfordrink, String kind, String unit_buy, float weight_unit_buy, int price_unit_buy, float stock_weight, Byte fm_status, String supply_contact) {
        this.fm_id = fm_id;
        this.name = name;
        this.info = info;
        this.isfordrink = isfordrink;
        this.kind = kind;
        this.unit_buy = unit_buy;
        this.weight_unit_buy = weight_unit_buy;
        this.price_unit_buy = price_unit_buy;
        this.stock_weight = stock_weight;
        this.fm_status = fm_status;
        this.supply_contact = supply_contact;
    }
    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(fm_id);
        v.add(name);
        v.add(info);
        v.add(isfordrink);
        v.add(kind);
        v.add(unit_buy);
        v.add(weight_unit_buy);
        v.add(price_unit_buy);
        v.add(stock_weight);
        v.add(fm_status);
        v.add(supply_contact);
        
        return v;
    }

    public String getFm_id() {
        return fm_id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getKind() {
        return kind;
    }

    public String getUnit_buy() {
        return unit_buy;
    }

    public String getSupply_contact() {
        return supply_contact;
    }

    public Byte getIsfordrink() {
        return isfordrink;
    }

    public Byte getFm_status() {
        return fm_status;
    }

    public int getPrice_unit_buy() {
        return price_unit_buy;
    }

    public float getWeight_unit_buy() {
        return weight_unit_buy;
    }

    public float getStock_weight() {
        return stock_weight;
    }

    public void setFm_id(String fm_id) {
        this.fm_id = fm_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setUnit_buy(String unit_buy) {
        this.unit_buy = unit_buy;
    }

    public void setSupply_contact(String supply_contact) {
        this.supply_contact = supply_contact;
    }

    public void setIsfordrink(Byte isfordrink) {
        this.isfordrink = isfordrink;
    }

    public void setFm_status(Byte fm_status) {
        this.fm_status = fm_status;
    }

    public void setPrice_unit_buy(int price_unit_buy) {
        this.price_unit_buy = price_unit_buy;
    }

    public void setWeight_unit_buy(float weight_unit_buy) {
        this.weight_unit_buy = weight_unit_buy;
    }

    public void setStock_weight(float stock_weight) {
        this.stock_weight = stock_weight;
    }
    
}
