package org.example.uap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.*;

public class StokBarangGUI extends JFrame {
    private StokBarangManager manager;
    private JTextField tfNama, tfKategori, tfStok, tfHarga, tfKodeBarang, tfJumlahJual;
    private JButton btnTambah, btnUpdate, btnCari, btnLaporanHarian, btnLaporanMingguan, btnJual;
    private JTextArea taLaporan;
    private JLabel lblTanggalInput;

    public StokBarangGUI() {
        manager = new StokBarangManager();

        // Set up the frame
        setTitle("Manajemen Stok Barang");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        setLayout(new FlowLayout());

        // Input fields
        tfNama = new JTextField(20);
        tfKategori = new JTextField(20);
        tfStok = new JTextField(5);
        tfHarga = new JTextField(10);
        tfKodeBarang = new JTextField(10);
        tfJumlahJual = new JTextField(5);

        // Labels
        lblTanggalInput = new JLabel("Tanggal Input: " + LocalDate.now());

        // Buttons
        btnTambah = new JButton("Tambah Barang");
        btnUpdate = new JButton("Update Stok");
        btnCari = new JButton("Cari Barang");
        btnLaporanHarian = new JButton("Laporan Harian");
        btnLaporanMingguan = new JButton("Laporan Mingguan");
        btnJual = new JButton("Jual Barang");

        taLaporan = new JTextArea(12, 50);
        taLaporan.setEditable(false);

        // Add components to frame
        add(new JLabel("Nama Barang:"));
        add(tfNama);
        add(new JLabel("Kategori:"));
        add(tfKategori);
        add(new JLabel("Stok:"));
        add(tfStok);
        add(new JLabel("Harga:"));
        add(tfHarga);
        add(new JLabel("Kode Barang:"));
        add(tfKodeBarang);
        add(lblTanggalInput);
        add(btnTambah);
        add(btnUpdate);
        add(btnCari);
        add(new JLabel("Jumlah Jual:"));
        add(tfJumlahJual);
        add(btnJual);
        add(btnLaporanHarian);
        add(btnLaporanMingguan);
        add(new JScrollPane(taLaporan));

        // Button actions
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = tfNama.getText();
                    String kategori = tfKategori.getText();
                    int stok = Integer.parseInt(tfStok.getText());
                    double harga = Double.parseDouble(tfHarga.getText());
                    String kodeBarang = tfKodeBarang.getText();

                    manager.tambahBarang(nama, kategori, stok, harga, kodeBarang);

                    // Menampilkan pesan konfirmasi dan memperbarui laporan
                    JOptionPane.showMessageDialog(null, "Barang berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    taLaporan.setText("Barang yang baru ditambahkan:\n" +
                            "Nama: " + nama + "\nKategori: " + kategori + "\nStok: " + stok + "\nHarga: " + harga + "\nKode Barang: " + kodeBarang + "\nTanggal Input: " + LocalDate.now());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = tfNama.getText();
                    int stokMasuk = Integer.parseInt(tfStok.getText());
                    int stokKeluar = Integer.parseInt(tfHarga.getText()); // Menggunakan harga untuk stok keluar

                    manager.updateStok(nama, stokMasuk, stokKeluar);

                    // Menampilkan pesan konfirmasi dan memperbarui laporan
                    JOptionPane.showMessageDialog(null, "Stok berhasil diperbarui!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    taLaporan.setText("Stok untuk barang " + nama + " berhasil diperbarui.\n" +
                            "Stok Masuk: " + stokMasuk + "\nStok Keluar: " + stokKeluar + "\nTanggal Update: " + LocalDate.now());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnJual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = tfNama.getText();
                    int jumlahJual = Integer.parseInt(tfJumlahJual.getText());

                    // Memanggil fungsi jualBarang untuk memperbarui stok dan mencatat hasil penjualan
                    manager.jualBarang(nama, jumlahJual);

                    // Menampilkan pesan konfirmasi dan memperbarui laporan
                    JOptionPane.showMessageDialog(null, "Barang berhasil dijual!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                    // Menampilkan laporan barang yang terjual
                    Barang barang = manager.cariBarang(nama);
                    if (barang != null) {
                        taLaporan.setText("Penjualan Barang:\n" +
                                "Nama: " + barang.getNama() + "\nJumlah Terjual: " + barang.getStokTerjual() +
                                "\nHasil Penjualan: " + barang.getHasilPenjualan() + "\nStok Tersisa: " + barang.getStok() + "\nTanggal Terjual: " + LocalDate.now());
                    } else {
                        taLaporan.setText("Barang tidak ditemukan.");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = tfNama.getText().isEmpty() ? tfKodeBarang.getText() : tfNama.getText();
                Barang barang = manager.cariBarang(search);
                if (barang != null) {
                    taLaporan.setText("Nama: " + barang.getNama() + "\nKategori: " + barang.getKategori() +
                            "\nStok: " + barang.getStok() + "\nHarga: " + barang.getHarga() +
                            "\nKode Barang: " + barang.getKodeBarang() +
                            "\nTanggal Input: " + barang.getTanggalInput() +
                            "\nStok Terjual: " + barang.getStokTerjual() + "\nHasil Penjualan: " + barang.getHasilPenjualan());
                } else {
                    taLaporan.setText("Barang tidak ditemukan");
                }
            }
        });

        btnLaporanHarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String laporan = "Laporan Stok Harian:\n";
                for (Barang barang : manager.laporanStokHarian()) {
                    laporan += "Nama: " + barang.getNama() + ", Stok: " + barang.getStok() + ", Stok Terjual: " + barang.getStokTerjual() + ", Hasil Penjualan: " + barang.getHasilPenjualan() + "\n";
                }
                taLaporan.setText(laporan);
            }
        });

        btnLaporanMingguan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String laporan = "Laporan Stok Mingguan:\n";
                for (Barang barang : manager.laporanStokMingguan()) {
                    laporan += "Nama: " + barang.getNama() + ", Stok: " + barang.getStok() + ", Stok Terjual: " + barang.getStokTerjual() + ", Hasil Penjualan: " + barang.getHasilPenjualan() + "\n";
                }
                taLaporan.setText(laporan);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StokBarangGUI().setVisible(true);
            }
        });
    }
}