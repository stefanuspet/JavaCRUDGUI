package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Aduan;
public class AduanDAO {
    private DbConnection dbConnection = new DbConnection();
    private Connection con;

    public void insertAduan(Aduan a){
        con = dbConnection.makeConnection();
        String sql ="INSERT INTO aduan(id_penghuni, tanggal, deskripsi_aduan) "
                + "VALUES ('"+a.getId_penghuni()+"','"+a.getTanggal()+"','"+a.getDeskripsi_aduan()+"')";
        System.out.println("Adding Aduan....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + "Aduan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Aduan...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    public void deleteAduan(int id_aduan){
        con = dbConnection.makeConnection();
        String sql ="DELETE FROM aduan WHERE id_aduan='"+id_aduan+"'";
        System.out.println("Deleting Aduan....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + "Aduan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Aduan...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    public void updateAduan(Aduan a, int id_aduan){
        con = dbConnection.makeConnection();
        String sql ="UPDATE aduan SET id_penghuni='"+a.getId_penghuni()+"', tanggal='"+a.getTanggal()+"', deskripsi_aduan='"+a.getDeskripsi_aduan()+"' WHERE id_aduan='"+id_aduan+"'";
        System.out.println("Updating Aduan....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + "Aduan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error updating Aduan...");
            System.out.println(e);
        }
        dbConnection.closeConnection();
    }

    //kurang select aduan

}
