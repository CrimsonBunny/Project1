package za.ac.nwu.ac.repo.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.persistence.AccountBalance;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.config.RepositoryTestConfig;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class})
public class AccountBalanceRepositoryTest {

    @Autowired
    AccountBalanceRepository accountBalanceRepository;

    @Mock
    AccountType accountType;

    @Mock
    AccountBalance accountBalance;

    @Before
    public void setUp() throws Exception {
        accountType = new AccountType();
        accountBalance = new AccountBalance();
    }

    @After
    public void tearDown() throws Exception {
        accountType = null;
        accountBalance = null;
    }

    @Test
    public void getAccountBalanceByMemberIDMiles() {
        accountType = new AccountType(1L, "MILES", "Miles", LocalDate.parse("2021-10-07"));
        AccountBalance balance = accountBalanceRepository.getAccountBalanceByMemberID(1L, accountType);
        assertNotNull(balance);
        assertEquals((Long)500L, balance.getBalance());
    }

    @Test
    public void getAccountBalanceByMemberIDPlays() {
        accountType = new AccountType(1L, "MILES", "Miles", LocalDate.parse("2021-10-07"));
        AccountBalance balance = accountBalanceRepository.getAccountBalanceByMemberID(2L, accountType);
        assertNull(balance);
    }

    @Test
    public void getAccountBalanceDtoByMemberIDMiles() {
        accountType = new AccountType(1L, "MILES", "Miles", LocalDate.parse("2021-10-07"));
        AccountBalanceDto balance = accountBalanceRepository.getAccountBalanceDtoByMemberID(1L, accountType);
        assertNotNull(balance);
        assertEquals((Long)500L, balance.getBalance());
    }

    @Test
    public void getAccountBalanceDtoByMemberIDPlays() {
        accountType = new AccountType(1L, "MILES", "Miles", LocalDate.parse("2021-10-07"));
        AccountBalanceDto balance = accountBalanceRepository.getAccountBalanceDtoByMemberID(2L, accountType);
        assertNull(balance);
    }

    @Test
    public void addAccountBalance() {
        accountType = new AccountType(1L, "MILES", "Miles", LocalDate.parse("2021-10-07"));
        accountBalanceRepository.addAccountBalance(1L, accountType, 200L);
        AccountBalance accountBalance = accountBalanceRepository.getAccountBalanceByMemberID(1L, accountType);
        assertEquals((Long)700L, accountBalance.getBalance());
    }

    @Test
    public void subtractAccountBalance() {
        accountType = new AccountType(1L, "MILES", "Miles", LocalDate.parse("2021-10-07"));
        accountBalanceRepository.addAccountBalance(1L, accountType, -200L);
        AccountBalance accountBalance = accountBalanceRepository.getAccountBalanceByMemberID(1L, accountType);
        assertEquals((Long)300L, accountBalance.getBalance());
    }
}