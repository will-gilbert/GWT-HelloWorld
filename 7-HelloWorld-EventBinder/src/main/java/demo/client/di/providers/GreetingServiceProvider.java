package demo.client.di.providers;

// RPC
import demo.client.rpc.GreetingService; 
import demo.client.rpc.GreetingServiceAsync; 


// Google Injection
import com.google.inject.Inject;
import com.google.inject.Provider;

// GWT - Core,UI
import com.google.gwt.core.client.GWT;
  
public class GreetingServiceProvider implements Provider<GreetingServiceAsync> {

    // Global singleton
    private static final GreetingServiceAsync rpcService = GWT.create(GreetingService.class);

    @Override
    public GreetingServiceAsync get() {
        return rpcService;
    }

}
