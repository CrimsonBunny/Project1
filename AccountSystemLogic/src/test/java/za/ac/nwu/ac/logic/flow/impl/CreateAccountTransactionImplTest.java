package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTransactionImplTest {

    @Mock
    private AccountTransactionTranslator translator;

    @InjectMocks
    private CreateAccountTransactionImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        when(translator.create("Test", 1L, 200L, LocalDate.now())).thenReturn(null);
        AccountTransactionDto result = flow.create("Test", 1L, 200L, LocalDate.now());
        assertNull(result);
        verify(translator).create("Test", 1L, 200L, LocalDate.now());
    }
}