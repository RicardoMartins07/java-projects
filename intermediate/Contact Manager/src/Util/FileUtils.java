package Util;

import Model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public void doExport(List<Contact> contacts) {
        try {
            FileWriter myWriter = new FileWriter("Contacts.txt");

            for (Contact c : contacts) {
                StringBuilder line = new StringBuilder();

                line.append(c.getName()).append(" - ");
                line.append(c.getPhoneNumber()).append(" - ");
                line.append(c.getEmail()).append(" - ");
                line.append(c.getAddress());

                line.append("\n");
                myWriter.write(line.toString());
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public List<Contact> doImport(String filePath) {
        List<Contact> contacts = new ArrayList<>();

        File file = new File(filePath);

        if (!file.exists()) {
            try {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("File not found. Empty file created at: " + filePath);
                }
            } catch (IOException e) {
                System.out.println("Error creating file.");
                e.printStackTrace();
                return contacts;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length != 4) {
                    System.out.println("Skipped malformed line: " + line);
                    continue;
                }

                String name = parts[0].trim();
                String phoneNumber = parts[1].trim();
                String email = parts[2].trim();
                String address = parts[3].trim();

                Contact contact = new Contact(name, phoneNumber, email, address);
                contacts.add(contact);
            }

            System.out.println("Successfully imported contacts from file.");

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }

        return contacts;
    }

}
