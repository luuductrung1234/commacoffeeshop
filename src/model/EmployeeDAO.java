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
                    empresult.setHour_wage(rs.getInt(7));
                    empresult.setAddr(rs.getString(8));
                    empresult.setEmail(rs.getString(9));
                    empresult.setPhone(rs.getString(10));
                    empresult.setEm_role(rs.getInt(11));
                    empresult.setManager(rs.getString(12));

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
                newitem.setHour_wage(rs.getInt(7));
                newitem.setAddr(rs.getString(8));
                newitem.setEmail(rs.getString(9));
                newitem.setPhone(rs.getString(10));
                newitem.setEm_role(rs.getInt(11));
                newitem.setManager(rs.getString(12));
                
                ds.add(newitem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }
    
    public static int changeHourWage(String em_id, int newhourwage){
        String sql = "UPDATE tbEmployee SET hour_wage = ? WHERE em_id = ?";
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql)){
            st.setInt(1, newhourwage);
            st.setString(2, em_id);
            
            return st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    
    public static int insert(Employee new_emp)
    {
        String sql = "SELECT COUNT(em_id) FROM tbEmployee";                        // tạo id mới cho employee cần thêm vào database
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();){
            
            if(rs.next()){
                int current_number_oftbEmployee = rs.getInt(1);
                
                sql = "INSERT tbEmployee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                int result = 0;
                do{
                    String newid = createid("EM", String.valueOf(++current_number_oftbEmployee), 10);
                    new_emp.setEm_id(newid);



                    try(PreparedStatement st2 = cn.prepareStatement(sql);){

                        st2.setString(1, new_emp.getEm_id());
                        st2.setString(2, new_emp.getUsername());
                        st2.setString(3, new_emp.getPass());
                        st2.setString(4, new_emp.getName());
                        st2.setDate(5, new_emp.getBirth());
                        st2.setDate(6, new_emp.getStartday());
                        st2.setInt(7, new_emp.getHour_wage());
                        st2.setString(8, new_emp.getAddr());
                        st2.setString(9, new_emp.getEmail());
                        st2.setString(10, new_emp.getPhone());
                        st2.setInt(11, new_emp.getEm_role());
                        st2.setString(12, new_emp.getManager());

                        result = st2.executeUpdate();
                    }
                } while(result == 0);
                return result;
            }
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
