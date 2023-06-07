package control;

import dao.PemesananDAO;
import java.util.List;
import model.Pemesanan;

public class PemesananControl {
    private PemesananDAO pDao = new PemesananDAO();
    
    public void insertDataPemesanan(Pemesanan p){
        pDao.insertPemesanan(p);
    }
    
//    public String showDataPemesanan(){
//        List<Pemesanan> dataPemesanan = pDao.showPemesanan();
//        String PemesananString = "";
//        for(int i=0; i<dataPemesanan.size(); i++){
//            PemesananString = PemesananString + dataPemesanan.get(i).showPemesanan()+"\n";
//        }
//        return PemesananString;
//    }
    
    public void  updateDatePemesanan(Pemesanan p, int id_pemesanan){
        pDao.updatePemesanan(p, id_pemesanan);
    }
    
    public void deleteDataPemesanan(int id_pemesanan){
        pDao.deletePemesanan(id_pemesanan);
    }
    
//    public List<Pemesanan> showListPemesanan(){
//        List<Pemesanan> dataPemesanan = pDao.showPemesanan();
//        return dataPemesanan;
//    }
}
