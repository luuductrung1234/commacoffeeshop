/*
 * Intro: Là một class bổ sung cho chương trình, dùng để chứa thông tin của một bill tính tiền. Có thể kết hợp với chức năng in để in bill
 * 
 * Warning: - Các thông tin biểu thị một hoá đơn order sẽ tương thích với kích thước của máy in bill
 *          - Loại hoá đơn: hoá đơn tạm
 */
package supportclass;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author DELL
 *
 */
public class PrintTextForm {
    // dữ liệu mặc định
    private String[] defaultform;
    private LocalDate date;
    private String address;
    private String phone;
    private String[] wifiname;
    private String[] wifipass;
    
    // dữ liệu tuỳ biến
    private int tablenumber;
    private int number_customer;
    private int number_employee;
    private int discount;
    private String orderid;
    
    
    // dữ liệu trả về
    ArrayList<String> pretext;
    ArrayList<String> posttext;

    public PrintTextForm() {
        this.initDefaultForm();
    }

    public PrintTextForm(int tablenumber, int number_customer, int number_employee, String orderid, int discount) {
        this.initDefaultForm();
        
        this.tablenumber = tablenumber;
        this.number_customer = number_customer;
        this.number_employee = number_employee;
        this.discount = discount;
        this.orderid = orderid;
    }
    
    private void initDefaultForm(){
        this.defaultform = new String[15];
        this.defaultform[0] =  "                             CAFE COMMA";
        this.defaultform[1] =  "Address: ";
        this.defaultform[2] =  "Phone:    ";
        this.defaultform[3] =  "Date: ";
        this.defaultform[4] =  " ";
        this.defaultform[5] =  "                         TEMPORARY ORDER";
        this.defaultform[6] =  "                            TABLE:  ";
        this.defaultform[7] =  "#Customer: ";
        this.defaultform[8] =  "#Employee: ";
        this.defaultform[9] =  "Discount: ";
        this.defaultform[10] =  "No: ";
        this.defaultform[11] =  " ";

        this.defaultform[12] =  " ";
        this.defaultform[13] =  "           wifi: ";
        this.defaultform[14] =  "               pass: ";
        
        this.date = LocalDate.now( ZoneId.of( "Asia/Ho_Chi_Minh" ) );
        this.address = "653,  st.Le Van Luong,  w.Tan Phong,  d.7";
        this.phone = "0862622858";
        this.wifiname = new String[1];
        this.wifiname[0] = "cafe comma 1/ cafe comma 2";
        this.wifipass = new String[1];
        this.wifipass[0] = "123456789";
    }
    
    public void prepareTextForPrint(){
        this.pretext = new ArrayList<>();
        
        pretext.add(this.defaultform[0]);
        pretext.add(this.defaultform[1] + this.address);
        pretext.add(this.defaultform[2] + this.phone);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        pretext.add(this.defaultform[3] + this.date + "     Time: " + sdf.format(c.getTime()));
        pretext.add(this.defaultform[4]);
        pretext.add(this.defaultform[5]);
        pretext.add(this.defaultform[6] + this.tablenumber);
        pretext.add(this.defaultform[7] + this.number_customer);
        pretext.add(this.defaultform[8] + this.number_employee);
        pretext.add(this.defaultform[9] + this.discount + " %");
        pretext.add(this.defaultform[10] + this.orderid);
        pretext.add(this.defaultform[11]);
        

        this.posttext = new ArrayList<>();
        posttext.add(this.defaultform[12]);
        for(int i = 0; i < this.wifiname.length; i++){
            posttext.add(this.defaultform[13] + this.wifiname[i]);
        }
        for(int i = 0; i < this.wifipass.length; i++){
            posttext.add(this.defaultform[14] + this.wifipass[i]);
        }
    }
    
    static public String localizedFormat(String pattern, double value, Locale loc ) {
        NumberFormat nf = NumberFormat.getNumberInstance(loc);
        DecimalFormat df = (DecimalFormat)nf;
        df.applyPattern(pattern);
        String output = df.format(value);
        return output;
    }

    public String[] getDefaultform() {
        return defaultform;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getNumber_customer() {
        return number_customer;
    }

    public int getNumber_employee() {
        return number_employee;
    }

    public String getOrderid() {
        return orderid;
    }


    public String[] getWifiname() {
        return wifiname;
    }

    public String[] getWifipass() {
        return wifipass;
    }

    public void setDefaultform(String[] defaultform) {
        this.defaultform = defaultform;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNumber_customer(int number_customer) {
        this.number_customer = number_customer;
    }

    public void setNumber_employee(int number_employee) {
        this.number_employee = number_employee;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }


    public void setWifiname(String[] wifiname) {
        this.wifiname = wifiname;
    }

    public void setWifipass(String[] wifipass) {
        this.wifipass = wifipass;
    }

    public int getTablenumber() {
        return tablenumber;
    }

    public void setTablenumber(int tablenumber) {
        this.tablenumber = tablenumber;
    }

    public Integer[] getBoldline() {
        return new Integer[] {0, 5};
    }

    public ArrayList<String> getPretext() {
        return pretext;
    }

    public ArrayList<String> getPosttext() {
        return posttext;
    }
}
