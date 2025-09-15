interface EuropeanSocket {
    void provideElectricity();
}

class USSocket {
    public void GiveElectricity() {
        System.out.println("Providing electricity 110V");
    }
}

class EUSocket implements EuropeanSocket {
    private USSocket usSocket;
    
    public EUSocket(USSocket usSocket) {
        this.usSocket = usSocket;
    }
    
    @Override
    public void provideElectricity() {
        System.out.println("Converting electricity 110V -> 220V");
        usSocket.GiveElectricity();
        System.out.println("Now sutable for EU device");
    }
}

public class Main {
    public static void main(String[] args) {
        USSocket usSocket = new USSocket();
        EUSocket euSocket = new EUSocket(usSocket);
        euSocket.provideElectricity();
    }
}
