package main;

import java.sql.*;
import java.util.Scanner;

public class AplikasiRetail {
    // Port 3306 adalah port standar XAMPP MySQL laptop pada umumnya
    private static final String URL = "jdbc:mysql://localhost:3306/toko_retail";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Koneksi Database Gagal: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n==================================");
            System.out.println("         MENU TOKO RETAIL         ");
            System.out.println("==================================");
            System.out.println("1. Tampil Semua Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Ubah Data");
            System.out.println("5. Hapus Data");
            System.out.println("0. Keluar");
            System.out.println("==================================");
            System.out.print("Pilihan : ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Pilihan tidak valid! Pilihan : ");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tampilSemuaData();
                    break;
                case 2:
                    tambahData(scanner);
                    break;
                case 3:
                    cariData(scanner);
                    break;
                case 4:
                    ubahData(scanner);
                    break;
                case 5:
                    hapusData(scanner);
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }
        } while (pilihan != 0);

        scanner.close();
    }

    // 1. Tampil Semua Data
    private static void tampilSemuaData() {
        String query = "SELECT * FROM barang";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n+-------------------------------------------------------+");
            System.out.println("|               DAFTAR BARANG TOKO RETAIL               |");
            System.out.println("+----+--------+----------------------+---------+--------+");
            System.out.println("| #  | Kode   | Nama Barang          | Harga   | Stok   |");
            System.out.println("+----+--------+----------------------+---------+--------+");

            int no = 1;
            while (rs.next()) {
                System.out.printf("| %-2d | %-6s | %-20s | %-7d | %-6d |\n",
                        no++,
                        rs.getString("kode"),
                        rs.getString("nama_barang"),
                        rs.getInt("harga"),
                        rs.getInt("stok"));
            }
            System.out.println("+----+--------+----------------------+---------+--------+");
            System.out.println("Total: " + (no - 1) + " barang");

        } catch (SQLException e) {
            System.out.println("Error tampil data: " + e.getMessage());
        }
    }

    // 2. Tambah Data
    private static void tambahData(Scanner scanner) {
        System.out.print("Masukkan Kode Barang (cth: B004): ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga Barang: ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan Stok Barang: ");
        int stok = scanner.nextInt();

        String query = "INSERT INTO barang (kode, nama_barang, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, kode);
            pstmt.setString(2, nama);
            pstmt.setInt(3, harga);
            pstmt.setInt(4, stok);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data berhasil ditambahkan!");
            }
        } catch (SQLException e) {
            System.out.println("Error tambah data: " + e.getMessage());
        }
    }

    // 3. Cari Data
    private static void cariData(Scanner scanner) {
        System.out.print("Masukkan Kode atau Nama Barang yang dicari: ");
        String keyword = scanner.nextLine();

        String query = "SELECT * FROM barang WHERE kode = ? OR nama_barang LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, keyword);
            pstmt.setString(2, "%" + keyword + "%");
            
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n+----+--------+----------------------+---------+--------+");
                System.out.println("| #  | Kode   | Nama Barang          | Harga   | Stok   |");
                System.out.println("+----+--------+----------------------+---------+--------+");
                
                int no = 1;
                while (rs.next()) {
                    System.out.printf("| %-2d | %-6s | %-20s | %-7d | %-6d |\n",
                            no++,
                            rs.getString("kode"),
                            rs.getString("nama_barang"),
                            rs.getInt("harga"),
                            rs.getInt("stok"));
                }
                System.out.println("+----+--------+----------------------+---------+--------+");
                if (no == 1) {
                    System.out.println("Data tidak ditemukan.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error cari data: " + e.getMessage());
        }
    }

    // 4. Ubah Data
    private static void ubahData(Scanner scanner) {
        System.out.print("Masukkan Kode Barang yang ingin diubah: ");
        String kode = scanner.nextLine();

        System.out.print("Masukkan Nama Barang Baru: ");
        String namaBaru = scanner.nextLine();
        System.out.print("Masukkan Harga Barang Baru: ");
        int hargaBaru = scanner.nextInt();
        System.out.print("Masukkan Stok Barang Baru: ");
        int stokBaru = scanner.nextInt();

        String query = "UPDATE barang SET nama_barang = ?, harga = ?, stok = ? WHERE kode = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, namaBaru);
            pstmt.setInt(2, hargaBaru);
            pstmt.setInt(3, stokBaru);
            pstmt.setString(4, kode);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data dengan Kode " + kode + " berhasil diubah!");
            } else {
                System.out.println("Kode barang tidak ditemukan!");
            }
        } catch (SQLException e) {
            System.out.println("Error ubah data: " + e.getMessage());
        }
    }

    // 5. Hapus Data
    private static void hapusData(Scanner scanner) {
        System.out.print("Masukkan Kode Barang yang ingin dihapus: ");
        String kode = scanner.nextLine();

        String query = "DELETE FROM barang WHERE kode = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, kode);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data dengan Kode " + kode + " berhasil dihapus!");
            } else {
                System.out.println("Kode barang tidak ditemukan!");
            }
        } catch (SQLException e) {
            System.out.println("Error hapus data: " + e.getMessage());
        }
    }
}
