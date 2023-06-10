package control;

import dao.AduanDAO;
import java.util.List;
import model.Aduan;

public class AduanControl {
    private AduanDAO aDao = new AduanDAO();
    
    public void insertDataAduan (Aduan a){
        aDao.insertAduan(a);
    }
    
    public void updateDataAduan(Aduan a, int id_aduan){
        aDao.updateAduan(a, id_aduan);
    }
    
    public void deleteDataAduan (int id_aduan){
        aDao.deleteAduan(id_aduan);
    }

    public List<Aduan> showListAduan(String query){
        List<Aduan> dataAduan = aDao.showAduan(query);
        return dataAduan;
    }

    public List<Aduan> showAduanByPenghuni(String id_penghuni, String query){
        List<Aduan> dataAduan = aDao.showAduanByPenghuni(id_penghuni, query);
        return dataAduan;
    }
}
