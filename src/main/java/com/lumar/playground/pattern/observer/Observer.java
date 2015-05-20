package com.lumar.playground.pattern.observer;

/**
 * The Observers will be "observing" the subject
 * @author Martin
 *
 */
public interface Observer {
     
    //method to update the observer, these updates are passed through by the subjsect
    public void update();
     
    //attach with subject to observe
    public void setSubject(Subject sub);
    
    //Post a message to the subject
    public void postMessage(String message);
}
