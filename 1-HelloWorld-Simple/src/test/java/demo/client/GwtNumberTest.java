
package demo.client;

import com.google.gwt.i18n.client.NumberFormat;
import java.text.DecimalFormat;

// JUnit 4.x testing
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.gwtmockito.GwtMockito;
import com.google.gwtmockito.GwtMock;

// PowerMock
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.mockito.stubbing.Answer;
import org.mockito.invocation.InvocationOnMock;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyString;
import static org.junit.Assert.assertEquals;


@RunWith(PowerMockRunner.class)
@PrepareForTest( { NumberFormat.class })
public class GwtNumberTest  {

    @GwtMock
    NumberFormat numberformatMock;

    @Before
    public void setup() throws Throwable {

        GwtMockito.initMocks(this);
        mockStatic(NumberFormat.class);

        when(NumberFormat.getFormat(anyString())).thenReturn(numberformatMock);
    }

    @Test
    public void numberformat() {

        String pattern = "0.0";
        DecimalFormat jdkFormatter = new DecimalFormat(pattern);

        // Use JDK for number fomatting
        when(numberformatMock.format(anyDouble())).thenAnswer(
            new Answer<String>() {
                public String answer(InvocationOnMock invocation) throws Throwable {
                    Double number = (Double)invocation.getArguments()[0];
                    return jdkFormatter.format(number.doubleValue());
                }
            });

        // Tests -----------------------------------------------------

        NumberFormat numberformat = NumberFormat.getFormat(pattern);

        // Doubles
        assertEquals("0.0", numberformat.format(0.0));
        assertEquals("1.0", numberformat.format(1.0));
        assertEquals("100.0", numberformat.format(100.0));

        // Doubles with extra precision
        assertEquals("0.0", numberformat.format(0.00001));
        assertEquals("1.0", numberformat.format(1.00001));
        assertEquals("100.0", numberformat.format(100.00001));

        // Doubles with less precision
        assertEquals("0.0", numberformat.format(0.));
        assertEquals("1.0", numberformat.format(1.));
        assertEquals("100.0", numberformat.format(100.));

        // Integers
        assertEquals("0.0", numberformat.format(0));
        assertEquals("1.0", numberformat.format(1));
        assertEquals("100.0", numberformat.format(100));

        // Floats
        assertEquals("0.0", numberformat.format(0.0f));
        assertEquals("1.0", numberformat.format(1.0f));
        assertEquals("100.0", numberformat.format(100.0f));
       
    }

}

