package DesignPatterns.DecoratorDesignPattern;
interface BasePizza{
    public String getDescription();
   public int getCost();
}

class Margherita implements BasePizza{
   public String getDescription(){
        return "Margherita";
    }
   public int getCost(){
       return 700;
    }
}

class PlainPizza implements BasePizza{
    public String getDescription(){
        return "Plain Pizza";
    }
    public int getCost(){
        return 300;
    }
}

class Farmhouse implements BasePizza{
    public String getDescription(){
        return "Farmhouse";
    }
    public int getCost(){
        return 70;
    }
}
abstract class ToppingDecorator implements BasePizza{
    BasePizza pizza;
    ToppingDecorator(BasePizza pizza){
        this.pizza=pizza;
    }

}
class Cheese extends ToppingDecorator{
    Cheese(BasePizza pizza){
        super(pizza);

    }
    public String getDescription(){
        return pizza.getDescription()+" + Cheese";
    }
    public int getCost(){
        return pizza.getCost()+ 20;
    }
}

class Mushroom extends ToppingDecorator{
    public Mushroom(BasePizza pizza){
        super(pizza);
    }
    public String getDescription(){
        return pizza.getDescription()+" + Mushroom";
    }
    public int  getCost(){
        return pizza.getCost()+20;
    }
}

class Panneer extends ToppingDecorator{
    public Panneer(BasePizza pizza){
        super(pizza);
    }
    public String getDescription(){
        return pizza.getDescription()+" + Panneer";
    }
    public int getCost(){
        return pizza.getCost()+20;
    }
}
public class Pizza {
    public static void main(String[] args) {
    
        //Simple plain pizza
        BasePizza pizza = new PlainPizza();
        System.out.println("Order 1:"+pizza.getDescription()+" Price:"+pizza.getCost());

        //Adding extra cheese to plain pizza
        BasePizza cheezy = new Cheese(new PlainPizza());
        System.out.println("Order 2:"+cheezy.getDescription()+" Price:"+cheezy.getCost());

        //Farmhouse pizza with panner topping
        BasePizza farmPizza = new Panneer(new Farmhouse());
        System.out.println("Order 3:"+farmPizza.getDescription()+" Price:"+farmPizza.getCost());

        //Margherita pizza with Mushroom topping
        BasePizza marghePizza = new Mushroom(new Margherita());
        System.out.println("Order 4:"+marghePizza.getDescription()+" Price:"+marghePizza.getCost());


    }
}
