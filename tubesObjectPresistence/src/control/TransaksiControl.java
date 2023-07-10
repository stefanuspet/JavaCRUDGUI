package control;

import dao.TransaksiDAO;
import java.util.List;
import model.Transaksi;
import table.TransaksiUserTable;

public class TransaksiControl {
    private TransaksiDAO tDao = new TransaksiDAO();
    
    public void insertDataTransaksi(Transaksi t){
        tDao.insertTransaksi(t);
    }

    
    public void updateDataTransaksi(Transaksi t,int id_transaksi){
        tDao.updateTransaksi(t, id_transaksi);
    }
    
    public void deleteDataTransaki(int id_transaksi){
        tDao.deleteTransaksi(id_transaksi);
    }
    
//    public List<Transaksi> showTransaksiByPenghuni(String id_penghuni, String query){
//        List<Transaksi>dataTransaksi = tDao.showTransaksiByPenghuni(id_penghuni, query);
//        return dataTransaksi;
//    }

//    public List<Transaksi> showAllTransaksi(String query){
//        List<Transaksi>dataTransaksi = tDao.showAllTransaksi(query);
//        return dataTransaksi;
//    }
    
    public TransaksiUserTable showDataMenu(String query, String user){
        List<Transaksi> dataTransaksi = tDao.showTransakasiByUser(query,user);
        TransaksiUserTable transaksiUserTable = new TransaksiUserTable(dataTransaksi);
        
        return transaksiUserTable;
    }
    
    public TransaksiUserTable showDataMenuAdmin (String query){
        List<Transaksi> dataTransaksi = tDao.TransaksiAdmin(query);
        TransaksiUserTable transaksiUserTable = new TransaksiUserTable(dataTransaksi);
        
        return transaksiUserTable;
    }
    
    
    
//    public Transaksi searchTransaksi (int id){
//        return tDao.searchTransaksi(id);
//    }
   
//    public TransaksiTable searchTransaksiTable (String query){
//        List<Transaksi> dataTransaksi = tDao.searchTransaksiTable(query);
//        TransaksiTable transaksiTable = new transaksiTable(dataTransaksi);
//        return transaksiTable;
//    }
}
