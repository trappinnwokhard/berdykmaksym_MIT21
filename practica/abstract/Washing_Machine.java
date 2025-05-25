package practica.abstract;

public class WashingMachine extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Washing machine ON.");
    }
}