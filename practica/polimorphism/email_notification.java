package practica.polimorphism;

public class email_notification extends notification {
    @Override
    public void send() {
        System.out.println("Sending email notification");
    }
}