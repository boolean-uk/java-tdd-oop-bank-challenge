
# Domain Model

| Classes         | Methods                                     | Fields                                                | Scenario                                | Output                     |
|-----------------|---------------------------------------------|-------------------------------------------------------|-----------------------------------------|----------------------------|
| Account         | deposit(amount: double)                     | List<Transaction> transactions                        | deposit funds                           | prints message             |
|                 | getBalance()                                | String branchID                                       | get current balance                     | double balance             |
|                 |                                             | String accountNumber                                  |                                         |                            |
|                 |                                             | User owner                                            |                                         |                            |
|                 |                                             | User manager                                          |                                         |                            |
|                 |                                             |                                                       |                                         |                            |
|                 |                                             |                                                       |                                         |                            |
| User            | sendRequest(Request)                        | String name                                           |                                         |                            |
|                 | approveRequest(Request)                     | boolean isManager                                     | true if approved, false if not approved | boolean                    |
|                 |                                             | boolean isEngineer                                    |                                         |                            |
|                 |                                             |                                                       |                                         |                            |
|                 |                                             |                                                       |                                         |                            |
| CurrentAccount  | withdraw(amount: double)                    |                                                       | withdraw funds                          |                            |
|                 | wire(amount: double, accountNumber: String) |                                                       | wires funds                             |                            |
| SavingsAccount  |                                             | int percentage                                        |                                         |                            |
| Transaction     |                                             | double amount, LocalDate date                         |                                         |                            |
|                 |                                             | TransactionType type                                  |                                         |                            |
|                 |                                             |                                                       |                                         |                            |
| BankStatement   | generateStatement()                         | Map<String,List<Transaction> transactions, User owner | generate bank statement                 | String formatted statement |
|                 |                                             |                                                       |                                         |                            |
| Bank            | createAccount(Account account)              | List<Account> accounts                                | create a new account                    | Account created            |
|                 | getAccount(accountNumber: String)           |                                                       | get account by account ID               | Account object             |
|                 | getBranchAccounts(branchId: String)         |                                                       | get all accounts associated with        | List<Account> accounts     |
|                 |                                             |                                                       | a specific branch                       |                            |
|                 |                                             |                                                       |                                         |                            |
| TransactionType |                                             |                                                       |                                         |                            |
|                 |                                             |                                                       |                                         |                            |
| Request         |                                             | User user                                             |                                         |                            |
|                 |                                             | double amount                                         |                                         |                            |
|                 |                                             | Account account                                       |                                         |                            |

