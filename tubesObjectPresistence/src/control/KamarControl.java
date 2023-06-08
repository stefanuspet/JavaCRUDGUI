package control;

import dao.KamarDAO;
import java.util.List;
import model.Kamar;

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
}


