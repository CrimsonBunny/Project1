package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.persistence.AccountBalance;
import za.ac.nwu.ac.domain.persistence.AccountType;

@Repository
public interface AccountBalanceRepository extends JpaRepository<AccountBalance, Long> {

    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountBalance at" +
            "   WHERE at.memberID = :memberID AND at.accountType = :accountType")
    AccountBalance getAccountBalanceByMemberID(Long memberID, AccountType accountType);

    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountBalance at" +
            "   WHERE at.memberID = :memberID AND at.accountType = :accountType")
    AccountBalanceDto getAccountBalanceDtoByMemberID(Long memberID, AccountType accountType);

    @Modifying
    @Query(value = "UPDATE " +
            "       AccountBalance at" +
            "   SET " +
            "       at.balance = balance + :amount" +
            "   WHERE at.memberID = :memberID AND at.accountType = :accountType")
    void addAccountBalance(Long memberID, AccountType accountType, Long amount);
}
