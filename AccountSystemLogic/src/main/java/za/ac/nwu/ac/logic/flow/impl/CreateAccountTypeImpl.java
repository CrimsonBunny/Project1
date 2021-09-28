package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeImpl implements CreateAccountTypeFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTypeImpl.class);

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType) {
        if(LOGGER.isInfoEnabled()) {
            String outputForLogging = "null";
            if((null != accountType) && (null != accountType.getCreationDate())) {
                outputForLogging = accountType.getCreationDate().toString();
            }
            LOGGER.info("The input object was {} and the creation date is {}", accountType, outputForLogging);
        }

        if (null == accountType.getCreationDate()) {
            accountType.setCreationDate(LocalDate.now());
        }
        AccountTypeDto result = accountTypeTranslator.create(accountType);
        LOGGER.info("The return object is {}", result);
        return result;
    }
}
