package control;

import dao.PelanggaranDAO;

import java.util.ArrayList;
import java.util.List;
import model.Pelanggaran;
import table.PelanggaranTable;

public class PelanggaranControl {
    private PelanggaranDAO pDao = new PelanggaranDAO();
    
    public void insertDataPelanggaran(Pelanggaran p){
        pDao.insertPelanggaran(p);
    }

    
    public void updateDataPelanggaran(Pelanggaran p, int id_pelanggaran){
        pDao.updatePelanggaran(p, id_pelanggaran);
    }
    
    public void deleteDataPelanggaran(int id_pelanggaran){
        pDao.deletePelanggaran(id_pelanggaran);
    }
    
    public List<Pelanggaran>showListPelanggaran(){
        List<Pelanggaran>dataPelanggaran = pDao.showPelanggaran();
        return dataPelanggaran;
    }

    public Pelanggaran getPelanggaran(int id_pelanggaran){
        return pDao.getPelanggaran(id_pelanggaran);
    }
    
    public PelanggaranTable showTable(){
        List<Pelanggaran> dataPlnggrn = pDao.showPelanggaran();
        PelanggaranTable pelanggaranTable = new PelanggaranTable(dataPlnggrn);
        return pelanggaranTable;
    }
    
    public PelanggaranTable searchTable(String query){
        List<Pelanggaran> dataPelanggarans = pDao.searchPelanggaran(query);
        PelanggaranTable pelanggarantbl = new PelanggaranTable(dataPelanggarans);
        return pelanggarantbl;
    }
}
