/*

 */
package model;

import java.util.*;
import java.sql.*;
import entities.*;
import connection.DBConnect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDAO {

//SELF EDITING
    public static Admin check(String ad_id, String pass)
    {
        Admin adresult = null;
        String sql = "SELECT * FROM tbAdmin WHERE ad_id LIKE ? AND pass LIKE ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);)
        {
            st.setString(1, ad_id);
            st.setString(2, pass);
            try (ResultSet rs = st.executeQuery()) {
                String name = rs.getString(3);
                int ad_role = rs.getInt(4);
                adresult = new Admin(ad_id, pass, name, ad_role);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return adresult;
    }
     
    public static int changePass(Admin a)
    {
        try(Connection cn = new DBConnect().getCon())
        {
            String sql = "update tbAdmin set pass = ? where ad_id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, a.getPass());
            pst.setString(2, a.getAd_id());
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return 0;
    }
    
    
    public static int update(Admin in_admin)
    {
        String sql = "update tbAdmin set pass = ?, name = ?, ad_role = ? where ad_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);)
        {
            st.setString(1, in_admin.getPass());
            st.setString(2, in_admin.getName());
            st.setInt(3, in_admin.getAd_role());
            st.setString(4, in_admin.getAd_id());
            
            return st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
        return 0;
    }
// END SELF EDITING
    
    
// REQUIRE ADMIN'S ROLE
    public static List<Admin> getList()
    {
        List<Admin> ds = new ArrayList<>();
        String sql = "SELECT * FROM tbAdmin";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery())
        {
            while(rs.next()){
                Admin newitem = new Admin();
                newitem.setAd_id(rs.getString(1));
                newitem.setPass(rs.getString(2));
                newitem.setName(rs.getString(3));
                newitem.setAd_role(rs.getInt(4));
                ds.add(newitem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return ds;
    }
    
    public static int insert(Admin new_ad, int your_role)
    {
        if(new_ad.getAd_role() > your_role)      // không thể add admin có quyền cao hơn bản thân
            return 0;
        
        String sql = "INSERT INTO tbAdmin VALUES (?, ?, ?, ?)";
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);)
        {
            pst.setString(1, new_ad.getAd_id());
            pst.setString(2, new_ad.getPass());
            pst.setString(3, new_ad.getName());
            pst.setInt(4, new_ad.getAd_role());
            
            return pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    
    public static int delete(String ad_id, int your_role)
    {
        String sql = "SELECT * FROM tbAdmin WHERE ad_id = ?";
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
            
            st.setString(1, ad_id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                if(rs.getInt(4) >= your_role)        // không thể xoá tài khoản cấp độ cao hơn bản thân
                    return 0;
            }
            
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql = "DELETE tbAdmin WHERE ad_id = ?";
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
            st.setString(1, ad_id);
            
            return st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
// END REQUIRE ADMIN'S ROLE
}
