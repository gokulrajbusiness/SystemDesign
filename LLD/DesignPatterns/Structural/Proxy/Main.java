package LLD.DesignPatterns.Structural.Proxy;

public class Main {

    public static void main(String[] args){

        PaymentProxy paymentProxy = new PaymentProxy();
        paymentProxy.processPayment();
    }

}
