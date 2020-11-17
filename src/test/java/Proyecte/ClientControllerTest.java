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

import Proyecte.ApplicationLogic.BoundaryGateways.ClientBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.ClientBoundaryOut;
import Proyecte.InterfaceAdapters.Controllers.ClientController;
import spark.*;


@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {
    @Mock
    ClientBoundaryIn boundaryIn;

    @InjectMocks
    ClientController controller;

    @Mock
    Route route;

    @Mock
    Request request;

    @Mock
    Response response;

    @Mock
    Session session;

    @Test
    void getAllClientShouldReturnARoute(){
        HashMap example = new HashMap<>();
        example.put("clients", new ArrayList());
        Mockito.when(session.attribute("locale")).thenReturn("en");
        Mockito.when(request.session()).thenReturn(session);
        Mockito.when(boundaryIn.getAllClients()).thenReturn(example);
        route = controller.getAllClients;
        String respuesta = "";
        try {
            respuesta = (String)route.handle(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(respuesta.contains("<html>"));
    }
}
