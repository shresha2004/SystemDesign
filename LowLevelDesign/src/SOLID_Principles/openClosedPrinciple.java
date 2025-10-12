package SOLID_Principles;
// ----------------------------
//  BAD DESIGN - Violates OCP
// -------
class payMentMethod{
    private String method;
    payMentMethod(String method){
        this.method=method;//Cash, UPI, Credit Card
    }
    public void findMethod(double amount){
        if(method.equals("Cash"))
            System.out.println("Paid "+amount+" using Cash.");
        else if(method.equals("UPI"))
            System.out.println("Paid "+amount+" using UPI");
        else if(method.equals("Credit Card"))
            System.out.println("Paid "+amount+" using Credit Card");
        else new IllegalArgumentException("Unsupported Payment Method:"+method);
    }
        
}

// ----------------------------
// GOOD DESIGN - Follows OCP
// ----------------------------

// Step 1: Abstraction (closed for modification, open for extension)
interface paymenthProccessor{
    abstract void pay(double amount);
}

class CashPayment implements paymenthProccessor{
    public void pay(double amount){
        System.out.println("Paid "+amount+" using Cash");
    }
}

class UPIPayment implements paymenthProccessor{
    public void pay(double amount){
        System.out.println("Paid "+amount+" using UPI");
    }
}
class CreditCard implements paymenthProccessor{
    public void pay(double amount){
        System.out.println("Paid "+amount+" using Credit Card");
    }
}
public class openClosedPrinciple {
 public static void main(String[] args) {
    //Bad
    System.out.println("Bad code.Not aligning with OCP.");
    payMentMethod meth1 = new payMentMethod("UPI");
    meth1.findMethod(1000);

    payMentMethod meth2 = new payMentMethod("PayPal");
    meth2.findMethod(9000);


    //Good
    System.out.println("\n\nGood code.Aligning with OCP.");
    CashPayment c = new CashPayment();
    c.pay(500);

    UPIPayment upi = new UPIPayment();
    upi.pay(600);

    CreditCard cc = new CreditCard();
    cc.pay(80);
 }   
}
