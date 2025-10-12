package DesignPatterns.ObserverDesignPattern.Observer;
import DesignPatterns.ObserverDesignPattern.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    String emailId;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailId,StockObservable observable){
        this.observable =observable;
        this.emailId = emailId;
    }
    public void update(){
        sendMail(emailId,"Product is in stock hurry up!");
    }
    private void sendMail(String emailId,String msg){
        System.out.println("Email sent to:"+emailId);
    }
}