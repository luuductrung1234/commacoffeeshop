/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.DBConnect;
import entities.EmpSchedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class EmpScheduleDAO {

    public static int insert(EmpSchedule newsche){
        String sql = "SELECT COUNT(sche_id) FROM tbEmpSchedule";                    // tạo id mới cho schedule cần thêm vào database
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();){
            
            if(rs.next()){
                int current_number_oftbEmpSchedule = rs.getInt(1);
                String newid = createid("SCHE", String.valueOf(current_number_oftbEmpSchedule + 1), 10);
                newsche.setSche_id(newid);
                
                
                sql = "INSERT INTO tbEmpSchedule VALUES (?, ?, ?, ?, ?, ?, ?, ?)";          // tiến hành thêm schedule mới vào database
                try(PreparedStatement st2 = cn.prepareStatement(sql);){

                    st2.setString(1, newsche.getSche_id());
                    st2.setString(2, newsche.getEm_id());
                    st2.setDate(3, newsche.getWorkday());
                    st2.setInt(4, newsche.getStarthour());
                    st2.setInt(5, newsche.getStartminute());
                    st2.setInt(6, newsche.getEndhour());
                    st2.setInt(7, newsche.getEndminute());
                    st2.setString(8, newsche.getResult_salary());

                    return st2.executeUpdate();
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmpScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    
    
    public static List<EmpSchedule> getlist_inday(java.sql.Date date){
        ArrayList<EmpSchedule> resultlist = new ArrayList<>();
        String sql = "SELECT * FROM tbEmpSchedule WHERE workday = ?";
        
        try(Connection cn = new DBConnect().getCon();
                PreparedStatement st = cn.prepareStatement(sql);){
            
            st.setDate(1, date);
            try(ResultSet rs = st.executeQuery()){
                if(rs.next()){
                    EmpSchedule newitem = new EmpSchedule();
                    newitem.setSche_id(rs.getString(1));
                    newitem.setEm_id(rs.getString(2));
                    newitem.setWorkday(rs.getDate(3));
                    newitem.setStarthour(rs.getInt(4));
                    newitem.setStartminute(rs.getInt(5));
                    newitem.setEndhour(rs.getInt(6));
                    newitem.setEndminute(rs.getInt(7));
                    newitem.setResult_salary(rs.getString(8));
                    
                    resultlist.add(newitem);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SalaryNoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return resultlist;
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
