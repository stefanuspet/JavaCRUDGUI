package control;

import dao.AduanDAO;
import java.util.List;
import model.Aduan;

public class AduanControl {
    private AduanDAO aDao = new AduanDAO();
    
    public void insertDataAduan (Aduan a){
        aDao.insertAduan(a);
    }
    
//    public String showDataAduan(){
//        List<Aduan> dataAduan = aDao.showAduan();
//        String AduanString ="";
//        for(int i=0; i<dataAduan.size(); i++){
//            AduanString = AduanString + dataAduan.get(i).showAduan()+ "\n";
//        }
//        return AduanString;
//    }
    
    public void updateDataAduan(Aduan a, int id_aduan){
        aDao.updateAduan(a, id_aduan);
    }
    
    public void deleteDataAduan (int id_aduan){
        aDao.deleteAduan(id_aduan);
    }
    
    
//    public List<Aduan> showListAduan(){
//        List<Aduan> dataAduan = aDao.showAduan();
//        return dataAduan;
//    }
}
