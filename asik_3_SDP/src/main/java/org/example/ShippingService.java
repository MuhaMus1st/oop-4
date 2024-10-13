package org.example;

public class ShippingService {
    public int calculateShipping(String productName) {
        int shippingCost = productName.equals("Laptop") ? 20 : 10;
        System.out.println("Shipping cost for '" + productName + "' is $" + shippingCost);
        return shippingCost;
    }

    public boolean shipOrder(String productName) {
        System.out.println("Shipping '" + productName + "' order.");
        return true;
    }
}

