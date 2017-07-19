/*
 * Intro: Là một class bổ sung cho chương trình, dùng để chứa thông tin của một bill tính tiền. Có thể kết hợp với chức năng in để in bill
 * 
 * Warning: - Các thông tin biểu thị một hoá đơn order sẽ tương thích với kích thước của máy in bill
 *          - Loại hoá đơn: hoá đơn cho nhà bếp
 */
package supportclass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author DELL
 */
public class KitchenPrintTextForm {
    public static int BAR_MODE = 1;
    public static int KITCHEN_MODE = 2;
    
    private String[] defaultform;
    
    private String orderid;
    private int tablenumber;
    private int numbercustomer;
    
    private ArrayList<String> pretext;
    private ArrayList<String> postext;

    public KitchenPrintTextForm(String orderid, int tablenumber, int numbercustomer, int mode) {
        this.orderid = orderid;
        this.tablenumber = tablenumber;
        this.numbercustomer = numbercustomer;
        
        this.initDefaultForm(mode);
    }

    private void initDefaultForm(int mode) {
        this.defaultform = new String[4];
        
        this.defaultform[0] = "TABLE - " + this.tablenumber;
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        this.defaultform[1] = "No." + this.orderid + "      " + LocalDate.now( ZoneId.of( "Asia/Ho_Chi_Minh" ) ) + "    " + sdf.format(c.getTime());
        this.defaultform[2] = "#Customer: " + this.numbercustomer;
        
        switch(mode){
            case 1:
                this.defaultform[3] = "                BAR PROCESS";
                break;
            case 2:
                this.defaultform[3] = "               KITCHEN PROCESS";
        }
    }
    
    public void prepareTextForPrint(){
        this.pretext = new ArrayList<>();
        
        this.pretext.add(this.defaultform[0]);
        this.pretext.add(this.defaultform[1]);
        this.pretext.add(this.defaultform[2]);
        this.pretext.add(this.defaultform[3]);
        
        this.postext = new ArrayList<>();
        // chưa dùng đến
    }

    public String[] getDefaultform() {
        return defaultform;
    }

    public String getOrderid() {
        return orderid;
    }

    public int getTablenumber() {
        return tablenumber;
    }

    public int getNumbercustomer() {
        return numbercustomer;
    }

    public ArrayList<String> getPretext() {
        return pretext;
    }

    public ArrayList<String> getPosttext() {
        return postext;
    }

    public void setDefaultform(String[] defaultform) {
        this.defaultform = defaultform;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public void setTablenumber(int tablenumber) {
        this.tablenumber = tablenumber;
    }

    public void setNumbercustomer(int numbercustomer) {
        this.numbercustomer = numbercustomer;
    }

    public void setPretext(ArrayList<String> pretext) {
        this.pretext = pretext;
    }

    public void setPosttext(ArrayList<String> postext) {
        this.postext = postext;
    }
    
    public Integer[] getBoldLine(){
        return new Integer[] {0, 3};
    }
}
