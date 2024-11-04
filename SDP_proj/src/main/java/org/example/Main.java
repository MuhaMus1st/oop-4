package org.example;

public class Main {
    public static void main(String[] args) {
        LibraFaca libraryFacade = new LibraFaca();

        libraryFacade.registerUser("Alice");
        libraryFacade.registerUser("Bob");

        Library library = Library.getInstance();
        library.addBook(new Book("Java Programming", "Author A"));
        library.addBook(new Book("Design Patterns", "Author B"));

        libraryFacade.borrowBook("Java Programming", "Alice");
        libraryFacade.returnBook("Java Programming", "Alice");

        libraryFacade.setLoanPolicy(new ExteLoPoli());
        libraryFacade.borrowBook("Design Patterns", "Alice");
    }
}
