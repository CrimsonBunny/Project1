package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ModifyAccountTypeImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private ModifyAccountTypeImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteAccountTypeByMnemonic() {
        when(translator.delete("MILES")).thenReturn(null);
        AccountTypeDto result = flow.deleteAccountTypeByMnemonic("MILES");
        assertNull(result);
        verify(translator).delete("MILES");
    }

    @Test
    public void updateAccountType() {
        when(translator.update("MILES", "Plays", LocalDate.now())).thenReturn(null);
        AccountTypeDto result = flow.updateAccountType("MILES", "Plays", LocalDate.now());
        assertNull(result);
        verify(translator).update("MILES", "Plays", LocalDate.now());
    }
}