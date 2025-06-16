import Model.Contact;
import Service.ContactService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Contact> contacts = new ArrayList<>();

        showMenu(scanner,contacts);

        scanner.close();

    }

    public static void showMenu(Scanner scanner, List<Contact> contacts) {

        int option = 0;
        boolean isValid = false;

        ContactService contactService = new ContactService();


        while (!isValid) {
            System.out.println("============== Contact Manager ================");
            System.out.println("1 - Enter a new Contact");
            System.out.println("2 - Search By name");
            System.out.println("3 - Search By Phone Number");
            System.out.println("4 - Edit Contact");
            System.out.println("5 - List All Contacts");
            System.out.println("6 - Delete Contact");
            System.out.println("0 - Quit");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option == 0) {
                    System.out.println("Exiting... 👋");
                    return;
                } else if (option >= 1 && option <= 6) {
                    isValid = true;
                } else {
                    System.out.println("Choose a valid option between 0 and 6");
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }

        switch(option){
            case 1:
                contactService.createContact(scanner,contacts);
                showMenu(scanner,contacts);
                break;
            case 2:
                contactService.searchContactByName(scanner,contacts);
                showMenu(scanner,contacts);
                break;
            case 3:
                contactService.searchContactByPhoneNumber(scanner,contacts);
                showMenu(scanner,contacts);
                break;
            case 4:
                contactService.editContact();
                showMenu(scanner,contacts);
                break;
            case 5:
                contactService.listAllContacts(contacts);
                showMenu(scanner,contacts);
                break;
            case 6:
                contactService.deleteContact(scanner,contacts);
                showMenu(scanner,contacts);
                break;

        }
    }
}