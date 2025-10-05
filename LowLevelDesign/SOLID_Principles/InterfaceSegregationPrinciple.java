// ----------------------------
//  BAD DESIGN - Violates ISP
// ----------------------------
//Fat interface
interface task{
    public void work();
    public void eat();
}

class badRobot implements task{
    public void work(){
        System.out.println("Robot is working");
    }
    public void eat(){
         new UnsupportedOperationException("Robot cannot eat");//Have to handle separately
    }
}

class badHuman implements task{
    public void work(){
        System.out.println("Humans are working");
    }
    public void eat(){
        System.out.println("Humans are eating");
    }
}

// ----------------------------
// GOOD DESIGN - Follows ISP
// ----------------------------
interface workable{
    public void work();
}
interface eatable{
    public void eat();
}
class goodRobot implements workable{
    public void work(){
        System.out.println("Robot can work.");
    }
}
class goodHuman implements eatable,workable{
    public void work(){
        System.out.println("Human is working.");
    }
    public void eat(){
        System.out.println("Human is eating");
    }
}
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
         System.out.println("---- BAD DESIGN ----");
        badRobot bR = new badRobot();
        bR.work();
        bR.eat();
        badHuman bH = new badHuman();
        bH.work();
        bR.eat();

        System.out.println("\n---- Good Design ----");
        goodHuman gH = new goodHuman();
        gH.work();
        gH.eat();
        goodRobot gR = new goodRobot();
        gR.work();
        
    }
}
