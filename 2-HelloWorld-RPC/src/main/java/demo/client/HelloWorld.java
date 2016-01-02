package demo.client;


// Greeting RPC Service
import demo.client.rpc.GreetingService; 
import demo.client.rpc.GreetingServiceAsync; 


// GWT - Core, User
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.ui.Button;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

// SmartGWT - Widgets
// import com.smartgwt.client.widgets.Button;
// import com.smartgwt.client.widgets.events.ClickHandler;
// import com.smartgwt.client.widgets.events.ClickEvent;

// SmartGWT - Utility
// import com.smartgwt.client.util.SC;


/**
 * Entry point classes define onModuleLoad()
 */

public class HelloWorld implements EntryPoint {

	// Generate the RPC code from the interface
	static final GreetingServiceAsync rpcService = GWT.create(GreetingService.class);

	// Application starting point	
	public void onModuleLoad() {
		
		// Create a button
		Button button = new Button("Hello?");

		// Add handler code for a button click
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				invokeGreetingServiceWith("World");
			}
		});
				
		// Display the button
		RootPanel.get().add(button);
	}

	private void invokeGreetingServiceWith(String name) {

		rpcService.greetServer(name, new AsyncCallback<String>() {

			public void onSuccess(String results) {
				Window.alert(results);	
			}

			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());	
			}

		});


	}




}