package mobi.mpk.chessandroid.observer.model;


import java.util.LinkedList;
import java.util.List;

import mobi.mpk.chessandroid.observer.Observable;
import mobi.mpk.chessandroid.observer.Observer;
import mobi.mpk.chessandroid.type.ResultType;

public class GameData implements Observable {

    private List<Observer> observers;

    public GameData(){
        observers = new LinkedList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update();
    }

    public void setResultGame(ResultType resultType){
        notifyObservers();
    }

}
