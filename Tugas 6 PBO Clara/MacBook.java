public class MacBook extends LaptopBase {

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Apple MacBook Pro");
    }

    @Override
    public void powerOff() {
        isOn = false;
        System.out.println("Shutdown on process...");
    }
}