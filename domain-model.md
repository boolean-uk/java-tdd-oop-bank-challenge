## Account

| Class   | Attributes                             | Methods                                                       | Scenario                              | Output |
|---------|----------------------------------------|---------------------------------------------------------------|---------------------------------------|--------|
| Account | transactionHistory: List<Transactions> | openAccount()                                                 |                                       | void   |
|         |                                        | createAccountNumber()                                         |                                       | void   |
|         |                                        | getBankStatement()                                            | user wants to generate bank statement | String |
|         |                                        | printBankStatement()                                          |                                       | void   |
|         |                                        | deposit(BigDecimal: amount)                                   | user can deposit money                | void   |
|         |                                        | withdraw(BigDecimal: amount)                                  | user can withdraw money               | void   |
|         |                                        | createTransaction(BigDecimal: amount, type: TRANSACTION_TYPE) |                                       | void   |

## CurrentAccount extends Account

## SavingsAccount extends Account

## Transaction

| Class       | Attributes             | Methods | Scenarios | Output |
|-------------|------------------------|---------|-----------|--------|
| Transaction | LocaleDate: date       |         |           |        |
|             | TRANSACTION_TYPE: type |         |           |        |
|             | BigDecimal: amount     |         |           |        |
|             | Account: account       |         |           |        |

## Customer

| Class    | Attributes             | Methods                               | Scenarios | Output |
|----------|------------------------|---------------------------------------|-----------|--------|
| Customer | List<Account> accounts | addAccount(AccountType: ACCOUNT_TYPE) |           | void   |
|          | customerCardNumber     |                                       |           |        |
|          |                        |                                       |           |        |


## Bank

| Class | Attributes | Methods                                                   | Scenarios                                            | Output |
|-------|------------|-----------------------------------------------------------|------------------------------------------------------|--------|
| Bank  |            | createAccount(Customer customer, AccountType accountType) | customer creates a new bank account of selected type |        |
|       |            |                                                           |                                                      |        |
|       |            |                                                           |                                                      |        |
