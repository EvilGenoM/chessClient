package mobi.mpk.chessandroid.observer;


import mobi.mpk.chessandroid.type.ResultType;

public interface Observable {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(ResultType resultType);

}
