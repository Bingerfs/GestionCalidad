package Proyecte;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import Proyecte.ApplicationLogic.BoundaryGateways.AccountBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.AccountBoundaryOut;
import Proyecte.InterfaceAdapters.Controllers.AccountController;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;


@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
    @Mock
    AccountBoundaryIn boundaryIn;

    @Mock
    AccountBoundaryOut boundaryOut;

    @InjectMocks
    AccountController controller;

    @Mock
    Route route;

    @Mock
    Request request;

    @Mock
    Response response;

    @Mock
    Session session;

    @Test
    void renderViewShouldReturnARoute(){
        Mockito.when(session.attribute("locale")).thenReturn("en");
        Mockito.when(request.session()).thenReturn(session);
        route = controller.renderView;
        String respuesta = "";
        try {
            respuesta = (String)route.handle(request, response);   
        } catch (Exception e) {
            //TODO: handle exception
        }
        assertTrue(respuesta.contains("<html>"));
    }

    @Test
    void saveAccountsShouldReturnARoute(){
        HashMap example = new HashMap<>();
        example.put("accounts", new ArrayList());
        Mockito.when(session.attribute("locale")).thenReturn("en");
        Mockito.when(request.session()).thenReturn(session);
        Mockito.when(boundaryOut.onSaveAccountsFromFile(anyObject())).thenReturn(example);
        route = controller.saveAccounts;
        String respuesta = "";
        try {
            respuesta = (String)route.handle(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(respuesta.contains("<html>"));
    }
}
