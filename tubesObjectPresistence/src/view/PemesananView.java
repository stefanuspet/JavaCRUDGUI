/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author stefa
 */
import exception.*;
import control.PemesananControl;
import control.PenghuniControl;
import control.KamarControl;
import control.PelanggaranControl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Kamar;
import model.Pelanggaran;
import model.Pemesanan;
import model.Penghuni;
import table.PemesananTable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;

public class PemesananView extends javax.swing.JFrame {

    /**
     * Creates new form AdminView
     */
    private PemesananControl psnCtrl;
    private PenghuniControl penghuniCtrl;
    private KamarControl kmarCtrl;
    private PelanggaranControl pelanggaranCtrl;
    int selectedId = 0;
    String action = "";
    private String pemesanan;
    private List<Penghuni> listPenghuni;
    private List<Kamar> listKamar;
    private List<Pelanggaran> listPelanggaran;
    int indexPenghuni = 0;
    int indexKamar = 0;
    int indexPelanggaran = 0;
    int denda = 0;
    int hargaKamar = 0;
    int totalBayar = denda + hargaKamar;
    int getIndexKamar = 0;
    int getIndexPelanggaran = 0;
    int getIndexPenghuni = 0;
    int getIndexStatus = 0;

    public PemesananView() {
        initComponents();
        idPemesananText.setEnabled(false);
        setComponent(false);
        setEditDeletebtn(false);
        clearText();
        psnCtrl = new PemesananControl();
        penghuniCtrl = new PenghuniControl();
        kmarCtrl = new KamarControl();
        pelanggaranCtrl = new PelanggaranControl();
        tanggalMasukText.setEnabled(false);
        setPenghuniToDropdown();
        setKamarToDropdown();
        setPelanggaranToDropdown();
        getIndexPelanggaran = pelanggaranComboBox.getSelectedIndex();
        showPemesanan();
    }

    private static boolean isValidDate(String dateString, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateString);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1; // Bulan dimulai dari 0
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            if (year == calendar.getActualMinimum(Calendar.YEAR) && year == calendar.getActualMaximum(Calendar.YEAR)
                    && month == calendar.getActualMinimum(Calendar.MONTH) + 1
                    && month == calendar.getActualMaximum(Calendar.MONTH) + 1
                    && day == calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
                    && day == calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                return false; // Tanggal diluar rentang yang valid
            }

