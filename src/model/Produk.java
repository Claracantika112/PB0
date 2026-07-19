package model;

public class Produk {
    private int idProduk;
    private String namaProduk;
    private double harga;
    private int stok;

    public Produk(int idProduk, String namaProduk, double harga, int stok) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter dan Setter untuk Enkapsulasi
    public int getIdProduk() { return idProduk; }
    public String getNamaProduk() { return namaProduk; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void tampilInfo() {
        System.out.printf("| %-9d | %-25s | Rp%-10.2f | %-6d |\n", idProduk, namaProduk, harga, stok);
    }
}