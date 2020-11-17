package Proyecte;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import Proyecte.InterfaceAdapters.Utils.RequestUtil;
import spark.Request;
import spark.Session;

@ExtendWith(MockitoExtension.class)
public class RequestUtilTest {

    @Mock
    Request request;

    @Mock
    Session session;

    @Mock
    HttpServletRequest req;

    @Test
    void getQueryLocaleReturnsValueFromLocaleParameter() {
        try {
            Mockito.when(request.queryParams("locale")).thenReturn("en");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String localeRetrieved = RequestUtil.getQueryLocale(request);
        assertEquals("en", localeRetrieved);
    }

    @Test
    void constructorShouldThrowException() {
        assertThrows(IllegalStateException.class, () -> {
            new RequestUtil();
        });
    }

    @Test
    void getParamIsbnShouldReturnIsbnParameterValue() {
        try {
            Mockito.when(request.params("isbn")).thenReturn("24");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String isbnRetrieved = RequestUtil.getParamIsbn(request);
        assertEquals("24", isbnRetrieved);
    }

    @Test
    void getSessionLocaleShouldReturnLocaleValue(){
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
        String localeSessionRetrieved = RequestUtil.getSessionLocale(request);
        assertEquals("en", localeSessionRetrieved);
    }

    @Test
    void testClientAcceptsHTMLReturnsTrue(){
        try {
            Mockito.when(request.headers("Accept")).thenReturn("content: text/html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean booleanRetrieved = RequestUtil.clientAcceptsHtml(request);
        assertTrue(booleanRetrieved);
    }

    @Test
    void testClientAcceptsJson(){
        try {
            Mockito.when(request.headers("Accept")).thenReturn("content: application/json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean booleanRetrieved = RequestUtil.clientAcceptsJson(request);
        assertTrue(booleanRetrieved);
    }

    @Test
    void getFileUrlShouldReturnException(){
        try {
            Mockito.when(request.raw()).thenReturn(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String res = RequestUtil.getfileurl(request);
        assertTrue(res.contains("Exception occurred"));
    }
}
