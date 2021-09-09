package za.ac.nwu.ac.logic.flow.impl;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.ModifyAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;

public class ModifyAccountTypeImpl implements ModifyAccountTypeFlow {
    private final AccountTypeTranslator accountTypeTranslator;

    public ModifyAccountTypeImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto deleteAccountTypeByMnemonic(String mnemonic) {
        return accountTypeTranslator.delete(mnemonic);
    }

    @Override
    public AccountTypeDto updateAccountType(String mnemonic, String newAccountName, LocalDate newCreationDate) {
        return accountTypeTranslator.update(mnemonic, newAccountName, newCreationDate);
    }
}
