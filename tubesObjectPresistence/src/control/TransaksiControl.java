package control;

import dao.TransaksiDAO;
import java.util.List;
import model.Transaksi;

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
    
    public List<Transaksi> showTransaksi(String username){
        List<Transaksi>dataTransaksi = tDao.showTransaksi(username);
        return dataTransaksi;
    }

    public List<Transaksi> showAllTransaksi(String query){
        List<Transaksi>dataTransaksi = tDao.showAllTransaksi(query);
        return dataTransaksi;
    }
}
