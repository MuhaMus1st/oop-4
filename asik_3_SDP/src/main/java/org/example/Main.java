package org.example;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ShopFacade shopFacade = new ShopFacade();
        System.out.println("Place order for Laptop:");
        shopFacade.placeOrder("Laptop");
        System.out.println();

        System.out.println("Place order for Phone:");
        shopFacade.placeOrder("Phone");
        System.out.println();

        System.out.println("Place order for Tablet:");
        shopFacade.placeOrder("Tablet");
    }
}
