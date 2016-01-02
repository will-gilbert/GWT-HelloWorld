package demo.client.di;

// MVP Triads
import demo.client.HelloWorldModel;
import demo.client.HelloWorldView;
import demo.client.HelloWorldPresenter;

import demo.client.HelloWorldModelImpl;
import demo.client.HelloWorldViewImpl;
import demo.client.HelloWorldPresenter;

// Google Dependency Injection
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;


public class InjectorModule extends AbstractGinModule {

    @Override
    protected void configure() {

        // MVP Triads -------------------------------------------------------------------

        bind(HelloWorldModel.class).to(HelloWorldModelImpl.class);
        bind(HelloWorldView.class).to(HelloWorldViewImpl.class);
        bind(HelloWorldPresenter.class).in(Singleton.class);

    }
 
}
