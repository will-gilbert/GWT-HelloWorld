package demo.client;

// GWT - Core, User
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Button;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
/**
 * Entry point classes define onModuleLoad()
 */

public class HelloWorld implements EntryPoint {
	
	VerticalPanel container = new VerticalPanel();

	// Application starting point	
	public void onModuleLoad() {

		
		// Create a button
		Button button = new Button("Hello?");
		container.add(button);

		// Add handler code for a button click
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String userAgent = Window.Navigator.getUserAgent();
				Window.alert("Hello, World!\n\n" +
					         "It looks like I'm using:\n" + 
					         userAgent
				);
			}
		});
		
		// Display the button
		RootPanel.get().add(container);
	}

}
