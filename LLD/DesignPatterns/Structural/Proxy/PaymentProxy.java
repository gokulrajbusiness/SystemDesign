package LLD.DesignPatterns.Structural.Proxy;

public class PaymentProxy implements PaymentService{

    PaymentServiceImpl psi;

    PaymentProxy(){

    }



    @Override
    public void processPayment() {
        if(isAuthorised()){
            psi = new PaymentServiceImpl();
            psi.processPayment();
        }
        else{
            System.out.println("Not Authorised");
        }
    }

    private boolean isAuthorised() {
        return true;
    }
}
