| Classes        | Attribute                     | Methods                    | Scenario                                                | Output             |
|----------------|-------------------------------|----------------------------|---------------------------------------------------------|--------------------|
| Account        | String name                   |                            |                                                         |                    |
|                | String accountNumber          |                            |                                                         |                    |
|                | double balance                |                            |                                                         |                    |
|                | List<Trasaction> transactions |                            |                                                         |                    |
|                | BankBranch bankBranch         |                            |                                                         |                    |
|                | Random random                 |                            |                                                         |                    |
|                |                               | generateStatement()        | user wants to generate account history                  | String             |
|                |                               | getBankBranch()            | user wants to get account Bank branch                   | BankBranch         |
|                |                               | getBalance()               | User wants to get account balance                       | double balance     |
|                |                               | setBalance(double balance) | Transaction sets balance after deposit/withdraw         | void               |
|                |                               | getTransactions()          | user wants to get list of transactions                  | List<transactions> |
| BankBranch     | different bank branches       |                            |                                                         |                    |
| CurrentAccount |                               |                            |                                                         |                    |
| SavingAccount  |                               |                            |                                                         |                    |
| Transaction    | Account account               | deposit(double amount)     | user wants to deposit money into account                | void               |
|                | LocalDate localDate           | getLocalDateFormatted()    | user wants to get transaction date                      | String             |
|                | double deposit                | withdraw(double amount)    | user wants to withdraw money from account               | void               |
|                | double withdraw               | getDeposit()               | user wants to get amount of deposit in transaction      | double             |
|                | double balance                | getWithdraw()              | user wants to get amount of withdraw money from account | double             |
|                |                               | getBalance()               | user wants to get account balance                       | double             |
|                |                               |                            |                                                         |                    |
