package service;

import database.DatabaseConnection;
import java.sql.*;
import model.Kasir;
import model.Produk;

public class MinimarketService {

    // 1. Menampilkan Semua Produk
    public void tampilkanSemuaProduk() {
        String sql = "SELECT * FROM produk";
        System.out.println("\n=========================== DAFTAR PRODUK ===========================");
        System.out.printf("| %-9s | %-25s | %-12s | %-6s |\n", "ID PRODUK", "NAMA PRODUK", "HARGA", "STOK");
        System.out.println("---------------------------------------------------------------------");
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Produk p = new Produk(
                    rs.getInt("id_produk"),
                    rs.getString("nama_produk"),
                    rs.getDouble("harga"),
                    rs.getInt("stok")
                );
                p.tampilInfo();
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil data produk: " + e.getMessage());
        }
        System.out.println("=====================================================================");
    }

    // 2. Menampilkan Semua Kasir
    public void tampilkanSemuaKasir() {
        String sql = "SELECT * FROM kasir";
        System.out.println("\n====================== DAFTAR KASIR ======================");
        System.out.printf("| %-8s | %-20s | %-10s |\n", "ID KASIR", "NAMA KASIR", "SHIFT");
        System.out.println("----------------------------------------------------------");
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Kasir k = new Kasir(
                    rs.getInt("id_kasir"),
                    rs.getString("nama_kasir"),
                    rs.getString("shift")
                );
                k.tampilInfo();
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil data kasir: " + e.getMessage());
        }
        System.out.println("==========================================================");
    }

    // 3. Menambah Penjualan Baru (Memanggil Stored Procedure & Trigger Otomatis)
    public void tambahTransaksi(int idProduk, int idKasir, int jumlah) {
        String sql = "{CALL tambah_penjualan(?, ?, ?)}";
        
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            
            cstmt.setInt(1, idProduk);
            cstmt.setInt(2, idKasir);
            cstmt.setInt(3, jumlah);
            
            cstmt.execute();
            System.out.println("\n[SUKSES] Transaksi berhasil ditambahkan! Stok otomatis terpotong.");
            
        } catch (SQLException e) {
            System.err.println("\n[ERROR] Gagal melakukan transaksi: " + e.getMessage());
        }
    }

    // 4. Menampilkan Pendapatan Total (Memanggil MySQL Function)
    public void tampilkanTotalPendapatan() {
        String sql = "{? = call hitung_pendapatan()}";
        
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            
            double total = cstmt.getDouble(1);
            System.out.println("\n==================================================");
            System.out.printf(" TOTAL PENDAPATAN MINIMARKET SAAT INI: Rp%,.2f\n", total);
            System.out.println("==================================================");
            
        } catch (SQLException e) {
            System.err.println("Gagal menghitung pendapatan: " + e.getMessage());
        }
    }

    // 5. Menampilkan Laporan Lengkap (Memanggil View)
    public void tampilkanLaporanPenjualan() {
        String sql = "SELECT * FROM view_laporan_penjualan";
        System.out.println("\n=================================== LAPORAN TRANSAKSI PENJUALAN (VIEW) ===================================");
        System.out.printf("| %-5s | %-20s | %-15s | %-6s | %-15s | %-20s |\n", "ID", "PRODUK", "KASIR", "JUMLAH", "TOTAL HARGA", "TANGGAL");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                System.out.printf("| %-5d | %-20s | %-15s | %-6d | Rp%-12.2f | %-20s |\n",
                    rs.getInt("id_penjualan"),
                    rs.getString("nama_produk"),
                    rs.getString("nama_kasir"),
                    rs.getInt("jumlah"),
                    rs.getDouble("total_harga"),
                    rs.getTimestamp("tanggal").toString()
                );
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil laporan penjualan: " + e.getMessage());
        }
        System.out.println("==========================================================================================================");
    }
}
