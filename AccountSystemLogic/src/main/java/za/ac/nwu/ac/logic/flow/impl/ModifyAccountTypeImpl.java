package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.ModifyAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
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
        if(null == newCreationDate) {
            newCreationDate = LocalDate.now();
        }
        return accountTypeTranslator.update(mnemonic, newAccountName, newCreationDate);
    }
}
