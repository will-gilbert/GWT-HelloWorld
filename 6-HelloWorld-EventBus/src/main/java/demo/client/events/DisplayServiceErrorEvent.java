package demo.client.events;

import demo.client.events.HelloWorldEvents;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.Event.Type;


public class DisplayServiceErrorEvent extends Event<HelloWorldEvents.DisplayServiceErrorEvent>  {

    public static Type<HelloWorldEvents.DisplayServiceErrorEvent> TYPE = new Type<HelloWorldEvents.DisplayServiceErrorEvent>();

    public String errorMessage;

    public DisplayServiceErrorEvent(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Event abstract methods --------------------------------------------------------------
    @Override
    public Type<HelloWorldEvents.DisplayServiceErrorEvent> getAssociatedType() { return TYPE; }

    @Override
    protected void dispatch(HelloWorldEvents.DisplayServiceErrorEvent handler) { handler.processEvent(this); }
}
