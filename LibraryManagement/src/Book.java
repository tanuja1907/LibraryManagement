import java.time.LocalDateTime;

public class Book {

    private final String title;
    private final String author;
    private boolean isAvailable;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable=true;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable(){
        return isAvailable;
    }


    public LocalDateTime getReturnDate() {
        return returnDate;
    }


    public void borrow(){
        isAvailable=false;
        borrowDate=LocalDateTime.now();
        returnDate= borrowDate.plusDays(7);
    }
    public void returnBook(){
        isAvailable=true;
        borrowDate=null;
        returnDate=null;
    }
}
