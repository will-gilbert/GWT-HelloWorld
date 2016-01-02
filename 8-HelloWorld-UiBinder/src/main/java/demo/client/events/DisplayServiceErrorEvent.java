package demo.client.events;

import com.google.web.bindery.event.shared.binder.GenericEvent;

public class DisplayServiceErrorEvent extends GenericEvent {

    public String errorMessage;

    public DisplayServiceErrorEvent(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
