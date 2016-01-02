package demo.client.di;

// RPC
import demo.client.rpc.GreetingServiceAsync; 

// Service Provider Singleton
import demo.client.di.providers.GreetingServiceProvider;

// Google GIN
import com.google.gwt.inject.client.AbstractGinModule;

// Dependency Injection
import com.google.inject.Singleton;


public class ProvidersModule extends AbstractGinModule {

    @Override
    protected void configure() {

        // Service Providers ------------------------------------------------------------------

        bind(GreetingServiceAsync.class)
            .toProvider(GreetingServiceProvider.class);
    }
 
}
