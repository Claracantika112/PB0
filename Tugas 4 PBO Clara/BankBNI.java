class BankBNI extends Bank {

    @Override
    void sukuBunga() {
        System.out.println("Suku bunga BNI adalah 4%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BNI";
        System.out.println("[BNI] Transfer Rp" + jumlah +
                " ke rekening " + rekeningTujuan +
                " di bank " + bankTujuan);
    }
}