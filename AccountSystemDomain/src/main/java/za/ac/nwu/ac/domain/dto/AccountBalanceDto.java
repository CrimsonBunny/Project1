package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountBalance;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "AccountBalance", description = "A DTO that represents the AccountBalance")
public class AccountBalanceDto implements Serializable {

    private static final long serialVersionUID = 5885539458265992212L;

    private String mnemonic;
    private Long balance;

    public AccountBalanceDto() {
    }

    public AccountBalanceDto(String mnemonic, Long balance) {
        this.mnemonic = mnemonic;
        this.balance = balance;
    }

    public AccountBalanceDto(AccountBalance accountBalance) {
        this.setMnemonic(accountBalance.getAccountType().getMnemonic());
        this.setBalance(accountBalance.getBalance());
    }

    @ApiModelProperty(position = 1,
            value = "AccountType",
            name = "AccountType",
            notes = "Gets an accountType",
            dataType = "accountType",
            example = "MILES",
            required = true)
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(position = 2,
            value = "AccountBalance Balance",
            name = "Balance",
            notes = "The total amount of currency a member has in their account",
            dataType = "java.lang.Long",
            example = "200",
            required = true)
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
        AccountBalanceDto that = (AccountBalanceDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(balance, that.balance);
    }

    @JsonIgnore
    public AccountBalance getAccountBalance(AccountType accountType) {
        return new AccountBalance(accountType, getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, balance);
    }

    @Override
    public String toString() {
        return "AccountBalanceDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", balance=" + balance +
                '}';
    }
}
