/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Pemesanan;

/**
 *
 * @author nayal
 */
public class PemesananTable extends AbstractTableModel {
    public List<Pemesanan> list;

    public PemesananTable(List<Pemesanan> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId_pemesanan();
            case 1:
                return list.get(rowIndex).getId_penghuni();
            case 2:
                return list.get(rowIndex).getId_kamar();
            case 3:
                return list.get(rowIndex).getTanggal_masuk();
            case 4:
                return list.get(rowIndex).getTanggal_keluar();
            case 5:
                return list.get(rowIndex).getPelanggaran();
//            case 6:
//                return list.get(rowIndex).getTotal();
            case 7:
                return list.get(rowIndex).getStatus();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Pemesanan";
            case 1:
                return "ID Penghuni";
            case 2:
                return "ID Kamar";
            case 3:
                return "Tanggal Masuk";
            case 4:
                return "Tanggal Keluar";
            case 5:
                return "ID Pelanggaran";
            case 6:
                return "Total";
            case 7:
                return "Status";
            default:
                return null;
        }

    }
    
}
