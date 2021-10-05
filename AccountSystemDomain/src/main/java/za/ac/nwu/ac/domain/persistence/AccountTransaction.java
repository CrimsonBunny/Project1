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
    private AccountBalance accountBalance;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction(Long Transaction_ID, AccountType accountType, AccountBalance accountBalance, Long amount, LocalDate transactionDate) {
        this.Transaction_ID = Transaction_ID;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {
    }

    public AccountTransaction(AccountType accountType, AccountBalance accountBalance, Long amount, LocalDate transactionDate) {
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "GenericSequence", sequenceName = "AS_Generic_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GenericSequence")
    @Column(name = "Transaction_ID")
    public Long getTransaction_ID() {
        return Transaction_ID;
    }

    public void setTransaction_ID(Long accountID) {
        this.Transaction_ID = accountID;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "AccountTypeID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "BalanceID")
    public AccountBalance getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(AccountBalance accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Column(name = "Amount")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "transactionDate")
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
        return Objects.equals(Transaction_ID, that.Transaction_ID) && Objects.equals(accountType, that.accountType) && Objects.equals(accountBalance, that.accountBalance) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Transaction_ID, accountType, accountBalance, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "Transaction_ID=" + Transaction_ID +
                ", accountType=" + accountType +
                ", accountBalance=" + accountBalance +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
