package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;

import javax.transaction.Transactional;

@Transactional
@Component
public class FetchAccountTransactionImpl implements FetchAccountTransactionFlow {
}
