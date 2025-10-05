// ----------------------------
//  BAD DESIGN - Violates LSP
// ----------------------------
class badRectangle{
    float height;
    float width;
    public void setHeight(float height){
        this.height =height;
    }
    public void setWidth(float width){
        this.width=width;
    }
    public void calArea(){
        System.out.println("Area:"+height*width);
    }
}

class badSquare extends badRectangle{
    public void setHeight(float height){
        this.height =height;
        this.width = height;
    }
    public void setWidth(float width){
        this.height=height;
        this.width=width;
    }
    
}


// ----------------------------
// GOOD DESIGN - Follows LSP
// ----------------------------
interface Shape{
    public void getArea();
}

class goodRectangle implements Shape{
    float height;
    float width;
    public goodRectangle(float height,float width){
        this.height =height;
        this.width=width;
    }
    public void getArea(){
        System.out.println("Area:"+(height*width));
    }
}

class goodSquare implements Shape{
    float length;
    public goodSquare(float length){
        this.length=length;
    }
    public void getArea(){
        System.out.println("Area:"+(length*length));
    }
}
class PrintArea{
    public PrintArea(Shape s){
      s.getArea();
    }
}
public class liskovSubstitutionPrinciple {
    public static void main(String[] args) {
         System.out.println("---- BAD DESIGN ----");
         badRectangle bR = new badRectangle();
         bR.setHeight(40);
         bR.setWidth(90);
         bR.calArea();

         badSquare bS = new badSquare();
         bS.setHeight(50);
         bS.setWidth(50);
         bS.calArea();

         System.out.println("\n---- GOOD DESIGN ----");
         goodRectangle gR = new goodRectangle(40, 40);
         goodSquare gS = new goodSquare(50);
         gR.getArea();
         gS.getArea();

         Shape sR = new goodRectangle(5, 10);
         Shape sS = new goodSquare(8);
         PrintArea pr = new PrintArea(sR);
         PrintArea ps = new PrintArea(sS);
    }
}
