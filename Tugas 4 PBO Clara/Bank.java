class Bank {

    // 1) Transfer ke rekening lain (tanpa bank tujuan)
    void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer Rp" + jumlah +
                " ke rekening " + rekeningTujuan);
    }

    // 2) Transfer ke bank berbeda
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        System.out.println("Transfer Rp" + jumlah +
                " ke rekening " + rekeningTujuan +
                " di bank " + bankTujuan);
    }

    // 3) Transfer dengan berita
    void transferUang(int jumlah, String rekeningTujuan,
                      String bankTujuan, String berita) {
        System.out.println("Transfer Rp" + jumlah +
                " ke rekening " + rekeningTujuan +
                " di bank " + bankTujuan +
                " | Berita: " + berita);
    }

    // 4) Suku bunga default
    void sukuBunga() {
        System.out.println("Suku bunga standar adalah 3%");
    }
}