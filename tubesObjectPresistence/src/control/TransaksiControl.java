package control;

import dao.TransaksiDAO;
import java.util.List;
import model.Transaksi;

public class TransaksiControl {
    private TransaksiDAO tDao = new TransaksiDAO();
    
    public void insertDataTransaksi(Transaksi t){
        tDao.insertTransaksi(t);
    }
    
//    public String showDataTransaksi(){
//        List<Transaksi> dataTransaksi = tDao.showTransaksi();
//        String TransaksiString= "";
//        for(int i=0; i<dataTransaksi.size(); i++){
//            TransaksiString =  TransaksiString + dataTransaksi.get(i).showTransaksi()+"\n";
//        }
//        return TransaksiString;
//    }
    
    public void updateDataTransaksi(Transaksi t,int id_transaksi){
        tDao.updateTransaksi(t, id_transaksi);
    }
    
    public void deleteDataTransaki(int id_transaksi){
        tDao.deleteTransaksi(id_transaksi);
    }
    
    public List<Transaksi> showListTransaksi(){
        List<Transaksi>dataTransaksi = tDao.showTransaksi();
        return dataTransaksi;
    }
}
