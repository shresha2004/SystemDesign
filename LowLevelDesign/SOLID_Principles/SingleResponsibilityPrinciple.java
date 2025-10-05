//Bad code which is not aliging with SRP 
class StockManager{
    void fetchStockData(String symbol){
        System.out.println(symbol+"is fetched.");
    }
    double calculateAvg(double[] dayPrices){
        double sum =0;
        for(double price : dayPrices){
            sum += price;
        }
        return sum/dayPrices.length;
    }
    void stockRepo(String symbol){
        System.out.println(symbol+" is stored in repository");
    }
}
//  Problem:
// This class violates SRP because it handles data fetching, calculations,  and storing all in one place.
// If requirements for DB change → you modify this class.
// If report format changes → you modify this class.
// High chance of bugs and hard to maintain.


//Good code which aligns with SRP
class stockFetcher{
    void fetchStockData(String symbol){
        System.out.println(symbol+" is fetched");
    }
}

class stockCalculator{
    double calculateAvg(double[] dayPrices){
         double sum =0;
        for(double price : dayPrices){
            sum += price;
        }
        return sum/dayPrices.length;
    }
}

class stockRepository{
    void storeStockData(String symbol){
        System.out.println(symbol+" is stored in database");
    }
}
// Benefits of SRP Code
// Each class has one responsibility.
// Easier to test (unit test StockCalculator separately).
// Easier to extend (change DB logic without touching calculations).
// Improves readability and maintainability.


public class SingleResponsibilityPrinciple {

    public static void main(String[] args) {
        StockManager bad = new StockManager();
        bad.fetchStockData("Reliance");
        bad.calculateAvg(new double[] {700.7,600.5,500.6});
        bad.stockRepo("HAL");


        stockFetcher sf = new stockFetcher();
        sf.fetchStockData("Reliance");
        
        stockCalculator sc = new stockCalculator();
        sc.calculateAvg(new double[] {700.7,600.5,500.6});

        stockRepository sr = new stockRepository();
        sr.storeStockData("Infosys");
    }
}