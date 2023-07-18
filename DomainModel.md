
# Domain Model

| Classes         | Methods                                      | Fields                                                | Scenario                                | Output                     |
|-----------------|----------------------------------------------|-------------------------------------------------------|-----------------------------------------|----------------------------|
| Account         | deposit(amount: double)                      | List<Transaction> transactions                        | deposit funds                           | prints message             |
|                 | getBalance()                                 | String branchID                                       | get current balance                     | double balance             |
|                 |                                              | String accountNumber                                  |                                         |                            |
|                 |                                              | User owner                                            |                                         |                            |
|                 |                                              | User manager                                          |                                         |                            |
|                 |                                              |                                                       |                                         |                            |
|                 |                                              |                                                       |                                         |                            |
| User            | sendRequest(Request)                         | String name                                           |                                         |                            |
|                 | approveRequest(Request)                      | boolean isManager                                     | true if approved, false if not approved | boolean                    |
|                 | generateStatement()                          | boolean isEngineer                                    | generate bank statement                 |                            |
|                 | printStatement()                             |                                                       | printsStatement                         |                            |
|                 |                                              |                                                       |                                         |                            |
| CurrentAccount  | withdraw(amount: double)                     |                                                       | withdraw funds                          |                            |
|                 | wire(amount: double, accountNumber: String)  |                                                       | wires funds                             |                            |
| SavingsAccount  |                                              | int percentage                                        |                                         |                            |
| Transaction     |                                              | double amount, LocalDate date                         |                                         |                            |
|                 |                                              | TransactionType type                                  |                                         |                            |
|                 |                                              |                                                       |                                         |                            |
| BankStatement   |                                              | Map<String,List<Transaction> transactions, User owner |                                         | String formatted statement |
|                 |                                              |                                                       |                                         |                            |
| Bank            | getBranchAccounts(branchId: String)          | List<Account> accounts                                | get all accounts associated with        | List<Account> accounts     |
|                 | getAccount(accountNumber: String)            |                                                       | get account by account ID               | Account object             |
|                 | createAccount(String name,boolean isSasving) |                                                       | creates account                         |                            |
|                 |                                              |                                                       |                                         |                            |
|                 |                                              |                                                       |                                         |                            |
| TransactionType |                                              |                                                       |                                         |                            |
|                 |                                              |                                                       |                                         |                            |
| Request         |                                              | User user                                             |                                         |                            |
|                 |                                              | double amount                                         |                                         |                            |
|                 |                                              | Account account                                       |                                         |                            |

