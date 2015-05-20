package com.lumar.playground.pattern.observer;

/**
 * This is the thing being "observed" 
 * @author Martin
 *
 */
public interface Subject {
 
    //methods to register and unregister observers
    public void register(Observer obj);
    
    public void unregister(Observer obj);
     
    //method to notify observers of change
    public void notifyObservers();
     
    //method to get updates from subject
    public Object getUpdate(Observer obj);
    
    //post message to the subject
    public void postMessage(String msg);
}

