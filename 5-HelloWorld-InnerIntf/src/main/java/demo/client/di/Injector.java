package demo.client.di;

// Presenters
import demo.client.HelloWorldPresenter;

// Google Dependency Injection
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.inject.client.GinModules;

@GinModules({InjectorModule.class, ProvidersModule.class})
public interface Injector extends Ginjector {

    // Presenters
    HelloWorldPresenter getHelloWorldPresenter();

}
