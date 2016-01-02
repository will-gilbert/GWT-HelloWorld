
package demo.client;


import demo.client.HelloWorldPresenter;
import demo.client.events.FetchHelloWorldEvent;
import demo.client.events.DisplayHelloWorldEvent;
import demo.client.events.DisplayServiceErrorEvent;

// GWT - Core, User
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.event.shared.Event;
import com.google.gwt.event.shared.testing.CountingEventBus;

// GWT - Widgets
import com.google.gwt.event.dom.client.ClickEvent;

// GWT EventBinder
import com.google.web.bindery.event.shared.binder.EventBinder;
import com.google.web.bindery.event.shared.binder.GenericEvent;
import com.google.web.bindery.event.shared.binder.impl.GenericEventType;

// GWTMockito
import com.google.gwtmockito.GwtMockitoTestRunner;
import com.google.gwtmockito.GwtMock;

// JUnit 4.x testing
import org.junit.runner.RunWith;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


@RunWith(GwtMockitoTestRunner.class)
public class HelloWorldPresenterTest  {

    // EventType Constants
    static final GenericEventType fetchEventType = GenericEventType.getTypeOf(FetchHelloWorldEvent.class);
    static final GenericEventType errorEventType = GenericEventType.getTypeOf(DisplayServiceErrorEvent.class);
   

    @Test
    public void clickHelloButton() throws Exception {

        // Given
        CountingEventBus eventBus =  new CountingEventBus();
        HelloWorldPresenter presenter = new HelloWorldPresenter(eventBus); 

        // When
        presenter.onHelloClick(new ClickEvent(){});

        // Then
        assertEquals(1, eventBus.getFiredCount(fetchEventType));
    }
    
    @Test
    public void clickNoNameButton() throws Exception {

        // Given
        CountingEventBus eventBus =  new CountingEventBus();
        HelloWorldPresenter presenter = new HelloWorldPresenter(eventBus); 

        // When
        presenter.onNoNameClick(new ClickEvent(){});

        // Then
        assertEquals(1, eventBus.getFiredCount(fetchEventType));
    }


}
