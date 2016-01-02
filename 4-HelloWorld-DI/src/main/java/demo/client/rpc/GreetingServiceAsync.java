package demo.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */

public interface GreetingServiceAsync {

	// Created by 'GWT.create' and used to invoke the remote server
	//  AsyncCallback is an interface which implements two methods
	//
	//		void onSuccess(<T> results)
	//      void onFailure(Throwable caught)
	//


  	void greetServer(String input, AsyncCallback<String> callback);

}
