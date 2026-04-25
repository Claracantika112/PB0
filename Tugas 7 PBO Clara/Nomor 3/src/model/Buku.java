package model;

public class Buku extends Item {
    private final String penulis;

    public Buku(String judul, String penulis){
        super(judul);
        this.penulis = penulis;
    }

    @Override
    public void display() {
        System.out.println("Buku: " + judul + " | Penulis: " + penulis);
    }
}