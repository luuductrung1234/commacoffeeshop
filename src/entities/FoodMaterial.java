/*

 */
package entities;

import java.util.Vector;

public class FoodMaterial {
    private String fm_id, name, info, fmtype, unit_buy, supplier;
    private Byte usefor;
    private float standard_price;

    public FoodMaterial() {
    }

    public FoodMaterial(String fm_id, String name, String info, String fmtype, String unit_buy, String supplier, Byte usefor, float standard_price) {
        this.fm_id = fm_id;
        this.name = name;
        this.info = info;
        this.fmtype = fmtype;
        this.unit_buy = unit_buy;
        this.supplier = supplier;
        this.usefor = usefor;
        this.standard_price = standard_price;
    }

    
    public Vector toVector()
    {
        Vector v = new Vector();
        v.add(this.fm_id);
        v.add(this.name);
        v.add(this.info);
        v.add(this.usefor);
        v.add(this.fmtype);
        v.add(this.unit_buy);
        v.add(this.standard_price);
        v.add(this.supplier);
                
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

    public String getFmtype() {
        return fmtype;
    }

    public String getUnit_buy() {
        return unit_buy;
    }

    public String getSupplier() {
        return supplier;
    }

    public Byte getUsefor() {
        return usefor;
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

    public void setFmtype(String fmtype) {
        this.fmtype = fmtype;
    }

    public void setUnit_buy(String unit_buy) {
        this.unit_buy = unit_buy;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setUsefor(Byte usefor) {
        this.usefor = usefor;
    }

    public float getStandard_price() {
        return standard_price;
    }

    public void setStandard_price(float standard_price) {
        this.standard_price = standard_price;
    }

    
}
