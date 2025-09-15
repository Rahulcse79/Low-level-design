interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int level);
}

class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is OFF");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("TV volume set to " + level);
    }
}

class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Radio is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is OFF");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("Radio volume set to " + level);
    }
}

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void pressOn();
    public abstract void pressOff();
    public abstract void volumeUp();
}

class BasicRemote extends RemoteControl {
    private int volume = 5;

    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void pressOn() {
        device.turnOn();
    }

    @Override
    public void pressOff() {
        device.turnOff();
    }

    @Override
    public void volumeUp() {
        volume++;
        device.setVolume(volume);
    }
}

public class Main {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remoteForTV = new BasicRemote(tv);

        Device radio = new Radio();
        RemoteControl remoteForRadio = new BasicRemote(radio);

        System.out.println("Using TV Remote:");
        remoteForTV.pressOn();
        remoteForTV.volumeUp();
        remoteForTV.pressOff();

        System.out.println("\nUsing Radio Remote:");
        remoteForRadio.pressOn();
        remoteForRadio.volumeUp();
        remoteForRadio.pressOff();
    }
}
