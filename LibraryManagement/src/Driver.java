import controller.BookController;
import controller.PatronController;
import entity.Book;

import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        BookController bookController=new BookController();
        PatronController patronController=new PatronController();

        try(Scanner sc=new Scanner(System.in)){
            int choice;
            do{
                System.out.println("\n-------Library Management System---------");
                System.out.println("""
                        1. Add Book
                        2. Add Patron
                        3. Borrow Book
                        4. Return Book
                        5. View All Books
                        6. View Books Borrowed by Patron
                        7. Search Book
                        8. Exit
                        Enter your choice:
                        """);
                choice=sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Enter entity.Book title:");
                        String title=sc.next();
                        sc.nextLine();
                        System.out.println("Enter Author Name");
                        String author=sc.nextLine();
                        boolean bookAdded=bookController.addBook(title,author);
                        System.out.println(bookAdded?"Book Added Successfully":"Failed to add book");
                        break;
                    case 2:
                        System.out.println("Enter Name");
                        String name=sc.next();
                        sc.nextLine();
                        boolean patronAdded=patronController.addPatron(name);
                        System.out.println(patronAdded?"Patron added successfully":"Failed to add Patron");
                        break;
                    case 3:
                        System.out.println("Enter Patron Id");
                        int patronId=sc.nextInt();
                        System.out.println("Enter Book Id to borrow:");
                        int bookId=sc.nextInt();
                        boolean borrowed=bookController.borrowBook(patronId,bookId);
                        System.out.println(borrowed?"Book borrowed Successfully":"Borrowing failed");
                        break;
                    case 4:
                        System.out.println("Enter Patron Id");
                        int returnPatronId=sc.nextInt();
                        System.out.println("Enter Book Id to be return:");
                        int returnBookId=sc.nextInt();
                        boolean returned=bookController.returnBook(returnPatronId,returnBookId);
                        System.out.println(returned?"Book returned successfully":"return failed");
                        break;
                    case 5:
                        System.out.println("-----Books List-----");
                        List<Book> allBooks=bookController.getAllBooks();
                        for(Book book:allBooks){
                            String borrowedBy= book.isAvailable()?"Available":"Borrowed by PatronId-"+book.getBorrowedBy();
                            System.out.println(book.getId()+". "+book.getTitle()+" by "+book.getAuthor()+" ["+borrowedBy+"] ");
                        }
                        break;
                    case 6:
                        System.out.println("Enter Patron ID:");
                        int id=sc.nextInt();
                        List<Book> books=bookController.getBooksByPatron(id);
                        if(books.isEmpty()){
                            System.out.println("No books borrowed buy this patron");
                        }else{
                            for(Book book:books){
                                System.out.println(book.getId()+". "+book.getTitle()+" by "+book.getAuthor());
                            }
                        }
                        break;
                    case 7:
                        System.out.print("Enter search term (title or author): ");
                        String searchTerm = sc.next();
                        sc.nextLine();
                        List<Book> foundBooks = bookController.searchBooks(searchTerm);

                        if (foundBooks.isEmpty()) {
                            System.out.println("No books found matching the search term.");
                        } else {
                            System.out.println("-----Search Results-----");
                            for (Book book : foundBooks) {
                                String borrowedBy = book.isAvailable() ? "Available" : "Borrowed by PatronId-" + book.getBorrowedBy();
                                System.out.println(book.getId() + ". " + book.getTitle() + " by " + book.getAuthor() + " [" + borrowedBy + "]");
                            }
                        }
                        break;
                    case 8:
                        System.out.println("Thank you for visiting,GoodBye!!!");
                        return;
                    default:
                        System.out.println("Invalid option‼️‼️‼️");
                }
            }while(choice!=9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
