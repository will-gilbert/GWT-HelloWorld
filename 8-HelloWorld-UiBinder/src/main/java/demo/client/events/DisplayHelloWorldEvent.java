package demo.client.events;

import com.google.web.bindery.event.shared.binder.GenericEvent;

public class DisplayHelloWorldEvent extends GenericEvent {

    public String response;

    public DisplayHelloWorldEvent(String response) {
        this.response = response;
    }
}
