package DesignPatterns.FactoryDesignPattern;
interface Engine{
    public void design();
}
interface Tyre{
    public void manufacture();
}

class LuxuryCarEngine implements Engine{
    public void design(){
        System.out.println("Design Luxury Car Engine");
    }

}

class LuxuryCarTyre implements Tyre{
    public void manufacture(){
        System.out.println("Manufacture Luxury Car Tyre");
    }
}

class OrdinaryCarEngine implements Engine{
    public void design(){
        System.out.println("Design Ordinary Car Engine");
    }
}

class OrdinaryCarTyre implements Tyre{
    public void manufacture(){
        System.out.println("Manufacture Ordinary Car Tyre");
    }
}

interface carFactory{
   public Engine createEngine();
   public Tyre  manufactureTyre();
}

class LuxuryCarFactory implements carFactory{
    @Override
    public Engine createEngine() {
        
        return new LuxuryCarEngine();
    }
    public Tyre manufactureTyre(){
        return new LuxuryCarTyre();
    }
}

class OrdinaryCarFactory implements carFactory{
    public Engine createEngine(){
        return new OrdinaryCarEngine();
    }
    public Tyre  manufactureTyre(){
        return new OrdinaryCarTyre();
    }
}
public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {
        carFactory luxCar = new LuxuryCarFactory();
     Engine luxEngine=   luxCar.createEngine();
      Tyre luxTyre =  luxCar.manufactureTyre();
      luxEngine.design();
      luxTyre.manufacture();

        carFactory ordCar = new OrdinaryCarFactory();
    Engine ordEngine =    ordCar.createEngine();
      Tyre ordTyre =  ordCar.manufactureTyre();
      ordEngine.design();
      ordTyre.manufacture();
    }
}
