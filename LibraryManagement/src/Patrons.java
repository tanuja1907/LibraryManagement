public class Patrons {
    private final String name;
    private final boolean[] borrowedBooks;

    public Patrons(String name, int maxBooks) {
        this.name = name;
        borrowedBooks = new boolean[maxBooks];
    }

    public String getName() {
        return name;
    }
    public void borrowBook(int bookId){
        borrowedBooks[bookId]=true;

    }
    public void returnBook(int bookId){
        borrowedBooks[bookId]=false;
    }

    public boolean hasBorrowed(int bookId){
        return borrowedBooks[bookId];
    }
}
