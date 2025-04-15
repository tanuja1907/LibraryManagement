import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Library library=new Library();
        try(Scanner sc=new Scanner(System.in)){
            int choice;
            do{
                System.out.println("\n-------Library Management System---------");
                System.out.println("\n1.Add book \n2.Add Patron \n3.Return Book \n4.Borrow Book \n5.View All Book \n6.Exit \nEnter your choice please");
                choice=sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Enter Book title:");
                        String title=sc.next();
                        sc.nextLine();
                        System.out.println("Enter Author Name");
                        String author=sc.nextLine();
                        if(library.addBook(title,author)){
                            System.out.println("Book added successfully!!!");
                        }else{
                            System.out.println("‼️‼️‼️Failed to add book");
                        }
                        break;
                    case 2:
                        System.out.println("Enter Name");
                        String name=sc.next();
                        sc.nextLine();
                        if(library.addPatron(name)){
                            System.out.println("Patron added Successfully!!!");
                        }else{
                            System.out.println("‼️‼️‼️Failed to add patron.Limit reached");
                        }
                        break;
                    case 3:
                        int patronId=getValidId("patron id",library.getPatronCount());
                        int bookId=getValidId("book id",library.getBookCount());
                        if(library.returnBook(patronId,bookId)){
                            System.out.println("Book returned successfully!!!");
                        }else{
                            System.out.println("Return failed");
                        }
                        break;
                    case 4:
                        int patron_id=getValidId("patron id",library.getPatronCount());
                        int  book_id=getValidId("book id", library.getBookCount());
                        if(library.borrowBook(patron_id,book_id)){
                            System.out.println("Borrowing success!!!");
                        }
                        else {
                            System.out.println("Borrowing unsuccessfull‼️");
                        }
                        break;
                    case 5:
                        System.out.println("-----Books List-----");
                        Book[] books=library.getBooks();
                        for(int i=0;i<library.getBookCount();i++){
                            Book book=books[i];
                            System.out.println("Book "+book.getTitle() +" by "+ book.getAuthor() +" ["+(book.isAvailable()?"Available":"Borrowed") +"]");
                        }
                        break;
                    case 6:
                        System.out.println("Thank you for visiting,GoodBye!!!");
                        return;
                    default:
                        System.out.println("Invalid option‼️‼️‼️");
                }
            }while(choice!=7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    static int getValidId(String label,int max){

        System.out.println("Enter "+label+" (0 to "+(max-1)+"): ");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        if(id<0||id>=max){
            System.out.println("Invalid‼️");
            return -1;
        }
        return id;
    }
}
