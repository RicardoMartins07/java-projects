package Service;

import Model.Customer;

import java.util.Map;
import java.util.Scanner;

public class CustomerService {

    public  Customer getCustomerIfExists(Scanner scanner, Map<String, Customer> customers) {
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

    public  Customer createUser(Scanner scanner, Map<String, Customer> customers) {
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

    public  boolean searchCustomerByNif(String nif, Map<String, Customer> customers) {
        return customers.containsKey(nif);
    }
}
