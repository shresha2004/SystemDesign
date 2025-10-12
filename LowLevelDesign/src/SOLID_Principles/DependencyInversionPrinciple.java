package SOLID_Principles;
// ----------------------------
//  BAD DESIGN - Violates DIP
// ----------------------------
class badMySql{
    public void connect(){//Defining concrete class
        System.out.println("My SQl is connecting...");
    }
}
class badMongoDB{
    public void connect(){
        System.out.println("MongoDB is connecting...");
    }
}


// ----------------------------
// GOOD DESIGN - Follows DIP
// ----------------------------
interface Database{
    public void connect();
}

class  goodMySql implements Database{
    public void connect(){//Abstract class
        System.out.println("MySql is connecting....");
    }
}

class goodMongoDB implements Database{
    public void connect(){
        System.out.println("MongoDB is connecting....");
    }
}
public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        System.out.println("---- Bad Design ----");
        badMySql bM = new badMySql();
        bM.connect();
        badMongoDB bG = new badMongoDB();
        bG.connect();

        System.out.println("\n---- Good Design ----");
        goodMySql gM = new goodMySql();
        gM.connect();
        goodMongoDB gG = new goodMongoDB();
        gG.connect();

    }
}
