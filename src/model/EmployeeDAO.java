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
    public static Employee check(String em_id, String pass)
    {
        Employee empresult = null;
        String sql = "SELECT * FROM tbEmployee WHERE em_id LIKE ? AND pass LIKE ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
            
            st.setString(1, em_id);
            st.setString(2, pass);
            
            try(ResultSet rs = st.executeQuery()){
                String name = rs.getString(3);
                int age = rs.getInt(4);
                java.util.Date startday = rs.getDate(5);
                String addr = rs.getString(6);
                String email = rs.getString(7);
                String phone = rs.getString(8);
                int em_role = rs.getInt(9);
                String manager = rs.getString(10);

                empresult = new Employee(em_id, name, startday, addr, email, phone, em_role, manager, pass, age);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return empresult;
    }
     
    public static int changePass(Employee e)
    {
        String sql = "UPDATE tbEmployee SET pass = ? WHERE em_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            pst.setString(1, e.getPass());
            pst.setString(2, e.getEm_id());
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int update(Employee e)
    {
        String sql = "UPDATE tbEmployee SET name = ?, startday = ?, addr = ?, email = ?, phone = ?, em_role = ?, manager = ?, pass = ?, age = ? WHERE em_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, e.getName());
            pst.setString(2, e.getStartday().toString());
            pst.setString(3, e.getAddr());
            pst.setString(4, e.getEmail());
            pst.setString(5, e.getPhone());
            pst.setInt(6, e.getEm_role());
            pst.setString(7, e.getManager());
            pst.setString(8, e.getPass());
            pst.setInt(9, e.getAge());
            pst.setString(10, e.getEm_id());
            
            return pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
// END SELF EDITING
    
    
// REQUIRE ADMIN'S ROLE
    public static List<Employee> getList()
    {
        List<Employee> ds = new ArrayList<>();
        String sql = "select * from tbEmployee";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();){

            while(rs.next())
            {
                Employee newitem = new Employee();
                newitem.setEm_id(rs.getString(1));
                newitem.setPass(rs.getString(2));
                newitem.setName(rs.getString(3));
                newitem.setAge(rs.getInt(4));
                newitem.setStartday(rs.getDate(5));
                newitem.setAddr(rs.getString(6));
                newitem.setEmail(rs.getString(7));
                newitem.setPhone(rs.getString(8));
                newitem.setEm_role(rs.getInt(9));
                newitem.setManager(rs.getString(10));
                
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
        String sql = "INSERT tbEmployee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, e.getEm_id());
            pst.setString(2, e.getPass());
            pst.setString(3, e.getName());
            pst.setInt(4, e.getAge());
            pst.setString(5, e.getStartday().toString());
            pst.setString(6, e.getAddr());
            pst.setString(7, e.getEmail());
            pst.setString(8, e.getPhone());
            pst.setInt(9, e.getEm_role());
            pst.setString(10, e.getManager());
            
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
// END REQUIRE ADMIN'S ROLE
}
