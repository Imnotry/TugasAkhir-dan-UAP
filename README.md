# Manajemen Stok Barang

**Manajemen Stok Barang** adalah sebuah aplikasi berbasis Java dengan antarmuka GUI (Graphical User Interface) yang digunakan untuk mengelola data stok barang, mencatat penjualan, dan menghasilkan laporan stok harian maupun mingguan.

## Fitur Utama

1. **Menambahkan Barang:**
   - Pengguna dapat menambahkan barang baru ke dalam daftar stok dengan informasi seperti nama barang, kategori, stok awal, harga, dan kode barang.

2. **Memperbarui Stok:**
   - Memungkinkan pengguna untuk menambah atau mengurangi jumlah stok barang tertentu.

3. **Mencari Barang:**
   - Fitur pencarian barang berdasarkan nama atau kode barang.

4. **Penjualan Barang:**
   - Mencatat jumlah barang yang terjual dan secara otomatis memperbarui stok tersisa.

5. **Laporan Stok:**
   - Laporan harian dan mingguan yang menampilkan data stok barang, jumlah barang yang terjual, dan hasil penjualan.

## Struktur Kode

### **1. Kelas Utama: `StokBarangGUI`**
Kelas ini bertanggung jawab untuk mengelola antarmuka pengguna (GUI) dan menangani interaksi pengguna dengan fitur-fitur aplikasi.

### **2. Kelas Pendukung:**
- **`StokBarangManager`**
  - Mengelola logika bisnis, seperti penambahan barang, pembaruan stok, dan pencatatan penjualan.

- **`Barang`**
  - Representasi entitas barang dengan atribut seperti nama, kategori, stok, harga, kode barang, dan informasi penjualan.

## Cara Menggunakan

### 1. Menjalankan Aplikasi
- Compile semua file Java menggunakan perintah:
  ```bash
  javac -d . *.java
  ```
- Jalankan aplikasi dengan perintah:
  ```bash
  java manajemenstok.StokBarangGUI
  ```

### 2. Fitur Aplikasi
- **Tambah Barang:** Isi informasi barang di form dan klik tombol `Tambah Barang`.
- **Update Stok:** Masukkan nama barang dan jumlah stok masuk atau keluar, lalu klik tombol `Update Stok`.
- **Jual Barang:** Masukkan nama barang dan jumlah barang yang terjual, lalu klik tombol `Jual Barang`.
- **Cari Barang:** Masukkan nama atau kode barang, lalu klik tombol `Cari Barang`.
- **Laporan Harian/Mingguan:** Klik tombol `Laporan Harian` atau `Laporan Mingguan` untuk melihat laporan stok barang.

## Contoh Penggunaan

- Menambahkan barang:
  - Nama Barang: "Laptop"
  - Kategori: "Elektronik"
  - Stok: 10
  - Harga: 15000000
  - Kode Barang: "ELEC123"

- Menjual barang:
  - Nama Barang: "Laptop"
  - Jumlah Jual: 2

- Laporan Harian:
  Menampilkan daftar barang beserta stok, jumlah terjual, dan hasil penjualan.

## Teknologi yang Digunakan

- **Java Swing**: Untuk antarmuka pengguna (GUI).
- **Java Collections Framework**: Untuk mengelola data barang menggunakan struktur data `List`.
- **Java Time API**: Untuk pengelolaan tanggal seperti tanggal input barang dan laporan.

## Pengembang

- Nama: [Nama Pengembang]
- Kontak: [Email atau Media Sosial]

---

Jika Anda menemukan bug atau memiliki saran pengembangan, jangan ragu untuk menghubungi kami!
