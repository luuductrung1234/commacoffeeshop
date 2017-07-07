/*

 */
package model;

import java.util.*;
import java.sql.*;
import entities.*;
import connection.DBConnect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodDAO {
    
    public static List<Food> getList()
    {
        List<Food> ds = new ArrayList<>();
        String sql = "SELECT * FROM tbFood";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();)
        {
            while(rs.next())
            {
                Food newrecord = new Food();
                newrecord.setFood_id(rs.getString(1));
                newrecord.setName(rs.getString(2));
                newrecord.setInfo(rs.getString(3));
                newrecord.setPrice(rs.getInt(4));
                newrecord.setIsdrink(rs.getByte(5));
                
                ds.add(newrecord);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }
    
    public static int insert(Food f)
    {
        String sql = "INSERT tbFood VALUES (?, ?, ?, ?, ?)";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, f.getFood_id());
            pst.setString(2, f.getName());
            pst.setString(3, f.getInfo());
            pst.setInt(4, f.getPrice());
            pst.setByte(5, f.getIsdrink());
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int update(Food old_food, String newname, String newinfo, int newprice, byte newisdrink)
    {
        String sql = "UPDATE tbFood SET name = ?, info = ?, price = ?, isdrink = ? WHERE food_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, newname);
            pst.setString(2, newinfo);
            pst.setInt(3, newprice);
            pst.setByte(4, newisdrink);
            pst.setString(5, old_food.getFood_id());
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int delete(String food_id)
    {
        String sql = "DELETE tbFood WHERE food_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, food_id);
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
}
