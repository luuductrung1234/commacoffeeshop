/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportclass;

/**
 *
 * @author DELL
 */
public class FoodReport {
    private String name;
    private String isdrink;
    private int quan;
    private int orderamount;

    public FoodReport() {
    }

    public FoodReport(String name, String isdrink, int quan, int orderamount) {
        this.name = name;
        this.isdrink = isdrink;
        this.quan = quan;
        this.orderamount = orderamount;
    }


    public String getName() {
        return name;
    }

    public String getIsdrink() {
        return isdrink;
    }

    public int getQuan() {
        return quan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsdrink(String isdrink) {
        this.isdrink = isdrink;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public int getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(int orderamount) {
        this.orderamount = orderamount;
    }

    
}
