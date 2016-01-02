package demo.client;


// GWT - Core, User
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Window;

// GWT - Widgets
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.HasClickHandlers;

public class HelloWorldView implements HelloWorldPresenter.View  {

	// Create a button
	private final Button button = new Button("Hello?");

	@Override
	public Widget asWidget() {
		return button;
	}

	@Override
	public HasClickHandlers getClickable() {
		return button;
	}

	@Override
	public void displayResponse(String response) {
		Window.alert(response);	
	}

	@Override
	public void displayError(String error) {
		Window.alert("ERROR:\n\n" + error);	
	}

}