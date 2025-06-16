package Service;

import Model.Account;
import Model.Customer;
import Model.Movements;
import Utils.Constants;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MovementsService {

    public  void checkMovements(Scanner scanner, Map<String, Customer> customers) {
        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();
        Customer customer = customerService.getCustomerIfExists(scanner, customers);
        if (customer == null) return;
        List<Account> accounts = customer.getAccounts();
        accountService.printAccounts(accounts);
        Account account = accountService.selectAccountFromList(scanner, accounts, "Select the account you want to check the movements:");
        System.out.println("============================== Account Movements ==============================");
        account.getTransactions();
    }

    public  void transfer(Scanner scanner, Map<String, Customer> customers) {
        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();
        Customer customer = customerService.getCustomerIfExists(scanner, customers);
        if (customer == null) return;

        System.out.println("Choose the type of transfer");
        System.out.println("1 - Intern\n2 - To other person");
        int option = scanner.nextInt();
        while (option < 1 || option > 2) {
            System.out.println("Invalid selection. Please choose a valid option:");
            option = scanner.nextInt();
        }

        List<Account> accountsCopy = new ArrayList<>(customer.getAccounts());

        if (option == 1 && accountsCopy.size() > 1) {
            accountService.printAccounts(accountsCopy);
            System.out.println("Select the account you want to transfer money from:");
            int index = scanner.nextInt() - 1;
            while (index < 0 || index >= accountsCopy.size()) {
                System.out.println("Invalid selection. Please choose the right account:");
                index = scanner.nextInt() - 1;
            }
            Account accountFrom = accountsCopy.get(index);
            accountsCopy.remove(index); // remove origem para não poder ser destino

            accountService.printAccounts(accountsCopy);
            System.out.println("Select the account you want to transfer money to:");
            int indexAccountTo = scanner.nextInt() - 1;
            while (indexAccountTo < 0 || indexAccountTo >= accountsCopy.size()) {
                System.out.println("Invalid selection. Please choose the right account:");
                indexAccountTo = scanner.nextInt() - 1;
            }
            Account accountTo = accountsCopy.get(indexAccountTo);

            performTransfer(scanner, accountFrom, accountTo);

        } else if (option == 2) {
            scanner.nextLine(); // limpar buffer
            accountService.printAccounts(customer.getAccounts());
            System.out.println("Select the account you want to transfer money from:");
            int index = scanner.nextInt() - 1;
            while (index < 0 || index >= accountsCopy.size()) {
                System.out.println("Invalid selection. Please choose the right account:");
                index = scanner.nextInt() - 1;
            }
            Account accountFrom = accountsCopy.get(index);

            scanner.nextLine(); // limpar buffer
            System.out.println("Enter recipient NIF:");
            String recipientNif = scanner.nextLine();
            Customer recipient = customers.get(recipientNif);

            if (recipient == null || recipient.getAccounts().isEmpty()) {
                System.out.println("Recipient not found or has no accounts.");
                return;
            }

            accountService.printAccounts(recipient.getAccounts());
            System.out.println("Select the recipient's account:");
            int recipientIndex = scanner.nextInt() - 1;
            while (recipientIndex < 0 || recipientIndex >= recipient.getAccounts().size()) {
                System.out.println("Invalid selection. Please choose the right account:");
                recipientIndex = scanner.nextInt() - 1;
            }
            Account accountTo = recipient.getAccounts().get(recipientIndex);

            performTransfer(scanner, accountFrom, accountTo);

        } else {
            System.out.println("You don't have other accounts to transfer to, please choose option 2 to transfer to another account");
        }
    }

    public  void performTransfer(Scanner scanner, Account from, Account to) {
        double balance = from.getBalance();
        System.out.println("Your balance is: " + balance);
        System.out.println("Enter the amount you want to transfer:");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        } else if (amount > balance) {
            System.out.println("Error. You don't have that amount of money in your account.");
            return;
        }

        from.setBalance(balance - amount);
        to.setBalance(to.getBalance() + amount);

        from.getMovements().add(new Movements(LocalDateTime.now(), Constants.Movements.DEBIT, amount));
        to.getMovements().add(new Movements(LocalDateTime.now(), Constants.Movements.CREDIT, amount));

        System.out.println("Transfer Successfully!");
    }

    public  void withdrawMoney(Scanner scanner, Map<String, Customer> customers) {
        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();

        Customer customer = customerService.getCustomerIfExists(scanner, customers);
        if (customer == null) return;
        List<Account> accounts = customer.getAccounts();
        accountService.printAccounts(accounts);
        Account account = accountService.selectAccountFromList(scanner, accounts, "Select the account you want to withdraw money from:");
        double balance = account.getBalance();
        System.out.println("Your balance is: " + balance);
        System.out.println("Enter the amount you want to withdraw:");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        } else if (amount > balance) {
            System.out.println("Error. You don't have that amount of money in your account");
            return;
        }
        account.setBalance(balance - amount);
        account.getMovements().add(new Movements(LocalDateTime.now(), Constants.Movements.DEBIT, amount));
        System.out.println("\uD83D\uDCB0 Withdraw successful!");
    }

    public  void deposit(Scanner scanner, Map<String, Customer> customers) {
        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();

        Customer customer = customerService.getCustomerIfExists(scanner, customers);

        if (customer == null) return;
        List<Account> accounts = customer.getAccounts();
        accountService.printAccounts(accounts);
        Account account = accountService.selectAccountFromList(scanner, accounts, "Select the account to deposit:");

        System.out.println("Enter the amount:");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        account.setBalance(account.getBalance() + amount);
        account.getMovements().add(new Movements(LocalDateTime.now(), Constants.Movements.CREDIT, amount));
        System.out.println("\uD83D\uDCB0 Deposit successful!");
    }
}
