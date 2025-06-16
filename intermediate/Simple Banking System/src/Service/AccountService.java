package Service;

import Model.Account;
import Model.Customer;
import Utils.Constants;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountService {

    public  void deactivateAccont(Scanner scanner, Map<String, Customer> customers) {
        CustomerService customerService = new CustomerService();

        Customer customer = customerService.getCustomerIfExists(scanner, customers);
        if (customer == null) return;
        List<Account> accounts = customer.getAccounts();
        printAccounts(accounts);
        Account account = selectAccountFromList(scanner, accounts, "Select the account you want to deactivate:");
        account.setActive(false);
        System.out.println("Account deactivated successfully.");
    }

    public  void checkBalance(Scanner scanner, Map<String, Customer> customers) {
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getCustomerIfExists(scanner, customers);
        if (customer == null) return;
        List<Account> accounts = customer.getAccounts();
        printAccounts(accounts);
        Account account = selectAccountFromList(scanner, accounts, "Select the account you want to check the balance:");
        System.out.println("Your balance is: " + account.getBalance());
    }

    public  void createAccount(Scanner scanner, Map<String, Customer> customers) {
        int option;
        String accountType = null;
        CustomerService customerService = new CustomerService();

        scanner.nextLine();
        System.out.println("Please Enter your NIF:");
        String nif = scanner.nextLine();
        boolean existCustomer = customerService.searchCustomerByNif(nif, customers);
        Customer customer;

        if (existCustomer) {
            customer = customers.get(nif);
            while (accountType == null) {
                System.out.println("You already have a checking account in the bank");
                System.out.println("Which type of account you want to create?");
                System.out.println("1 - SAVINGS\n2 - BUSINESS\n");
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    switch (option) {
                        case 1 -> accountType = Constants.AccountType.SAVINGS_ACCOUNT;
                        case 2 -> accountType = Constants.AccountType.BUSINESS_ACCOUNT;
                        default -> System.out.println("Please choose a valid option");
                    }
                } else {
                    System.out.println("Please enter a valid number");
                    scanner.next();
                }
            }
        } else {
            System.out.println("You have no accounts in this bank");
            System.out.println("We need firstly to create your Checking Account and User");
            customer = customerService.createUser(scanner, customers);
            accountType = Constants.AccountType.CHECKING_ACCOUNT;
        }

        Account account = new Account(LocalDateTime.now(), accountType, customer);
        customer.getAccounts().add(account);
        System.out.println("Your account has been created!");
    }

    public  void printAccounts(List<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + " - " + accounts.get(i));
        }
    }

    public  Account selectAccountFromList(Scanner scanner, List<Account> accounts, String actionMessage) {
        System.out.println(actionMessage);
        int index = scanner.nextInt() - 1;
        while (index < 0 || index >= accounts.size()) {
            System.out.println("Invalid selection. Please choose the right account:");
            index = scanner.nextInt() - 1;
        }
        return accounts.get(index);
    }
}
