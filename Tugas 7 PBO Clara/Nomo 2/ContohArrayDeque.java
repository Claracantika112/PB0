import java.util.ArrayDeque;

public class ContohArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<String> antrian = new ArrayDeque<>();

        antrian.add("Andi");
        antrian.add("Budi");
        antrian.add("Citra");

        System.out.println("Antrian Awal: " + antrian);

        antrian.poll(); // hapus depan
        System.out.println("Setelah poll(): " + antrian);

        antrian.addFirst("Dina");
        System.out.println("Setelah addFirst(): " + antrian);
    }
}