class ThinkPad extends LaptopBase {

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Lenovo ThinkPad ");
    }

    @Override
    public void powerOff() {
        isOn = false;
        System.out.println("Shutdown on process...");
    }
}