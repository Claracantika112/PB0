package model;

public class User {
    private String nama;

    public User(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void tampilInfo() {
        System.out.println("Nama Pengguna: " + nama);
    }
}