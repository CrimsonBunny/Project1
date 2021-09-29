package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTransactionDto(" +
            "       at.accountType," +
            "       at.memberID," +
            "       at.amount, " +
            "       at.transactionDate )" +
            "   FROM " +
            "       AccountTransaction at" +
            "   WHERE at.memberID = :memberID AND at.accountType = :accountType")
    AccountTransactionDto getTransactionByMnemonic(Long memberID, AccountTypeDto accountType);
}
