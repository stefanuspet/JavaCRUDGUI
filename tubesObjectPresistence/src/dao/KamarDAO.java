package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Kamar;
public class KamarDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    public void insertKamar(Kamar k){
        con = dbCon.makeConnection();
        String sql ="INSERT INTO kamar(id_kamar,fasilitas, harga_sewa, deskripsi, status) "
                + "VALUES ('"+k.getId_kamar()+"','"+k.getFasilitas()+"','"+k.getHarga_sewa()+"','"+k.getDeskripsi()+"','"+k.getStatus()+"')";
        System.out.println("Adding Kamar....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + "Kamar");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Kamar...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

}
