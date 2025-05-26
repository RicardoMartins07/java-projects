import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);



        Map<String,Customer> customers = new HashMap<>();

        showMenu(scanner,customers);

        scanner.close();

    }

    public static void showMenu(Scanner scanner, Map<String, Customer> customers) {
        int option;
        boolean isValid = false;

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
                        createAccount(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 2 -> {
                        isValid = true;
                        withdrawMoney(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 3 -> {
                        isValid = true;
                        checkMovements(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 4 -> {
                        isValid = true;
                        transfer(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 5 -> {
                        isValid = true;
                        deactivateAccont(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 6 -> {
                        isValid = true;
                        deposit(scanner, customers);
                        showMenu(scanner, customers);
                    }
                    case 7 -> {
                        isValid = true;
                        checkBalance(scanner, customers);
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

    public static Customer getCustomerIfExists(Scanner scanner, Map<String, Customer> customers) {
        scanner.nextLine();
        System.out.println("Please Enter NIF:");
        String nif = scanner.nextLine();
        Customer customer = customers.get(nif);
        if (customer == null || customer.getAccounts().isEmpty()) {
            System.out.println("There are no accounts in this Bank with this NIF");
            return null;
        }
        return customer;
    }

    public static void printAccounts(List<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + " - " + accounts.get(i));
        }
    }

    public static Account selectAccountFromList(Scanner scanner, List<Account> accounts, String actionMessage) {
        System.out.println(actionMessage);
        int index = scanner.nextInt() - 1;
        while (index < 0 || index >= accounts.size()) {
            System.out.println("Invalid selection. Please choose the right account:");
            index = scanner.nextInt() - 1;
        }
        return accounts.get(index);
    }

    public static Customer createUser(Scanner scanner, Map<String, Customer> customers) {
        System.out.println("Enter your First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your Email:");
        String email = scanner.nextLine();
        System.out.println("Enter your Phone Number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter your NIF:");
        String nif = scanner.nextLine();
        Customer customer = new Customer(firstName, lastName, email, phoneNumber, nif);
        customers.put(nif, customer);
        return customer;
    }

    public static void createAccount(Scanner scanner, Map<String, Customer> customers) {
        int option;
        String accountType = null;

        scanner.nextLine();
        System.out.println("Please Enter your NIF:");
        String nif = scanner.nextLine();
        boolean existCustomer = searchCustomerByNif(nif, customers);
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
            customer = createUser(scanner, customers);
            accountType = Constants.AccountType.CHECKING_ACCOUNT;
        }

        Account account = new Account(LocalDateTime.now(), accountType, customer);
        customer.getAccounts().add(account);
        System.out.println("Your account has been created!");
    }

    public static boolean searchCustomerByNif(String nif, Map<String, Customer> customers) {
        return customers.containsKey(nif);
    }

    public static void deposit(Scanner scanner, Map<String, Customer> customers) {
        Customer customer = getCustomerIfExists(scanner, customers);

        if (customer == null) return;
        List<Account> accounts = customer.getAccounts();
        printAccounts(accounts);
        Account account = selectAccountFromList(scanner, accounts, "Select the account to deposit:");

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

    public static void checkBalance(Scanner scanner, Map<String, Customer> customers) {
        Customer customer = getCustomerIfExists(scanner, customers);
        if (customer == null) return;
        List<Account> accounts = customer.getAccounts();
        printAccounts(accounts);
        Account account = selectAccountFromList(scanner, accounts, "Select the account you want to check the balance:");
        System.out.println("Your balance is: " + account.getBalance());
    }

    public static void withdrawMoney(Scanner scanner, Map<String, Customer> customers) {
        Customer customer = getCustomerIfExists(scanner, customers);
        if (customer == null) return;
        List<Account> accounts = customer.getAccounts();
        printAccounts(accounts);
        Account account = selectAccountFromList(scanner, accounts, "Select the account you want to withdraw money from:");
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

    public static void deactivateAccont(Scanner scanner, Map<String, Customer> customers) {
        Customer customer = getCustomerIfExists(scanner, customers);
        if (customer == null) return;
        List<Account> accounts = customer.getAccounts();
        printAccounts(accounts);
        Account account = selectAccountFromList(scanner, accounts, "Select the account you want to deactivate:");
        account.setActive(false);
        System.out.println("Account deactivated successfully.");
    }

    public static void checkMovements(Scanner scanner, Map<String, Customer> customers) {
        Customer customer = getCustomerIfExists(scanner, customers);
        if (customer == null) return;
        List<Account> accounts = customer.getAccounts();
        printAccounts(accounts);
        Account account = selectAccountFromList(scanner, accounts, "Select the account you want to check the movements:");
        System.out.println("============================== Account Movements ==============================");
        account.getTransactions();
    }

    public static void transfer(Scanner scanner, Map<String, Customer> customers) {
        Customer customer = getCustomerIfExists(scanner, customers);
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
            printAccounts(accountsCopy);
            System.out.println("Select the account you want to transfer money from:");
            int index = scanner.nextInt() - 1;
            while (index < 0 || index >= accountsCopy.size()) {
                System.out.println("Invalid selection. Please choose the right account:");
                index = scanner.nextInt() - 1;
            }
            Account accountFrom = accountsCopy.get(index);
            accountsCopy.remove(index); // remove origem para não poder ser destino

            printAccounts(accountsCopy);
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
            printAccounts(customer.getAccounts());
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

            printAccounts(recipient.getAccounts());
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

    public static void performTransfer(Scanner scanner, Account from, Account to) {
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




}