package demo.client;


// Greeting RPC Service
import demo.client.rpc.GreetingService; 
import demo.client.rpc.GreetingServiceAsync; 

// GWT - Core, User
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * Entry point classes define onModuleLoad()
 */

public class HelloWorldModel  {

	// Generate the RPC code from the interface
	static final GreetingServiceAsync rpcService = GWT.create(GreetingService.class);

	public void invokeGreetingServiceWith(String name, AsyncCallback callback) {
		rpcService.greetServer(name, callback);
	}


}