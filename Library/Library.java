import java.util.LinkedList;

public class Library {
    private LinkedList<Book> listBook = new LinkedList<>();

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("001", "pyro", "max", "erlangga", 10));
        library.addBook(new Book("002", "cryo", "maxi", "dunia Ilmu", 5));
        library.addBook(new Book("003", "dendro", "maxim", "gatot", 11));
        library.addBook(new Book("004", "electro", "maximu", "kesurupan", 1));
        library.addBook(new Book("005", "hydro", "maximum", "DayDream", 50));
        System.out.println(library.getList());
        // System.out.println(library.findBook("006"));
        System.out.println(library.removeBook("001"));
        System.out.println(library.getList());
    }

    public void addBook(Book book) {
        listBook.add(book);
    }

    public String removeBook(String ISBN) {
        for (Book book : listBook) {
            if (ISBN.equalsIgnoreCase(book.getISBN())) {
                listBook.remove(book);
                return "Book has been removed";
            }
        }
        return "There is no book by ISBN " + ISBN;
    }

    public String findBook(String ISBN) {
        for (Book book : listBook) {
            if (ISBN.equalsIgnoreCase(book.getISBN())) {
                return String.format("ISBN: %s\nTitle: %s\nAuthor: %s\nPublisher: %s\nNumber of copies: %s",
                        book.getISBN(), book.getTitle(), book.getAuthor(), book.getPublisher(),
                        book.getNumberOfCopies());
            }
        }
        return "There is no book by ISBN " + ISBN;
    }

    public Book getBook(String ISBN) {
        for (Book book : listBook) {
            if (ISBN.equalsIgnoreCase(book.getISBN())) {
                return book;
            }
        }
        return null;
    }

    public String getList() {
        StringBuilder sb = new StringBuilder();
        for (Book book : listBook) {
            sb.append(book.getTitle()).append("\n");
        }
        return sb.toString();
    }

}