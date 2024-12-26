package org.example.uap;

import java.time.LocalDate;

public class Barang {
    private String nama;
    private String kategori;
    private int stok;
    private double harga;
    private String kodeBarang;
    private LocalDate tanggalInput;
    private int stokTerjual;
    private double hasilPenjualan;

    // Constructor
    public Barang(String nama, String kategori, int stok, double harga, String kodeBarang) {
        this.nama = nama;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
        this.kodeBarang = kodeBarang;
        this.tanggalInput = LocalDate.now();
        this.stokTerjual = 0;
        this.hasilPenjualan = 0.0;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public LocalDate getTanggalInput() {
        return tanggalInput;
    }

    public int getStokTerjual() {
        return stokTerjual;
    }

    public void tambahStokTerjual(int jumlah) {
        this.stokTerjual += jumlah;
        this.hasilPenjualan += jumlah * this.harga;  // Hasil penjualan dihitung berdasarkan harga dan jumlah terjual
    }

    public double getHasilPenjualan() {
        return hasilPenjualan;
    }
}