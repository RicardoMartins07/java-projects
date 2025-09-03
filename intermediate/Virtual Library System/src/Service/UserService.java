package Service;

import Model.Book;
import Model.User;

import java.util.List;
import java.util.Scanner;

public class UserService {

    public void addNewUser(Scanner scanner, List<User> users){

        scanner.nextLine();

        System.out.println("Please enter the name of the user:");
        String name = scanner.nextLine();
        System.out.println("Please enter the email of the user:");
        String email = scanner.nextLine();
        System.out.println("Please enter the age of the user:");
        int age = scanner.nextInt();


        User u = new User(name,age,email);
        users.add(u);

        System.out.println("User addedd successfully!");
    }

    public void editUser(Scanner scanner, List<User> users){

        scanner.nextLine();

        System.out.println("Please enter the name of the User you want to Edit:");
        String name = scanner.nextLine();

        List<User> matchedUsers = searchUserByNameUtil(users,name);

        if (matchedUsers.isEmpty()){
            System.out.println("There are no matching users!");
            return;
        }

        System.out.println("Please Choose the User you want to Edit:");
        int index = listFilteredUsers(scanner, matchedUsers);

        if (index!= 0){
            User u = matchedUsers.get(index - 1);

            scanner.nextLine();

            System.out.println("Please enter the name of the user:");
            String nameUser = scanner.nextLine();
            System.out.println("Please enter the email of the user:");
            String email = scanner.nextLine();
            System.out.println("Please enter the age of the user:");
            int age = scanner.nextInt();


            u.setAge(age);
            u.setEmail(email);
            u.setName(nameUser);

            System.out.println("User Edited successfully!");

        }


    }

    public void deleteUser(Scanner scanner, List<User> users){

        scanner.nextLine();

        System.out.println("Please enter the name of the User you want to delete:");
        String name = scanner.nextLine();

        List<User> matchedUsers = searchUserByNameUtil(users,name);

        if (matchedUsers.isEmpty()){
            System.out.println("There are no matching users!");
            return;
        }

        System.out.println("Please Choose the User you want to delete:");
        int index = listFilteredUsers(scanner, matchedUsers);

        if (index!= 0){
            User u = matchedUsers.get(index - 1);

            users.remove(u);

            System.out.println("User Deleted successfully!");

        }

    }

    public List<User> searchUserByNameUtil(List<User> users, String name){
        String search = name.trim().toLowerCase();
        return users.stream()
                .filter(u -> u.getName().trim().toLowerCase().contains(search))
                .toList();
    }


    public void listAllUsers(List<User> users){
        if (users.isEmpty()){
            System.out.println("There are no users registed");
            return;
        }
        for (User u : users){
            System.out.println(u.toString());
        }
    }

    public void searchUserByName(Scanner scanner, List<User> users){
        scanner.nextLine();

        System.out.println("Please enter the name of the User:");
        String name = scanner.nextLine();
        String search = name.trim().toLowerCase();

        List<User> matchedUsers = users.stream()
                .filter(u -> u.getName().trim().toLowerCase().contains(search))
                .toList();

        if (matchedUsers.isEmpty()){
            System.out.println("There are no matching Users!");
            return;
        }

        System.out.println("Found " + matchedUsers.size() + " User(s):");
        for (User u : matchedUsers) {
            System.out.println(u.toString());
        }

    }

    public int listFilteredUsers(Scanner scanner , List<User> users){
        if (users.isEmpty()){
            System.out.println("There are no matching books!");
            return 0;
        }

        System.out.println("Found " + users.size() + " User(s):");
        int i = 1;
        for (User u : users) {
            System.out.println(i + " - " + u.toString());
            i++;
        }

        while (true) {

            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                if (option < 1 || option > users.size()) {
                    System.out.println("Please enter a valid option");
                } else {
                    return option;
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }
    }

    public void checkUsersLoans(Scanner scanner , List<User> users){
        scanner.nextLine();

        System.out.println("Please enter the name of the User you want to check Loans:");
        String name = scanner.nextLine();

        List<User> matchedUsers = searchUserByNameUtil(users,name);

        if (matchedUsers.isEmpty()){
            System.out.println("There are no matching users!");
            return;
        }

        System.out.println("Please Choose the User:");
        int index = listFilteredUsers(scanner, matchedUsers);

        if (index!= 0){
            User u = matchedUsers.get(index - 1);

            System.out.println(
                    !u.getLoans().isEmpty()
                            ? u.getLoans().toString()
                            : "There are no loans for this user"
            );


        }

    }
}
