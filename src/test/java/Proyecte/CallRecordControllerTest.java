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

import Proyecte.ApplicationLogic.BoundaryGateways.AccountBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.AccountBoundaryOut;
import Proyecte.ApplicationLogic.BoundaryGateways.CallRecordBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.CallRecordBoundaryOut;
import Proyecte.InterfaceAdapters.Controllers.AccountController;
import Proyecte.InterfaceAdapters.Controllers.CallRecordController;


@ExtendWith(MockitoExtension.class)
public class CallRecordControllerTest {

    @Mock
    CallRecordBoundaryIn boundaryIn;

    @Mock
    CallRecordBoundaryOut boundaryOut;

    @InjectMocks
    CallRecordController controller;
    
    @Test
    void getAllRecordsShouldReturnARoute(){
        Object actual = controller.getAllCallRecords;
        assertNotNull(actual);
    }

    @Test
    void getFileRecordsShouldReturnARoute(){
        Object actual = controller.getfileCallrecords;
        assertNotNull(actual.getClass());
    }
    
    @Test
    void rateUploadedRecordsShouldReturnARoute(){
        Object actual = controller.rateUploadedRecords;
        assertNotNull(actual.getClass());
    }

    @Test
    void saveCDRListShouldReturnARoute(){
        Object actual = controller.saveCdrList;
        assertNotNull(actual.getClass());
    }
}
