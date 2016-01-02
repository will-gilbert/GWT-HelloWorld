package demo.client.events;

import com.google.web.bindery.event.shared.binder.GenericEvent;

public class FetchHelloWorldEvent extends GenericEvent {
    
    public String name;

    public FetchHelloWorldEvent(String name) {
        this.name = name;
    }
}
