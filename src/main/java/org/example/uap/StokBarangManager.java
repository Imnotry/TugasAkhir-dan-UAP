package org.example.uap;

import java.util.ArrayList;
import java.util.List;

public class StokBarangManager {
    private List<Barang> barangList;

    public StokBarangManager() {
        barangList = new ArrayList<>();
    }

    public void tambahBarang(String nama, String kategori, int stok, double harga, String kodeBarang) {
        barangList.add(new Barang(nama, kategori, stok, harga, kodeBarang));
    }

    public void updateStok(String nama, int stokMasuk, int stokKeluar) {
        for (Barang barang : barangList) {
            if (barang.getNama().equals(nama)) {
                barang.setStok(barang.getStok() + stokMasuk - stokKeluar);
                return;
            }
        }
    }

    public void jualBarang(String nama, int jumlah) {
        for (Barang barang : barangList) {
            if (barang.getNama().equals(nama)) {
                if (barang.getStok() >= jumlah) {
                    barang.setStok(barang.getStok() - jumlah);
                    barang.tambahStokTerjual(jumlah);
                }
            }
        }
    }

    public Barang cariBarang(String search) {
        for (Barang barang : barangList) {
            if (barang.getNama().equalsIgnoreCase(search) || barang.getKodeBarang().equalsIgnoreCase(search)) {
                return barang;
            }
        }
        return null;
    }

    public List<Barang> laporanStokHarian() {
        return barangList;
    }

    public List<Barang> laporanStokMingguan() {
        return barangList;
    }
}