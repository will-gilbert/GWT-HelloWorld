package demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

// Java: Reflection
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;

// Static methods: JUnit
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

// Static methods: PowerMockito, single method stubbing
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.replace;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Ctor.class)
public class CtorTest {

    boolean wasInvoked = false;
    int invocationCount = 0;

    @Before 
    public void initializeTestingStates() {
        wasInvoked = false;
        invocationCount = 0;
    }

    @Test
    public void ctorAsInstance() {

        // When: 'Ctor' is created as an instance
        Ctor ctor = new Ctor();

        // Then: we do a sanity check of the exposed counters
        assertEquals(1, ctor.a);
        assertEquals(1, ctor.b);
        assertEquals(1, ctor.c);
    }


    @Test
    public void method_a_IsInvoked() throws Exception {

        // Setup: Replace method 'a' in Ctor with an InvocationHandler
        Method a = method(Ctor.class, "a");
        replace(a).with(createInvocationHandler());

        // When: 'Ctor' is created as an instance
        Ctor ctor = new Ctor();

        // Then: The states should have been changed
        assertTrue(wasInvoked);
        assertEquals(1, invocationCount);

        // And: we do a sanity check of the exposed counters; None set, 'a' was stubbed, no
        //  other methods involked
        assertEquals(0, ctor.a);
        assertEquals(0, ctor.b);
        assertEquals(0, ctor.c);

    }
    
    @Test
    public void method_b_IsInvoked() throws Exception {

        // Setup: Replace method 'b' in Ctor with an InvocationHandler
        Method b = method(Ctor.class, "b", int.class);
        replace(b).with(createInvocationHandler());

        // When: 'Ctor' is created as an instance
        Ctor ctor = new Ctor();

        // Then: The states should have been changed
        assertTrue(wasInvoked);
        assertEquals(1, invocationCount);

        // And: Crosscheck; b not invlked, 'a' and 'c'
        assertEquals(1, ctor.a);
        assertEquals(0, ctor.b);
        assertEquals(1, ctor.c);
    }

    
    @Test
    public void method_c_IsInvoked() throws Exception {

        // Setup: Replace method 'c' in Ctor with an InvocationHandler
        Method c = method(Ctor.class, "c", Integer.class, String.class);
        replace(c).with(createInvocationHandler());

        // When: 'Ctor' is created as an instance
        Ctor ctor = new Ctor();

        // Then: The states should have been changed
        assertTrue(wasInvoked);
        assertEquals(1, invocationCount);

        // And: Crosscheck; c not invlked, 'a' and 'b'
        assertEquals(1, ctor.a);
        assertEquals(1, ctor.b);
        assertEquals(0, ctor.c);

    }

    private InvocationHandler createInvocationHandler() {
        return new InvocationHandler() {

            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
                wasInvoked = true;
                invocationCount ++;
                return Void.class;
            }
        };
    }


}