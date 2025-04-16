package controller;

import dao.BookDao;
import entity.Book;

import java.util.List;

public class BookController {
    private final BookDao dao=new BookDao();
    public boolean borrowBook(int patronId, int bookId) {
        return dao.borrowBook(patronId,bookId);
    }

    public boolean returnBook(int returnPatronId, int returnBookId) {
        return dao.returnBook(returnPatronId,returnBookId);
    }

    public List<Book> getAllBooks() {
        return dao.getAllBook();
    }

    public List<Book> getBooksByPatron(int id) {
        return dao.getBooksByPatron(id);
    }

    public boolean addBook(String title, String author) {
        Book book=new Book(title,author);
        return dao.addBook(book);
    }

    public List<Book> searchBooks(String searchTerm) {
        return dao.searchBooks(searchTerm);
    }
}
