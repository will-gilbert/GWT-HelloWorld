package demo.client;

import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define onModuleLoad()
 */

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

	// Application starting point	
	public void onModuleLoad() {
		
		HelloWorldModel model = new HelloWorldModel();
		HelloWorldView  view = new HelloWorldView();
		HelloWorldPresenter presenter = new HelloWorldPresenter(model, view);
				
		// Display the UI
		RootPanel.get().add(presenter.getView());
	}


}