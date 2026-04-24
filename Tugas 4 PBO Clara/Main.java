public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        BankBNI bni = new BankBNI();
        BankBCA bca = new BankBCA();

        // Overloading
        bank.transferUang(100000, "123456");
        bank.transferUang(200000, "123456", "Mandiri");
        bank.transferUang(300000, "123456", "BRI", "Bayar utang");

        bank.sukuBunga();

        System.out.println();

        // Overriding
        bni.transferUang(500000, "987654", "Bank Lain");
        bni.sukuBunga();

        System.out.println();

        bca.transferUang(750000, "555555", "Bank Lain");
        bca.sukuBunga();
    }
}