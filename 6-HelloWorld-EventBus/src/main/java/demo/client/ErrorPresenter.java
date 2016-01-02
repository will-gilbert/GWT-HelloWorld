package demo.client;

// GWT - Core, User
import com.google.gwt.user.client.Window;

import demo.client.events.HelloWorldEvents;
import demo.client.events.DisplayServiceErrorEvent;

// GWT - Core, User
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.shared.EventBus;

// GWT - Widgets
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;


// Google - Dependency Injection
import com.google.inject.Inject;


public class ErrorPresenter  {

	final EventBus eventBus;

	@Inject
	public ErrorPresenter(EventBus eventBus) {
		this.eventBus = eventBus;
		bindEvents();
	}

	private void bindEvents() {

		// Receive and process a server error
        eventBus.addHandler(DisplayServiceErrorEvent.TYPE,
            new HelloWorldEvents.DisplayServiceErrorEvent() {
                public void processEvent(DisplayServiceErrorEvent event) {
                	Window.alert("ERROR: " + event.errorMessage);
                }
            }
        );

	}


}