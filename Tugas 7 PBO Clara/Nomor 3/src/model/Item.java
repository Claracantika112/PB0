package model;

public abstract class Item {
    protected String judul;

    public Item(String judul){
        this.judul = judul;
    }

    public abstract void display();
}