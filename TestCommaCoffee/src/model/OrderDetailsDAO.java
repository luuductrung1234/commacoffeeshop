/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.DBConnect;
import entities.OrderDetails;
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
public class OrderDetailsDAO {
    
    
    
    
    
    
// HIGHT LEVEL PROCESS
    public static List<OrderDetails> getList()
    {
        List<OrderDetails> ds = new ArrayList<>();
        String sql = "SELECT * FROM tbOrderDetails";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery())
        {
            
            while(rs.next()){
                OrderDetails newitem = new OrderDetails();
                newitem.setOrder_id(rs.getString(1));
                newitem.setFood_id(rs.getString(2));
                newitem.setQuan(rs.getInt(3));
                ds.add(newitem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return ds;
    }    
    
}
