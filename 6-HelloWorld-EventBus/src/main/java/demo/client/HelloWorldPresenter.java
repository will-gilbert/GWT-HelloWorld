package demo.client;

import demo.client.events.HelloWorldEvents;
import demo.client.events.FetchHelloWorldEvent;
import demo.client.events.DisplayHelloWorldEvent;
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


public class HelloWorldPresenter  {

	// Inner Interfaces ===========================================================
	public interface View {
		HasClickHandlers getHelloClickable();
		HasClickHandlers getNoNameClickable();
		void displayResponse(String response);
		void displayError(String errorMessage);
		Widget asWidget();
	}
	
	//===========================================================================

	final View view;
	final EventBus eventBus;

	@Inject
	public HelloWorldPresenter(View view, EventBus eventBus) {
		this.view = view;
		this.eventBus = eventBus;

		bindView();
		bindEvents();
	}

	public Widget getView() {
		return view.asWidget();
	}

	private void bindView() {

		// Add handler code for the button click
		view.getHelloClickable().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new FetchHelloWorldEvent("World"));
			}
			
		});

		// Add handler code for the button click
		view.getNoNameClickable().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new FetchHelloWorldEvent(null));
			}
			
		});
				
	}

	private void bindEvents() {

        eventBus.addHandler(DisplayHelloWorldEvent.TYPE,
            new HelloWorldEvents.DisplayHelloWorldEvent() {
                public void processEvent(DisplayHelloWorldEvent event) {
                	view.displayResponse(event.response);
                }
            }
        );


	}


}