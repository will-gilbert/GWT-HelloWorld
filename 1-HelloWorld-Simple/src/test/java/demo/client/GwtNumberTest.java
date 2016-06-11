
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


@RunWith(PowerMockRunner.class)
@PrepareForTest( { NumberFormat.class })
public class GwtNumberTest  {

    static final String FORMAT = "0.0";
    static final DecimalFormat jdkFormatter = new DecimalFormat(FORMAT);


    @GwtMock
    NumberFormat numberformatMock;

    @Before
    public void setup() throws Throwable {

        GwtMockito.initMocks(this);
        mockStatic(NumberFormat.class);

        when(NumberFormat.getFormat(anyString())).thenReturn(numberformatMock);

        // Use JDK for number fomatting
        when(numberformatMock.format(anyDouble())).thenAnswer(
            new Answer<String>() {
                public String answer(InvocationOnMock invocation) throws Throwable {
                    Double number = (Double)invocation.getArguments()[0];
                    return jdkFormatter.format(number.doubleValue());
                }
            });

    }

    @Test
    public void numberformat() {
        NumberFormat numberformat = NumberFormat.getFormat(FORMAT);
        System.out.println(numberformat.format(0));
        System.out.println(numberformat.format(0.0));
        System.out.println(numberformat.format(1.0));
        System.out.println(numberformat.format(100.0));
    }

}

