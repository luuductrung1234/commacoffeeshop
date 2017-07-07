/*

 */
package model;

import java.util.*;
import java.sql.*;
import entities.*;
import connection.DBConnect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodDetailsDAO {
    
    public static List<FoodDetails> getList()
    {
        List<FoodDetails> ds = new ArrayList<>();
        String sql = "SELECT * FROM tbFoodDetails";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();){

            while(rs.next())
            {
                FoodDetails newitem = new FoodDetails();
                newitem.setFd_id(rs.getString(1));
                newitem.setFood_id(rs.getString(2));
                newitem.setFm_id(rs.getString(3));
                newitem.setQuan(rs.getFloat(4));
                newitem.setUnit_use(rs.getString(5));
                
                ds.add(newitem);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }
    
    public static int insert(FoodDetails fd)
    {
        String sql = "insert tbFoodDetails values(?, ?, ?, ?, ?)";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, fd.getFd_id());
            pst.setString(2, fd.getFood_id());
            pst.setString(3, fd.getFm_id());
            pst.setFloat(4, fd.getQuan());
            pst.setString(5, fd.getUnit_use());
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int update(FoodDetails old_fd, String newfoodid, String newfmid, float newquan, String newunituse)
    {
        String sql = "UPDATE tbFoodDetails SET food_id = ?, fm_id = ?, quan = ?, unit_use = ? WHERE fd_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, newfoodid);
            pst.setString(2, newfmid);
            pst.setFloat(3, newquan);
            pst.setString(4, newunituse);
            pst.setString(5, old_fd.getFd_id());
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int delete(String fd_id)
    {
        String sql = "delete tbFoodDetails where fd_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, fd_id);
            
            return pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
}
