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

class PaymentFactory{
    public static Payment getPaymentMethod(String paymentMethod){
        if(paymentMethod == null || paymentMethod.isEmpty())
            throw new IllegalArgumentException("Payment method cannot be empty");

        switch (paymentMethod) {
            case "UPI": return new UPIPayment();
            case "Debit Card": return new DebitCardPayment();
            case "Cash": return new CashPayment();
            default: throw new IllegalArgumentException();
                
        }
    }
}
/*
Benefits After Using Factory Pattern

• Removes code duplication — one centralized factory handles object creation.  
• Reduces tight coupling — client depends only on interface, not concrete classes.  
• Improves scalability — new types can be added by updating only the factory.  
• Enhances maintainability — single point of modification for creation logic.  
• Increases readability — eliminates large if-else or switch blocks in client code.  
• Follows Open/Closed Principle — code is open for extension but closed for modification.
*/

public class WithFactoryDesignPattern {
    public static void main(String[] args) {
        //User input
            String paymentType = "Debit Card";
            int amount = 600;
        Payment paymentMethod = PaymentFactory.getPaymentMethod(paymentType);
        paymentMethod.pay(amount);
    }
}
