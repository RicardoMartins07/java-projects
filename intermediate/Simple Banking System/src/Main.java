import Model.Account;
import Model.Customer;
import Model.Movements;
import Service.AccountService;
import Service.CustomerService;
import Service.MovementsService;
import Utils.Constants;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Map<String, Customer> customers = new HashMap<>();

        showMenu(scanner,customers);

        scanner.close();

    }

    public static void showMenu(Scanner scanner, Map<String, Customer> customers) {
        int option;
        boolean isValid = false;

        AccountService accountService = new AccountService();
        MovementsService movementsService = new MovementsService();


        while (!isValid) {
            System.out.println("============== Banking System ===================");
            System.out.println("1 - Create an account");
            System.out.println("2 - Withdraw money");
            System.out.println("3 - Check account movements");
            System.out.println("4 - Transfer to another account");
            System.out.println("5 - Deactivate account");
            System.out.println("6 - Deposit");
            System.out.println("7 - Check Balance");
            System.out.println("0 - Quit");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> {
                        isValid = true;
                        accountService.createAccount(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 2 -> {
                        isValid = true;
                        movementsService.withdrawMoney(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 3 -> {
                        isValid = true;
                        movementsService.checkMovements(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 4 -> {
                        isValid = true;
                        movementsService.transfer(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 5 -> {
                        isValid = true;
                        accountService.deactivateAccont(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 6 -> {
                        isValid = true;
                        movementsService.deposit(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 7 -> {
                        isValid = true;
                        accountService.checkBalance(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 0 -> {
                        isValid = true;
                        System.out.println("Exiting ....");
                    }
                    default -> System.out.println("Please choose a valid option");
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }
    }

























}