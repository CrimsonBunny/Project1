package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "AccountTest")
public class AccountTransaction implements Serializable {

    private static final long serialversionUID = -1420294317019175746L;

    private Long accountID;
    private AccountType accountType;
    private String memberID;
    private LocalDate amount;
    private LocalDate transactionDate;

    public AccountTransaction(Long accountID, AccountType accountType, String memberID, LocalDate amount, LocalDate transactionDate) {
        this.accountID = accountID;
        this.accountType = accountType;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {
    }

    @Id
    @SequenceGenerator(name = "GenericSequence", sequenceName = "AccountSystemGenericSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GenericSequence")
    @Column(name = "AccountID")
    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountTypeID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Column(name = "MemberID")
    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    @Column(name = "Amount")
    public LocalDate getAmount() {
        return amount;
    }

    public void setAmount(LocalDate amount) {
        this.amount = amount;
    }

    @Column(name = "TX_DATE")
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
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(accountID, that.accountID) && Objects.equals(accountType, that.accountType) && Objects.equals(memberID, that.memberID) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, accountType, memberID, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountID=" + accountID +
                ", accountTypeID='" + accountType + '\'' +
                ", memberID='" + memberID + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
