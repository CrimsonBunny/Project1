package za.ac.nwu.ac.web.sb.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.AdditionalAnswers.returnsFirstArg;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountTransactionControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_TYPE_CONTROLLER_URL = APP_URL + "/account-transaction";

    @Mock
    private CreateAccountTransactionFlow createAccountTransactionFlow;

    @InjectMocks
    private AccountTransactionController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() throws Exception {
//        String accountTransactionToBeCreated = "{\"mnemonic\":\"MILES\",\"memberID\":1,\"amount\":200,\"transactionDate\":[2020,10,08]},";
//        String expectedResponse = "{\"successful\":true,\"payload\":" +
//                "{\"mnemonic\":\"MILES\",\"memberID\":1,\"amount\":200,\"transactionDate\":[2020,10,08]}}";
//
//        AccountTransactionDto accountTransaction = new AccountTransactionDto("MILES", 1L, 200L, LocalDate.parse("2020-10-08"));
//
//        when(createAccountTransactionFlow.create("MILES", 1L, 200L, LocalDate.parse("2020-10-08"))).thenReturn(accountTransaction);
//
//        MvcResult mvcResult = mockMvc.perform(post(ACCOUNT_TYPE_CONTROLLER_URL)
//                        .servletPath(APP_URL)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(accountTransactionToBeCreated)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andReturn();
//
//        verify(createAccountTransactionFlow, times(1)).create("MILES", 1L, 200L, LocalDate.parse("2020-10-08"));
//        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }
}