package com.lumar.playground.pattern.observer;

public class MyTopicSubscriber implements Observer {
    
    private String name;
    
    /* The Subject/Observable */
    private Subject topic;
     
    public MyTopicSubscriber(String nm){
        this.name=nm;
    }
    
    /**
     * The Subject will call this method to update all Observers
     */
    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
        System.out.println(name+":: Consuming message::"+msg);
    }
 
    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
    }
    
    /**
     * Post to the topic
     */
    @Override
    public void postMessage(String message) {
    	System.out.println(this + " posting message....");
    	this.topic.postMessage(message);
    }
    
    @Override
    public String toString() {
    	return name;
    }
}