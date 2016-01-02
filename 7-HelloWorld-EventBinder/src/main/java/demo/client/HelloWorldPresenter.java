package demo.client;

import demo.client.events.FetchHelloWorldEvent;
import demo.client.events.DisplayHelloWorldEvent;

// GWT - Core, User
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.shared.EventBus;

// GWT - Widgets
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

// EventBinder
import com.google.web.bindery.event.shared.binder.EventBinder;
import com.google.web.bindery.event.shared.binder.EventHandler;


// Google - Dependency Injection
import com.google.inject.Inject;


public class HelloWorldPresenter  {

  	interface AnEventBinder extends EventBinder<HelloWorldPresenter> {}
  	private static final AnEventBinder eventBinder = GWT.create(AnEventBinder.class);


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
		eventBinder.bindEventHandlers(this, eventBus);
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

  	@EventHandler
  	void onDisplayHelloWorld(DisplayHelloWorldEvent event) {
		view.displayResponse(event.response);
	}	


}