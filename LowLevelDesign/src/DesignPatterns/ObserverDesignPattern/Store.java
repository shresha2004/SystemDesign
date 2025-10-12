package DesignPatterns.ObserverDesignPattern;
import DesignPatterns.ObserverDesignPattern.Observable.IphoneObservableImpl;
import DesignPatterns.ObserverDesignPattern.Observable.StockObservable;
import DesignPatterns.ObserverDesignPattern.Observer.EmailAlertObserverImpl;
import DesignPatterns.ObserverDesignPattern.Observer.MobileAlertObserverImpl;
import DesignPatterns.ObserverDesignPattern.Observer.NotificationAlertObserver;

public class Store {

    public static void main(String args[]){
        StockObservable iphoneStockObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz1@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz2@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("xyz_username",iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);
    }
}
