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
public class TableItem {
    private String product, quan, price, amt;

    public TableItem() {
    }

    public TableItem(String product, String quan, String price, String amt) {
        this.product = product;
        this.quan = quan;
        this.price = price;
        this.amt = amt;
    }

    public String getProduct() {
        return product;
    }

    public String getQuan() {
        return quan;
    }

    public String getPrice() {
        return price;
    }

    public String getAmt() {
        return amt;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }
    
    
}
