package org.example;

public class ShopFacade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    public ShopFacade() {
        productCatalog = new ProductCatalog();
        paymentProcessor = new PaymentProcessor();
        inventoryManager = new InventoryManager();
        shippingService = new ShippingService();
    }

    public void placeOrder(String productName) {
        Integer productPrice = productCatalog.searchProduct(productName);
        if (productPrice == null) {
            System.out.println("Order failed: Product '" + productName + "' is not available.");
            return;
        }

        if (!inventoryManager.checkStock(productName)) {
            System.out.println("Order failed: Product '" + productName + "' is out of stock.");
            return;
        }

        int shippingCost = shippingService.calculateShipping(productName);
        int totalAmount = productPrice + shippingCost;

        if (!paymentProcessor.processPayment(totalAmount)) {
            System.out.println("Order failed: Payment processing failed.");
            return;
        }

        if (!inventoryManager.updateStock(productName)) {
            System.out.println("Order failed: Could not update inventory.");
            return;
        }

        if (!shippingService.shipOrder(productName)) {
            System.out.println("Order failed: Shipping failed.");
            return;
        }

        System.out.println("Order successful: '" + productName + "' has been ordered and will be shipped soon.");
    }
}

