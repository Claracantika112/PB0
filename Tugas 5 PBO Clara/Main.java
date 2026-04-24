import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input Student
        System.out.print("Nama Mahasiswa: ");
        String namaMhs = input.nextLine();
        System.out.print("Alamat Mahasiswa: ");
        String alamatMhs = input.nextLine();

        Student s = new Student(namaMhs, alamatMhs);

        System.out.print("Jumlah Mata Kuliah: ");
        int jumlahMK = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlahMK; i++) {
            System.out.print("Nama MK: ");
            String mk = input.nextLine();
            System.out.print("Nilai: ");
            int nilai = input.nextInt();
            input.nextLine();
            s.addCourseGrade(mk, nilai);
        }

        // Output Student
        System.out.println("\nData Mahasiswa:");
        System.out.println(s);
        s.printGrades();
        System.out.println("Rata-rata: " + s.getAverageGrade());

        // Input Teacher
        System.out.print("\nNama Dosen: ");
        String namaDosen = input.nextLine();
        System.out.print("Alamat Dosen: ");
        String alamatDosen = input.nextLine();

        Teacher t = new Teacher(namaDosen, alamatDosen);

        System.out.print("Jumlah MK diajar: ");
        int jumlahAjar = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlahAjar; i++) {
            System.out.print("Nama MK: ");
            String mk = input.nextLine();
            if (!t.addCourse(mk)) {
                System.out.println("MK sudah ada!");
            }
        }

        System.out.println("\nData Dosen:");
        System.out.println(t);

        input.close();
    }
}
