package Proyecte;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import Proyecte.EnterpriseLogic.Account;
import Proyecte.InterfaceAdapters.Utils.AccountReader;

@ExtendWith(MockitoExtension.class)
public class AccountReaderTest {
    @Test
    void readerShouldReturnListOfAccounts() {
        AccountReader.filename = "accountslist.txt";
        Object actual = AccountReader.readFile().get(0).getClass();
        assertEquals(Account.class, actual);
    }

    @Test
    void readerShouldReturnEmptyListOnUnexistantFile(){
        AccountReader.filename = "anything.txt";
        List<Account> actual = AccountReader.readFile();
        assertEquals(actual.size(), 0);
    }
}
