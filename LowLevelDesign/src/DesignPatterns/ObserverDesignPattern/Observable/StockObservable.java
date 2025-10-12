package DesignPatterns.ObserverDesignPattern.Observable;
import DesignPatterns.ObserverDesignPattern.Observer.NotificationAlertObserver;


public interface StockObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setStockCount(int newStockAdd);
    public int getStockCount();
}
