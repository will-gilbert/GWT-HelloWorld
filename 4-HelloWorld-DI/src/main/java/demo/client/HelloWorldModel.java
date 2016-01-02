package demo.client;

// GWT - Core, User
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HelloWorldModel   {

	void setName(String name);
	void fetchGreeting(AsyncCallback<String> callback);

}