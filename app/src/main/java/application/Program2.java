package application;

import model.entities.Account;
import model.entities.BusinessAccount;
import model.entities.SavingsAccount;

public class Program2 {
    
    public static void main(String[] args) {

        limparTerminal();

        Account acc1 = new Account(1001, "Alex",1000.0);
        Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
        Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);

        acc1.withdraw(200.0);
        acc2.withdraw(200.0);
        acc3.withdraw(200.0);
        
        System.out.println("Acc1: $" + acc1.getBalance());
        System.out.println("Acc2: $" + acc2.getBalance());
        System.out.println("Acc3: $" + acc3.getBalance());

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
