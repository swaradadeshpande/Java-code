class BookException extends Exception {  // class for exception handling
 public BookException(String message) { super(message); }
}
class Book {  // book class
 String title;
 boolean isCheckedOut;
 Book(String title) {
     this.title = title;
     this.isCheckedOut = false;
 }
}
class Library {  //library class
 private Book[] books;
 private int bookCount;
 public Library(int capacity) {
     books = new Book[capacity];
     bookCount = 0;
 }
 // method to add book
 public void addBook(String title) {
     if (bookCount < books.length) {
         books[bookCount++] = new Book(title);
     }
 }
 // method to find book
 private Book findBook(String title) throws BookException {
     for (int i = 0; i < bookCount; i++) {
         if (books[i].title.equalsIgnoreCase(title)) {
             return books[i];
         }
     }
     throw new BookException("Error: Book '" + title + "' not found in the library.");
 }

 //method to checkout
 public void checkOutBook(String title) throws BookException {
     Book b = findBook(title);
     if (b.isCheckedOut) {
         throw new BookException("Error: The book is already checked out!");
     }
     b.isCheckedOut = true;
     System.out.println("Book checked out successfully: " + b.title);
 }
 // method to return
 public void returnBook(String title, int daysLate) throws BookException {
     if (daysLate < 0) {
         throw new BookException("Error: Invalid return date! Days late cannot be negative.");
     }
     Book b = findBook(title);
     b.isCheckedOut = false;
     System.out.println("Book returned successfully: " + b.title);
     if (daysLate > 0) {
         System.out.println("Late Fee: ₹" + (daysLate * 10));
     }
 }
}

public class Exception_handling {
 public static void main(String[] args) {
     Library myLibrary = new Library(10);
     myLibrary.addBook("Java Programming");

     try { myLibrary.checkOutBook("Java Programming"); 
} 
     catch (BookException e) { System.out.println(e.getMessage()); 
}

     try { myLibrary.checkOutBook("Java Programming"); 
} 
     catch (BookException e) { System.out.println(e.getMessage()); 
}
     System.out.println(); 

     try { myLibrary.returnBook("Java Programming", 2); 
} 
     catch (BookException e) { System.out.println(e.getMessage()); 
}

     try { myLibrary.returnBook("Java Programming", -1); 
} 
     catch (BookException e) { System.out.println(e.getMessage());
 }

     try { myLibrary.returnBook("Unknown Book", 0); 
} 
     catch (BookException e) { System.out.println(e.getMessage());
 }
 }
}
