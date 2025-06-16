package Service;

import Model.Contact;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactService {

    public void createContact(Scanner scanner, List<Contact> contacts){

        scanner.nextLine();

        System.out.println("Enter the name of the Contact:");
        String firstName = scanner.nextLine();

        System.out.println("Enter the Phone Number of the Contact:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter the Email of the Contact:");
        String email = scanner.nextLine();

        System.out.println("Enter the Address of the Contact:");
        String address = scanner.nextLine();

        Contact c = new Contact(firstName,phoneNumber,email,address);

        contacts.add(c);

        System.out.println("Contact addedd successfully!");


    }

    public void listAllContacts(List<Contact> contacts){

        for (Contact c : contacts){
            System.out.println(c.toString());
        }

    }

    public void searchContactByName(Scanner scanner, List<Contact> contacts){
        if (contacts.isEmpty()){
            System.out.println("Your contact list is empty!");
            return;
        }

        scanner.nextLine();
        System.out.println("Enter the name of the Contact:");
        String firstName = scanner.nextLine();

        List<Contact> matchedContacts = contacts.stream()
                .filter(c -> c.getName().contains(firstName) || c.getName().trim().equalsIgnoreCase(firstName))
                .toList();

        if (matchedContacts.isEmpty()){
            System.out.println("There are no matching contacts with that name!");
            return;
        }

        System.out.println("Found " + matchedContacts.size() + " contact(s):");
        for (Contact c : matchedContacts){
            System.out.println(c.toString());
        }
    }

    public void searchContactByPhoneNumber(Scanner scanner, List<Contact> contacts){
        if (contacts.isEmpty()){
            System.out.println("Your contact list is empty!");
            return;
        }

        scanner.nextLine();
        System.out.println("Enter the Phone Number of the Contact:");
        String phoneNumber = scanner.nextLine();

        List<Contact> matchedContacts = contacts.stream()
                .filter(c -> c.getPhoneNumber().equals(phoneNumber) || c.getPhoneNumber().contains(phoneNumber)).toList();

        if (matchedContacts.isEmpty()){
            System.out.println("There are no matching contacts with that Phone Number!");
            return;
        }

        System.out.println("Found " + matchedContacts.size() + " contact(s):");
        for (Contact c : matchedContacts){
            System.out.println(c.toString());
        }


    }

    public void editContact(){

    }

    public void deleteContact(Scanner scanner, List<Contact> contacts){
        scanner.nextLine();

        System.out.println("Enter the name of the Contact or the phone Number:");
        String nameOrPhoneNumber = scanner.nextLine();

        String input = nameOrPhoneNumber.trim();

        List<Contact> matchedContacts = contacts.stream()
                .filter(c -> c.getPhoneNumber().trim().equals(input) ||
                        c.getName().trim().equalsIgnoreCase(input) || c.getName().contains(input))
                .toList();


        if (matchedContacts.isEmpty()){
            System.out.println("There are no matching contacts with that Phone Number or Name!");
            return;
        }

        System.out.println("Found " + matchedContacts.size() + " contact(s):");
        int i = 1;
        for (Contact c : matchedContacts){
            System.out.println(i +" - "+c.toString());
            i++;
        }
    }
}
