
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author nayal
 */

import dao.KamarDAO;
import java.util.List;
import model.Kamar;
import table.KamarTable;

public class KamarControl {
    
    private KamarDAO kDao = new KamarDAO();
    
    public void insertDataKamar(Kamar k){
        kDao.insertKamar(k);
    }

    
    public void updateDataKamar(Kamar k, int id_kamar){
        kDao.updateKamar(k, id_kamar);
    }
    
    public void deleteDataKamar(int id_kamar){
        kDao.deleteKamar(id_kamar);
    }
        
    public List<Kamar>showListKamar(){
        List<Kamar> dataKamar = kDao.showKamar();
        return dataKamar;
    }

    public Kamar getKamar(int id_kamar){
        return kDao.getKamar(id_kamar);
    }
    
    public KamarTable showTableKamar(){
        List<Kamar> dataKamar = kDao.showKamar();
        KamarTable kamartbl = new KamarTable(dataKamar);
        
        return kamartbl;
    }
    
    public KamarTable searchTableKamar(String query){
        List<Kamar> dataKamar = kDao.searchKamarTable(query);
        KamarTable kamarTable = new KamarTable(dataKamar);
        return kamarTable;
    }
}
