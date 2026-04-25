package main;

import java.util.ArrayList;
import model.*;
import service.*;


public class Main {
    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Buku("Pemrograman Java", "Yulhan"));
        items.add(new Majalah("Teknologi", 12));

        for (Item i : items) {
            i.display();
        }

        DataManager<String> dm = new DataManager<>();
        dm.addData("Data 1");
        dm.addData("Data 2");

        System.out.println("Data Manager:");
        dm.showData();
}
}