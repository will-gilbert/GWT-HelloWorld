package demo.client;

import demo.client.events.FetchHelloWorldEvent;
import demo.client.events.DisplayHelloWorldEvent;

// GWT - Core, User
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.Window;

// GWT - Widgets
import com.google.gwt.event.dom.client.ClickEvent;

// EventBinder
import com.google.gwt.event.shared.EventBus;
import com.google.web.bindery.event.shared.binder.EventBinder;
import com.google.web.bindery.event.shared.binder.EventHandler;

// UiBinder
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiField;

// Google - Dependency Injection
import com.google.inject.Inject;


public class HelloWorldPresenter extends Composite  {

  	interface AnEventBinder extends EventBinder<HelloWorldPresenter> {}
  	private static final AnEventBinder eventBinder = GWT.create(AnEventBinder.class);

    interface TheUiBinder extends UiBinder<Widget, HelloWorldPresenter> {}
	private static TheUiBinder uiBinder = GWT.create(TheUiBinder.class);

	@UiField HorizontalPanel container;
	@UiField Button helloButton;
	@UiField Button noNameButton;

	final EventBus eventBus;

	@Inject
	public HelloWorldPresenter(EventBus eventBus) {
		this.eventBus = eventBus;
		eventBinder.bindEventHandlers(this, eventBus);
        initWidget(uiBinder.createAndBindUi(this));
	}

	public Widget getView() {
		return this;
	}

	@UiHandler("helloButton")
	void onHelloClick(ClickEvent event) {
		eventBus.fireEvent(new FetchHelloWorldEvent("World"));
	}
	
	@UiHandler("noNameButton")
	void onNoNameClick(ClickEvent event) {
		eventBus.fireEvent(new FetchHelloWorldEvent(null));
	}		

  	@EventHandler
  	void onDisplayHelloWorld(DisplayHelloWorldEvent event) {
		// view.displayResponse(event.response);
		Window.alert(event.response);
	}	


}