package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "AccountBalance")
public class AccountBalance implements Serializable {

    private static final long serialVersionUID = 8304323850814087170L;

    private Long balanceID;
    private Long memberID;
    private AccountType accountType;
    private Long balance;

    private Set<AccountTransaction> accountTransactions;

    public AccountBalance() {
    }

    public AccountBalance(Long balanceID, Long memberID, AccountType accountType, Long balance) {
        this.balanceID = balanceID;
        this.memberID = memberID;
        this.accountType = accountType;
        this.balance = balance;
    }

    public AccountBalance(Long memberID, AccountType accountType, Long balance) {
        this.memberID = memberID;
        this.accountType = accountType;
        this.balance = balance;
    }

    @Id
    @SequenceGenerator(name = "Bal_Seq", sequenceName = "AS_Balance_Seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AS_Balance_Seq")
    @Column(name = "BalanceID")
    public Long getBalanceID() {
        return balanceID;
    }

    public void setBalanceID(Long balanceID) {
        this.balanceID = balanceID;
    }

    @Column(name = "MemberID")
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "AccountTypeID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Column(name = "Balance")
    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountBalance", cascade = CascadeType.ALL)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountBalance that = (AccountBalance) o;
        return Objects.equals(balanceID, that.balanceID) && Objects.equals(memberID, that.memberID) && Objects.equals(accountType, that.accountType) && Objects.equals(balance, that.balance) && Objects.equals(accountTransactions, that.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceID, memberID, accountType, balance, accountTransactions);
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "balanceID=" + balanceID +
                ", memberID=" + memberID +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}
