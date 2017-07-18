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
    private String[] foodname;          // foodname.length = foodquan.length = foodprice.length
    private int[] foodquan;
    private float[] foodprice;          // đơn vị kVND => x1000 => VND
    private int tablenumber;
    private int number_customer;
    private int number_employee;
    private String orderid;
    private float totalamount;
    

    public PrintTextForm() {
        this.initDefaultForm();
    }

    public PrintTextForm(String[] foodname, int[] foodquan, float[] foodprice, int tablenumber, int number_customer, int number_employee, String orderid, float totalamount) {
        this.initDefaultForm();
        
        this.foodname = foodname;
        this.foodquan = foodquan;
        this.foodprice = foodprice;
        this.tablenumber = tablenumber;
        this.number_customer = number_customer;
        this.number_employee = number_employee;
        this.orderid = orderid;
        this.totalamount = totalamount;
    }
    
    private void initDefaultForm(){
        this.defaultform = new String[17];
        this.defaultform[0] =  "Cafe COMMA";
        this.defaultform[1] =  "Address: ";
        this.defaultform[2] =  "Phone:    ";
        this.defaultform[3] =  "Date: ";
        this.defaultform[4] =  " ";
        this.defaultform[5] =  "                          TEMPORARY ORDER";
        this.defaultform[6] =  "                            TABLE:  ";
        this.defaultform[7] =  "#Customer: ";
        this.defaultform[8] =  "#Employee: ";
        this.defaultform[9] =  "No: ";
        this.defaultform[10] =  " ";
        this.defaultform[11] =  "Product                           Q          Price            Amt";
        this.defaultform[12] =  " ";
        this.defaultform[13] =  "                         Total Amount: ";
        this.defaultform[14] =  " ";
        this.defaultform[15] =  "           wifi: ";
        this.defaultform[16] =  "               pass: ";
        
        this.date = LocalDate.now( ZoneId.of( "Asia/Ho_Chi_Minh" ) );
        this.address = "653,  st.Le Van Luong,  w.Tan Phong,  d.7";
        this.phone = "0862622858";
        this.wifiname = new String[2];
        this.wifiname[0] = "cafe comma1";
        this.wifiname[1] = "cafe comma2";
        this.wifipass = new String[1];
        this.wifipass[0] = "123456789";
    }
    
    public ArrayList<String> getTextForPrint(){
        ArrayList<String> result = new ArrayList<>();
        
        result.add(this.defaultform[0]);
        result.add(this.defaultform[1] + this.address);
        result.add(this.defaultform[2] + this.phone);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        result.add(this.defaultform[3] + this.date + "     Time: " + sdf.format(c.getTime()));
        result.add(this.defaultform[4]);
        result.add(this.defaultform[5]);
        result.add(this.defaultform[6] + this.tablenumber);
        result.add(this.defaultform[7] + this.number_customer);
        result.add(this.defaultform[8] + this.number_employee);
        result.add(this.defaultform[9] + this.orderid);
        result.add(this.defaultform[10]);
        
        
        // food list
        result.add(this.defaultform[11]);
        for(int i = 0; i < this.foodname.length; i++){
            String item = "";
            
            // cột name
            item += foodname[i];
            for(int j = 1; j < 35-foodname[i].length(); j++){
                item += " ";
            }
            
            // cột số lượng
            String quantity = String.valueOf(foodquan[i]);
            for(int j = 1; j < 3-quantity.length(); j++){
                item += " ";
            }
            item += quantity;
            
            // cột giá
            int price = (int) (foodprice[i] * 1000);
            String sprice = localizedFormat("###,###.###", price, Locale.US);
            for(int j = 1; j < 14-sprice.length(); j++){
                item += " ";
            }
            item += sprice;
            
            // cột tổng giá
            int totalprice = price * foodquan[i];
            String stotalprice = localizedFormat("###,###.###", totalprice, Locale.US);
            for(int j = 1; j < 16-stotalprice.length(); j++){
                item += " ";
            }
            item += stotalprice;
            
            // thêm vào kết quả
            result.add(item);
        }
        
        result.add(this.defaultform[12]);
        result.add(this.defaultform[13] + this.totalamount);
        result.add(this.defaultform[14]);
        for(int i = 0; i < this.wifiname.length; i++){
            result.add(this.defaultform[15] + this.wifiname[i]);
        }
        for(int i = 0; i < this.wifipass.length; i++){
            result.add(this.defaultform[16] + this.wifipass[i]);
        }
        
        return result;
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

    public String[] getFoodname() {
        return foodname;
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

    public float getTotalamount() {
        return totalamount;
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

    public void setFoodname(String[] foodname) {
        this.foodname = foodname;
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

    public void setTotalamount(float totalamount) {
        this.totalamount = totalamount;
    }

    public void setWifiname(String[] wifiname) {
        this.wifiname = wifiname;
    }

    public void setWifipass(String[] wifipass) {
        this.wifipass = wifipass;
    }

    public int[] getFoodquan() {
        return foodquan;
    }

    public float[] getFoodprice() {
        return foodprice;
    }

    public int getTablenumber() {
        return tablenumber;
    }

    public void setFoodquan(int[] foodquan) {
        this.foodquan = foodquan;
    }

    public void setFoodprice(float[] foodprice) {
        this.foodprice = foodprice;
    }

    public void setTablenumber(int tablenumber) {
        this.tablenumber = tablenumber;
    }
    
    
}
