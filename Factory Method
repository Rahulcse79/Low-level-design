import java.util.*;

interface Notification {
    void notifyUser(String message);
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class NotificationFactory {
    
    public static Notification createNotification(String type) {
        if(type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if(type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else {
            throw new IllegalArgumentException("Unknown Notification type");
        }
    }
}

public class Main {
    
    public static void main(String args[]) {
        Notification notification1 = NotificationFactory.createNotification("SMS");
        notification1.notifyUser("Hello via SMS");
        Notification notification2 = NotificationFactory.createNotification("EMAIL");
        notification2.notifyUser("Hello via Email");
    }
}
