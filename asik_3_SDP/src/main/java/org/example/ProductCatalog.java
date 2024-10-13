package org.example;

public class ProductCatalog {
    public ProductCatalog() {
    }

    public Integer searchProduct(String productName) {
        switch (productName) {
            case "Laptop":
                System.out.println("'Laptop' found with price $1000.");
                return 1000;
            case "Phone":
                System.out.println("'Phone' found with price $500.");
                return 500;
            case "Headphones":
                System.out.println("'Headphones' found with price $100.");
                return 100;
            default:
                System.out.println("'" + productName + "' not found.");
                return null;
        }
    }
}
