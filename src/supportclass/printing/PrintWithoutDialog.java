/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportclass.printing;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.PrinterResolution;
/**
 *
 * @author ADMIN
 */
public class PrintWithoutDialog implements Printable 
{
    public static int TEMPORARY_PRINT = 1;
    public static int KITCHEN_PRINT = 2;
    public static int PAY_PRINT = 3;
    public static int REPORT_PRINT = 4;
    
    private Integer[] boldline;
    private String[] pretext;
    private ArrayList<TableItem> table;
    private String[] posttext;
    private int print_style;
    
    
    public PrintService findPrintService(String printerName)
    {
        for (PrintService service : PrinterJob.lookupPrintServices())
        {
            if (service.getName().equalsIgnoreCase(printerName))
                return service;
        }

        return null;
    }

    public int print(Graphics g, PageFormat pf, int page) throws PrinterException 
    {
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
        
        
        /* User (0,0) is typically outside the imageable area, so we must
        * translate by the X and Y values in the PageFormat to avoid clipping
        */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        
        
        switch(this.print_style){
            case 1:
                this.temporaryPrint(g);
                break;
            case 2:
                this.kitchenPrint(g);
                break;
            case 3:
                this.payPrint(g);
                break;
            case 4:
                this.reportprint(g);
                break;
        }
        

        return PAGE_EXISTS;
    }

    
    /*
    * @param    printerName : name of printer we need to find in system
    * @param    boldline : index of lines need to bold style
    * @param    pretext : the head info of bill
    * @param    table : the table of bill
    * @param    posttext : the tail info of bill
    */
    public PrintWithoutDialog(String printerName, Integer[] boldline, String[] pretext, ArrayList<TableItem> table, String[] posttext, int print_style)
    {
        // get information to printing
        this.boldline = boldline;
        this.pretext = pretext;
        this.table = table;
        this.posttext = posttext;
        this.print_style = print_style;
        
        //find the printService of name printerName
        PrintService ps = findPrintService(printerName);                                    
        //create a printerJob
        PrinterJob job = PrinterJob.getPrinterJob();

        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();         
        //aset.add(new PrinterResolution(300, 300, PrinterResolution.DPI));
        aset.add(new MediaPrintableArea(0, 0, 150, 300, MediaPrintableArea.MM));            // set the page size
        try {
            //set the printService found (should be tested)
            job.setPrintService(ps);
        } catch (PrinterException ex) {
            Logger.getLogger(PrintWithoutDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        //set the printable (an object with the print method that can be called by "job.print")
        job.setPrintable(this);                
        try {
            //call je print method of the Printable object
            job.print(aset);
        } catch (PrinterException ex) {
            Logger.getLogger(PrintWithoutDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
//PRINTING PROCEDURE
    private void temporaryPrint(Graphics g){
        /* in thông tin đầu bill */
        int linesize = 10;
        for(int i = 0; i < this.pretext.length; i++){
            g.setFont(new Font("Plain", 0, 8));
            for(Integer iter : this.boldline){
                if(i == iter){
                    g.setFont(new Font("Plain", 0, 9).deriveFont(Font.BOLD));
                    break;
                }
            }
            
            g.drawString(pretext[i], 0, linesize);
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
        
        /* in bảng bill */
        boolean firstline = true;
        int index;
        for(index = 0; index < this.table.size() - 2; index++){
            if(firstline){
                g.setFont(new Font("Plain", 0, 8).deriveFont(Font.BOLD));
                firstline = false;
            }else{
                g.setFont(new Font("Plain", 0, 8));
            }
            g.drawString(this.table.get(index).getProduct(), 0, linesize);
            g.drawString(this.table.get(index).getQuan(), 120, linesize);
            g.drawString(this.table.get(index).getPrice(), 140, linesize);
            g.drawString(this.table.get(index).getAmt(), 170, linesize);
            
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
        
        /* in phần tổng kết */
        // phần tổng kết mặc định được tạo chung với table
        // đối với temporary print thì 2 dòng cuối của table là chứ phần tổng kết
        for(; index < this.table.size(); index++){
            g.setFont(new Font("Plain", 0, 8).deriveFont(Font.BOLD));
            
            g.drawString(this.table.get(index).getProduct(), 80, linesize);
            g.drawString(this.table.get(index).getAmt(), 170, linesize);
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
        
        
        /* in thông tin cuối bill */
        for(int i = 0; i < this.posttext.length; i++){
            g.setFont(new Font("Plain", 0, 8).deriveFont(Font.BOLD));
            
            g.drawString(posttext[i], 0, linesize);
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
    }
    
    private void kitchenPrint(Graphics g){
        /* in thông tin đầu bill */
        int linesize = 10;
        for(int i = 0; i < this.pretext.length; i++){
            g.setFont(new Font("Plain", 0, 12));
            for(Integer iter : this.boldline){
                if(i == iter){
                    g.setFont(new Font("Plain", 0, 12).deriveFont(Font.BOLD));
                    break;
                }
            }
            
            g.drawString(pretext[i], 0, linesize);
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
        
        g.drawLine(0, linesize, 200, linesize);
        linesize += 11;
        
        /* in bảng bill */
        int index;
        for(index = 0; index < this.table.size(); index++){
            if(this.table.get(index).getQuan().length() == 0){
                g.setFont(new Font("Plain", 0, 11));
            }else{
                g.setFont(new Font("Plain", 0, 13).deriveFont(Font.BOLD));
            }
            
            g.drawString(this.table.get(index).getQuan(), 10, linesize);
            g.drawString(this.table.get(index).getProduct(), 30, linesize);
            
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
        
        
        /* in thông tin cuối bill */
    }
    
    private void payPrint(Graphics g){
        /* in thông tin đầu bill */
        int linesize = 10;
        for(int i = 0; i < this.pretext.length; i++){
            g.setFont(new Font("Plain", 0, 8));
            for(Integer iter : this.boldline){
                if(i == iter){
                    g.setFont(new Font("Plain", 0, 9).deriveFont(Font.BOLD));
                    break;
                }
            }
            
            g.drawString(pretext[i], 0, linesize);
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
        
        /* in bảng bill */
        boolean firstline = true;
        int index;
        for(index = 0; index < this.table.size() - 4; index++){
            if(firstline){
                g.setFont(new Font("Plain", 0, 8).deriveFont(Font.BOLD));
                firstline = false;
            }else{
                g.setFont(new Font("Plain", 0, 8));
            }
            g.drawString(this.table.get(index).getProduct(), 0, linesize);
            g.drawString(this.table.get(index).getQuan(), 120, linesize);
            g.drawString(this.table.get(index).getPrice(), 140, linesize);
            g.drawString(this.table.get(index).getAmt(), 170, linesize);
            
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
        
        /* in phần tổng kết */
        // phần tổng kết mặc định được tạo chung với table
        // đối với pay print thì 4 dòng cuối của table là chứ phần tổng kết
        for(; index < this.table.size(); index++){
            g.setFont(new Font("Plain", 0, 8).deriveFont(Font.BOLD));
            
            g.drawString(this.table.get(index).getProduct(), 80, linesize);
            g.drawString(this.table.get(index).getAmt(), 160, linesize);
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
        
        
        /* in thông tin cuối bill */
        for(int i = 0; i < this.posttext.length; i++){
            g.setFont(new Font("Plain", 0, 8).deriveFont(Font.BOLD));
            
            g.drawString(posttext[i], 0, linesize);
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
    }

    private void reportprint(Graphics g) {
        /* in thông tin đầu report */
        int linesize = 10;
        for(int i = 0; i < this.pretext.length; i++){
            g.setFont(new Font("Plain", 0, 8));
            for(Integer iter : this.boldline){
                if(i == iter){
                    g.setFont(new Font("Plain", 0, 9).deriveFont(Font.BOLD));
                    break;
                }
            }
            
            g.drawString(pretext[i], 0, linesize);
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
        
        
        /* in bảng chi tiết trong report */
        boolean firstline = true;
        int index;
        for(index = 0; index < this.table.size() - 2; index++){
            if(firstline){
                g.setFont(new Font("Plain", 0, 8).deriveFont(Font.BOLD));
                firstline = false;
            }else{
                g.setFont(new Font("Plain", 0, 8));
            }
            g.drawString(this.table.get(index).getProduct(), 0, linesize);
            g.drawString(this.table.get(index).getQuan(), 120, linesize);
            g.drawString(this.table.get(index).getAmt(), 170, linesize);
            
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
        
        /* in phần tổng kết */
        // phần tổng kết mặc định được tạo chung với table
        // đối với report print thì 1 dòng cuối của table là chứ phần tổng kết
        for(; index < this.table.size(); index++){
            g.setFont(new Font("Plain", 0, 8).deriveFont(Font.BOLD));
            
            g.drawString(this.table.get(index).getProduct(), 80, linesize);
            g.drawString(this.table.get(index).getAmt(), 160, linesize);
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
        
        
        
        /* in thông tin cuối bill */
        for(int i = 0; i < this.posttext.length; i++){
            g.setFont(new Font("Plain", 0, 8).deriveFont(Font.BOLD));
            
            g.drawString(posttext[i], 0, linesize);
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }
    }
}