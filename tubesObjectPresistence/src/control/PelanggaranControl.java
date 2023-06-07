package control;

import dao.PelanggaranDAO;
import java.util.List;
import model.Pelanggaran;

public class PelanggaranControl {
    private PelanggaranDAO pDao = new PelanggaranDAO();
    
    public void insertDataPelanggaran(Pelanggaran p){
        pDao.insertPelanggaran(p);
    }
    
//    public String showDataPelanggaran(){
//        List<Pelanggaran> dataPelanggaran = pDao.showPelanggaran();
//        String PelanggaranString = "";
//        for(int i=0; i<dataPelanggaran.size(); i++){
//            PelanggaranString = PelanggaranString + dataPelanggaran.get(i).showPelanggaran()+"\n";
//        }
//        return PelanggaranString;
//    }
    
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
}
