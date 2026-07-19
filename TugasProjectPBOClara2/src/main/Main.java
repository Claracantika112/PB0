package main;

import java.util.Scanner;
import service.MinimarketService;

public class Main {
    public static void main(String[] args) {
        MinimarketService service = new MinimarketService();
        try (Scanner scanner = new Scanner(System.in)) {
            int pilihan;
            
            do {
                System.out.println("\n===== APLIKASI MINIMARKET (Tugas Project PBO Clara) =====");
                System.out.println("1. Lihat Daftar Produk");
                System.out.println("2. Lihat Daftar Kasir");
                System.out.println("3. Tambah Transaksi Penjualan");
                System.out.println("4. Lihat Total Pendapatan Toko");
                System.out.println("5. Lihat Laporan Transaksi Lengkap");
                System.out.println("6. Keluar");
                System.out.print("Pilih menu (1-6): ");
                
                // Validasi input angka
                while (!scanner.hasNextInt()) {
                    System.out.print("Input harus berupa angka! Pilih menu (1-6): ");
                    scanner.next();
                }
                pilihan = scanner.nextInt();
                
                switch (pilihan) {
                    case 1 -> service.tampilkanSemuaProduk();
                    case 2 -> service.tampilkanSemuaKasir();
                    case 3 -> {
                        System.out.println("\n--- Input Transaksi Baru ---");
                        service.tampilkanSemuaProduk();
                        System.out.print("Masukkan ID Produk: ");
                        int idProduk = scanner.nextInt();
                        
                        service.tampilkanSemuaKasir();
                        System.out.print("Masukkan ID Kasir: ");
                        int idKasir = scanner.nextInt();
                        
                        System.out.print("Masukkan Jumlah Beli: ");
                        int jumlah = scanner.nextInt();
                        
                        service.tambahTransaksi(idProduk, idKasir, jumlah);
                    }
                    case 4 -> service.tampilkanTotalPendapatan();
                    case 5 -> service.tampilkanLaporanPenjualan();
                    case 6 -> System.out.println("\nTerima kasih! Program selesai.");
                    default -> System.out.println("\nPilihan tidak valid! Silakan pilih menu 1-6.");
                }
            } while (pilihan != 6);
        }
    }
}