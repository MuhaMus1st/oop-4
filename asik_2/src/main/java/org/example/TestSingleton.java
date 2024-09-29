package org.example;

public class TestSingleton {

    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getInstan();
        connection1.con();

        DatabaseConnection connection2 = DatabaseConnection.getInstan();
        connection2.con();

        if (connection1 == connection2) {
            System.out.println("Both instances are the same.");
        }

        connection1.discon();
    }
}