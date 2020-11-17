package Proyecte;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {
    @Mock
    ClientBoundaryIn boundaryIn;


    @InjectMocks
    ClientController controller;

    @Test
    void getAllClientShouldReturnARoute(){
        Object actual = controller.getAllClients;
        assertNotNull(actual);
    }
}
