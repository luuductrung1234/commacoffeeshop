/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.DBConnect;
import entities.ReceiptNote;
import entities.ReceiptNoteDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ReceiptNoteDetailsDAO {
    
// HIGHT LEVEL PROCESS
    public static List<ReceiptNoteDetails> getList()
    {
        List<ReceiptNoteDetails> ds = new ArrayList<>();
        String sql = "SELECT * FROM tbReceiptNoteDetails";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery())
        {
            while(rs.next()){
                ReceiptNoteDetails newitem = new ReceiptNoteDetails();
                newitem.setRn_id(rs.getString(1));
                newitem.setFm_id(rs.getString(2));
                newitem.setQuan(rs.getInt(3));
                newitem.setItem_price(rs.getFloat(4));
                newitem.setNote(rs.getString(5));
                ds.add(newitem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return ds;
    }
}
