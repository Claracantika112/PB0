package model;

public class Majalah extends Item {
    private final int edisi;

    public Majalah(String judul, int edisi){
        super(judul);
        this.edisi = edisi;
    }

    @Override
    public void display() {
        System.out.println("Majalah: " + judul + " | Edisi: " + edisi);
    }
}
