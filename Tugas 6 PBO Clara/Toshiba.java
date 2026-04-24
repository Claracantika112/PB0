public class Toshiba extends LaptopBase {

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Toshiba Satellite");
    }

    @Override
    public void powerOff() {
        isOn = false;
        System.out.println("Shutwon on process...");
    }
}