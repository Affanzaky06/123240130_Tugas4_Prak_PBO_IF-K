/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdataFilm;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOimplement.datafilmImplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ACER
 */
public class dataFilmDAO implements datafilmImplement{
    Connection connection;
    
    final String select = "SELECT * FROM movie;";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES ( ?, ?, ?, ?, ?);";
    final String update = "UPDATE movie SET judul=?, alur=?, penokohan=?, akting=?, nilai=? WHERE id=?";
    final String delete = "DELETE FROM movie WHERE id=?";
    
    public dataFilmDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(datafilm f) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, f.getJudul());
            statement.setDouble(2, f.getAlur());
            statement.setDouble(3, f.getPenokohan());
            statement.setDouble(4, f.getAkting());
            statement.setDouble(5, f.getNilai());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {                
                f.setId(rs.getInt(1));
            }
            
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                statement.close();
            } 
            catch (Exception e) {
            e.printStackTrace();
            }
        }
    }

  
    @Override
    public void update(datafilm f) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, f.getJudul());
            statement.setDouble(2, f.getAlur());
            statement.setDouble(3, f.getPenokohan());
            statement.setDouble(4, f.getAkting());
            statement.setDouble(5, f.getNilai());
            statement.setInt(6, f.getId());
            statement.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                statement.close();
            } 
            catch (Exception e) {
            e.printStackTrace();
            }
        }
    }

    
    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                statement.close();
            } 
            catch (Exception e) {
            e.printStackTrace();
            }
        }
    }

    
    @Override
    public List<datafilm> getAll() {
        List<datafilm> df = null;
        try {
            df = new ArrayList<datafilm>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {                
                datafilm film = new datafilm();
                film.setId(rs.getInt("id"));
                film.setJudul(rs.getString("judul"));
                film.setAlur(rs.getDouble("alur"));
                film.setPenokohan(rs.getDouble("penokohan"));
                film.setAkting(rs.getDouble("akting"));
                film.setNilai(rs.getDouble("nilai"));
                df.add(film);
            }
            
        } 
        catch (SQLException e) {
            Logger.getLogger(dataFilmDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return df;
    }
}
