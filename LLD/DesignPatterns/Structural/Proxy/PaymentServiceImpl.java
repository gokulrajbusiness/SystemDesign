package LLD.DesignPatterns.Structural.Proxy;

public class PaymentServiceImpl implements PaymentService{
    @Override
    public void processPayment() {
        System.out.println("Payment Successful");
    }
}
