package org.example;

import java.util.HashMap;
import java.util.Map;

public class LibraFaca {
    private Library library;
    private Map<String, User> users;
    private LoanPolicy loanPolicy;

    public LibraFaca() {
        library = Library.getInstance();
        users = new HashMap<>();
        loanPolicy = new StanLoPoli();
    }

    public void registerUser(String userName) {
        if (!users.containsKey(userName)) {
            users.put(userName, new User(userName));
            System.out.println("User " + userName + " registered successfully.");
        }
    }

    public boolean borrowBook(String title, String userName) {
        User user = users.get(userName);
        if (user == null) {
            System.out.println("User not found.");
            return false;
        }

        Book book = library.searchBook(title);
        if (book != null) {
            user.borrowBook(book);
            System.out.println(userName + " borrowed " + title + " for " + loanPolicy.getLoanDuration() + " days.");
            logTransaction(userName + " borrowed " + title);
            return true;
        } else {
            System.out.println("Book not available.");
            return false;
        }
    }

    public void returnBook(String title, String userName) {
        User user = users.get(userName);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        for (Book book : user.getBorrowedBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                user.returnBook(book);
                System.out.println(userName + " returned " + title);
                logTransaction(userName + " returned " + title);
                return;
            }
        }
        System.out.println("Book not found in user's borrowed list.");
    }

    private void logTransaction(String message) {
        System.out.println("Transaction Log: " + message);
    }

    public void setLoanPolicy(LoanPolicy loanPolicy) {
        this.loanPolicy = loanPolicy;
    }
}
