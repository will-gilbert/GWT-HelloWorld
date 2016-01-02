package demo.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service
 */

@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {

	// Submit a name, then receive a response
 	String greetServer(String name);

}
