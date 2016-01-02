package demo.client.di;


import demo.client.Application;

import demo.client.HelloWorldPresenter;
import demo.client.HelloWorldView;

import demo.client.ErrorPresenter;

// Event Bus
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

// Google Dependency Injection
import com.google.gwt.inject.client.AbstractGinModule;

// Google Injection
import com.google.inject.Singleton;

public class InjectorModule extends AbstractGinModule {

    @Override
    protected void configure() {

        // Application
    	bind(Application.class).in(Singleton.class);

        // Event bus
        bind(SimpleEventBus.class).in(Singleton.class);
        bind(EventBus.class).to(SimpleEventBus.class);

        // MVP Triads -------------------------------------------------------------------

        bind(HelloWorldPresenter.View.class).to(HelloWorldView.class);
        bind(HelloWorldPresenter.class).in(Singleton.class);

        bind(ErrorPresenter.class).in(Singleton.class);


    }
 
}
