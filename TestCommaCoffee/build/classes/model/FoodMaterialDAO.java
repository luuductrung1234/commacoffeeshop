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
    
    public static int insert(FoodMaterial new_fm)
    {
        String sql = "SELECT COUNT(fm_id) FROM tbFoodMaterial";                        // tạo id mới cho foodmaterial cần thêm vào database
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();){
            
            if(rs.next()){
                int current_number_oftbFoodMaterial = rs.getInt(1);
                
                sql = "INSERT tbFoodMaterial VALUES (?, ?, ?, ?, ?, ?, ?)";
                int result = 0;
                do{
                String newid = createid("F", String.valueOf(++current_number_oftbFoodMaterial), 10);
                new_fm.setFm_id(newid);
        
                try(PreparedStatement st2 = cn.prepareStatement(sql);){

                    st2.setString(1, new_fm.getFm_id());
                    st2.setString(2, new_fm.getName());
                    st2.setString(3, new_fm.getInfo());
                    st2.setByte(4, new_fm.getUsefor());
                    st2.setString(5, new_fm.getFmtype());
                    st2.setString(6, new_fm.getUnit_buy());
                    st2.setString(7, new_fm.getSupplier());

                    result = st2.executeUpdate();
                }
                }while(result == 0);
                return result;
            }
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
