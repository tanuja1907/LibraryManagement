A Simple Java-based project named Library Management System that allows you to manage books,patrons ,borrow and returning book using jdbc and mysql

# Features:
** Add new Book to library
** Add new patron
** Patron can borrow book
** Return borrowed book
** View Books borrowed by any particular patron  with id
** Search any book with either title or author name
** JDBC integration with mysql
** Cleaned architecture( ``controller`,`dao`,`entity`,`connection``)

$ Project Structure:
# Entity
      |-Book(fields like id, title,author,isAvailable)
      |-Patron(id,name)
# Dao-(handles all the business logic)
      |-BookDao-(add book,borrow book,return book,all books, all books by particular patron)
      |-PatronDao-(add patron, get patron)
# Controller-(bridge between user and Dao layer)
      |-BookController
      |-PatronController
# Connection-(connects with database)
      |-DBConnection
# Driver class-main method

### Setup Instruction
Either clone the project or download zip.
