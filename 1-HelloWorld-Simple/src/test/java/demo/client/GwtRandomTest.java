
package demo.client;

import com.google.gwt.user.client.Random;

// JUnit 4.x testing
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

// PowerMock
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest( { Random.class })

/**
* If not correctly mocked, this class will not compile
*
*/

public class GwtRandomTest  {

    @Before
    public void createStaticMocks() throws Throwable {

        // Mock Singleton
        mockStatic(Random.class);

        // Use JDK Random class in place of GWT Random class
        java.util.Random jdkRandom = new java.util.Random();
        when(Random.nextInt()).thenReturn(jdkRandom.nextInt());
        when(Random.nextDouble()).thenReturn(jdkRandom.nextDouble());
    }

    @Test
    @SuppressWarnings("unused")
    public void randomInt() {
        int random = Random.nextInt();
    }

    @Test
    @SuppressWarnings("unused")
    public void randomDouble() {
        double random = Random.nextDouble();
    }

  

}
