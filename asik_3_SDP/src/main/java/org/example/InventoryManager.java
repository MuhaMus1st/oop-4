package org.example;

public class InventoryManager {
    private java.util.Map<String, Integer> stock;

    public InventoryManager() {
        stock = new java.util.HashMap<>();
        stock.put("Laptop", 10);
        stock.put("Phone", 20);
        stock.put("Headphones", 15);
    }

    public boolean checkStock(String productName) {
        if (stock.containsKey(productName) && stock.get(productName) > 0) {
            System.out.println("Product '" + productName + "' is in stock.");
            return true;
        } else {
            System.out.println("Product '" + productName + "' is out of stock.");
            return false;
        }
    }

    public boolean updateStock(String productName) {
        if (stock.containsKey(productName) && stock.get(productName) > 0) {
            stock.put(productName, stock.get(productName) - 1);
            System.out.println("Stock updated. Remaining '" + productName + "' units: " + stock.get(productName));
            return true;
        } else {
            return false;
        }
    }
}
