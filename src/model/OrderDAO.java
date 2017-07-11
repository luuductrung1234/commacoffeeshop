/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class OrderDAO {
    





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
