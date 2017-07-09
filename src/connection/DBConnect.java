/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;

public class DBConnect {
    private final String dbname;
    private final String userid;
    private final String userpwd;
    
    private final String host;
    private final String port;

    public DBConnect() {
        this.dbname = "COMMACOFFEESHOP";
        this.userid = "sa";
        this.userpwd = "maiyeuminhem";
        
        this.host = "127.0.0.1";
        this.port = "1433";
    }

    public DBConnect(String dbname, String userid, String userpwd, String host, String port) {
        this.dbname = dbname;
        this.userid = userid;
        this.userpwd = userpwd;
        this.host = host;
        this.port = port;
    }
    
    
    public Connection getCon() throws SQLException
    {
        Connection cn = null;
        
        try
        {
            //1. nap driver jdbc4
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //2. tao ket noi den co so du lieu
            String url = "jdbc:sqlserver://" + host + ":" + port + "; database = " + dbname;
            cn = DriverManager.getConnection(url, userid, userpwd);
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            ex.getStackTrace();
        }
        
        return cn;
    }
}
