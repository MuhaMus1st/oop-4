import java.util.ArrayList;
import java.util.List;

// Observer Pattern: Observer interface
interface PaymentObserver {
    void update(int amount);
}

// Observer Pattern: Observer implementation
class PaymentObserverImpl implements PaymentObserver {
    @Override
    public void update(int amount) {
        System.out.println("Payment of " + amount + " processed successfully!");
    }
}

interface PaymentMethod {
    void makePayment(int amount);
}

class CardPayment implements PaymentMethod {
    @Override
    public void makePayment(int amount) {
        System.out.println(amount + " paid with card");
    }
}

class PayPal implements PaymentMethod {
    @Override
    public void makePayment(int amount) {
        System.out.println(amount + " paid using PayPal");
    }
}

class Cart {
    private PaymentMethod paymentMethod;
    private List<PaymentObserver> observers = new ArrayList<>();

    public void addPaymentObserver(PaymentObserver observer) {
        observers.add(observer);
    }

    public void removePaymentObserver(PaymentObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(int amount) {
        for (PaymentObserver observer : observers) {
            observer.update(amount);
        }
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout(int amount) {
        paymentMethod.makePayment(amount);
        notifyObservers(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        PaymentObserver observer = new PaymentObserverImpl();
        cart.addPaymentObserver(observer);

        PaymentMethod cardPayment = new CardPayment();
        PaymentMethod payPalPayment = new PayPal();

        cart.setPaymentMethod(cardPayment);
        cart.checkout(4000);

        cart.setPaymentMethod(payPalPayment);
        cart.checkout(1000);
    }
}
