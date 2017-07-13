/*

 */
package model;

import java.util.*;
import java.sql.*;
import entities.*;
import connection.DBConnect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO {
    
    public static List<Customer> getList()
    {
        List<Customer> ds = new ArrayList<>();
        String sql = "SELECT * FROM tbCustomer";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();)
        {
            while(rs.next())
            {
                Customer newitem = new Customer();
                newitem.setCus_id(rs.getString(1));
                newitem.setName(rs.getString(2));
                newitem.setPhone(rs.getString(3));
                newitem.setEmail(rs.getString(4));
                newitem.setDiscount(rs.getInt(5));
                ds.add(newitem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }
    
    
    public static int insert(Customer new_cus)
    {
        String sql = "SELECT COUNT(cus_id) FROM tbCustomer";                        // tạo id mới cho customer cần thêm vào database
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();){
            
            if(rs.next()){
                int current_number_oftbCustomer = rs.getInt(1);
                
                sql = "INSERT INTO tbCustomer VALUES (?, ?, ?, ?, ?)";
                int result = 0;
                do{
                    String newid = createid("CUS", String.valueOf(++current_number_oftbCustomer), 10);
                    new_cus.setCus_id(newid);

                    try(PreparedStatement st2 = cn.prepareStatement(sql);){
                        st2.setString(1, new_cus.getCus_id());
                        st2.setString(2, new_cus.getName());
                        st2.setString(3, new_cus.getPhone());
                        st2.setString(4, new_cus.getEmail());
                        st2.setInt(5, new_cus.getDiscount());

                        result = st2.executeUpdate();
                    }
                }while(result == 0);
                return result;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    
    public static int update(Customer c, String newname, String newphone, String newemail, int newdiscount)
    {
        String sql = "UPDATE tbCustomer SET name = ?, phone = ?, email = ?, discount = ? WHERE cus_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);)
        {
            st.setString(1, newname);
            st.setString(2, newphone);
            st.setString(3, newemail);
            st.setInt(4, newdiscount);
            st.setString(5, c.getCus_id());
            
            return st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    
    public static int delete(String cus_id)
    {
        String sql = "DELETE tbCustomer WHERE cus_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
            
            st.setString(1, cus_id);
            
            return st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
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
