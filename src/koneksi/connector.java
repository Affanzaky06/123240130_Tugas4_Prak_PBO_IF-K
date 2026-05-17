/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author ACER
 */
public class connector {
    static Connection conn;
   
    public static Connection connection(){
        if (conn == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("movie_db");
            data.setUser("root");
            data.setPassword("");
            try {
                conn = data.getConnection();
                System.out.println("Koneksi Berhasil");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Koneksi gagal");
            }
        }
        
       
       return conn;
    }
}
