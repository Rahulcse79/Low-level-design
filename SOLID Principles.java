// SOLID Principles Example
// Author: Rahul Singh 😊

/*
S -> Single Responsibility Principle
O -> Open/Closed Principle
L -> Liskov Substitution Principle
I -> Interface Segregation Principle
D -> Dependency Inversion Principle
*/

import java.util.*;

// ------------------- S: Single Responsibility -------------------
class Invoice {
    private int amount;

    public Invoice(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}

// Responsibility 1: Calculate
class InvoiceCalculator {
    public int calculateTotal(Invoice invoice) {
        return invoice.getAmount();
    }
}

// Responsibility 2: Print
class InvoicePrinter {
    public void printInvoice(Invoice invoice) {
        System.out.println("Invoice amount: " + invoice.getAmount());
    }
}

// ------------------- O: Open/Closed -------------------
interface Discount {
    double apply(double amount);
}

class NoDiscount implements Discount {
    public double apply(double amount) {
        return amount;
    }
}

class ChristmasDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.9; // 10% off
    }
}

// ------------------- L: Liskov Substitution -------------------
abstract class Bird {
    public abstract void fly();
}

class Sparrow extends Bird {
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

// If we had a Penguin extending Bird, it would break LSP since Penguin can't fly.
// Instead, separate interfaces for FlyingBird and NonFlyingBird.

// ------------------- I: Interface Segregation -------------------
interface Printer {
    void printDocument(String content);
}

interface Scanner {
    void scanDocument(String content);
}

class SimplePrinter implements Printer {
    public void printDocument(String content) {
        System.out.println("Printing: " + content);
    }
}

class MultiFunctionMachine implements Printer, Scanner {
    public void printDocument(String content) {
        System.out.println("Multi-function printing: " + content);
    }
    public void scanDocument(String content) {
        System.out.println("Scanning: " + content);
    }
}

// ------------------- D: Dependency Inversion -------------------
interface MessageService {
    void sendMessage(String msg);
}

class EmailService implements MessageService {
    public void sendMessage(String msg) {
        System.out.println("Email sent: " + msg);
    }
}

class SMSService implements MessageService {
    public void sendMessage(String msg) {
        System.out.println("SMS sent: " + msg);
    }
}

// High-level module depends on abstraction, not concrete class
class Notification {
    private MessageService service;

    public Notification(MessageService service) {
        this.service = service;
    }

    public void notifyUser(String msg) {
        service.sendMessage(msg);
    }
}

// ------------------- Main -------------------
public class SolidDemo {
    public static void main(String[] args) {
        // S: Single Responsibility
        Invoice invoice = new Invoice(500);
        InvoiceCalculator calculator = new InvoiceCalculator();
        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(invoice);
        System.out.println("Total: " + calculator.calculateTotal(invoice));

        // O: Open/Closed
        Discount discount = new ChristmasDiscount(); // easy to extend
        System.out.println("Discounted: " + discount.apply(1000));

        // L: Liskov Substitution
        Bird bird = new Sparrow();
        bird.fly(); // works fine

        // I: Interface Segregation
        Printer simplePrinter = new SimplePrinter();
        simplePrinter.printDocument("Report");

        MultiFunctionMachine mfm = new MultiFunctionMachine();
        mfm.printDocument("Resume");
        mfm.scanDocument("Passport");

        // D: Dependency Inversion
        MessageService service = new EmailService(); // switchable
        Notification notification = new Notification(service);
        notification.notifyUser("Hello via Email");

        service = new SMSService();
        notification = new Notification(service);
        notification.notifyUser("Hello via SMS");
    }
}
