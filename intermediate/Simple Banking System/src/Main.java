import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);



        Map<String,Customer> customers = new HashMap<>();
        
        showMenu(scanner,customers);
        
        scanner.close();

        /*
        * Funcionalidades:
        *
        * 1 - Criar Conta (Criando também utilizador)
        * 2 - Levantar Dinheiro
        * 3 - Verificar Extrato
        * 4 - Transferir entre contas
        * 5 - Desativar Conta
        * 6 - Depositar
        * 7- Ver saldo
        * */

        
    }
    
    public static  void showMenu(Scanner scanner, Map<String,Customer> customers){

        int option;
        boolean isValid = false;
        

        
        while (!isValid){

            System.out.println("============== Banking System ===================");
            System.out.println("1 - Create an account");
            System.out.println("2 - Withdraw money");
            System.out.println("3 - Check account movements");
            System.out.println("4 - Transfer to another account");
            System.out.println("5 - Deactivate account");
            System.out.println("6 - Deposit");
            System.out.println("7 - Check Balance");
            System.out.println("0 - Quit");

        if (scanner.hasNextInt()){
            option = scanner.nextInt();
           switch (option){
               case 1:
                   isValid = true;
                   createAccount(scanner,customers);
                   showMenu(scanner,customers);
                   break;
               case 2:
                   withdrawMoney(scanner,customers);
                   showMenu(scanner,customers);
                   isValid = true;
                   break;
               case 3:
                   isValid = true;
                   break;
               case 4:
                   isValid = true;
                   break;
               case 5:
                   deactivateAccont(scanner,customers);
                   showMenu(scanner,customers);
                   isValid = true;
                   break;
               case 6:
                   deposit(scanner,customers);
                   showMenu(scanner,customers);
                   isValid = true;
                   break;
               case 7:
                   checkBalance(scanner,customers);
                   showMenu(scanner,customers);
                   isValid = true;
                   break;
               case 0:
                   isValid = true;
                   System.out.println("Exiting ....");
                   break;
               default:
                   System.out.println("Please choose a valid option");
                   break;
           }

        }else {
            System.out.println("Please enter a valid number");
            scanner.next();
        }

        }
    }


    public static Customer createUser(Scanner scanner,Map<String,Customer> customers){


        System.out.println("Enter your First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter your Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter your Email:");
        // Validate Email
        String email = scanner.nextLine();

        System.out.println("Enter your Phone Number:");
        // Validate PhoneNumber
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter your NIF:");
        String nif = scanner.nextLine();

        Customer customer = new Customer(firstName,lastName,email,phoneNumber,nif);
        customers.put(nif,customer);

        return customer;

    }

    //Account Methods
    public static  void createAccount ( Scanner scanner , Map<String,Customer> customers ) {

        int option;


        AccountType accountType = null;

        scanner.nextLine();
        System.out.println("Please Enter your NIF:");
        String nif = scanner.nextLine();
        boolean existCutomer = searchCustomerByNif(nif,customers);
        Customer customer ;


        if (existCutomer) {
            customer = customers.get(nif);
                while (accountType == null){
                    System.out.println("You already have a checking account in the bank");
                    System.out.println("Which type of account you want to create?");
                    System.out.println("1 - SAVINGS\n2 - BUSINESS\n");
                    if (scanner.hasNextInt()) {
                        option = scanner.nextInt();
                        switch (option) {
                            case 1:
                                accountType = AccountType.SAVINGS;
                                break;
                            case 2:
                                accountType = AccountType.BUSINESS;
                                break;
                            default:
                                System.out.println("Please choose a valid option");
                                break;
                        }

                    } else {
                        System.out.println("Please enter a valid number");
                        scanner.next();
                    }
            }


            } else {
                System.out.println("You have no accounts in this bank");
                System.out.println("We need firstly to create your Checking Account and User");

                customer = createUser(scanner,customers);
                accountType = AccountType.CHECKING;


            }

            Account account = new Account(LocalDateTime.now(),accountType,customer);
            customer.getAccounts().add(account);


            System.out.println("Your account has been created!");
    }

    public  static boolean searchCustomerByNif(String nif, Map<String,Customer> custumers){

        return custumers.containsKey(nif);
    }

    //Deposit
    public static void deposit(Scanner scanner, Map<String, Customer> customers) {
        scanner.nextLine();
        System.out.println("Please Enter your NIF:");
        String nif = scanner.nextLine();
        Customer customer = customers.get(nif);

        if (customer == null || customer.getAccounts().isEmpty()) {
            System.out.println("There are no accounts in this Bank with your NIF");
            return;
        }

        System.out.println("Accounts available:");
        List<Account> accounts = customer.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + 1 + " - " + accounts.get(i));
        }

        System.out.println("Select the account to deposit:");
        int index = scanner.nextInt() - 1;
        if (index < 0 || index >= accounts.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        System.out.println("Enter the amount:");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        Account account = accounts.get(index);
        account.setBalance(account.getBalance() + amount);
        System.out.println("💰 Deposit successful!");
    }

    // Check Balance
    public static void checkBalance(Scanner scanner,Map<String, Customer> customers){

        scanner.nextLine();
        System.out.println("Please Enter your NIF:");
        String nif = scanner.nextLine();
        Customer customer = customers.get(nif);

        if (customer == null || customer.getAccounts().isEmpty()) {
            System.out.println("There are no accounts in this Bank with your NIF");
            return;
        }

        System.out.println("Accounts available:");
        List<Account> accounts = customer.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + 1 + " - " + accounts.get(i));
        }

        System.out.println("Select the account you want to check the balance:");
        int index = scanner.nextInt() - 1;
        while(index < 0 || index >= accounts.size()) {
            System.out.println("Invalid selection. Please choose the right account:");
            index = scanner.nextInt() - 1;
        }

        System.out.println("Your balance is: " + accounts.get(index).getBalance());
    }

    //Withdraw Money
    public static void withdrawMoney(Scanner scanner, Map<String, Customer> customers){
        scanner.nextLine();
        System.out.println("Please Enter your NIF:");
        String nif = scanner.nextLine();
        Customer customer = customers.get(nif);

        if (customer == null || customer.getAccounts().isEmpty()) {
            System.out.println("There are no accounts in this Bank with your NIF");
            return;
        }

        System.out.println("Accounts available:");
        List<Account> accounts = customer.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + 1 + " - " + accounts.get(i));
        }

        System.out.println("Select the account you want to withdraw money from:");
        int index = scanner.nextInt() - 1;
        while(index < 0 || index >= accounts.size()) {
            System.out.println("Invalid selection. Please choose the right account:");
            index = scanner.nextInt() - 1;
        }

        double balance = accounts.get(index).getBalance();
        System.out.println("Your balance is: " +balance);
        System.out.println("Enter the amount you want to withdraw:");
        double amount = scanner.nextDouble();
        if (amount <= 0 ) {
            System.out.println("Amount must be positive.");
            return;
        } else if (amount > balance) {
            System.out.println("Error. You don't have that amount of money in your account");
            return;
        }


        Account account = accounts.get(index);

        account.setBalance(balance - amount);

        System.out.println("💰 Withdraw successful!");

    }


    //Deactivate Account
    public static void deactivateAccont(Scanner scanner, Map<String, Customer> customers){
        scanner.nextLine();
        System.out.println("Please Enter your NIF:");
        String nif = scanner.nextLine();
        Customer customer = customers.get(nif);

        if (customer == null || customer.getAccounts().isEmpty()) {
            System.out.println("There are no accounts in this Bank with your NIF");
            return;
        }

        System.out.println("Accounts available:");
        List<Account> accounts = customer.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + 1 + " - " + accounts.get(i));
        }

        System.out.println("Select the account you want to deactivate:");
        int index = scanner.nextInt() - 1;
        while(index < 0 || index >= accounts.size()) {
            System.out.println("Invalid selection. Please choose the right account:");
            index = scanner.nextInt() - 1;
        }

        Account account = accounts.get(index);
        account.setActive(false);
    }
}