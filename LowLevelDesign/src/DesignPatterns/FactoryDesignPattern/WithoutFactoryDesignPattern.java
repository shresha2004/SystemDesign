package DesignPatterns.FactoryDesignPattern;
interface Payment{
    public void pay(int amount);
}
class CashPayment implements Payment{
    public void pay(int amount){
        System.out.println("Amount "+amount+" paid using cash.");
    }
}

class DebitCardPayment implements Payment{
    public void pay(int amount){
        System.out.println("Amount "+amount+" paid using debit card.");
    }
}

class UPIPayment implements Payment{
    public void pay(int amount){
        System.out.println("Amount "+amount+" paid using UPI.");
    }
}
public class WithoutFactoryDesignPattern {
    public static void main(String[] args) {
        //User input
        String paymentType = "UPI";
        int amount = 500;


        Payment paymentMethod;
        if(paymentType.equals("Debit"))
           paymentMethod=new DebitCardPayment();
        else if(paymentType.equals("Cash"))
            paymentMethod = new CashPayment();
        else if(paymentType.equals("UPI"))
           paymentMethod=new UPIPayment();
        else throw new IllegalArgumentException("Invalid payment");

        
       paymentMethod.pay(amount);
        // 🔴 Problems with This Approach
        // Problem	Description
        // ❌ Violation of Open/Closed Principle	Every time we add a new payment type,
        // we must modify the if-else block in the client.
        // ❌ Tight Coupling	The client depends on all concrete classes (CreditCardPayment,
        // UPIPayment, PayPalPayment).
        // ❌ Code Duplication Risk	If multiple parts of the system create payments, 
        //each will have its own if-else logic.
        // ❌ Hard to maintain & extend	Adding a new class means touching many files — error-prone.
    }
}
