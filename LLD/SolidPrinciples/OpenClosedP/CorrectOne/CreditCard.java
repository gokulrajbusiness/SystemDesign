package LLD.SolidPrinciples.OpenClosedP.CorrectOne;

public class CreditCard implements PaymentStrategy {


    @Override
    public void process(int rupees) {
        System.out.print("Used CreditCard");
    }
}
