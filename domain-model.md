## Account

| Class   | Attributes                             | Methods                                                           | Scenario                                          | Output     |
|---------|----------------------------------------|-------------------------------------------------------------------|---------------------------------------------------|------------|
| Account | transactionHistory: List<Transactions> | openAccount()                                                     |                                                   | void       |
|         |                                        | createAccountNumber()                                             |                                                   | void       |
|         |                                        | getBankStatement()                                                | user wants to generate bank statement             | String     |
|         |                                        | printBankStatement()                                              |                                                   | void       |
|         |                                        | deposit(BigDecimal: amount)                                       | user can deposit money                            | void       |
|         |                                        | withdraw(BigDecimal: amount)                                      | user can withdraw money                           | void       |
|         |                                        | createTransaction(BigDecimal: amount, type: TRANSACTION_TYPE)     |                                                   | void       |
|         |                                        | getBalance()                                                      | user can get account balance                      | BigDecimal |
|         |                                        | getBalance(Transaction: transaction, BigDecimal: previousBalance) | helper method                                     | BigDecimal |
|         |                                        | requestOverdraft(BigDecimal: amount)                              | user can request for an overdraft amount of money | void       |

## CurrentAccount extends Account

## SavingsAccount extends Account

## Bank

| Class | Attributes                  | Methods                                             | Scenarios | Output |
|-------|-----------------------------|-----------------------------------------------------|-----------|--------|
| Bank  | BANK_NAMES: bankName        | addBranch(Branch: branch, BankManager: bankManager) |           |        |
|       | ArrayList<Branch>: branches |                                                     |           |        |
|       | BankManager : bankManager   |                                                     |           |        |

## BankManager

| Class       | Attributes      | Methods                                                                    | Scenarios                               | Output |
|-------------|-----------------|----------------------------------------------------------------------------|-----------------------------------------|--------|
| BankManager | String: name    | processOverdraftRequest(OverdraftRequest: request, OVERDRAFT_STATE: state) | a bank manager can change request state | void   |
|             | String: surname |                                                                            |                                         |        |

## Branch

| Class  | Attributes                     | Methods                         | Scenarios | Output |
|--------|--------------------------------|---------------------------------|-----------|--------|
| Branch | String: branchCode             | addCustomer(Customer: Customer) |           |        |
|        | String: country                |                                 |           |        |
|        | String: town                   |                                 |           |        |
|        | ArrayList<Cutomer> : customers |                                 |           |        |

## Transaction

| Class       | Attributes             | Methods | Scenarios | Output |
|-------------|------------------------|---------|-----------|--------|
| Transaction | LocaleDate: date       |         |           |        |
|             | TRANSACTION_TYPE: type |         |           |        |
|             | BigDecimal: amount     |         |           |        |
|             | Account: account       |         |           |        |

## Customer

| Class    | Attributes                    | Methods                             | Scenarios | Output |
|----------|-------------------------------|-------------------------------------|-----------|--------|
| Customer | String: ID                    | generateCustomRandomID(int: length) |           | String |
|          | String: name                  |                                     |           |        |
|          | String: surname               |                                     |           |        |
|          | LocaleDate: dateOfBirth       |                                     |           |        |
|          | ArrayList<Account> : accounts |                                     |           |        |

## OverdraftRequest

| Class            | Attributes                    | Methods | Scenarios | Output |
|------------------|-------------------------------|---------|-----------|--------|
| OverdraftRequest | Account: account              |         |           |        |
|                  | OVERDRAFT_STATE: requestState |         |           |        |
|                  | BigDecimal: amount            |         |           |        |
