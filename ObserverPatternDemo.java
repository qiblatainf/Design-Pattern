package MediatorPattern;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

// Concrete subject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void setState(String state) {
        this.state = state;
        notifyObservers(); //notify after you set the state
    }

    public String getState() {
        return state;
    }

    //implement attach, detach, and notify methods
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Observer interface
interface Observer {
    void update();
}

// Concrete observer
class ConcreteObserver implements Observer {
    private String observerState;
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
    }

    public void update() {
        observerState = subject.getState();
        System.out.println("Observer state updated: " + observerState);
    }
}

// Driver Class
public class ObserverPatternDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject(); //create a subject/event manager
        
        ConcreteObserver observer1 = new ConcreteObserver(subject); //the observers can subscribe/unsubscribe
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        subject.attach(observer1);
        subject.attach(observer2);

        subject.setState("Attaching");

        subject.detach(observer1);

        subject.setState("Detatching");
    }
}

