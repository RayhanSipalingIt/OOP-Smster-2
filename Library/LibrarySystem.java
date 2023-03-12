import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class LibrarySystem {
    private LinkedList<Borrow> listBorrow = new LinkedList<>();

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Library library = new Library();
        library.addBook(new Book("001", "pyro", "max", "erlangga", 10));
        library.addBook(new Book("002", "cryo", "maxi", "dunia Ilmu", 5));
        library.addBook(new Book("003", "dendro", "maxim", "gatot", 11));
        library.addBook(new Book("004", "electro", "maximu", "kesurupan", 1));
        library.addBook(new Book("005", "hydro", "maximum", "DayDream", 50));
        Scanner scan = new Scanner(System.in);
        System.out.print("ID: ");
        String id = scan.nextLine();
        System.out.print("Nama murid: ");
        String name = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("ISBN: ");
        String ISBN = scan.nextLine();
        while (library.getBook(ISBN) == null) {
            System.out.println("Kode ISBN tidak ditemukan, coba lagi");
            System.out.print("ISBN: ");
            ISBN = scan.nextLine();
        }
        Book book = library.getBook(ISBN);

        System.out.print("Lama meminjam: ");
        int lama = scan.nextInt();
        librarySystem.addBorrow(new Student(id, name, email), book, lama);
        librarySystem.addBorrow(new Student("01231", "budiman", "herobudi"), book, 5);
        System.out.println(librarySystem.findTransaction(id));
        // librarySystem.removeBorrow(name);
        System.out.println(librarySystem.getList());

    }

    public void addBorrow(Student student, Book book, int borrowDays) {
        Borrow borrow = new Borrow(student, book, borrowDays);
        listBorrow.add(borrow);
    }

    public String removeBorrow(String name) {
        for (Borrow borrow : listBorrow) {
            if (borrow.getStudent().getName() == name) {
                listBorrow.remove(borrow);
                return "Borrow transaction has been removed";
            }
        }
        return "There is no student by name " + name;
    }

    public String findTransaction(String ID) {
        for (Borrow borrow : listBorrow) {
            if (borrow.getStudent().getID() == ID) {
                return String.format("Nama: %s\nBuku: %s\nTanggal peminjaman: %s\nTenggat pengembalian: %s",
                        borrow.getStudent().getName(), borrow.getBook().getTitle(), borrow.getDateBorrow(),
                        borrow.getDateReturn());
            }
        }
        return "There is no student by ID " + ID;
    }

    public String getList() {
        StringBuilder sb = new StringBuilder();
        for (Borrow borrow : listBorrow) {
            sb.append(borrow.getBook().getTitle()).append(" borrowed by ").append(borrow.getStudent().getName()).append("\n");
        }
        return sb.toString();
    }

}

class Borrow {
    private Student student;
    private Book book;
    private Date dateBorrow;
    private Date dateReturn;

    public Borrow(Student student, Book infoBook, int dateReturn) {
        this.student = student;
        this.book = infoBook;
        this.dateBorrow = new Date();
        this.dateReturn = new Date(dateBorrow.getTime() + (1000 * 60 * 60 * 24) * dateReturn);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

}
