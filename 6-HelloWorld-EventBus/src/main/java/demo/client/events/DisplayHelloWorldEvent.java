package demo.client.events;

import demo.client.events.HelloWorldEvents;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.Event.Type;


public class DisplayHelloWorldEvent extends Event<HelloWorldEvents.DisplayHelloWorldEvent>  {

    public static Type<HelloWorldEvents.DisplayHelloWorldEvent> TYPE = new Type<HelloWorldEvents.DisplayHelloWorldEvent>();

    public String response;

    public DisplayHelloWorldEvent(String response) {
        this.response = response;
    }

    // Event abstract methods --------------------------------------------------------------
    @Override
    public Type<HelloWorldEvents.DisplayHelloWorldEvent> getAssociatedType() { return TYPE; }

    @Override
    protected void dispatch(HelloWorldEvents.DisplayHelloWorldEvent handler) { handler.processEvent(this); }
}


