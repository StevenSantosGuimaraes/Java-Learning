package application;

import entities.Account;
import entities.SavingsAccount;

public class Program3 {

    public static void main(String[] args) {

        limparTerminal();
        
        // Polimorfismo:
        Account x = new Account(1002, "Alex", 1000.0);
        Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);

        x.withdraw(50.0);
        y.withdraw(50.0);

        System.out.println("X: " + x.getBalance());
        System.out.println("Y: " + y.getBalance());

    }

    public static void limparTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
