package LLD.SolidPrinciples.OpenClosedP;

//if new payment have to be added then i have to modify this class
// so that the class which is using it will be able to pay
public class OCPviolation {

        public void process(String type) {
            if (type.equals("CREDIT_CARD")) { System.out.println("Using Paypal"); }
            else if (type.equals("PAYPAL")) { System.out.println("Using Paypal"); }
                }

}
