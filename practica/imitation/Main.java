package practica.imitation;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Imitation---");
        Vehicle vehicle = new Vehicle("Nissan", "Skyline");
        vehicle.displayInfo();

        Motorcycle motorcycle = new Motorcycle("BMW", "S1000RR", 900);
        motorcycle.displayInfo();

        Employee employee = new Employee("Vyacheslav", "Plumber");
        employee.displayInfo();

        Manager manager = new Manager("Denis", "Foreman", 8);
        manager.displayInfo();
        System.out.println();
    }

}