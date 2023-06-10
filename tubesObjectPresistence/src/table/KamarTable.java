/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Kamar;
/**
 *
 * @author stefa
 */
public class KamarTable extends AbstractTableModel{
    public List<Kamar> list;

    public KamarTable(List<Kamar> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId_kamar();
            case 1:
                return list.get(rowIndex).getFasilitas();
            case 2:
                return list.get(rowIndex).getHarga_sewa();
            case 3:
                return list.get(rowIndex).getDeskripsi();
            case 4:
                return list.get(rowIndex).getStatus();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Kamar";
            case 1:
                return "Fasilitas";
            case 2:
                return "Harga Sewa";
            case 3:
                return "Deskripsi";
            case 4:
                return "Status";

            default:
                return null;
        }

    }
}
