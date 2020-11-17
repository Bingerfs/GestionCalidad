package Proyecte;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;

import javax.swing.text.View;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.internal.matchers.ArrayEquals;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import Proyecte.InterfaceAdapters.Utils.Path;
import Proyecte.InterfaceAdapters.Utils.ViewUtil;
import spark.Request;
import spark.Session;


@ExtendWith(MockitoExtension.class)
public class ViewUtilTest {
    @Mock
    Request request;
    
    @Mock
    Session session;

   

    @Test
    void renderTestShouldReturnHTMLView(){
        try {
            Mockito.when(request.session()).then(new Answer<Session>() {

				@Override
				public Session answer(InvocationOnMock invocation) throws Throwable {
	                return session;
                }});
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Mockito.when(session.attribute("locale")).thenReturn("en");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String actual = ViewUtil.render(request, new HashMap<>(),  Path.Template.INDEX);
        assertTrue(actual.contains("<html>"));
    } 

    @Test
    void renderShouldReturnNotAccesiblePropOn406(){
        Object actual = ViewUtil.notAcceptable;
        assertNotNull(actual);
    }
}
