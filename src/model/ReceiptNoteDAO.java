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
import java.util.logging.Level;
import java.util.logging.Logger;
import supportclass.Pair;

/**
 *
 * @author DELL
 */
public class ReceiptNoteDAO {
    public static int insert(Pair<ReceiptNote, ArrayList<ReceiptNoteDetails>> new_rn){
    	String sql = "SELECT COUNT(rn_id) FROM tbReceiptNote";
    	try(Connection cn = new DBConnect().getCon();
    			PreparedStatement st = cn.prepareStatement(sql);
    			ResultSet rs = st.executeQuery();){
    		if(rs.next()){
    			int current_number_oftbReceiptNote = rs.getInt(1);
    			String newid = createid("RN", String.valueOf(current_number_oftbReceiptNote+1), 10);
    			new_rn.getFirst().setRn_id(newid);
    			for(ReceiptNoteDetails iter : new_rn.getSecond()){
    				iter.setRn_id(newid);
    			}

    			sql = "INSERT INTO tbReceiptNote VALUES(?, ?, ?, ?)";
    			try(PreparedStatement st2 = cn.prepareStatement(sql)){
    				st2.setString(1, new_rn.getFirst().getRn_id());
    				st2.setString(2, new_rn.getFirst().getEm_id());
    				st2.setDate(3, new_rn.getFirst().getRday());
    				st2.setFloat(4, new_rn.getFirst().getTotal_amount());

    				st2.executeUpdate();

    				sql = "INSERT INTO tbReceiptNoteDetails VALUES(?, ?, ?, ?, ?)";
    				try(PreparedStatement st3 = cn.prepareStatement(sql)){
    					for(ReceiptNoteDetails iter : new_rn.getSecond()){
    						st3.setString(1, iter.getRn_id());
    						st3.setString(2, iter.getFm_id());
    						st3.setInt(3, iter.getQuan());
    						st3.setFloat(4, iter.getItem_price());
    						st3.setString(5, iter.getNote());

    						st3.executeUpdate();
    					}

    					return 1;
    				}
    			}
    		}
    	} catch (SQLException ex) {
    		ex.printStackTrace();
            Logger.getLogger(ReceiptNoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }




    // WARNING: những DAO có dùng hàm createid thì các record đã tạo rồi sẽ không xoá. Tức là ko nên tạo method delete() để xoá record trong table
    private static String createid(String startid, String number_want_toset, int idsize) {
        String str_result = "";
        
        int blank = idsize - (startid.length() + number_want_toset.length());
        str_result += startid;
        for(int i = 0; i < blank; i++){
            str_result += "0";
        }
        str_result += number_want_toset;
        
        return str_result;
    }
}