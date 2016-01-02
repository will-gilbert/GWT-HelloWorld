
package demo.client;


import demo.client.HelloWorldPresenter;
import demo.client.HelloWorldModel;
import demo.client.HelloWorldView;

import com.google.gwt.user.client.rpc.AsyncCallback;

// GWT - Widgets
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Button;

import static org.mockito.Mockito.*;

// Mockito
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

// JUnit 4.x testing
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


// @RunWith(GwtMockitoTestRunner.class)
public class HelloWorldPresenterTest  {

	@Mock
	HelloWorldModel model;

	@Mock
	HelloWorldView view;

	@Mock
	HasClickHandlers hasClickHandlers; 
 
    ClickHandler clickHandler;

    final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        // The view communicates via the a 'ClickHandler' interface 
        when(view.getClickable()).thenReturn(hasClickHandlers);

        // When the mock 'hasClickHandlers' is registered get the Presenters
        //  real 'ClickHandler' from the invocation arguments
        when(hasClickHandlers.addClickHandler(any(ClickHandler.class)))
            .thenAnswer(
                new Answer<Object>() {
                    public Object answer(InvocationOnMock aInvocation) throws Throwable {
                        clickHandler = (ClickHandler) aInvocation.getArguments()[0];
                        return null;
                    }
                }
           );
    }

    
    @Test
    public void onSuccess() throws Exception {

        // Given
        HelloWorldPresenter presenter = new HelloWorldPresenter(model, view); 
        modelWillReturnSuccess();

        // When
        clickHandler.onClick(null);

        // Expect
        verify(view, times(1)).displayResponse(captor.capture());
        verify(view, never()).displayError(anyString());

        assertEquals("Hello, World", captor.getValue());

    }

    @Test
    public void onFailure() throws Exception {

        // Given
        HelloWorldPresenter presenter = new HelloWorldPresenter(model, view); 
        modelWillReturnFailure();

        // When
        clickHandler.onClick(null);

        // Expect
        verify(view, never()).displayResponse(anyString());
        verify(view, times(1)).displayError(captor.capture());

        assertEquals("Server Failure", captor.getValue());

    }

    //================================================================================================

    private void modelWillReturnSuccess() {

        doAnswer(new Answer<Object>() {

            public Object answer(InvocationOnMock invocation) throws Throwable {
                AsyncCallback <String> callback = (AsyncCallback<String>) invocation.getArguments()[0];
                callback.onSuccess("Hello, World");
                return null;
            }

        }).when(model).fetchGreeting((AsyncCallback<String>) any());
        
    }

    private void modelWillReturnFailure() {

        doAnswer(new Answer<Object>() {

            public Object answer(InvocationOnMock invocation) throws Throwable {
                AsyncCallback <String> callback = (AsyncCallback<String>) invocation.getArguments()[0];
                callback.onFailure(new Throwable("Server Failure"));
                return null;
            }

        }).when(model).fetchGreeting((AsyncCallback<String>) any());
        
    }


}
