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
                newitem.setName(rs.getString(2));
                newitem.setInfo(rs.getString(3));
                newitem.setUsefor(rs.getByte(4));
                newitem.setFmtype(rs.getString(5));
                newitem.setUnit_buy(rs.getString(6));
                newitem.setSupplier(rs.getString(7));
                
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
        String sql = "INSERT tbFoodMaterial VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, fm.getFm_id());
            pst.setString(2, fm.getName());
            pst.setString(3, fm.getInfo());
            pst.setByte(4, fm.getUsefor());
            pst.setString(5, fm.getFmtype());
            pst.setString(6, fm.getUnit_buy());
            pst.setString(7, fm.getSupplier());
            
            return pst.executeUpdate();
        } catch (SQLException ex) { 
            ex.printStackTrace();
            Logger.getLogger(FoodMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int update(FoodMaterial fm, String newname, String newinfo, byte newusefor, String newfmtype, String newunitbuy, String newsupplier)
    {
        String sql = "UPDATE tbFoodMaterial SET name = ?, info = ?, usefor = ?, fmtype = ?, unit_buy = ?, supplier = ? WHERE fm_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, fm.getName());
            pst.setString(2, fm.getInfo());
            pst.setByte(3, fm.getUsefor());
            pst.setString(4, fm.getFmtype());
            pst.setString(5, fm.getUnit_buy());
            pst.setString(6, fm.getSupplier());
            pst.setString(7, fm.getFm_id());
            
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
