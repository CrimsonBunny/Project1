package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.translator.AccountBalanceTranslator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FetchAccountBalanceImplTest {

    @Mock
    private AccountBalanceTranslator translator;

    @InjectMocks
    private FetchAccountBalanceImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAccountBalanceByMnemonic() {
        when(translator.getAccountBalanceByMnemonic(1L, "MILES")).thenReturn(null);
        AccountBalanceDto result = flow.getAccountBalanceByMnemonic(1L, "MILES");
        assertNull(result);
        verify(translator).getAccountBalanceByMnemonic(1L, "MILES");
    }
}