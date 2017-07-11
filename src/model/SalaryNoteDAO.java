/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.DBConnect;
import entities.Employee;
import entities.SalaryNote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class SalaryNoteDAO {
    public static String insert(Employee owner){           // thêm bảng lương cho nhân viên
        String sql = "SELECT COUNT(sn_id) FROM tbSalaryNote";                    // tạo id mới cho salarynote cần thêm vào database
        String sql2 = "SELECT * FROM tbSalaryNote";
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                PreparedStatement st2 = cn.prepareStatement(sql2);
                ResultSet rs2 = st2.executeQuery();){
            
            if(rs.next()){
                int current_number_oftbSalaryNote = rs.getInt(1);
                String newid = createid("SAL", String.valueOf(current_number_oftbSalaryNote + 1), 10);
                
                
                SalaryNote newsn = new SalaryNote();                             // tạo Salary Note mới
                newsn.setSn_id(newid);
                newsn.setEm_id(owner.getEm_id());
                newsn.setDate_pay(null);
                newsn.setSalary_value(0);                                        // lúc đầu tạo thì không cần cập nhật lương (để sau))
                newsn.setWork_hour(0);
                LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "Asia/Ho_Chi_Minh" ) );
                newsn.setFor_month(todayLocalDate.getMonthValue());
                newsn.setFor_year(todayLocalDate.getYear());
                newsn.setIs_paid((byte) 0);
                
                while(rs2.next()){
                    if(rs2.getInt(6) == newsn.getFor_month() && rs2.getInt(7) == newsn.getFor_year() && rs2.getString(2).equals(newsn.getEm_id())){     
                         // kiểm tra bảng lương của nhân viên đó đã có sẵn chưa
                         // nếu có sẵn thì tiến hành cập nhật
                        return rs2.getString(1);
                    }
                }
                    
                String sql3 = "INSERT INTO tbSalaryNote VALUES (?,?,?,?,?,?,?,?)";
                try(PreparedStatement st3 = cn.prepareStatement(sql3);){
                    st3.setString(1, newsn.getSn_id());
                    st3.setString(2, newsn.getEm_id());
                    st3.setDate(3, newsn.getDate_pay());
                    st3.setFloat(4, newsn.getSalary_value());
                    st3.setFloat(5, newsn.getWork_hour());
                    st3.setInt(6, newsn.getFor_month());
                    st3.setInt(7, newsn.getFor_year());
                    st3.setByte(8, newsn.getIs_paid());
                    
                    st3.executeUpdate();
                    return newsn.getSn_id();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmpScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // thất bại
        return null;
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
