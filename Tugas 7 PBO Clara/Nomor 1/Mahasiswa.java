public class Mahasiswa<N, Nm, C> {
    private N nim;
    private Nm name;
    private C clas;

    // setter
    public void setNim(N nim) {
        this.nim = nim;
    }

    public void setName(Nm name) {
        this.name = name;
    }

    public void setClas(C clas) {
        this.clas = clas;
    }

    // getter
    public N getNim() {
        return nim;
    }

    public Nm getName() {
        return name;
    }

    public C getClas() {
        return clas;
    }
}