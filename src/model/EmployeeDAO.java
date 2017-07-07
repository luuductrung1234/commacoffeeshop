/*

 */
package model;

import java.util.*;
import java.sql.*;
import entities.*;
import connection.DBConnect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {

// SELF EDITING
    public static Employee check(String username, String pass)
    {
        Employee empresult = null;
        String sql = "SELECT * FROM tbEmployee WHERE username = ? AND pass = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
        
            st.setString(1, username);
            st.setString(2, pass);
            
            try(ResultSet rs = st.executeQuery();){
                if(rs.next()){
                    empresult = new Employee();
                    empresult.setEm_id(rs.getString(1));
                    empresult.setUsername(rs.getString(2));
                    empresult.setPass(rs.getString(3));
                    empresult.setName(rs.getString(4));
                    empresult.setBirth(rs.getDate(5));
                    empresult.setStartday(rs.getDate(6));
                    empresult.setAddr(rs.getString(7));
                    empresult.setEmail(rs.getString(8));
                    empresult.setPhone(rs.getString(9));
                    empresult.setEm_role(rs.getInt(10));
                    empresult.setManager(rs.getString(11));

                    return empresult;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return empresult;
    }
     
    public static int changePass(Employee old_emp, String newpass)
    {
        String sql = "UPDATE tbEmployee SET pass = ? WHERE em_id = ?, username = ?, pass = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
            
            st.setString(1, newpass);
            st.setString(2, old_emp.getEm_id());
            st.setString(3, old_emp.getUsername());
            st.setString(4, old_emp.getPass());
            
            return st.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int update(Employee old_emp, String newusername, String newpass, String newname, java.sql.Date newbirth, java.sql.Date newstartday, String newaddr, String newemail, String newphone, String newrole, String newmanager)
    {
        String sql = "UPDATE tbEmployee SET username = ?, pass = ?, name = ?, birth = ?, startday = ?, addr = ?, email = ?, phone = ?, em_role, manager = ? WHERE em_id = ?, username = ?, pass = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
            
            st.setString(1, newusername);
            st.setString(2, newpass);
            st.setString(3, newname);
            st.setDate(4, newbirth);
            st.setDate(5, newstartday);
            st.setString(6, newaddr);
            st.setString(7, newemail);
            st.setString(8, newphone);
            st.setString(9, newrole);
            st.setString(10, newmanager);
            st.setString(11, old_emp.getEm_id());
            st.setString(12, old_emp.getUsername());
            st.setString(13, old_emp.getPass());
            
            return st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
// END SELF EDITING
    
    
// HIGHT LEVEL PROCESS
    public static List<Employee> getList()
    {
        List<Employee> ds = new ArrayList<>();
        String sql = "SELECT * FROM tbEmployee";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();){

            while(rs.next())
            {
                Employee newitem = new Employee();
                newitem.setEm_id(rs.getString(1));
                newitem.setUsername(rs.getString(2));
                newitem.setPass(rs.getString(3));
                newitem.setName(rs.getString(4));
                newitem.setBirth(rs.getDate(5));
                newitem.setStartday(rs.getDate(6));
                newitem.setAddr(rs.getString(7));
                newitem.setEmail(rs.getString(8));
                newitem.setPhone(rs.getString(9));
                newitem.setEm_role(rs.getInt(10));
                newitem.setManager(rs.getString(11));
                
                ds.add(newitem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }
    
    
    public static int insert(Employee e)
    {
        String sql = "INSERT tbEmployee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, e.getEm_id());
            pst.setString(2, e.getUsername());
            pst.setString(3, e.getPass());
            pst.setString(4, e.getName());
            pst.setDate(5, e.getBirth());
            pst.setDate(6, e.getStartday());
            pst.setString(7, e.getAddr());
            pst.setString(8, e.getEmail());
            pst.setString(9, e.getPhone());
            pst.setInt(10, e.getEm_role());
            pst.setString(11, e.getManager());
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    
    public static int delete(String em_id)
    {
        String sql = "DELETE tbEmployee WHERE em_id = ?";
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, em_id);
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
// HIGHT LEVEL PROCESS
}
