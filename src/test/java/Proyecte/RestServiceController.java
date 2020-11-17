package Proyecte;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;

import java.lang.reflect.Executable;
import java.util.ArrayList;
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

import Proyecte.ApplicationLogic.BoundaryGateways.ICDRRepository;
import Proyecte.ApplicationLogic.UseCases.RestService;

@ExtendWith(MockitoExtension.class)
public class RestServiceController {
    @Mock
    ICDRRepository repository;

    @InjectMocks
    RestService service;

    @Test
    void getCallRecordsByPhoneShouldReturnAList(){
        Mockito.when(repository.getCallRecordsByPhoneNumber(anyString())).thenReturn(new ArrayList());
        assertEquals(ArrayList.class, service.getCallRecordsByPhone("79789798").getClass());
    }
}
