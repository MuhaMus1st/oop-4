package org.example;

public class DatabaseConnection {

    private static volatile DatabaseConnection instance;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstan() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void con() {
        System.out.println("Connected to the database.");
    }

    public void discon() {
        System.out.println("Disconnected from the database.");
    }
}
