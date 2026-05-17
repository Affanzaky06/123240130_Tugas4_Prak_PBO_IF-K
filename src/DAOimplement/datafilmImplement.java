/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOimplement;
import java.util.List;
import model.*;
/**
 *
 * @author ACER
 */
public interface datafilmImplement {
    public void insert(datafilm f);
    public void update(datafilm f);
    public void delete(int id);
    public List<datafilm> getAll();
   
}
