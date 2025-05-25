package practica.polimorphism;

public class Main {
    public static void main(String[] args) {
        System.out.println("---polimorphism---");
        Shape triangle = new Triangle(5, 10);
        Shape square = new Square(9);

        System.out.println("Triangle area: " + triangle.calculateArea());
        System.out.println("Square area: " + square.calculateArea());

        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();

        email.send();
        sms.send();
        System.out.println();
    }
}