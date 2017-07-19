/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import connection.DBConnect;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class TestConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection cn = new DBConnect().getCon();
            System.out.println(cn);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
