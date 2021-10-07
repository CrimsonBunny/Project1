package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.time.LocalDate;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDto(" +
            "       at.mnemonic," +
            "       at.accountTypeName," +
            "       at.creationDate )" +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic ")
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    @Modifying
    @Query(value = "DELETE " +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic ")
    void deleteAccountTypeDtoByMnemonic(String mnemonic);

    @Modifying
    @Query(value = "UPDATE " +
            "       Account_Type" +
            "   SET " +
            "       Account_Type_Name = :newAccountName, "+
            "       Creation_Date = :newCreationDate  " +
            "   WHERE Mnemonic = :mnemonic", nativeQuery = true)
    void updateAccountTypeDtoByMnemonic(String mnemonic, String newAccountName, LocalDate newCreationDate);
}
