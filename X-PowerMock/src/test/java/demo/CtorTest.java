package demo;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

// Static methods: JUnit
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

// Static methods: PowerMockito
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.stub;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

// Static methods: Mockito
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Testable.class)
public class CtorTest {


    @Test
    public void ctorAsInstance() {

        // When 'testable' is created as an instance
        Ctor ctor = new Ctor();

        // Then we can only test what we have access to
        assertEquals(1, ctor.a);
        assertEquals(1, ctor.b);
        assertEquals(1, ctor.c);
    }



    @Ignore
    public void ctorAsSpy() throws Exception {

        // When a 'ctor' instance is wrapped in a spy we get the behavior of the
        //  class under test and the ability to verify
        Ctor ctor = spy(new Ctor());
        ctor.a();

        // Then we can verify that the public methods were involked and use a PowerMockito
        //  method to verify that the private method 'c' was involked.
        verify(ctor, times(1)).a();
        verify(ctor, times(1)).b(anyInt());
        verifyPrivate(ctor, times(1)).invoke("c", anyInt(), anyString());

        // AND Mockito can verity order of invocation, except for private methods; PowerMock
        //  has not yet implemented 'InOrder' for private methods.
        InOrder inOrder = inOrder(ctor);
        inOrder.verify(ctor).a();
        inOrder.verify(ctor).b(anyInt());
    }



}