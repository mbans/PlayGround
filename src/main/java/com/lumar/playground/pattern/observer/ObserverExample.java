package com.lumar.playground.pattern.observer;


/**
 * Subject/MyTopic - This is the object that will hold state, it is the thing being observed
 *  				 It can be updated and then will "notify" the observers
 *  				 Will hold a collection of Observers who need to be notified when it changes
 *  				 * register(Observer o)
 *  				 * unregister(Observer o) 
 *   				 * notifyObservers() 
 *   				 * update 	
 *    
 * Subsriber/Observer - These subsriber/obseve the subject. 
 * 						When Subject calls "updateObservers" each of the observers are notified
 * 					* update
 * 					* setSubject
 * 
 * Application:
 * 	JBPM - HumanTaskService - resume a WF (Subsriber/Observer) to the WorkflowTask(Subject) 
 *  EventListening 
 *  JMS, we have a "topic" and "subsriber" pattern
 *  
 * @author Martin
 *
 */
public class ObserverExample {
	 
    public static void main(String[] args) {
        //create subject
        MyTopic topic = new MyTopic();
         
        //create observers
        Observer obj1 = new MyTopicSubscriber("Subsriber1");
        Observer obj2 = new MyTopicSubscriber("Subsriber2");
        Observer obj3 = new MyTopicSubscriber("Subsriber3");
         
        //register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);
         
        //reverse, attach observer to subject
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);
         
        //now send message to subject, we really should create a "publisher" interface
        //rather than letting subsribers to publish
        obj1.postMessage("New Message");
    }
 
}
