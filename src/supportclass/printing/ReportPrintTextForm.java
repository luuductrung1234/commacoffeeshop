/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportclass.printing;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import static supportclass.printing.PrintTextForm.localizedFormat;

/**
 *
 * @author DELL
 */
public class ReportPrintTextForm {
    // dữ liệu mặc định
    private String[] defaultform;
    
    // dữ liệu tuỳ biến
    private int totalorder;
    private int totalorderamount;
    private int totaldiscount;
    private int totalcustomerpay;
    private int totalchange;
    private int totalfoodpurchase;
    private int totalotherpurchase;
    private int beginofday;
    private int endofday;
    private LocalDate dayreport;
    
    
    // dữ liệu trả về
    ArrayList<String> pretext;
    ArrayList<String> posttext;

    public ReportPrintTextForm() {
        this.initDefaultForm();
    }

    public ReportPrintTextForm(int totalorder, int totalorderamount, int totalcustomerpay, int totalchange, int totalfoodpurchase, int totalotherpurchase, int beginofday, int endofday, int totaldiscount, LocalDate dayreport) {
        this.initDefaultForm();
        
        this.totalorder = totalorder;
        this.totalorderamount = totalorderamount;
        this.totalcustomerpay = totalcustomerpay;
        this.totalchange = totalchange;
        this.totalfoodpurchase = totalfoodpurchase;
        this.totalotherpurchase = totalotherpurchase;
        this.beginofday = beginofday;
        this.endofday = endofday;
        this.totaldiscount = totaldiscount;
        this.dayreport = dayreport;
    }

    
    private void initDefaultForm(){
        this.defaultform = new String[18];
        this.defaultform[0] = "                  END OF DAY REPORT";
        this.defaultform[1] = "Income:";
        this.defaultform[2] = "     - total order: ";
        this.defaultform[3] = "     - total order amount: ";
        this.defaultform[4] = "     - total discount: ";
        this.defaultform[5] = "     - total customer pay: ";
        this.defaultform[6] = "     - total change: ";
        this.defaultform[7] = " ";
        this.defaultform[8] = "Purchase:";
        this.defaultform[9] = "     - total food purchase: ";
        this.defaultform[10] = "     - total other purchase: ";
        this.defaultform[11] = " ";
        this.defaultform[12] = "Cash:";
        this.defaultform[13] = "     - begin of day: ";
        this.defaultform[14] = "     - end of day: ";
        this.defaultform[15] = " ";
        this.defaultform[16] = "Details:";
        this.defaultform[17] = " ";
    }
    
    public void prepareTextForPrint(){
        this.pretext = new ArrayList<>();
        this.pretext.add(this.defaultform[0]);
        this.pretext.add(this.defaultform[1]);
        this.pretext.add(this.defaultform[2] + this.totalorder);
        
        this.pretext.add(this.defaultform[3] + localizedFormat("###,###.###", totalorderamount, Locale.US));
        this.pretext.add(this.defaultform[4] + localizedFormat("###,###.###", totaldiscount, Locale.US));
        this.pretext.add(this.defaultform[5] + localizedFormat("###,###.###", totalcustomerpay, Locale.US));
        this.pretext.add(this.defaultform[6] + localizedFormat("###,###.###", totalchange, Locale.US));
        this.pretext.add(this.defaultform[7]);
        this.pretext.add(this.defaultform[8]);
        this.pretext.add(this.defaultform[9] + localizedFormat("###,###.###", totalfoodpurchase, Locale.US));
        this.pretext.add(this.defaultform[10] + localizedFormat("###,###.###", totalotherpurchase, Locale.US));
        this.pretext.add(this.defaultform[11]);
        this.pretext.add(this.defaultform[12]);
        this.pretext.add(this.defaultform[13] + localizedFormat("###,###.###", beginofday, Locale.US));
        this.pretext.add(this.defaultform[14] + localizedFormat("###,###.###", endofday, Locale.US));
        this.pretext.add(this.defaultform[15]);
        this.pretext.add(this.defaultform[16]);
        this.pretext.add(this.defaultform[17]);
        
        
        this.posttext = new ArrayList<>();          // hiện tại chưa dùng đến
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

    public int getTotalorder() {
        return totalorder;
    }

    public int getTotalorderamount() {
        return totalorderamount;
    }

    public int getTotalcustomerpay() {
        return totalcustomerpay;
    }

    public int getTotalchange() {
        return totalchange;
    }

    public int getTotalfoodpurchase() {
        return totalfoodpurchase;
    }

    public int getTotalotherpurchase() {
        return totalotherpurchase;
    }

    public int getBeginofday() {
        return beginofday;
    }

    public int getEndofday() {
        return endofday;
    }

    public int getTotaldiscount() {
        return totaldiscount;
    }

    public LocalDate getDayreport() {
        return dayreport;
    }

    public ArrayList<String> getPretext() {
        return pretext;
    }

    public ArrayList<String> getPosttext() {
        return posttext;
    }

    public void setDefaultform(String[] defaultform) {
        this.defaultform = defaultform;
    }

    public void setTotalorder(int totalorder) {
        this.totalorder = totalorder;
    }

    public void setTotalorderamount(int totalorderamount) {
        this.totalorderamount = totalorderamount;
    }

    public void setTotalcustomerpay(int totalcustomerpay) {
        this.totalcustomerpay = totalcustomerpay;
    }

    public void setTotalchange(int totalchange) {
        this.totalchange = totalchange;
    }

    public void setTotalfoodpurchase(int totalfoodpurchase) {
        this.totalfoodpurchase = totalfoodpurchase;
    }

    public void setTotalotherpurchase(int totalotherpurchase) {
        this.totalotherpurchase = totalotherpurchase;
    }

    public void setBeginofday(int beginofday) {
        this.beginofday = beginofday;
    }

    public void setEndofday(int endofday) {
        this.endofday = endofday;
    }

    public void setTotaldiscount(int totaldiscount) {
        this.totaldiscount = totaldiscount;
    }

    public void setDayreport(LocalDate dayreport) {
        this.dayreport = dayreport;
    }

    public void setPretext(ArrayList<String> pretext) {
        this.pretext = pretext;
    }

    public void setPosttext(ArrayList<String> posttext) {
        this.posttext = posttext;
    }

    public Integer[] getBoldline() {
        return new Integer[] {0, 1, 8, 12, 16};
    }
}
