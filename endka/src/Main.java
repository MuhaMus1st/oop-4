import java.util.ArrayList;
import java.util.List;

// SOLID: Observer Pattern: Observer interface adheres to the Single Responsibility Principle (SRP)
interface PaymentObserver {
    void update(int amount); // SRP: Defines a single responsibility - to update based on payment events
}

// SOLID: Observer Pattern: Observer implementation adheres to SRP
class PaymentObserverImpl implements PaymentObserver {
    @Override
    public void update(int amount) {
        System.out.println("Payment of " + amount + " processed successfully!");
    }
}

// SOLID: Encapsulation: PaymentMethod interface encapsulates payment behavior, adheres to SRP
interface PaymentMethod {
    void makePayment(int amount); // SRP: Defines a single responsibility - to make a payment
}

// SOLID: Encapsulation: CardPayment class encapsulates payment method using card, adheres to SRP
class CardPayment implements PaymentMethod {
    @Override
    public void makePayment(int amount) {
        System.out.println(amount + " paid with card");
    }
}

// SOLID: Encapsulation: PayPal class encapsulates payment method using PayPal, adheres to SRP
class PayPal implements PaymentMethod {
    @Override
    public void makePayment(int amount) {
        System.out.println(amount + " paid using PayPal");
    }
}

// SOLID: Encapsulation: Cart class encapsulates shopping cart functionality, adheres to SRP and OCP
class Cart {
    private PaymentMethod paymentMethod; // Encapsulation: PaymentMethod object encapsulated
    private List<PaymentObserver> observers = new ArrayList<>(); // Encapsulation: List encapsulated

    // SOLID: SRP: Method to add payment observer
    public void addPaymentObserver(PaymentObserver observer) {
        observers.add(observer);
    }

    // SOLID: SRP: Method to remove payment observer
    public void removePaymentObserver(PaymentObserver observer) {
        observers.remove(observer);
    }

    // SOLID: SRP: Method to notify observers
    private void notifyObservers(int amount) {
        for (PaymentObserver observer : observers) {
            observer.update(amount);
        }
    }

    // SOLID: OCP: Method to set payment method allows extension without modification
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // SOLID: Polymorphism: checkout method demonstrates polymorphism, adheres to OCP
    public void checkout(int amount) {
        paymentMethod.makePayment(amount); // Polymorphism: method call polymorphic based on the type of paymentMethod
        notifyObservers(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart(); // Encapsulation: Cart object encapsulates shopping cart functionality
        PaymentObserver observer = new PaymentObserverImpl(); // Encapsulation: PaymentObserverImpl object encapsulated
        cart.addPaymentObserver(observer);

        PaymentMethod cardPayment = new CardPayment(); // Encapsulation: CardPayment object encapsulated via PaymentMethod interface
        PaymentMethod payPalPayment = new PayPal(); // Encapsulation: PayPal object encapsulated via PaymentMethod interface

        cart.setPaymentMethod(cardPayment); // Polymorphism: cart.setPaymentMethod accepts any object implementing PaymentMethod interface
        cart.checkout(4000);

        cart.setPaymentMethod(payPalPayment); // Polymorphism: cart.setPaymentMethod accepts any object implementing PaymentMethod interface
        cart.checkout(1000);
    }
}
