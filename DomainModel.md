
# Domain Model

| Classes         | Methods                                   | Fields                                 | Scenario                              | Output                                   |
|-----------------|-------------------------------------------|----------------------------------------|---------------------------------------|------------------------------------------|
| Account         | deposit(amount: double)                   | double balance                         | deposit funds                         |                                          |
|                 | withdraw(amount: double)                  |                                        | withdraw funds                        |                                          |
|                 | getBalance()                              |                                        | get current balance                   | double balance                           |
|                 |                                           |                                        |                                       |                                          |
| CurrentAccount  |                                           |                                        |                                       |                                          |
| SavingsAccount  |                                           |                                        |                                       |                                          |
| Transaction     |                                           | double amount, LocalDate date          |                                       |                                          |
|                 |                                           | TransactionType type                   |                                       |                                          |
|                 |                                           |                                        |                                       |                                          |
| BankStatement   | generateStatement()                       | List<Transaction> transactions         | generate bank statement               | String formatted statement               |
|                 |                                           |                                        |                                       |                                          |
| Bank            | createAccount(accountType: AccountType)   | List<Account> accounts                 | create a new account                  | Account created                          |
|                 | getAccount(accountId: String)             |                                        | get account by account ID             | Account object                           |
|                 | getBranchAccounts(branchId: String)       |                                        | get all accounts associated with      | List<Account> accounts                   |
|                 |                                           |                                        | a specific branch                     |                                          |
|                 |                                           |                                        |                                       |                                          |
| TransactionType |                                           |                                        |                                       |                                          |
|                 |                                           |                                        |                                       |                                          |

