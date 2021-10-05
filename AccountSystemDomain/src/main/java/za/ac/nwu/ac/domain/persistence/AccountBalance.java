package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "AccountBalance")
public class AccountBalance implements Serializable {

    private static final long serialVersionUID = 8304323850814087170L;

    private Long memberID;
    private AccountType accountType;
    private Long balance;

    public AccountBalance() {
    }

    public AccountBalance(Long memberID, AccountType accountType, Long balance) {
        this.memberID = memberID;
        this.accountType = accountType;
        this.balance = balance;
    }

    public AccountBalance(AccountType accountType, Long balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    @Id
    @SequenceGenerator(name = "Bal_Seq", sequenceName = "AS_Balance_Seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AS_Balance_Seq")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountBalance that = (AccountBalance) o;
        return Objects.equals(memberID, that.memberID) && Objects.equals(accountType, that.accountType) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, accountType, balance);
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "memberID=" + memberID +
                ", accountTypeID=" + accountType +
                ", amount=" + balance +
                '}';
    }
}
