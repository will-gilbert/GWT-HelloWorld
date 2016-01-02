package demo.client;


// GWT - Core, User
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.rpc.AsyncCallback;

// GWT - Widgets
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

// Google - Dependency Injection
import com.google.inject.Inject;

public class HelloWorldPresenter  {

	final HelloWorldModel model;
	final HelloWorldView view;

	@Inject
	public HelloWorldPresenter(HelloWorldModel model, HelloWorldView view) {
		this.model = model;
		this.view = view;

		bindView();
		model.setName("World");
	}

	public Widget getView() {
		return view.asWidget();
	}

	void bindView() {

		// Add handler code for a button click
		view.getClickable().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				model.fetchGreeting(new AsyncCallback<String>() {

					public void onSuccess(String response) {
						view.displayResponse(response);
					}

					public void onFailure(Throwable caught) {
						view.displayError(caught.getMessage());
					}

				});
			}
			
		});
				
	}

}