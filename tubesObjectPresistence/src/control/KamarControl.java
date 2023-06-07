package control;

import dao.KamarDAO;
import java.util.List;
import model.Kamar;

public class KamarControl {
    private KamarDAO kDao = new KamarDAO();
    
    public void insertDataKamar(Kamar k){
        kDao.insertKamar(k);
    }
    
//    public String showDataKamar(){
//        List<Kamar> dataKamar = kDao.showKamar();
//        String KamarString = "";
//        for(int i=0; i<dataKamar.size(); i++){
//            KamarString = KamarString + dataKamar.get(i).showKamar()+"\n";
//        }
//        return KamarString;
//    }
    
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
}


