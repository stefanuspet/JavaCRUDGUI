package control;


import dao.PenghuniDAO;
import java.util.List;
import model.Penghuni;
import table.PenghuniTable;

public class PenghuniControl {
    private PenghuniDAO pDao = new PenghuniDAO();
    
    public void insertDataPenghuni(Penghuni p) {
        pDao.insertPenghuni(p);
    }
    
//    public String showDataPenghuni(){
//        List<Penghuni> dataPenghuni = pDao.showPenghuni();
//        String PenghuniString = "";
//        for (int i = 0; i < dataPenghuni.size(); i++) {
//            PenghuniString = PenghuniString + dataPenghuni.get(i).showPenghuni()+ "\n";
//        }
//        return PenghuniString;
//    }
    
    public List<Penghuni> showDataPenghuni(){
        List<Penghuni> listPenghuni = pDao.showPenghuni();
        return listPenghuni;
    }
    
    public void updateDataPenghuni(Penghuni p, int id) {
        pDao.UpdatePenghuni(p, id);
    }

    public void deleteDataPenghuni(int id) {
        pDao.DeletePenghuni(id);
    }
    
    public List<Penghuni> showListPenghuni(){
        List<Penghuni> dataPenghuni = pDao.showPenghuni();
        return dataPenghuni;
    }
    
    public PenghuniTable showTablePenghuni() {
        List<Penghuni> dataPenghuni = pDao.showPenghuni();
        PenghuniTable penghuniTable = new PenghuniTable(dataPenghuni);
        
        return penghuniTable;
    }

    public Penghuni searchPenghuni (int id){
        return pDao.searchPenghuni(id);
    }
    
    public PenghuniTable searchPenghuniTable (String nama){
        List<Penghuni> dataPenghunis = pDao.searchPenghuniTable(nama);
        PenghuniTable penghuniTable = new PenghuniTable(dataPenghunis);
        return penghuniTable;
    }
}
