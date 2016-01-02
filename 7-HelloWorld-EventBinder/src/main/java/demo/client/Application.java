package demo.client;


import com.google.gwt.core.client.GWT;

// RPC Service
import demo.client.rpc.GreetingService; 
import demo.client.rpc.GreetingServiceAsync; 
import com.google.gwt.user.client.rpc.AsyncCallback;

import demo.client.events.FetchHelloWorldEvent;
import demo.client.events.DisplayHelloWorldEvent;
import demo.client.events.DisplayServiceErrorEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;

// EventBinder
import com.google.web.bindery.event.shared.binder.EventBinder;
import com.google.web.bindery.event.shared.binder.EventHandler;

// Google - Dependency Injection
import com.google.inject.Inject;

public class Application {

    interface AnEventBinder extends EventBinder<Application> {}
    private static final AnEventBinder eventBinder = GWT.create(AnEventBinder.class);

    private final  EventBus eventBus;
    private final  GreetingServiceAsync rpcService;

    @Inject
    public Application(EventBus eventBus, GreetingServiceAsync rpcService) {
    	this.eventBus = eventBus;
    	this.rpcService = rpcService;

        eventBinder.bindEventHandlers(this, eventBus);
	}

    @EventHandler
    void onFetchHelloWorld(FetchHelloWorldEvent event) {
        fetchHelloWorld(event.name);
    }   
	
	// Create a service request and handle the response/error
	private void fetchHelloWorld(String name) {

		rpcService.greetServer(name, new AsyncCallback<String>() {

			public void onSuccess(String results) {
				eventBus.fireEvent(new DisplayHelloWorldEvent(results));	
			}

			public void onFailure(Throwable caught) {
				eventBus.fireEvent( new DisplayServiceErrorEvent(caught.getMessage()) );	
			}
		});

	}

}