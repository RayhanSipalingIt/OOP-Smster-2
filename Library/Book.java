public class Book {
    private String ISBN;
    private String title;
    private String author;
    private String publisher;
    private int numberOfCopies;

    public Book(String ISBN, String title, String author, String publisher, int numberOfCopies) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
    }

    public void borrowBook() {
        this.numberOfCopies -= 1;
    }

    public void returnBook() {
        this.numberOfCopies += 1;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

}
