package Proyecte;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyObject;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.function.Consumer;

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
import Proyecte.ApplicationLogic.BoundaryGateways.RestBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.RestBoundaryOut;
import Proyecte.InterfaceAdapters.Controllers.ClientController;
import Proyecte.InterfaceAdapters.Controllers.RestController;
import spark.Request;
import spark.Response;
import spark.Route;

@ExtendWith(MockitoExtension.class)
public class RestControllerTest {
    @Mock
    RestBoundaryIn boundaryIn;

    @Mock
    RestBoundaryOut boundaryOut;

    @Mock
    Route route;

    @Mock
    Request request;

    @Mock
    Response response;

    @InjectMocks
    RestController controller;

    @Test
    void getRecordsByPhoneNumberShouldReturnARoute(){
        Mockito.when(boundaryOut.onRestRetrieval(anyObject())).thenReturn("json");
        route = controller.getRecordsByPhoneNumber;
        String lista = "";
        try {
            lista = (String)route.handle(request, response);   
        } catch (Exception e) {
            //TODO: handle exception
        }
        assertEquals("json", lista);
    }
    
}
