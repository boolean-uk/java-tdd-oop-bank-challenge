```
As a customer,
So I can safely store and use my money,
I want to create a current account.

As a customer,
So I can save for a rainy day,
I want to create a savings account.

As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```

| Class    | Members                       | Method                       | Scenario                           | Outcome                             |
|----------|-------------------------------|------------------------------|------------------------------------|-------------------------------------|
| Customer | UUID uuid                     | Boolean openCurrentAccount() | Create current account             | true                                |
|          | CurrentAccount currentAccount |                              | Current account is already created | BankAccountAlreadyExistsException() |
|          | SavingAccount savingAccount   | Boolean openSavingAccount()  | Create saving account              | true                                |
|          |                               |                              | Saving account is already created  | Create current account              |
|          |                               | void changeEmergencyFund()   | Change emergency fund value        |                                     |

| Class       | Members                                   | Method                                                                   | Scenario                                                   | Outcome                                         |
|-------------|-------------------------------------------|--------------------------------------------------------------------------|------------------------------------------------------------|-------------------------------------------------|
| BankAccount | UUID uuid                                 |                                                                          |                                                            |                                                 |
|             | BigDecimal balance                        |                                                                          |                                                            |                                                 |
|             | List<BankTransactionDetails> transactions |                                                                          |                                                            |                                                 |
|             |                                           | BankTransactionDetails depositCurrentAccount(BigDecimal depositAmount)   | Deposit amount to current account success                  | Increase balance, return BankTransactionDetails |
|             |                                           |                                                                          | Deposit amount to current account failed                   | return BankTransactionDetails with reason       |
|             |                                           | BankTransactionDetails depositSavingAccount(BigDecimal depositAmount)    | Deposit amount to saving account success                   | Increase balance, return BankTransactionDetails |
|             |                                           |                                                                          | Deposit amount to saving account failed                    | return BankTransactionDetails with reason       |
|             |                                           | BankTransactionDetails withdrawCurrentAccount(BigDecimal withdrawAmount) | Withdraw amount to current account success                 | Decrease balance, return BankTransactionDetails |
|             |                                           |                                                                          | Decrease amount to current account failed                  | return BankTransactionDetails with reason       |
|             |                                           | BankTransactionDetails withdrawSavingAccount(BigDecimal withdrawAmount)  | Withdraw amount to saving account success                  | Decrease balance, return BankTransactionDetails |
|             |                                           |                                                                          | Decrease amount to saving account failed                   | return BankTransactionDetails with reason       |
|             |                                           | String generateCurrentAccountStatements()                                | Get all current account transactions and put inside report | Formatted String                                |
|             |                                           | String generateSavingAccountStatements()                                 | Get all saving account transactions and put inside report  | Formatted String                                |


| Class              | Members                             | Method | Scenario | Outcome |
|--------------------|-------------------------------------|--------|----------|---------|
| TransactionDetails | TransactionType transactionType     |        |          |         |
|                    | TransactionResult transactionResult |        |          |         |
|                    | BigDecimal balanceBefore            |        |          |         |
|                    | BigDecimal amount                   |        |          |         |
|                    | BigDecimal balanceAfter             |        |          |         |
|                    | Instant createdAt                   |        |          |         |
