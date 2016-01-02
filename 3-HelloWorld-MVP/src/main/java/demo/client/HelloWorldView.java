package demo.client;


// GWT - Core, User
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Window;

// GWT - Widgets
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.HasClickHandlers;

public class HelloWorldView  {

	// Create a button
	private final Button button = new Button("Hello?");

	public Widget asWidget() {
		return button;
	}

	public HasClickHandlers getClickable() {
		return button;
	}

	public void displayResponse(String response) {
		Window.alert(response);	
	}

	public void displayError(String error) {
		Window.alert("ERROR:\n\n" + error);	
	}

}