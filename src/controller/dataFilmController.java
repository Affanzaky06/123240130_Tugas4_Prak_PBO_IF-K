/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdataFilm.dataFilmDAO;
import DAOimplement.datafilmImplement;
import model.*;
import view.MainView;

/**
 *
 * @author ACER
 */
public class dataFilmController {
    MainView frame;
    datafilmImplement impldataFilm;
    List<datafilm> df;
    
    public dataFilmController(MainView frame){
        this.frame = frame;
        impldataFilm = new dataFilmDAO();
        df = impldataFilm.getAll();
        
    }
    
    public void isiTabel(){
        df = impldataFilm.getAll();
        modelDataFilm mf = new modelDataFilm(df);
        frame.getjTableFilm().setModel(mf);
    }
    
    public void insert(){
        try {
            datafilm df = new datafilm();  
            df.setJudul(frame.getjTextFieldJudul().getText());
            
            Double alur = Double.parseDouble(frame.getjTextFieldAlur().getText());
            df.setAlur(alur);
            
            Double penokohan = Double.parseDouble(frame.getjTextFieldPenokohan().getText());
            df.setPenokohan(penokohan);
            
            Double akting = Double.parseDouble(frame.getjTextFieldAkting().getText());
            df.setAkting(akting);
            
            Double nilai = (alur + penokohan + akting) / 3;
            df.setNilai(nilai);
            
            if (alur < 0 || alur > 5 || penokohan < 0 || penokohan > 5 || akting < 0 || akting > 5 ) {
                throw new Exception("Nilai Harus Antara 0-5");
            }
            else{
                impldataFilm.insert(df);
            }

            
            javax.swing.JOptionPane.showMessageDialog(frame, "Data berhasil ditambahkan!");
            
        } catch (NumberFormatException e) {
     
            javax.swing.JOptionPane.showMessageDialog(frame, 
                "Pastikan nilai Alur, Penokohan, dan Akting sudah diisi dengan angka!", 
                "Error Input", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            
            javax.swing.JOptionPane.showMessageDialog(frame, 
                "Terjadi kesalahan: " + e.getMessage(), 
                "Error System", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void update(){
         try {
            
            int row = frame.getjTableFilm().getSelectedRow();
            if(row < 0){
                javax.swing.JOptionPane.showMessageDialog(frame, "Pilih data di tabel yang mau diubah terlebih dahulu!");
                return; 
            }
            
           
            int id = df.get(row).getId();
            
            
            datafilm df = new datafilm();  
            df.setJudul(frame.getjTextFieldJudul().getText());
            
            Double alur = Double.parseDouble(frame.getjTextFieldAlur().getText());
            df.setAlur(alur);
            
            Double penokohan = Double.parseDouble(frame.getjTextFieldPenokohan().getText());
            df.setPenokohan(penokohan);
            
            Double akting = Double.parseDouble(frame.getjTextFieldAkting().getText());
            df.setAkting(akting);
            
            Double nilai = (alur + penokohan + akting) / 3;
            df.setNilai(nilai);
            
            df.setId(id);
            
            if (alur < 0 || alur > 5 || penokohan < 0 || penokohan > 5 || akting < 0 || akting > 5 ) {
                throw new Exception("Nilai Harus Antara 0-5");
            }
            else{
                impldataFilm.insert(df);
            }
            

            
            javax.swing.JOptionPane.showMessageDialog(frame, "Data berhasil diubah!");
            
        } catch (NumberFormatException e) {
           
            javax.swing.JOptionPane.showMessageDialog(frame, 
                "Pastikan nilai Alur, Penokohan, dan Akting sudah diisi dengan angka!", 
                "Error Input", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            
            javax.swing.JOptionPane.showMessageDialog(frame, 
                "Terjadi kesalahan: " + e.getMessage(), 
                "Error System", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(){
        try {
           
            int row = frame.getjTableFilm().getSelectedRow();
            if(row < 0){
                javax.swing.JOptionPane.showMessageDialog(frame, "Pilih data di tabel yang mau dihapus terlebih dahulu!");
                return; 
            }
            
            
            int dialogResult = javax.swing.JOptionPane.showConfirmDialog(frame, 
                    "Apakah Anda yakin ingin menghapus data ini?", "Peringatan", 
                    javax.swing.JOptionPane.YES_NO_OPTION);
            

            if (dialogResult == javax.swing.JOptionPane.YES_OPTION) {
                int id = df.get(row).getId();
                impldataFilm.delete(id);
            }

            }
        catch (Exception e) {
            
            javax.swing.JOptionPane.showMessageDialog(frame, 
                "Terjadi kesalahan: " + e.getMessage(), 
                "Error System", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    public void clear(){
    
        frame.getjTextFieldJudul().setText("");
        frame.getjTextFieldAlur().setText("");
        frame.getjTextFieldPenokohan().setText("");
        frame.getjTextFieldAkting().setText("");
       
        frame.getjTableFilm().clearSelection();
    
    }
}
