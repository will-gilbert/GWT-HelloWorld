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
public class TestableTest {


    @Test
    public void testableAsInstance() {

        // When 'testable' is created as an instance
        Testable testable = new Testable();
        testable.a();

        // Then we can only test what we have access to
        assertEquals(1, testable.a);
        assertEquals(1, testable.b);
        assertEquals(1, testable.c);
    }

   
    @Test
    public void testableAsMock() {

        // When 'testable' is created as a Mock
        Testable testable = mock(Testable.class);
        testable.a();

        // Then we can test that public methods are called but because we
        //   are not test the actual implementation we really aren't testing
        //   the 'Testable' class beause we have overridden all of its
        //   methods

        verify(testable, times(1)).a();
        verify(testable, times(0)).b(anyInt());
        // Can't verity private method 'c'

        // These were not incremented because Mocks do have implementations
        assertNotEquals(1, testable.a);
        assertNotEquals(1, testable.b);
        assertNotEquals(1, testable.c);
    }


    @Test
    public void testableAsSpy() throws Exception {

        // When a 'testable' instance is wrapped in a spy we get the behavior of the
        //  class under test and the ability to verify
        Testable testable = spy(new Testable());
        testable.a();

        // Then we can verify that the public methods were involked and use a PowerMockito
        //  method to verify that the private method 'c' was involked.
        verify(testable, times(1)).a();
        verify(testable, times(1)).b(anyInt());
        verifyPrivate(testable, times(1)).invoke("c", anyInt(), anyString());

        // AND Mockito can verity order of invocation, except for private methods; PowerMock
        //  has not yet implemented 'InOrder' for private methods.
        InOrder inOrder = inOrder(testable);
        inOrder.verify(testable).a();
        inOrder.verify(testable).b(anyInt());
    }



}