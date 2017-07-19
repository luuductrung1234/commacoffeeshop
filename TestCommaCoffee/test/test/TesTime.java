/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author DELL
 */
public class TesTime {
    static public String localizedFormat(String pattern, double value, Locale loc ) {
        NumberFormat nf = NumberFormat.getNumberInstance(loc);
        DecimalFormat df = (DecimalFormat)nf;
        df.applyPattern(pattern);
        String output = df.format(value);
        return output;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("aaaa                           1       1");
        System.out.println("aaaaaaaa                      21       1");
        System.out.println("aaaa                           1       1");
        System.out.println("aa aaaaaaaa                   21       1");
    }
    
}
