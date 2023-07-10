package control;

import dao.PemesananDAO;
import java.util.List;
import model.Pemesanan;
import table.PemesananTable;

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
    
//    public List<Pemesanan> showListPemesanan(String query){
//        List<Pemesanan> dataPemesanan = pDao.showAllPemesanan(query);
//        return dataPemesanan;
//    }
    
    public PemesananTable showPemesanan(String query){
        List<Pemesanan> dataPemesanan = pDao.showAllPemesanan(query);
        PemesananTable pesan = new PemesananTable(dataPemesanan);
        return pesan;
    }
    
    public PemesananTable showTablePemesanan(String query, String user){
        List<Pemesanan> dataPemesanan = pDao.showAllPemesananByUser(query, user);
        PemesananTable pesan = new PemesananTable(dataPemesanan);
        return pesan;
    }

    public Pemesanan getPemesanan(int id_pemesanan){
        return pDao.getPemesanan(id_pemesanan);
    }
    
     public PemesananTable showTablePemesanan(String query){
        List<Pemesanan> dataPemesanan = pDao.showAllPemesanan(query);
        PemesananTable pemesanantbl = new PemesananTable(dataPemesanan);
        
        return pemesanantbl;
    }
    
    public PemesananTable searchTablePemesanan(String query){
        List<Pemesanan> dataPemesanan = pDao.searchPemesanTable(query);
        PemesananTable pemesananTable = new PemesananTable(dataPemesanan);
        return pemesananTable;
    }
    
    public PemesananTable showPemesananByUser(String query, String id){
        List<Pemesanan> dataPemesan = pDao.showAllPemesananByUser(query,id);
        PemesananTable pemesananTable = new PemesananTable(dataPemesan);
        
        return pemesananTable;
    }
}
