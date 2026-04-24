import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Laptop laptop;

        System.out.println("Pilih Laptop:");
        System.out.println("1. Toshiba");
        System.out.println("2. MacBook");
        System.out.println("3. ThinkPad");
        System.out.print("Pilihan: ");
        int pilih = input.nextInt();
        input.nextLine();

        if (pilih == 1) {
            laptop = new Toshiba();
        } else if (pilih == 2) {
            laptop = new MacBook();
        } else {
            laptop = new ThinkPad();
        }

        String command;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("ON  = Nyalakan");
            System.out.println("OFF = Matikan");
            System.out.println("UP  = Volume +");
            System.out.println("DOWN = Volume -");
            System.out.println("EXIT = Keluar");
            System.out.print("Masukkan perintah: ");

            command = input.nextLine().toUpperCase();

            switch (command) {
                case "ON":
                    laptop.powerOn();
                    break;
                case "OFF":
                    laptop.powerOff();
                    break;
                case "UP":
                    laptop.volumeUp();
                    break;
                case "DOWN":
                    laptop.volumeDown();
                    break;
                case "EXIT":
                    System.out.println("Program selesai");
                    break;
                default:
                    System.out.println("Perintah tidak dikenal!");
            }

        } while (!command.equals("EXIT"));

        input.close();
    }
}