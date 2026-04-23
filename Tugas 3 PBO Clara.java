import java.util.*;

// class induk
class Mahasiswa {
    String nim;
    String nama;
    int nilai;

    Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }

    void tampilData() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Nilai : " + nilai);
    }
}

// class turunan (inheritance)
class NilaiMahasiswa extends Mahasiswa {

    NilaiMahasiswa(String nim, String nama, int nilai) {
        super(nim, nama, nilai);
    }

    String getGrade() {
        if (nilai >= 80 && nilai <= 100) return "A";
        else if (nilai >= 70) return "B";
        else if (nilai >= 60) return "C";
        else if (nilai >= 50) return "D";
        else if (nilai >= 0) return "E";
        else return "INVALID";
    }

    boolean isLulus() {
        return nilai >= 60;
    }
}

// main class
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<NilaiMahasiswa> data = new ArrayList<>();

        System.out.print("Jumlah mahasiswa: ");
        int n = input.nextInt();
        input.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nData ke-" + (i + 1));

            System.out.print("NIM   : ");
            String nim = input.nextLine();

            System.out.print("Nama  : ");
            String nama = input.nextLine();

            System.out.print("Nilai : ");
            int nilai = input.nextInt();
            input.nextLine();

            if (nilai < 0 || nilai > 100) {
                System.out.println("Input nilai anda salah");
                i--;
                continue;
            }

            data.add(new NilaiMahasiswa(nim, nama, nilai));
        }

        int total = 0;
        int lulus = 0, tidakLulus = 0;
        int a=0,b=0,c=0,d=0,e=0;

        System.out.println("\n=== HASIL ===");

        for (NilaiMahasiswa m : data) {
            m.tampilData();
            String grade = m.getGrade();
            System.out.println("Grade : " + grade);
            System.out.println("---------------------------");

            total += m.nilai;

            if (m.isLulus()) lulus++;
            else tidakLulus++;

            switch (grade) {
                case "A": a++; break;
                case "B": b++; break;
                case "C": c++; break;
                case "D": d++; break;
                case "E": e++; break;
            }
        }

        double rata = (double) total / data.size();

        System.out.println("\nJumlah Mahasiswa: " + data.size());
        System.out.println("Jumlah Lulus: " + lulus);
        System.out.println("Jumlah Tidak Lulus: " + tidakLulus);

        System.out.println("Jumlah Grade A: " + a);
        System.out.println("Jumlah Grade B: " + b);
        System.out.println("Jumlah Grade C: " + c);
        System.out.println("Jumlah Grade D: " + d);
        System.out.println("Jumlah Grade E: " + e);

        System.out.println("Rata-rata nilai: " + rata);
    }
}