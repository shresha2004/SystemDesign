package DesignPatterns.StrategyDesignPattern;
interface vehicle{
    public void drive();
}
class normalVehicle implements vehicle{
    public void drive(){
        System.out.println("Normal driving feature.");
    }
}
class sportsVehicle implements vehicle{
    public void drive(){
        System.out.println("Special driving feature.");
    }
}
class offRoadVehicle implements vehicle{
    public void drive(){
        System.out.println("Special driving feature.");//Method is duplicated or have same behavior
    }
}
public class withOutStrategyDesignPattern{
    public static void main(String[] args) {
        normalVehicle nV = new normalVehicle();
        nV.drive();
        sportsVehicle sV = new sportsVehicle();
        sV.drive();
        offRoadVehicle oV = new offRoadVehicle();
        oV.drive();

    }
}