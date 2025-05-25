package practica.polimorphism;

public class sms_notification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS notification");
    }
}