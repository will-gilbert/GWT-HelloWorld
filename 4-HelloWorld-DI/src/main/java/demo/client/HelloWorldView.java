package demo.client;


// GWT - Core, User
import com.google.gwt.user.client.ui.Widget;

// GWT - Widgets
import com.google.gwt.event.dom.client.HasClickHandlers;

public interface HelloWorldView  {

	HasClickHandlers getClickable();
	void displayResponse(String response);
	void displayError(String errorMessage);
	Widget asWidget();

}