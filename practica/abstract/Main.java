package practica.abstract;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Abstract Classes---");
        Appliance washingMachine = new WashingMachine();
        Appliance microwave = new Microwave();

        washingMachine.turnOn();
        microwave.turnOn();
        System.out.println();

        // ===== Інтерфейси =====
        System.out.println("---Interfaces---");
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        guitar.play();
        piano.play();
    }
}