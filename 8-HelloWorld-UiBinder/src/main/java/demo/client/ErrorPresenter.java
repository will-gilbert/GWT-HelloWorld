package demo.client;

// GWT - Core, User
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

import demo.client.events.DisplayServiceErrorEvent;

// GWT - Core, User
import com.google.gwt.event.shared.EventBus;


// EventBinder
import com.google.web.bindery.event.shared.binder.EventBinder;
import com.google.web.bindery.event.shared.binder.EventHandler;


// Google - Dependency Injection
import com.google.inject.Inject;


public class ErrorPresenter  {

    interface AnEventBinder extends EventBinder<ErrorPresenter> {}
    private static final AnEventBinder eventBinder = GWT.create(AnEventBinder.class);

	final EventBus eventBus;

	@Inject
	public ErrorPresenter(EventBus eventBus) {
		this.eventBus = eventBus;
        eventBinder.bindEventHandlers(this, eventBus);
	}

    @EventHandler
    void onFetchHelloWorld(DisplayServiceErrorEvent event) {
        Window.alert("ERROR: " + event.errorMessage);
    }   


}