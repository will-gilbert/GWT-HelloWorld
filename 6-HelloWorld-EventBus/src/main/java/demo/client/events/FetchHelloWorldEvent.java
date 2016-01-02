package demo.client.events;

import demo.client.events.HelloWorldEvents;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.Event.Type;


public class FetchHelloWorldEvent extends Event<HelloWorldEvents.FetchHelloWorldEvent>  {

    public static Type<HelloWorldEvents.FetchHelloWorldEvent> TYPE = new Type<HelloWorldEvents.FetchHelloWorldEvent>();

    public String name;

    public FetchHelloWorldEvent(String name) {
        this.name = name;
    }

    // Event abstract methods --------------------------------------------------------------
    @Override
    public Type<HelloWorldEvents.FetchHelloWorldEvent> getAssociatedType() { return TYPE; }

    @Override
    protected void dispatch(HelloWorldEvents.FetchHelloWorldEvent handler) { handler.processEvent(this); }
}
