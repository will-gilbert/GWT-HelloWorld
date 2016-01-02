package demo.server;

// Applicaton - Service RPC
import demo.client.rpc.GreetingService;


// GWT - RPC
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


/**
 * The server side implementation of the RPC service
 */


@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

  public String greetServer(String name) {

    String serverInfo = getServletContext().getServerInfo();
    String userAgent = getThreadLocalRequest().getHeader("User-Agent");

    return "Hello, " + name + "!\n\nI am running " + serverInfo
        + ".\n\nIt looks like you are using:\n" + userAgent;
  }
}
