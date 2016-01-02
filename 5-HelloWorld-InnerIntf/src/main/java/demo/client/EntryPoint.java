package demo.client;

import demo.client.di.Injector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define onModuleLoad()
 */

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

    private final Injector injector = GWT.create(Injector.class);

	// Application starting point	
	public void onModuleLoad() {
		
		HelloWorldPresenter presenter = injector.getHelloWorldPresenter();
				
		// Display the UI
		RootPanel.get().add(presenter.getView());
	}


}