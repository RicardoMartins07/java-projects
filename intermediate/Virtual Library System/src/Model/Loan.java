package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Loan {

     private Book book;
     private User user;
     private LocalDate dateOfLoan;
     private int daysOfLoan;


    public Loan(Book book, User user, LocalDate dateOfLoan) {
        this.book = book;
        this.user = user;
        this.dateOfLoan = dateOfLoan;
        this.daysOfLoan = 5;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book.getTitle() +
                ", user=" + user.getName() +
                ", dateOfLoan=" + dateOfLoan +
                ", daysOfLoan=" + daysOfLoan +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDateOfLoan() {
        return dateOfLoan;
    }

    public void setDateOfLoan(LocalDate dateOfLoan) {
        this.dateOfLoan = dateOfLoan;
    }

    public int getDaysOfLoan() {
        return daysOfLoan;
    }

    public void setDaysOfLoan(int daysOfLoan) {
        this.daysOfLoan = daysOfLoan;
    }
}
