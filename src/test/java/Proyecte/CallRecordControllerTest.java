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

import Proyecte.ApplicationLogic.BoundaryGateways.AccountBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.AccountBoundaryOut;
import Proyecte.ApplicationLogic.BoundaryGateways.CallRecordBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.CallRecordBoundaryOut;
import Proyecte.InterfaceAdapters.Controllers.AccountController;
import Proyecte.InterfaceAdapters.Controllers.CallRecordController;
import spark.*;


@ExtendWith(MockitoExtension.class)
public class CallRecordControllerTest {

    @Mock
    CallRecordBoundaryIn boundaryIn;

    @Mock
    CallRecordBoundaryOut boundaryOut;

    @InjectMocks
    CallRecordController controller;

    @Mock
    Route route;

    @Mock
    Request request;

    @Mock
    Response response;

    @Mock
    Session session;
    
    @Test
    void getAllRecordsShouldReturnARoute(){
        HashMap example = new HashMap<>();
        example.put("callRecords", new ArrayList());
        Mockito.when(session.attribute("locale")).thenReturn("en");
        Mockito.when(request.session()).thenReturn(session);
        Mockito.when(boundaryOut.onShowAllCallRecords(anyObject())).thenReturn(example);
        route = controller.getAllCallRecords;
        String respuesta = "";
        try {
            respuesta = (String)route.handle(request, response);   
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(respuesta.contains("<html>"));
    }

    @Test
    void getFileRecordsShouldReturnARoute(){
        Mockito.when(session.attribute("locale")).thenReturn("en");
        Mockito.when(request.session()).thenReturn(session);
        route = controller.getfileCallrecords;
        String respuesta = "";
        try {
            respuesta = (String)route.handle(request, response);   
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(respuesta.contains("<html>"));
    }
    
    @Test
    void rateUploadedRecordsShouldReturnARoute(){
        Mockito.when(session.attribute("locale")).thenReturn("en");
        Mockito.when(request.session()).thenReturn(session);
        route = controller.rateUploadedRecords;
        String respuesta = "";
        try {
            respuesta = (String)route.handle(request, response);   
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(respuesta.contains("<html>"));
    }

    @Test
    void saveCDRListShouldReturnARoute(){
        HashMap example = new HashMap<>();
        example.put("callRecords", new ArrayList());
        Mockito.when(session.attribute("locale")).thenReturn("en");
        Mockito.when(request.session()).thenReturn(session);
        Mockito.when(boundaryOut.onShowAllCallRecords(anyObject())).thenReturn(example);
        route = controller.saveCdrList;
        String respuesta = "";
        try {
            route = (Route)route.handle(request, response);
            respuesta = (String)route.handle(request, response);   
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(respuesta.contains("<html>"));
    }
}
