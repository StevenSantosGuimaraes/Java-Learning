package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program1 {

    public static void main(String[] args) {

        limparTerminal();
        
        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCASTING:
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        // DOWNCASTING:
        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);
        SavingsAccount acc5 = (SavingsAccount) acc3;
        acc5.setInterestRate(0.015);

        /*
            -> Error difference specify account (BusinessAccount =/= SavingsAccount):
            BusinessAccount acc6 = (BusinessAccount) acc3;
        */

        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc6 = (BusinessAccount) acc3;
            acc6.loan(200.0);
            System.out.println("Loan!");
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc6 = (SavingsAccount) acc3;
            acc6.updateBalance();
            System.out.println("Update!");
        }

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
