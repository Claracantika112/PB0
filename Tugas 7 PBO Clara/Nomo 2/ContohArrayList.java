import java.util.ArrayList;

public class ContohArrayList {
    public static void main(String[] args) {
        ArrayList<String> mahasiswa = new ArrayList<>();

        mahasiswa.add("Ferdi");
        mahasiswa.add("Budi");
        mahasiswa.add("Sinta");

        System.out.println("Data Mahasiswa:");
        for(String mhs : mahasiswa){
            System.out.println(mhs);
        }
    }
}