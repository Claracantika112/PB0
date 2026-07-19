package model;

public class Kasir extends User {
    private int idKasir;
    private String shift;

    public Kasir(int idKasir, String nama, String shift) {
        super(nama); // Memanggil constructor dari Parent Class (User)
        this.idKasir = idKasir;
        this.shift = shift;
    }

    public int getIdKasir() {
        return idKasir;
    }

    public String getShift() {
        return shift;
    }

    // Polimorfisme: Override method tampilInfo() milik class User
    @Override
    public void tampilInfo() {
        System.out.printf("| %-8d | %-20s | %-10s |\n", idKasir, getNama(), shift);
    }
}