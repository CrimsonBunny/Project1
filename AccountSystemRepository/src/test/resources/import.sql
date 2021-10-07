insert into account_type (ACCOUNT_TYPEID, MNEMONIC, ACCOUNT_TYPE_NAME, CREATION_DATE) values (1, 'MILES', 'Miles', '2021-10-07');
insert into account_type (ACCOUNT_TYPEID, MNEMONIC, ACCOUNT_TYPE_NAME, CREATION_DATE) values (2, 'PLAY', 'Game Play', '2021-03-01');
insert into account_balance (BalanceID, MemberID, Account_TypeID, Balance) values (1, 1, 1, 500);
insert into account_transaction (Transaction_ID, Account_TypeID, BalanceID, AMOUNT, Transaction_Date) values (1, 1, 1, 200, '2021-10-07');