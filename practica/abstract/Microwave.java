package practica.abstract;

public class Microwave extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Microwave is now ON.");
    }
}