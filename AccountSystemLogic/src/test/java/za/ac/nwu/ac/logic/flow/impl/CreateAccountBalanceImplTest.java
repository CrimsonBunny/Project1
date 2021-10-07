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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountBalanceImplTest {

    @Mock
    private AccountBalanceTranslator translator;

    @InjectMocks
    private CreateAccountBalanceImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        when(translator.create(any(AccountBalanceDto.class))).thenReturn(null);
        AccountBalanceDto result = flow.create(new AccountBalanceDto());
        assertNull(result);
        verify(translator).create(any(AccountBalanceDto.class));
    }
}