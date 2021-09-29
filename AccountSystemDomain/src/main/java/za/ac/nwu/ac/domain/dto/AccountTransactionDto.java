package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -7819344808062462808L;

    private AccountType accountType;
    private String memberID;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(AccountType accountType, String memberID, Long amount, LocalDate transactionDate) {
        this.accountType = accountType;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.setAccountType(accountTransaction.getAccountType());
        this.setMemberID(accountTransaction.getMemberID());
        this.setAmount(accountTransaction.getAmount());
        this.setTransactionDate(accountTransaction.getTransactionDate());
    }

    @ApiModelProperty(position = 1,
            value = "AccountType",
            name = "AccountType",
            notes = "Gets an accountType",
            dataType = "accountType",
            example = "MILES",
            required = true)
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @ApiModelProperty(position = 2,
            value = "Member ID",
            name = "Member ID",
            notes = "Id of the member who owns the account",
            dataType = "java.lang.Long",
            example = "81264598",
            required = true)
    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    @ApiModelProperty(position = 3,
            value = "AccountTransaction Amount",
            name = "Amount",
            notes = "The amount of currency added or removed in the transaction",
            dataType = "java.lang.Long",
            example = "200",
            required = true)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @ApiModelProperty(position = 4,
            value = "AccountTransaction Date",
            name = "Transaction Date",
            notes = "The date the transaction happened",
            dataType = "java.lang.Date",
            example = "2021-06-09",
            allowEmptyValue = true)
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(accountType, that.accountType) && Objects.equals(memberID, that.memberID) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction() {
        return new AccountTransaction(getAccountType(), getMemberID(), getAmount(), getTransactionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, memberID, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountType=" + accountType +
                ", memberID='" + memberID + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
