package unitTests;

import list.Interpreter;
import list.InterpreterRenderer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


/**
 * Created by Admin on 6.8.2016 г..
 */
public class MockInterpriterRendererTest {

    @Mock
    private Interpreter interpreter;
    private InterpreterRenderer renderer;

    @Before
    public void setUp(){
        this.interpreter = Mockito.mock(Interpreter.class);
        this.renderer = new InterpreterRenderer(this.interpreter);
    }

    @Test
    public void testGetElement_shouldReturnInteger(){
        String expected = "67";
        Mockito.when(this.interpreter.returnLastElementInCustomList()).thenReturn(Integer.parseInt(expected));

        String actual = this.renderer.getElement();

        Assert.assertEquals(expected, actual);
    }
}
