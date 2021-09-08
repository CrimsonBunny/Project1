package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private CreateAccountTypeImpl flow;

    @Before
    public void setUp() throws Exception {
        //hard way
//        translator = Mockito.mock(AccountTypeTranslator.class);
//        flow = new CreateAccountTypeImpl(translator);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create() {
        when(translator.create(any(AccountTypeDto.class))).thenReturn(null);
        AccountTypeDto result = flow.create(new AccountTypeDto());
        assertNull(result);
        verify(translator).create(any(AccountTypeDto.class));
    }
}