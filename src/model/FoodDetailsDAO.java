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
    
    public static int insert(FoodDetails new_fd)
    {
        String sql = "SELECT COUNT(fd_id) FROM tbFoodDetails";                        // tạo id mới cho fooddetails cần thêm vào database
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();){
            
            if(rs.next()){
                int current_number_oftbFoodDetails = rs.getInt(1);
                String newid = createid("F", String.valueOf(current_number_oftbFoodDetails + 1), 10);
                new_fd.setFd_id(newid);
        
        
                sql = "insert tbFoodDetails values(?, ?, ?, ?, ?)";
                try(PreparedStatement st2 = cn.prepareStatement(sql);){

                    st2.setString(1, new_fd.getFd_id());
                    st2.setString(2, new_fd.getFood_id());
                    st2.setString(3, new_fd.getFm_id());
                    st2.setFloat(4, new_fd.getQuan());
                    st2.setString(5, new_fd.getUnit_use());

                    return st2.executeUpdate();
                }
            }
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
    
    public static int deletefm(String fm_id)
    {
        String sql = "delete tbFoodDetails where fm_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, fm_id);
            
            return pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
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
