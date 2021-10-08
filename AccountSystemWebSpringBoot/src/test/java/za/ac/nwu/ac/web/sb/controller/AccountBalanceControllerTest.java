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
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.CreateAccountBalanceFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountBalanceFlow;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountBalanceControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_TYPE_CONTROLLER_URL = APP_URL + "/account-transaction";

    @Mock
    private CreateAccountBalanceFlow createAccountBalanceFlow;

    @Mock
    private FetchAccountBalanceFlow fetchAccountBalanceFlow;

    @InjectMocks
    private AccountBalanceController controller;

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
//        String accountBalanceToBeCreated = "{\"memberID\":1,\"mnemonic\":\"MILES\",\"balance\":400},";
//        String expectedResponse = "{\"successful\":true,\"payload\":" +
//                "{\"memberID\":1,\"mnemonic\":\"MILES\",\"balance\":400}}";
//
//        AccountBalanceDto accountBalance = new AccountBalanceDto(1L, "MILES", 400L);
//
//        when(createAccountBalanceFlow.create(eq(accountBalance))).then(returnsFirstArg());
//
//        MvcResult mvcResult = mockMvc.perform(post(ACCOUNT_TYPE_CONTROLLER_URL)
//                        .servletPath(APP_URL)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(accountBalanceToBeCreated)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andReturn();
//
//        verify(createAccountBalanceFlow, times(1)).create(eq(accountBalance));
//        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getBalance() throws Exception {
//        String expectedResponse = "{\"successful\":true,\"payload\":" +
//                "{\"memberID\":1,\"mnemonic\":\"MILES\",\"balance\":400}}";
//
//        AccountBalanceDto accountBalance = new AccountBalanceDto(1L, "MILES", 400L);
//
//        when(fetchAccountBalanceFlow.getAccountBalanceByMnemonic(1L, "MILES")).thenReturn(accountBalance);
//
//        MvcResult mvcResult = mockMvc.perform(post(ACCOUNT_TYPE_CONTROLLER_URL)
//                        .servletPath(APP_URL)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andReturn();
//
//        verify(fetchAccountBalanceFlow, times(1)).getAccountBalanceByMnemonic(1L, "MILES");
//        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }
}