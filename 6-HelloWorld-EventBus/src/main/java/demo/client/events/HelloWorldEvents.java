package demo.client.events;


public interface HelloWorldEvents {

    public interface FetchHelloWorldEvent {
         void processEvent(demo.client.events.FetchHelloWorldEvent event);
    }

    public interface DisplayHelloWorldEvent {
         void processEvent(demo.client.events.DisplayHelloWorldEvent event);
    }

    public interface DisplayServiceErrorEvent {
         void processEvent(demo.client.events.DisplayServiceErrorEvent event);
    }

}
