/*

 */
package model;

import java.util.*;
import java.sql.*;
import entities.*;
import connection.DBConnect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO {
    
    public static List<Customer> getList()
    {
        List<Customer> ds = new ArrayList<>();
        String sql = "SELECT * FROM tbCustomer";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();)
        {
            while(rs.next())
            {
                Customer newitem = new Customer();
                newitem.setCus_id(rs.getString(1));
                newitem.setName(rs.getString(2));
                newitem.setDis_percent(rs.getInt(3));
                ds.add(newitem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }
    
    
    public static int insert(Customer c)
    {
        String sql = "INSERT INTO tbCustomer VALUES (?, ?, ?)";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);)
        {
            st.setString(1, c.getCus_id());
            st.setString(2, c.getName());
            st.setInt(3, c.getDis_percent());
            
            return st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    
    public static int update(Customer c)
    {
        String sql = "UPDATE tbCustomer SET name = ?, dis_percent = ? where cus_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);)
        {
            st.setString(1, c.getName());
            st.setInt(2, c.getDis_percent());
            st.setString(3, c.getCus_id());
            
            return st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    
    public static int delete(String cus_id)
    {
        String sql = "DELETE tbCustomer WHERE cus_id = ?";
        
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
    
}
