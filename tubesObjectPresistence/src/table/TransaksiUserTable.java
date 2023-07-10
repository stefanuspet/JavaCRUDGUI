/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Transaksi;

/**
 *
 * @author nayal
 */
public class TransaksiUserTable extends AbstractTableModel{
    public List<Transaksi> list;

    public TransaksiUserTable(List<Transaksi> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId_transaksi();
            case 1:
                return list.get(rowIndex).getPemesanan().getId_pemesanan();
            case 2:
                return list.get(rowIndex).getJenis_pembayaran();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Transaksi";
            case 1:
                return "ID Pemesanan";
            case 2:
                return "Jenis Pemesanan";
            default:
                return null;
        }

    }
    
}