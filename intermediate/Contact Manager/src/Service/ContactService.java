package Service;

import Model.Contact;
import Util.FileUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactService {

    public void createContact(Scanner scanner, List<Contact> contacts) {

        scanner.nextLine();

        System.out.println("Enter the name of the Contact:");
        String firstName = scanner.nextLine();

        System.out.println("Enter the Phone Number of the Contact:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter the Email of the Contact:");
        String email = scanner.nextLine();

        System.out.println("Enter the Address of the Contact:");
        String address = scanner.nextLine();

        Contact c = new Contact(firstName, phoneNumber, email, address);

        contacts.add(c);

        System.out.println("Contact addedd successfully!");

        FileUtils fileUtils = new FileUtils();

        fileUtils.doExport(contacts);


    }

    public void listAllContacts(List<Contact> contacts) {

        if (contacts.isEmpty()) {
            System.out.println("Your contact list is empty!");
            return;
        }

        for (Contact c : contacts) {
            System.out.println(c.toString());
        }

    }

    public void listAllContactsOrderedByName(List<Contact> contacts) {

        if (contacts.isEmpty()) {
            System.out.println("Your contact list is empty!");
            return;
        }

        List<Contact> sortedList =  new ArrayList<>(contacts);
        sortedList.sort(Comparator.comparing(Contact::getName));

        for (Contact c : sortedList) {
            System.out.println(c.toString());
        }

    }

    public void searchContactByName(Scanner scanner, List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("Your contact list is empty!");
            return;
        }

        scanner.nextLine();
        System.out.println("Enter the name of the Contact:");
        String firstName = scanner.nextLine();

        List<Contact> matchedContacts = contacts.stream()
                .filter(c -> c.getName().toLowerCase().contains(firstName.toLowerCase()) || c.getName().toLowerCase().trim().equals(firstName.toLowerCase()))
                .toList();

        if (matchedContacts.isEmpty()) {
            System.out.println("There are no matching contacts with that name!");
            return;
        }

        System.out.println("Found " + matchedContacts.size() + " contact(s):");
        for (Contact c : matchedContacts) {
            System.out.println(c.toString());
        }
    }

    public void searchContactByPhoneNumber(Scanner scanner, List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("Your contact list is empty!");
            return;
        }

        scanner.nextLine();
        System.out.println("Enter the Phone Number of the Contact:");
        String phoneNumber = scanner.nextLine();

        List<Contact> matchedContacts = contacts.stream()
                .filter(c -> c.getPhoneNumber().equals(phoneNumber) || c.getPhoneNumber().contains(phoneNumber)).toList();

        if (matchedContacts.isEmpty()) {
            System.out.println("There are no matching contacts with that Phone Number!");
            return;
        }

        System.out.println("Found " + matchedContacts.size() + " contact(s):");
        for (Contact c : matchedContacts) {
            System.out.println(c.toString());
        }


    }

    public void editContact(Scanner scanner, List<Contact> contacts) {
        scanner.nextLine();

        System.out.println("Enter the name of the Contact or the phone Number:");
        String nameOrPhoneNumber = scanner.nextLine();

        String input = nameOrPhoneNumber.trim();

        List<Contact> matchedContacts = contacts.stream()
                .filter(c -> c.getPhoneNumber().trim().equals(input) ||
                        c.getName().toLowerCase().trim().equals(input.toLowerCase()) || c.getName().toLowerCase().contains(input.toLowerCase()))
                .toList();


        if (matchedContacts.isEmpty()) {
            System.out.println("There are no matching contacts with that Phone Number or Name!");
            return;
        }

        System.out.println("Found " + matchedContacts.size() + " contact(s):");
        int i = 1;
        for (Contact c : matchedContacts) {
            System.out.println(i + " - " + c.toString());
            i++;
        }

        boolean isValid = false;
        while (!isValid) {
            System.out.println("Please Choose the Contact you want to Edit:");

            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                if (option < 1 || option > matchedContacts.size()) {
                    System.out.println("Please enter a valid option");
                } else {
                    Contact c = matchedContacts.get(option - 1);
                    scanner.nextLine();

                    System.out.println("Enter the name of the Contact:");
                    String firstName = scanner.nextLine();

                    System.out.println("Enter the Phone Number of the Contact:");
                    String phoneNumber = scanner.nextLine();

                    System.out.println("Enter the Email of the Contact:");
                    String email = scanner.nextLine();

                    System.out.println("Enter the Address of the Contact:");
                    String address = scanner.nextLine();

                    c.setAddress(address);
                    c.setEmail(email);
                    c.setPhoneNumber(phoneNumber);
                    c.setName(firstName);

                    System.out.println("Contact Edited successfully");

                    FileUtils fileUtils = new FileUtils();

                    fileUtils.doExport(contacts);

                    isValid = true;
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }
    }

    public void deleteContact(Scanner scanner, List<Contact> contacts) {
        scanner.nextLine();

        System.out.println("Enter the name of the Contact or the phone Number:");
        String nameOrPhoneNumber = scanner.nextLine();

        String input = nameOrPhoneNumber.trim();

        List<Contact> matchedContacts = contacts.stream()
                .filter(c -> c.getPhoneNumber().trim().equals(input) ||
                        c.getName().toLowerCase().trim().equals(input.toLowerCase()) || c.getName().toLowerCase().contains(input.toLowerCase()))
                .toList();


        if (matchedContacts.isEmpty()) {
            System.out.println("There are no matching contacts with that Phone Number or Name!");
            return;
        }

        System.out.println("Found " + matchedContacts.size() + " contact(s):");
        int i = 1;
        for (Contact c : matchedContacts) {
            System.out.println(i + " - " + c.toString());
            i++;
        }

        boolean isValid = false;
        while (!isValid) {
            System.out.println("Please Choose the Contact you want to delete:");

            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                if (option < 1 || option > matchedContacts.size()) {
                    System.out.println("Please enter a valid option");
                } else {
                    Contact c = matchedContacts.get(option - 1);
                    contacts.remove(c);
                    System.out.println("Contact deleted successfully");

                    FileUtils fileUtils = new FileUtils();

                    fileUtils.doExport(contacts);

                    isValid = true;
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }
    }
}
