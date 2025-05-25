package practica.imitation;

public class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String make, String model, int engineCapacity) {
        super(make, model);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine Capacity: " + engineCapacity + " cc");
    }
}