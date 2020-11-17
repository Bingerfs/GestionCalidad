package Proyecte;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
    @Mock
    AccountBoundaryIn boundaryIn;

    @Mock
    AccountBoundaryOut boundaryOut;

    @InjectMocks
    AccountController controller;

    @Test
    void renderViewShouldReturnARoute(){
        Object actual = controller.renderView;
        assertNotNull(actual);
    }

    @Test
    void saveAccountsShouldReturnARoute(){
        Object actual = controller.saveAccounts;
        assertNotNull(actual);
    }
}
