/*

 */
package model;

import java.util.*;
import java.sql.*;
import entities.*;
import connection.DBConnect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodDAO {
    
    public static List<Food> getList()
    {
        List<Food> ds = new ArrayList<>();
        String sql = "SELECT * FROM tbFood";
                
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();)
        {
            while(rs.next())
            {
                Food newrecord = new Food();
                newrecord.setFood_id(rs.getString(1));
                newrecord.setName(rs.getString(2));
                newrecord.setInfo(rs.getString(3));
                newrecord.setPrice(rs.getInt(4));
                newrecord.setIsdrink(rs.getByte(5));
                
                ds.add(newrecord);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }
    
    public static int insert(Food new_food)
    {
        String sql = "SELECT COUNT(food_id) FROM tbFood";                        // tạo id mới cho food cần thêm vào database
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();){
            
            if(rs.next()){
                int current_number_oftbFood = rs.getInt(1);
                String newid = createid("F", String.valueOf(current_number_oftbFood + 1), 10);
                new_food.setFood_id(newid);
        
                sql = "INSERT tbFood VALUES (?, ?, ?, ?, ?)";                    // thêm food mới vào database
                try(PreparedStatement st2 = cn.prepareStatement(sql);){

                    st2.setString(1, new_food.getFood_id());
                    st2.setString(2, new_food.getName());
                    st2.setString(3, new_food.getInfo());
                    st2.setInt(4, new_food.getPrice());
                    st2.setByte(5, new_food.getIsdrink());

                    return st2.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int update(Food old_food, String newname, String newinfo, int newprice, byte newisdrink)
    {
        String sql = "UPDATE tbFood SET name = ?, info = ?, price = ?, isdrink = ? WHERE food_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, newname);
            pst.setString(2, newinfo);
            pst.setInt(3, newprice);
            pst.setByte(4, newisdrink);
            pst.setString(5, old_food.getFood_id());
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int delete(String food_id)
    {
        String sql = "DELETE tbFood WHERE food_id = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement pst = cn.prepareStatement(sql);){
            
            pst.setString(1, food_id);
            
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
