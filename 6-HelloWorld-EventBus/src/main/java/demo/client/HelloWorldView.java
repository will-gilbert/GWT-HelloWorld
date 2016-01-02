package demo.client;


// GWT - Core, User
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HorizontalPanel;

// GWT - Widgets
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.HasClickHandlers;

public class HelloWorldView implements HelloWorldPresenter.View  {

	private final HorizontalPanel container = new HorizontalPanel();

	// Create a button
	private final Button helloButton = new Button("Hello?");
	private final Button noNameButton = new Button("No Name");

	public HelloWorldView() {
		container.setSpacing(10);
		container.add(helloButton);
		container.add(noNameButton);
	}

	@Override
	public Widget asWidget() {
		return container;
	}

	@Override
	public HasClickHandlers getHelloClickable() {
		return helloButton;
	}

	@Override
	public HasClickHandlers getNoNameClickable() {
		return noNameButton;
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