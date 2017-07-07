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
    public static Admin check(String username, String pass)
    {
        String sql = "SELECT * FROM tbAdmin WHERE username = ? AND pass = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
            st.setString(1, username);
            st.setString(2, pass);
            
            try(ResultSet rs = st.executeQuery();)
            {
                if(rs.next()){
                    Admin adresult = new Admin(rs.getString(1), username, pass, rs.getString(4));
                    return adresult;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
     
    public static int changePass(Admin old_admin, String newpass)
    {
        String sql = "UPDATE tbAdmin SET pass = ? WHERE ad_id = ? AND username = ? AND pass = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, newpass);
            pst.setString(2, old_admin.getAd_id());
            pst.setString(3, old_admin.getUsername());
            pst.setString(4, old_admin.getUsername());
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return 0;
    }
    
    
    public static int update(Admin old_admin, String newusername, String newpass, String newname)
    {
        String sql = "UPDATE tbAdmin SET username = ?, pass = ?, name = ? WHERE ad_id = ? AND username = ? AND pass = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);)
        {
            st.setString(1, newusername);
            st.setString(2, newpass);
            st.setString(3, newname);
            st.setString(4, old_admin.getAd_id());
            st.setString(5, old_admin.getUsername());
            st.setString(6, old_admin.getPass());
            
            return st.executeUpdate();
            
        } catch (SQLException ex) { 
            ex.printStackTrace();
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
// END SELF EDITING
    
    
    
// HIGHT LEVEL PROCESS
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
                newitem.setUsername(rs.getString(2));
                newitem.setPass(rs.getString(3));
                newitem.setName(rs.getString(4));
                ds.add(newitem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return ds;
    }
    
    public static int insert(Admin new_ad, int your_role)
    {
        String sql = "INSERT INTO tbAdmin VALUES (?, ?, ?, ?)";
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);)
        {
            pst.setString(1, new_ad.getAd_id());
            pst.setString(2, new_ad.getUsername());
            pst.setString(3, new_ad.getPass());
            pst.setString(4, new_ad.getName());
            
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
// END HIGHT LEVEL PROCESS
}
