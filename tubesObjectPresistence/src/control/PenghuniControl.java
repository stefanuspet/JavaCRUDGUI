/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author stefa
 */

import dao.PenghuniDAO;
import java.util.List;
import model.Penghuni;

public class PenghuniControl {
    private PenghuniDAO pDao = new PenghuniDAO();
    
    public void insertDataPenghuni(Penghuni p) {
        pDao.insertPenghuni(p);
    }
    
    public String showDataPenghuni(){
        List<Penghuni> dataPenghuni = pDao.showPenghuni();
        String PenghuniString = "";
        for (int i = 0; i < dataPenghuni.size(); i++) {
            PenghuniString = PenghuniString + dataPenghuni.get(i).showPenghuni()+ "\n";
        }
        return PenghuniString;
    }
    
    public void updateDataPenghuni(Penghuni p, int id) {
        pDao.UpdatePenghuni(p, id);
    }

    public void deleteDataPenghuni(String nama) {
        pDao.DeletePenghuni(nama);
    }
    
    public List<Penghuni> showListPenghuni(){
        List<Penghuni> dataPenghuni = pDao.showPenghuni();
        return dataPenghuni;
    }
}
