package DesignPatterns.StrategyDesignPattern;
interface driveStrategy{
    public void drive();
}
class normalDrive implements driveStrategy{
    public void drive(){
        System.out.println("Normal driving feature.");
    }
}
class specialDrive implements driveStrategy{
    public void drive(){
        System.out.println("Special driving feature.");
    }
}

class vehicle {
   public driveStrategy dS;
    vehicle(driveStrategy dS){
        this.dS = dS;
    }
    public void drive(){
        dS.drive();
    }
}
class normalVehicle extends vehicle{
    normalVehicle(){
        super(new normalDrive());
    }
  
}

class specialVehicle extends vehicle{
    specialVehicle(){
        super(new specialDrive());
    }
}

class offroadVehicle extends vehicle{
    offroadVehicle(){
        super(new specialDrive());
    }
}
public class withStrategyDesignPattern {

    public static void main(String[] args) {
        normalVehicle nV = new normalVehicle();
        nV.drive();
        specialVehicle sV = new specialVehicle();
        sV.drive();
        offroadVehicle oV = new offroadVehicle();
        oV.drive();
    }
}
