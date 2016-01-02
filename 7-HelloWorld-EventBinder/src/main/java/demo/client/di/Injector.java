package demo.client.di;

// Presenters
import demo.client.Application;
import demo.client.HelloWorldPresenter;
import demo.client.ErrorPresenter;

// Event Bus
import com.google.gwt.event.shared.EventBus;

// Google Dependency Injection
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.inject.client.GinModules;

@GinModules({InjectorModule.class, ProvidersModule.class})
public interface Injector extends Ginjector {

    // EventBus
    EventBus getEventBus();

    // Application
    Application getApplication();

    // Presenters
    HelloWorldPresenter getHelloWorldPresenter();

    // Presenters
    ErrorPresenter getErrorPresenter();

}
