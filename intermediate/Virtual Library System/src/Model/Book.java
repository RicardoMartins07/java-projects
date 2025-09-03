package Model;

public class Book {

    private String title;
    private String author;
    private String ISBN;
    private String gender;
    private int year;
    private boolean isLoan;

    public boolean isLoan() {
        return isLoan;
    }

    public void setLoan(boolean loan) {
        isLoan = loan;
    }



    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", gender='" + gender + '\'' +
                ", year=" + year +
                ", isLoan=" + isLoan +
                '}';
    }

    public Book(String title, String author, String ISBN, String gender, int year) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.gender = gender;
        this.year = year;
        this.isLoan = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
