public abstract class LaptopBase implements Laptop {
    protected int volume = 50;
    protected boolean isOn = false;

    public void powerOn() {
        isOn = true;
        System.out.println("Laptop menyala");
    }

    public void powerOff() {
        isOn = false;
        System.out.println("Laptop mati");
    }

    public void volumeUp() {
        if (isOn) {
            volume += 10;
            System.out.println("Volume: " + volume);
        } else {
            System.out.println("Nyalakan laptop dulu!");
        }
    }

    public void volumeDown() {
        if (isOn) {
            volume -= 10;
            System.out.println("Volume: " + volume);
        } else {
            System.out.println("Nyalakan laptop dulu!");
        }
    }
}