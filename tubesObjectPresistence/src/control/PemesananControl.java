package control;

import dao.PemesananDAO;
import java.util.List;
import model.Pemesanan;

public class PemesananControl {
    private PemesananDAO pDao = new PemesananDAO();
    
    public void insertDataPemesanan(Pemesanan p){
        pDao.insertPemesanan(p);
    }

    
    public void  updateDatePemesanan(Pemesanan p, int id_pemesanan){
        pDao.updatePemesanan(p, id_pemesanan);
    }
    
    public void deleteDataPemesanan(int id_pemesanan){
        pDao.deletePemesanan(id_pemesanan);
    }
    
    public List<Pemesanan> showListPemesanan(String query){
        List<Pemesanan> dataPemesanan = pDao.showAllPemesanan(query);
        return dataPemesanan;
    }

    public Pemesanan getPemesanan(int id_pemesanan){
        return pDao.getPemesanan(id_pemesanan);
    }
}
