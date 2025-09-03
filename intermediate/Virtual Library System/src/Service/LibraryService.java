package Service;

import Model.Book;

import java.util.List;
import java.util.Scanner;

public class LibraryService {

    public void addNewBook(Scanner scanner, List<Book> bookList){
        scanner.nextLine();

        System.out.println("Please enter the title of the book:");
        String title = scanner.nextLine();

        System.out.println("Please enter the ISBN:");
        String isbn = scanner.nextLine();

        System.out.println("Please enter the gender of the book:");
        String gender = scanner.nextLine();

        System.out.println("Please enter the author:");
        String author = scanner.nextLine();

        System.out.println("Please enter the Year of the book:");
        int year = scanner.nextInt();

        Book b = new Book(title,author,isbn,gender,year);

        bookList.add(b);

        System.out.println("Book addedd successfully!");

    }

    public void listAllBooks(List<Book> bookList){
        if (bookList.isEmpty()){
            System.out.println("There are no books in this Library!");
            return;
        }

        for (Book b : bookList){
            System.out.println(b.toString());
        }

    }

    public int listFilteredBooks(Scanner scanner, List<Book> matchedBooks){
        if (matchedBooks.isEmpty()){
            System.out.println("There are no matching books!");
            return 0;
        }

        System.out.println("Found " + matchedBooks.size() + " Book(s):");
        int i = 1;
        for (Book b : matchedBooks) {
            System.out.println(i + " - " + b.toString());
            i++;
        }

        while (true) {

            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                if (option < 1 || option > matchedBooks.size()) {
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

    public void searchBookByName(Scanner scanner, List<Book> bookList){

        if(bookList.isEmpty()){
            System.out.println("There are no books in this Library!");
            return;
        }

        scanner.nextLine();

        System.out.println("Please enter the title of the book:");
        String title = scanner.nextLine();

        List<Book> matchedBooks = bookList.stream().filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()) || b.getTitle().toLowerCase().trim().equals(title.toLowerCase())).toList();

        if (matchedBooks.isEmpty()){
            System.out.println("There are no matching books with that title");
            return;
        }

        System.out.println("Found " + matchedBooks.size() + " Book(s):");
        for (Book b : matchedBooks) {
            System.out.println(b.toString());
        }
    }

    public void searchBookByISBN(Scanner scanner, List<Book> bookList){
        if(bookList.isEmpty()){
            System.out.println("There are no books in this Library!");
            return;
        }

        scanner.nextLine();

        System.out.println("Please enter the ISBN of the book:");
        String isbn = scanner.nextLine();

        List<Book> matchedBooks = bookList.stream().filter(b -> b.getISBN().toLowerCase().contains(isbn.toLowerCase()) || b.getISBN().toLowerCase().trim().equals(isbn.toLowerCase())).toList();

        if (matchedBooks.isEmpty()){
            System.out.println("There are no matching books with that ISBN");
            return;
        }

        System.out.println("Found " + matchedBooks.size() + " Book(s):");
        for (Book b : matchedBooks) {
            System.out.println(b.toString());
        }

    }

    public List<Book> checkIsbnOrTitle (List<Book> bookList, String isbnOrTitle){

        return bookList.stream().filter(b -> b.getTitle().toLowerCase().contains(isbnOrTitle.toLowerCase()) || b.getTitle().toLowerCase().trim().equals(isbnOrTitle.toLowerCase()) || b.getISBN().toLowerCase().contains(isbnOrTitle.toLowerCase()) || b.getISBN().toLowerCase().trim().equals(isbnOrTitle.toLowerCase())).toList();
    }

    public void editBook( Scanner scanner, List<Book> bookList){
        if (bookList.isEmpty()){
            System.out.println("There are no books in this Library");
            return;
        }

        scanner.nextLine();

        System.out.println("Please enter either the ISBN or Title of the book to edit:");
        String isbnOrTitle = scanner.nextLine();

        List<Book> matchedBooks = checkIsbnOrTitle(bookList,isbnOrTitle);

        if (matchedBooks.isEmpty()){
            System.out.println("There are no matching books!");
            return;
        }

        System.out.println("Please Choose the Book you want to Edit:");
        int index = listFilteredBooks(scanner, matchedBooks);
        if (index!= 0){
            Book b = matchedBooks.get(index - 1);

            scanner.nextLine();
            System.out.println("Please enter the title of the book:");
            String title = scanner.nextLine();

            System.out.println("Please enter the ISBN:");
            String isbn = scanner.nextLine();

            System.out.println("Please enter the gender of the book:");
            String gender = scanner.nextLine();

            System.out.println("Please enter the author:");
            String author = scanner.nextLine();

            System.out.println("Please enter the Year of the book:");
            int year = scanner.nextInt();

            b.setTitle(title);
            b.setAuthor(author);
            b.setISBN(isbn);
            b.setGender(gender);
            b.setYear(year);


            System.out.println("Book Edited successfully");
        }


    }

    public void deleteBook( Scanner scanner, List<Book> bookList) {
        if (bookList.isEmpty()) {
            System.out.println("There are no books in this Library");
            return;
        }

        scanner.nextLine();

        System.out.println("Please enter either the ISBN or Title of the book to Delete:");
        String isbnOrTitle = scanner.nextLine();

        List<Book> matchedBooks = checkIsbnOrTitle(bookList, isbnOrTitle);

        if (matchedBooks.isEmpty()) {
            System.out.println("There are no matching books!");
            return;
        }

        System.out.println("Please Choose the Book you want to Delete:");
        int index = listFilteredBooks(scanner, matchedBooks);
        if (index != 0) {
            Book b = matchedBooks.get(index - 1);

            bookList.remove(b);

            System.out.println("Book Deleted successfully");
        }
    }
}
