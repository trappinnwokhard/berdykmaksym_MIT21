package practica.incapsulation;

public class Main {
    public static void main(String[] args) {
        // ===== Інкапсуляція =====
        System.out.println("---incapsulation---");
        Book book = new Book("1999", "Boris Comfort", 2010);
        book.displayInfo();

        Account account = new Account("123456789", 500);
        account.deposit(200);
        account.withdraw(100);
        System.out.println("Current balance: " + account.getBalance());
        System.out.println();
    }
}