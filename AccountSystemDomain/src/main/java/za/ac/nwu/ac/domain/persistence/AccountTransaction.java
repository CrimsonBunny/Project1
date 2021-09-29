package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "AccountTransaction")
public class AccountTransaction implements Serializable {

    private static final long serialversionUID = -1420294317019175746L;

    private Long Transaction_ID;
    private AccountType accountType;
    private String memberID;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction(Long Transaction_ID, AccountType accountType, String memberID, Long amount, LocalDate transactionDate) {
        this.Transaction_ID = Transaction_ID;
        this.accountType = accountType;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {
    }

    public AccountTransaction(AccountType accountType, String memberID, Long amount, LocalDate transactionDate) {
        this.accountType = accountType;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "GenericSequence", sequenceName = "AccountSystemGenericSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GenericSequence")
    @Column(name = "AccountID")
    public Long getTransaction_ID() {
        return Transaction_ID;
    }

    public void setTransaction_ID(Long accountID) {
        this.Transaction_ID = accountID;
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
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
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
        return Objects.equals(Transaction_ID, that.Transaction_ID) && Objects.equals(accountType, that.accountType) && Objects.equals(memberID, that.memberID) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Transaction_ID, accountType, memberID, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountID=" + Transaction_ID +
                ", accountTypeID='" + accountType + '\'' +
                ", memberID='" + memberID + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
