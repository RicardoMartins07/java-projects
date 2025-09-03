package Service;

import Model.Book;
import Model.Loan;
import Model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoanService {

    public void loanBook(Scanner scanner, List<Book> books, List<User> users) {

        Book book = null;
        User user = null;
        if (books.isEmpty()) {
            System.out.println("There are no books in this Library!");
            return;
        }

        LibraryService libraryService = new LibraryService();
        UserService userService = new UserService();

        scanner.nextLine();
        System.out.println("Enter the name of the user that is loaning the book:");
        String name = scanner.nextLine();

        List<User> matchedUsers = userService.searchUserByNameUtil(users, name);

        if (matchedUsers.isEmpty()){
            System.out.println("There are no matching Users");
            return;
        }


        System.out.println("Found " + matchedUsers.size() + " Users(s):");
        int j = 1;
        for (User u : matchedUsers) {
            System.out.println(j + " - " + u.toString());
            j++;
        }

        boolean isValid = false;
        while (!isValid) {



            if (scanner.hasNextInt()) {
                int optionU = scanner.nextInt();
                if (optionU < 1 || optionU > matchedUsers.size()) {
                    System.out.println("Please enter a valid option");
                } else {
                    user = matchedUsers.get(optionU - 1);
                    isValid = true;


                }


            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }

        }

        scanner.nextLine();

        System.out.println("Please enter either the ISBN or Title of the book:");
        String isbnOrTitle = scanner.nextLine();

        List<Book> matchedBooks = libraryService.checkIsbnOrTitle(books, isbnOrTitle);
        List<Book> availableBooks = matchedBooks.stream()
                .filter(book1 -> !book1.isLoan())
                .toList();

        if (matchedBooks.isEmpty() || availableBooks.isEmpty()) {
            System.out.println("There are no matching books!");
            return;
        }




        System.out.println("Found " + availableBooks.size() + " Book(s):");
        int i = 1;
        for (Book b : availableBooks) {
            if (!b.isLoan()){
                System.out.println(i + " - " + b.toString());
            }
            i++;
        }

        System.out.println("Please Choose the Book you want to Loan:");
        isValid = false;
        while (!isValid) {


            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                if (option < 1 || option > availableBooks.size()) {
                    System.out.println("Please enter a valid option");
                } else {
                    book = availableBooks.get(option - 1);
                    Loan loan = new Loan(book, user, LocalDate.now());
                    book.setLoan(true);
                    user.getLoans().add(loan);
                    isValid = true;
                    System.out.println("Book loaned successfully!");

                }

            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }


    }

    public void markAsReturned(Scanner scanner, List<Book> books){
        if (books.isEmpty()){
            System.out.println("There are no books in this Library");
            return;
        }

        LibraryService libraryService = new LibraryService();

        scanner.nextLine();

        System.out.println("Please enter either the ISBN or Title of the book:");
        String isbnOrTitle = scanner.nextLine();

        List<Book>  matchedBooks = libraryService.checkIsbnOrTitle(books,isbnOrTitle);

        if (matchedBooks.isEmpty()){
            System.out.println("There are no matching books!");
        }

        List<Book> availableBooks = matchedBooks.stream()
                .filter(Book::isLoan)
                .toList();

        System.out.println("Found " + availableBooks.size() + " Book(s):");
        int i = 1;
        for (Book b : availableBooks) {
            if (b.isLoan()){
                System.out.println(i + " - " + b.toString());
            }
            i++;
        }

        boolean isValid = false;
        while (!isValid) {
            System.out.println("Please Choose the Book you want to mark as return:");

            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                if (option < 1 || option > matchedBooks.size()) {
                    System.out.println("Please enter a valid option");
                } else {
                    Book b = matchedBooks.get(option - 1);

                    b.setLoan(false);

                    System.out.println("Book returned successfully!");

                    isValid = true;
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }
    }
}
