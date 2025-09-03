import Model.Book;
import Model.Loan;
import Model.User;
import Service.LibraryService;
import Service.LoanService;
import Service.UserService;
import Utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FileUtils fileUtils = new FileUtils();


        List<Book> books = new ArrayList<>();
        List<Loan> loans = new ArrayList<>();
        List<User> users = new ArrayList<>();

        showMenu(scanner,books,users,loans);

        scanner.close();
    }

    public static void showMenu(Scanner scanner, List<Book> books, List<User> users, List<Loan> loans) {

        int option = 0;
        boolean isValid = false;


        FileUtils fileUtils = new FileUtils();
        LibraryService libraryService = new LibraryService();


        while (true) {
            System.out.println("============== Library System ================");
            System.out.println("1 - Enter a new Book");
            System.out.println("2 - List all books");
            System.out.println("3 - Search By name");
            System.out.println("4 - Search By ISBN");
            System.out.println("5 - Edit a book");
            System.out.println("6 - Delete Book");
            System.out.println("7 - Loans Menu");
            System.out.println("8 - Users Menu");
            System.out.println("0 - Quit");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option == 0) {

                    System.out.println("Exiting... 👋");
                    return;
                } else if (option >= 1 && option <= 8) {
                    switch(option){
                        case 1:
                            libraryService.addNewBook(scanner,books);
                            break;
                        case 2:
                            libraryService.listAllBooks(books);
                            break;
                        case 3:
                            libraryService.searchBookByName(scanner,books);
                            break;
                        case 4:
                            libraryService.searchBookByISBN(scanner,books);
                            break;
                        case 5:
                            libraryService.editBook(scanner,books);
                            break;
                        case 6:
                            libraryService.deleteBook(scanner,books);
                            break;
                        case 7:
                            showMenuLoans(scanner,books,users);
                            break;
                        case 8:
                            showMenuUsers(scanner,users);
                            break;

                    }
                } else {
                    System.out.println("Choose a valid option between 0 and 7");
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }


    }

    public static void showMenuLoans(Scanner scanner, List<Book> books , List<User> users) {

        int option = 0;
        boolean isValid = false;


        FileUtils fileUtils = new FileUtils();

        LoanService loanService = new LoanService();


        while (true) {
            System.out.println("============== Library System ================");
            System.out.println("1 - Loan a Book");
            System.out.println("2 - Mark a book as returned");
            System.out.println("0 - Return to main menu");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option == 0) {
                    return;
                } else if (option >= 1 && option <= 2) {
                    switch(option){
                        case 1:
                            loanService.loanBook(scanner,books,users);
                            break;
                        case 2:
                            loanService.markAsReturned(scanner,books);
                            break;

                    }
                } else {
                    System.out.println("Choose a valid option between 0 and 2");
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }


    }

    public static void showMenuUsers(Scanner scanner, List<User> users ) {

        int option = 0;
        boolean isValid = false;


        FileUtils fileUtils = new FileUtils();

        UserService userService = new UserService();


        while (true) {
            System.out.println("============== Library System ================");
            System.out.println("1 - Add new User");
            System.out.println("2 - Edit User");
            System.out.println("3 - Delete User");
            System.out.println("4 - List All Users");
            System.out.println("5 - Search User By name");
            System.out.println("6 - Check User Loans");
            System.out.println("0 - Return to main menu");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option == 0) {
                    return;
                } else if (option >= 1 && option <= 6) {
                    switch(option){
                        case 1:
                            userService.addNewUser(scanner,users);
                            break;
                        case 2:
                            userService.editUser(scanner,users);
                            break;
                        case 3:
                            userService.deleteUser(scanner,users);
                            break;
                        case 4:
                            userService.listAllUsers(users);
                            break;
                        case 5:
                            userService.searchUserByName(scanner,users);
                            break;
                        case 6:
                            userService.checkUsersLoans(scanner,users);
                            break;

                    }
                } else {
                    System.out.println("Choose a valid option between 0 and 4");
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }


    }
}