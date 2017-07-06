/*

 */
package model;

import java.util.*;
import java.sql.*;
import entities.*;
import connection.DBConnect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodMaterialDAO {
    
    public static List<FoodMaterial> getList()
    {
        List<FoodMaterial> ds = new ArrayList<>();
        String sql = "SELECT * FROM tbFoodMaterial";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();){
            
            while(rs.next())
            {
                FoodMaterial newitem = new FoodMaterial();
                newitem.setFm_id(rs.getString(1));
                newitem.setName(rs.getString(1));
                newitem.setInfo(rs.getString(1));
                newitem.setIsfordrink(rs.getByte(1));
                newitem.setKind(rs.getString(1));
                newitem.setUnit_buy(rs.getString(1));
                newitem.setWeight_unit_buy(rs.getFloat(1));
                newitem.setPrice_unit_buy(rs.getInt(1));
                newitem.setStock_weight(rs.getFloat(1));
                newitem.setFm_status(rs.getByte(1));
                newitem.setSupply_contact(rs.getString(1));
                
                ds.add(newitem);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }
    
    public static int insert(FoodMaterial fm)
    {
        String sql = "INSERT tbFoodMaterial VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, fm.getFm_id());
            pst.setString(2, fm.getName());
            pst.setString(3, fm.getInfo());
            pst.setByte(4, fm.getIsfordrink());
            pst.setString(5, fm.getKind());
            pst.setString(6, fm.getUnit_buy());
            pst.setFloat(7, fm.getWeight_unit_buy());
            pst.setInt(8, fm.getPrice_unit_buy());
            pst.setFloat(9, fm.getStock_weight());
            pst.setByte(10, fm.getFm_status());
            pst.setString(11, fm.getSupply_contact());
            
            return pst.executeUpdate();
        } catch (SQLException ex) { 
            ex.printStackTrace();
            Logger.getLogger(FoodMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int update(FoodMaterial fm)
    {
        String sql = "UPDATE tbFoodMaterial SET name = ?, info = ?, isfordrink = ?, kind = ?, unit_buy = ?, weight_unit_buy = ?, price_unit_buy = ?, stock_weight = ?, fm_status = ?, supply_contact = ? WHERE fm_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, fm.getName());
            pst.setString(2, fm.getInfo());
            pst.setByte(3, fm.getIsfordrink());
            pst.setString(4, fm.getKind());
            pst.setString(5, fm.getUnit_buy());
            pst.setFloat(6, fm.getWeight_unit_buy());
            pst.setInt(7, fm.getPrice_unit_buy());
            pst.setFloat(8, fm.getStock_weight());
            pst.setByte(9, fm.getFm_status());
            pst.setString(10, fm.getSupply_contact());
            pst.setString(11, fm.getFm_id());
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int delete(String fm_id)
    {
        String sql = "DELETE tbFoodMaterial WHERE fm_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, fm_id);
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
}
