package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
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
            "   WHERE at.memberID = :memberID ")
    AccountBalance getAccountBalanceByMemberID(Long memberID);

    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountBalance at" +
            "   WHERE at.memberID = :memberID AND at.accountType = :accountType")
    AccountBalanceDto getAccountBalanceDtoByMemberID(Long memberID, AccountType accountType);
}
