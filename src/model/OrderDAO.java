/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.DBConnect;
import entities.Order;
import entities.OrderDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class OrderDAO {
    public static int insert(Entry<Order, ArrayList<OrderDetails>> new_order){// thêm cả order và cả các orderdetails của nó
        String sql = "SELECT COUNT(order_id) FROM tbOrder";                    // tạo id mới cho order cần thêm vào database
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();){
            
            if(rs.next()){
                int current_number_oftbOrder = rs.getInt(1);
                String newid = createid("ORD", String.valueOf(current_number_oftbOrder + 1), 10);
                new_order.getKey().setOrder_id(newid);
                for(OrderDetails iter : new_order.getValue()){
                    iter.setOrder_id(newid);
                }
                
                sql = "INSERT INTO tbOrder VALUES (?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement st2 = cn.prepareStatement(sql)){
                    st2.setString(1, new_order.getKey().getOrder_id());
                    st2.setString(2, new_order.getKey().getCus_id());
                    st2.setInt(3, new_order.getKey().getOrdertable());
                    st2.setDate(4, new_order.getKey().getOrdertime());
                    st2.setFloat(5, new_order.getKey().getPrice());
                    st2.setFloat(6, new_order.getKey().getCustomerpay());
                    st2.setFloat(7, new_order.getKey().getPayback());
                    
                    st2.executeUpdate();
                    
                    sql = "INSERT INTO tbOrderDetails VALUES (?, ?, ?)";
                    try(PreparedStatement st3 = cn.prepareStatement(sql)){
                        for(OrderDetails iter : new_order.getValue()){
                            st3.setString(1, newid);
                            st3.setString(2, iter.getFood_id());
                            st3.setInt(3, iter.getQuan());
                            
                            st3.executeUpdate();
                        }
                        
                        return 1;
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

// HIGHT LEVEL PROCESS
    public static List<Order> getList()
    {
        List<Order> ds = new ArrayList<>();
        String sql = "SELECT * FROM tbOrder";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery())
        {
            while(rs.next()){
                Order newitem = new Order();
                newitem.setOrder_id(rs.getString(1));
                newitem.setCus_id(rs.getString(2));
                newitem.setOrdertable(rs.getInt(3));
                newitem.setOrdertime(rs.getDate(4));
                newitem.setPrice(rs.getInt(5));
                newitem.setCustomerpay(rs.getInt(6));
                newitem.setPayback(rs.getInt(7));
                ds.add(newitem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return ds;
    }
    
    public static int delete(String cus_id)
    {
        String sql = "DELETE tbOrder WHERE cus_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
            
            st.setString(1, cus_id);
            
            return st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static List<Order> getlist_indate(java.sql.Date indate){
        ArrayList<Order> resultlist = new ArrayList<>();
        String sql = "SELECT * FROM tbOrder WHERE ordertime = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
            
            st.setDate(1, indate);
            
            try (ResultSet rs = st.executeQuery()) {
                while(rs.next()){
                    Order newitem = new Order();
                    newitem.setOrder_id(rs.getString(1));
                    newitem.setCus_id(rs.getString(2));
                    newitem.setOrdertable(rs.getInt(3));
                    newitem.setOrdertime(rs.getDate(4));
                    newitem.setPrice(rs.getFloat(5));
                    newitem.setCustomerpay(rs.getFloat(6));
                    newitem.setPayback(rs.getFloat(7));
                    
                    resultlist.add(newitem);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return resultlist;
    }
    
    public static float getTodaySale(java.sql.Date indate) {
        float total = 0;
        
        String sql = "SELECT ordertime, SUM(price) FROM tbOrder GROUP BY ordertime HAVING ordertime = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
            
            st.setDate(1, indate);
            
            try (ResultSet rs = st.executeQuery()) {
                while(rs.next()){
                    total = rs.getFloat(2);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return total;
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
