package demo.client.di;

// MVP Triads
import demo.client.HelloWorldModel;
import demo.client.HelloWorldView;
import demo.client.HelloWorldPresenter;

// Google Dependency Injection
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;


public class InjectorModule extends AbstractGinModule {

    @Override
    protected void configure() {

        // MVP Triads -------------------------------------------------------------------

        bind(HelloWorldPresenter.Model.class).to(HelloWorldModel.class);
        bind(HelloWorldPresenter.View.class).to(HelloWorldView.class);
        bind(HelloWorldPresenter.class).in(Singleton.class);

    }
 
}
