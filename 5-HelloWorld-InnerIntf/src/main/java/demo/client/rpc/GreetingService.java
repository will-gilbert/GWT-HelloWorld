package demo.client.rpc;

// GWT RPC
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The interface for the RPC service
 */

@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {

	// Submit a name, then receive a response
 	String greetServer(String name);

}
