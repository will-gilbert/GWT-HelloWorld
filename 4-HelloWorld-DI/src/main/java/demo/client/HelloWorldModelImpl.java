package demo.client;


// Greeting RPC Service
import demo.client.rpc.GreetingService; 
import demo.client.rpc.GreetingServiceAsync; 

// GWT - Core, User
import com.google.gwt.user.client.rpc.AsyncCallback;

// Google Inject
import com.google.inject.Inject;

public class HelloWorldModelImpl implements HelloWorldModel {

	// Service Provider
	final GreetingServiceAsync rpcService;

	private String name;

	@Inject
	public HelloWorldModelImpl(GreetingServiceAsync rpcService) {
		this.rpcService = rpcService;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void fetchGreeting(AsyncCallback callback) {
		rpcService.greetServer(name, callback);
	}


}