            return true; // Tanggal valid
        } catch (ParseException e) {
            return false; // Format tanggal tidak sesuai
        }
    }

    public void showPemesanan() {
        tablePemesananShow.setModel(psnCtrl.showPemesanan(""));
    }

    public void setPenghuniToDropdown() {
        listPenghuni = penghuniCtrl.showListPenghuni();
        for (int i = 0; i < listPenghuni.size(); i++) {
            penghuniComboBox.addItem(listPenghuni.get(i));
        }
    }

    public void setKamarToDropdown() {
        listKamar = kmarCtrl.showListKamar();
        for (int i = 0; i < listKamar.size(); i++) {
            kamarComboBox.addItem(listKamar.get(i));
        }
    }

    public void setPelanggaranToDropdown() {
        listPelanggaran = pelanggaranCtrl.showListPelanggaran();
        for (int i = 0; i < listPelanggaran.size(); i++) {
            pelanggaranComboBox.addItem(listPelanggaran.get(i));
        }
    }

    public int setHargaKamar() {
        int hargaKamar = 0;
        getIndexKamar = kamarComboBox.getSelectedIndex();
        hargaKamar = listKamar.get(getIndexKamar).getHarga_sewa();

        return hargaKamar;
    }

    public void setComponent(boolean value) {
        penghuniComboBox.setEnabled(value);
        pelanggaranComboBox.setEnabled(value);
        tanggalMasukText.setEnabled(value);
        totalBayarText.setEnabled(value);
        statusComboBox.setEnabled(value);
        kamarComboBox.setEnabled(value);
        dendaText.setEnabled(value);
        tanggalKeluarText.setEnabled(value);

        Savebtn.setEnabled(value);
        cancelbtn.setEnabled(value);
    }

    public void setEditDeletebtn(boolean value) {
        editBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }

    public void clearText() {
        idPemesananText.setText("");
        tanggalMasukText.setText("");
        totalBayarText.setText("");
        dendaText.setText("");
        tanggalKeluarText.setText("");

        penghuniComboBox.setSelectedItem(false);
        pelanggaranComboBox.setSelectedItem(false);
        statusComboBox.setSelectedItem(false);
        kamarComboBox.setSelectedItem(false);
    }

    public void InputKosongException() throws InputKosongException {
        if (idPemesananText.getText().isEmpty() || tanggalMasukText.getText().isEmpty()
                || totalBayarText.getText().isEmpty() || dendaText.getText().isEmpty()
                || tanggalKeluarText.getText().isEmpty()) {
            throw new InputKosongException();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BodyPanel = new javax.swing.JPanel();
        StatusLocation = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        namaPenghuniText = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        penghuniComboBox = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        idPemesananText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        masukText = new javax.swing.JPanel();
        tanggalMasukText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        dendaText = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        kamarComboBox = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        tanggalKeluarText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        Savebtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        jenisPelanggaranText = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        pelanggaranComboBox = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        totalBayarText = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePemesananShow = new javax.swing.JTable();
        cariBtn = new javax.swing.JButton();
        cariText = new javax.swing.JTextField();
        NavPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        kamarNav = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        penghuniNav = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        pelanggaranNav = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        transaksiNav = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        aduanAdminNav = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        LogoutNav = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BodyPanel.setBackground(new java.awt.Color(255, 255, 255));

        StatusLocation.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        StatusLocation.setText("Pemesanan");

        addButton.setBackground(new java.awt.Color(0, 102, 0));
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Tambah");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(255, 204, 0));
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Ubah");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(139, 0, 0));
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Hapus");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jPanel9.setOpaque(false);

        jPanel10.setBackground(new java.awt.Color(242, 242, 0));
        jPanel10.setOpaque(false);

        namaPenghuniText.setOpaque(false);

        jLabel9.setText("Nama Penghuni");

        javax.swing.GroupLayout namaPenghuniTextLayout = new javax.swing.GroupLayout(namaPenghuniText);
        namaPenghuniText.setLayout(namaPenghuniTextLayout);
        namaPenghuniTextLayout.setHorizontalGroup(
            namaPenghuniTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaPenghuniTextLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaPenghuniTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(namaPenghuniTextLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addComponent(penghuniComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        namaPenghuniTextLayout.setVerticalGroup(
            namaPenghuniTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaPenghuniTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(penghuniComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13.setOpaque(false);

        jLabel8.setText("ID Pemesanan");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idPemesananText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idPemesananText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        masukText.setOpaque(false);

        tanggalMasukText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalMasukTextActionPerformed(evt);
            }
        });

        jLabel10.setText("Tanggal Masuk (dd-MM-yyyy)");

        javax.swing.GroupLayout masukTextLayout = new javax.swing.GroupLayout(masukText);
        masukText.setLayout(masukTextLayout);
        masukTextLayout.setHorizontalGroup(
            masukTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masukTextLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(masukTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(tanggalMasukText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        masukTextLayout.setVerticalGroup(
            masukTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masukTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggalMasukText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel17.setOpaque(false);

        jLabel13.setText("Denda");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(dendaText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dendaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel18.setOpaque(false);

        jLabel14.setText("Kamar");

        kamarComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kamarComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(kamarComboBox, 0, 200, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kamarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setOpaque(false);

        jLabel11.setText("Tanggal Keluar (dd-MM-yyyy)");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(tanggalKeluarText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggalKeluarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel19.setOpaque(false);

        jLabel15.setText("Status");

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Lunas", "Lunas" }));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Savebtn.setText("Save");
        Savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavebtnActionPerformed(evt);
            }
        });

        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        jenisPelanggaranText.setOpaque(false);

        jLabel16.setText("Jenis Pelanggaran");

        pelanggaranComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelanggaranComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jenisPelanggaranTextLayout = new javax.swing.GroupLayout(jenisPelanggaranText);
        jenisPelanggaranText.setLayout(jenisPelanggaranTextLayout);
        jenisPelanggaranTextLayout.setHorizontalGroup(
            jenisPelanggaranTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisPelanggaranTextLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jenisPelanggaranTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jenisPelanggaranTextLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 107, Short.MAX_VALUE))
                    .addComponent(pelanggaranComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jenisPelanggaranTextLayout.setVerticalGroup(
            jenisPelanggaranTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisPelanggaranTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pelanggaranComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel22.setOpaque(false);

        jLabel18.setText("Total Bayar");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(totalBayarText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalBayarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Savebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelbtn)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namaPenghuniText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masukText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jenisPelanggaranText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(namaPenghuniText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jenisPelanggaranText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(masukText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(165, 165, 165)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Savebtn)
                    .addComponent(cancelbtn))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(242, 20, 255));
        jPanel11.setOpaque(false);

        tablePemesananShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Pemesanan", "ID Penghuni", "ID Kamar", "Tgl Masuk", "Tgl Keluar", "ID Pelanggaran", "Total", "Status"
            }
        ));
        tablePemesananShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePemesananShowMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePemesananShow);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cariBtn.setText("Cari");
        cariBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBtnActionPerformed(evt);
            }
        });

        cariText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BodyPanelLayout = new javax.swing.GroupLayout(BodyPanel);
        BodyPanel.setLayout(BodyPanelLayout);
        BodyPanelLayout.setHorizontalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StatusLocation)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(editBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cariText, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cariBtn)
                        .addGap(38, 38, 38))))
        );
        BodyPanelLayout.setVerticalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StatusLocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn)
                    .addComponent(cariBtn)
                    .addComponent(cariText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        NavPanel.setBackground(new java.awt.Color(41, 128, 185));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Atma Jaya Kost");

        kamarNav.setBackground(new java.awt.Color(21, 108, 165));
        kamarNav.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kamarNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kamarNavMouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Kamar");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Room.png"))); // NOI18N

        javax.swing.GroupLayout kamarNavLayout = new javax.swing.GroupLayout(kamarNav);
        kamarNav.setLayout(kamarNavLayout);
        kamarNavLayout.setHorizontalGroup(
            kamarNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kamarNavLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kamarNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addContainerGap())
        );
        kamarNavLayout.setVerticalGroup(
            kamarNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kamarNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        penghuniNav.setBackground(new java.awt.Color(21, 108, 165));
        penghuniNav.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        penghuniNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                penghuniNavMouseClicked(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Penghuni");

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Penghuni.png"))); // NOI18N

        javax.swing.GroupLayout penghuniNavLayout = new javax.swing.GroupLayout(penghuniNav);
        penghuniNav.setLayout(penghuniNavLayout);
        penghuniNavLayout.setHorizontalGroup(
            penghuniNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, penghuniNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        penghuniNavLayout.setVerticalGroup(
            penghuniNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, penghuniNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pelanggaranNav.setBackground(new java.awt.Color(21, 108, 165));
        pelanggaranNav.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pelanggaranNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pelanggaranNavMouseClicked(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Pelanggaran");

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Pelanggaran.png"))); // NOI18N

        javax.swing.GroupLayout pelanggaranNavLayout = new javax.swing.GroupLayout(pelanggaranNav);
        pelanggaranNav.setLayout(pelanggaranNavLayout);
        pelanggaranNavLayout.setHorizontalGroup(
            pelanggaranNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pelanggaranNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );
        pelanggaranNavLayout.setVerticalGroup(
            pelanggaranNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pelanggaranNavLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        transaksiNav.setBackground(new java.awt.Color(21, 108, 165));
        transaksiNav.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transaksiNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transaksiNavMouseClicked(evt);
            }
        });

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Transaksi");

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Pemesanan.png"))); // NOI18N

        javax.swing.GroupLayout transaksiNavLayout = new javax.swing.GroupLayout(transaksiNav);
        transaksiNav.setLayout(transaksiNavLayout);
        transaksiNavLayout.setHorizontalGroup(
            transaksiNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        transaksiNavLayout.setVerticalGroup(
            transaksiNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiNavLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        aduanAdminNav.setBackground(new java.awt.Color(21, 108, 165));
        aduanAdminNav.setAlignmentX(0.0F);
        aduanAdminNav.setAlignmentY(0.0F);
        aduanAdminNav.setPreferredSize(new java.awt.Dimension(100, 100));
        aduanAdminNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aduanAdminNavMouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Aduan");
        jLabel4.setAlignmentX(0.5F);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/aduan.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout aduanAdminNavLayout = new javax.swing.GroupLayout(aduanAdminNav);
        aduanAdminNav.setLayout(aduanAdminNavLayout);
        aduanAdminNavLayout.setHorizontalGroup(
            aduanAdminNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aduanAdminNavLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aduanAdminNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(aduanAdminNavLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        aduanAdminNavLayout.setVerticalGroup(
            aduanAdminNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aduanAdminNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(13, 82, 128));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Pemesanan");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Transaksi.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LogoutNav.setBackground(new java.awt.Color(21, 108, 165));
        LogoutNav.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutNavMouseClicked(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Keluar");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logout.png"))); // NOI18N

        javax.swing.GroupLayout LogoutNavLayout = new javax.swing.GroupLayout(LogoutNav);
        LogoutNav.setLayout(LogoutNavLayout);
        LogoutNavLayout.setHorizontalGroup(
            LogoutNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutNavLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LogoutNavLayout.setVerticalGroup(
            LogoutNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoutNavLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout NavPanelLayout = new javax.swing.GroupLayout(NavPanel);
        NavPanel.setLayout(NavPanelLayout);
        NavPanelLayout.setHorizontalGroup(
            NavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kamarNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(penghuniNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aduanAdminNav, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pelanggaranNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transaksiNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoutNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        NavPanelLayout.setVerticalGroup(
            NavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavPanelLayout.createSequentialGroup()
                .addGroup(NavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(NavPanelLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel1))
                        .addComponent(pelanggaranNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aduanAdminNav, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(penghuniNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kamarNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transaksiNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(LogoutNav, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NavPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(NavPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        action = "edit";
        setComponent(true);
        totalBayarText.setEnabled(false);
        totalBayarText.setEditable(false);
        dendaText.setEditable(false);
        dendaText.setEnabled(false);

    }//GEN-LAST:event_editBtnActionPerformed

    private void SavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavebtnActionPerformed
        // TODO add your handling code here:
        try {
            InputKosongException();
            getIndexPenghuni = penghuniComboBox.getSelectedIndex();
            int indexPenghuni = listPenghuni.get(getIndexPenghuni).getId_penghuni();
            getIndexKamar = kamarComboBox.getSelectedIndex();
            int indexKamar = listKamar.get(getIndexKamar).getId_kamar();
            getIndexPelanggaran = pelanggaranComboBox.getSelectedIndex();
            int indexPelanggaran = listPelanggaran.get(getIndexPelanggaran).getId_pelanggaran();
            String dateFormat = "dd-MM-yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Date date1 = sdf.parse(tanggalMasukText.getText());
            Date date2 = sdf.parse(tanggalKeluarText.getText());
            if (!isValidDate(tanggalMasukText.getText(), dateFormat) || !isValidDate(tanggalKeluarText.getText(), dateFormat)) {
                JOptionPane.showMessageDialog(null, "Tanggal valid: " + dateFormat);
            } else if (!date1.before(date2)) {
                JOptionPane.showMessageDialog(null, "Tanggal invalid !");
            } else {
                if (action.equals("add")) {
                    Pemesanan p = new Pemesanan(0, indexPenghuni, indexKamar, tanggalMasukText.getText(), tanggalKeluarText.getText(), indexPelanggaran, Integer.parseInt(totalBayarText.getText()), statusComboBox.getSelectedItem().toString());
                    psnCtrl.insertDataPemesanan(p);
                    System.out.println("masuk");
                } else if (action.equals("edit")) {
                    Pemesanan p = new Pemesanan(selectedId, indexPenghuni, indexKamar, tanggalMasukText.getText(), tanggalKeluarText.getText(), indexPelanggaran, Integer.parseInt(totalBayarText.getText()), statusComboBox.getSelectedItem().toString());
                    psnCtrl.updateDatePemesanan(p, selectedId);
                }

                clearText();
                showPemesanan();
                setComponent(false);
                setEditDeletebtn(false);
            }
        } catch (Exception e) {
            System.out.println("eror " + e);
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_SavebtnActionPerformed

    private void pelanggaranComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelanggaranComboBoxActionPerformed
        // TODO add your handling code here:
        Object obj = evt.getSource();
        if (obj == pelanggaranComboBox) {
            getIndexPelanggaran = pelanggaranComboBox.getSelectedIndex();
            denda = listPelanggaran.get(getIndexPelanggaran).getDenda();
            dendaText.setText(Integer.toString(denda));
            totalBayar = hargaKamar + denda;
            totalBayarText.setText(Integer.toString(totalBayar));
        }
    }//GEN-LAST:event_pelanggaranComboBoxActionPerformed

    private void tanggalMasukTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalMasukTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalMasukTextActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Apakah yakin ingin menghapus data ?", "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        switch (getAnswer) {
            case 0:
                try {
                psnCtrl.deleteDataPemesanan(selectedId);
                clearText();
                showPemesanan();
                setComponent(false);
                setEditDeletebtn(false);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
            break;

            case 1:
                JOptionPane.showMessageDialog(null, "Data tidak jadi dihapus!");
                break;
        }

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        AduanAdminView aav = new AduanAdminView();
        aav.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        action = "add";
        setComponent(true);
        clearText();
        dendaText.setEnabled(false);
        dendaText.setEditable(false);
        totalBayarText.setEnabled(false);
        totalBayarText.setEditable(false);
        getIndexKamar = kamarComboBox.getSelectedIndex();
        getIndexPelanggaran = pelanggaranComboBox.getSelectedIndex();
        hargaKamar = listKamar.get(getIndexKamar).getHarga_sewa();
        denda = listPelanggaran.get(getIndexPelanggaran).getDenda();
        dendaText.setText(Integer.toString(denda));
        totalBayar = hargaKamar + denda;
        totalBayarText.setText(Integer.toString(totalBayar));
        idPemesananText.setText("Auto Increment");
    }//GEN-LAST:event_addButtonActionPerformed

    private void kamarComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kamarComboBoxActionPerformed
        // TODO add your handling code here:
//        dendaText.setText(Integer.toString(setDenda()));
//        totalBayarText.setText(Integer.toString(setTotalBayar()));
        Object obj = evt.getSource();
        if (obj == kamarComboBox) {
            getIndexKamar = kamarComboBox.getSelectedIndex();
            hargaKamar = listKamar.get(getIndexKamar).getHarga_sewa();
            totalBayar = hargaKamar + denda;
            totalBayarText.setText(Integer.toString(totalBayar));
        }
    }//GEN-LAST:event_kamarComboBoxActionPerformed

    private void kamarNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kamarNavMouseClicked
        // TODO add your handling code here:
        KamarView kv = new KamarView();
        kv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kamarNavMouseClicked

    private void penghuniNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penghuniNavMouseClicked
        // TODO add your handling code here:
        PenghuniView pv = new PenghuniView();
        pv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_penghuniNavMouseClicked

    private void aduanAdminNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aduanAdminNavMouseClicked
        // TODO add your handling code here:
        AduanAdminView aav = new AduanAdminView();
        aav.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_aduanAdminNavMouseClicked

    private void pelanggaranNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelanggaranNavMouseClicked
        // TODO add your handling code here:
        PelanggaranView pv = new PelanggaranView();
        pv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pelanggaranNavMouseClicked

    private void transaksiNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaksiNavMouseClicked
        // TODO add your handling code here:
        TransaksiAdminView tav = new TransaksiAdminView();
        tav.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_transaksiNavMouseClicked

    private void tablePemesananShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePemesananShowMouseClicked
        // TODO add your handling code here:
        int indexpemesanan = -1;
        setEditDeletebtn(true);
        setComponent(false);

        int clickedRow = tablePemesananShow.getSelectedRow();
        TableModel tableModel = tablePemesananShow.getModel();

        selectedId = Integer.parseInt(tableModel.getValueAt(clickedRow, 0).toString());

        idPemesananText.setText(tableModel.getValueAt(clickedRow, 0).toString());
        
        int idPenghuni = Integer.parseInt(tableModel.getValueAt(clickedRow, 9).toString());
        
        for (Penghuni p : listPenghuni) {
            if (p.getId_penghuni() == idPenghuni) {
                indexPenghuni = listPenghuni.indexOf(p);
                break;
            }
//            System.out.println("id getp" + p.getId_penghuni());

        }
        System.out.println(indexPenghuni);
        penghuniComboBox.setSelectedIndex(indexPenghuni);

        int idKamar = (int) tableModel.getValueAt(clickedRow, 10);
        System.out.println(idKamar);
        for (Kamar k : listKamar) {
            if (k.getId_kamar() == (idKamar)) {
                indexKamar = listKamar.indexOf(k);
                break;
            }
        }
        kamarComboBox.setSelectedIndex(indexKamar);

        int idPelanggaran = (int) tableModel.getValueAt(clickedRow, 11);
        System.out.println(idPelanggaran);
        for (Pelanggaran p : listPelanggaran) {
            if (p.getId_pelanggaran() == (idPelanggaran)) {
                indexPelanggaran = listPelanggaran.indexOf(p);
            }
        }
        pelanggaranComboBox.setSelectedIndex(indexPelanggaran);

        dendaText.setText(tableModel.getValueAt(clickedRow, 6).toString());
        tanggalMasukText.setText(tableModel.getValueAt(clickedRow, 3).toString());
        tanggalKeluarText.setText(tableModel.getValueAt(clickedRow, 4).toString());
        totalBayarText.setText(tableModel.getValueAt(clickedRow, 7).toString());
        statusComboBox.setSelectedItem(tableModel.getValueAt(clickedRow, 8));

    }//GEN-LAST:event_tablePemesananShowMouseClicked

    private void cariBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBtnActionPerformed
        // TODO add your handling code here:
        setEditDeletebtn(false);
        setComponent(false);
        try {
            PemesananTable pt = psnCtrl.showPemesanan(cariText.getText());
            if (pt.getRowCount() == 0) {
                clearText();
                setEditDeletebtn(false);
                JOptionPane.showConfirmDialog(null, "Data tidak ditemukan", "Konfirmasi",
                        JOptionPane.DEFAULT_OPTION);
            } else {
                tablePemesananShow.setModel(pt);
            }
            clearText();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_cariBtnActionPerformed

    private void cariTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariTextActionPerformed
        // TODO add your handling code here:
        setEditDeletebtn(false);
        setComponent(false);
        try {
            PemesananTable pt = psnCtrl.showPemesanan(cariText.getText());
            if (pt.getRowCount() == 0) {
                clearText();
                setEditDeletebtn(false);
                JOptionPane.showConfirmDialog(null, "Data tidak ditemukan", "Konfirmasi",
                        JOptionPane.DEFAULT_OPTION);
            } else {
                tablePemesananShow.setModel(pt);
            }
            clearText();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_cariTextActionPerformed

    private void LogoutNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutNavMouseClicked
        // TODO add your handling code here:
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutNavMouseClicked

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        // TODO add your handling code here:
        setComponent(false);
        setEditDeletebtn(false);
        clearText();
        dendaText.setEnabled(false);
        dendaText.setEditable(false);
        totalBayarText.setEnabled(false);
        totalBayarText.setEditable(false);
        getIndexKamar = kamarComboBox.getSelectedIndex();
        getIndexPelanggaran = pelanggaranComboBox.getSelectedIndex();
        hargaKamar = listKamar.get(getIndexKamar).getHarga_sewa();
        denda = listPelanggaran.get(getIndexPelanggaran).getDenda();
        dendaText.setText(Integer.toString(denda));
        totalBayar = hargaKamar + denda;
        totalBayarText.setText(Integer.toString(totalBayar));
        
    }//GEN-LAST:event_cancelbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PemesananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PemesananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PemesananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PemesananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PemesananView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel LogoutNav;
    private javax.swing.JPanel NavPanel;
    private javax.swing.JButton Savebtn;
    private javax.swing.JLabel StatusLocation;
    private javax.swing.JButton addButton;
    private javax.swing.JPanel aduanAdminNav;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JButton cariBtn;
    private javax.swing.JTextField cariText;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField dendaText;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField idPemesananText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jenisPelanggaranText;
    private javax.swing.JComboBox<Kamar> kamarComboBox;
    private javax.swing.JPanel kamarNav;
    private javax.swing.JPanel masukText;
    private javax.swing.JPanel namaPenghuniText;
    private javax.swing.JComboBox<Pelanggaran> pelanggaranComboBox;
    private javax.swing.JPanel pelanggaranNav;
    private javax.swing.JComboBox<Penghuni> penghuniComboBox;
    private javax.swing.JPanel penghuniNav;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JTable tablePemesananShow;
    private javax.swing.JTextField tanggalKeluarText;
    private javax.swing.JTextField tanggalMasukText;
    private javax.swing.JTextField totalBayarText;
    private javax.swing.JPanel transaksiNav;
    // End of variables declaration//GEN-END:variables
}
