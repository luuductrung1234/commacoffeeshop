/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportclass;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;
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
    public String[] printtext = new String[17];
    
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
        
        
        /* Now we perform our rendering */
        int linesize = 10;
        for(int i = 0; i < this.printtext.length; i++){
            if(i == 11){
                g.setFont(new Font("Plain", 0, 8).deriveFont(Font.BOLD));
            }else{
                if(i == 0 || i == 5){
                    g.setFont(new Font("Plain", 0, 9).deriveFont(Font.BOLD));
                }else
                    g.setFont(new Font("Plain", 0, 8));
            }
                
            g.drawString(printtext[i], 0, linesize);
            linesize += 11;         // chuyển tọa độ sang dòng khác
        }

        return PAGE_EXISTS;
    }

    public PrintWithoutDialog(String printerName,  String[] printtext)
    {
        this.printtext = printtext;
        
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
    
    
    
    public static void main(String[] args){
        
    }
}