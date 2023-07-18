# Domain model
## Bank challenge

| Classes                            | Attributes                      | Methods                                           | Scenario                                                        | Outcomes      |
|------------------------------------|---------------------------------|---------------------------------------------------|-----------------------------------------------------------------|---------------|
| BankAccount                        | double balance                  | deposit(double amount):boolean                    | deposit done correctly,transaction added to transactions list   | true          |
|                                    | long accountNumber              |                                                   | deposit done incorrectly                                        | false         |
|                                    | List<Transaction> transactions  | withdraw(double amount):boolean                   | withdraw done correctly, transaction added to transactions list | true          |
|                                    | String branch                   |                                                   | withdraw done incorrectly                                       | false         |
|                                    |                                 | generateStatement(): StringBuilder                | generates bank statement                                        | StringBuilder |
|                                    |                                 |                                                   |                                                                 |               |
| NormalAccount expends BankAccount  | double balance                  | deposit(double amount):boolean                    | deposit done correctly,transaction added to transactions list   | true          |
|                                    | long accountNumber              |                                                   | deposit done incorrectly                                        | false         |
|                                    | List<Transaction> transactions  | withdraw(double amount):boolean                   | withdraw done correctly,transaction added to transactions list  | true          |
|                                    | double debit =500               |                                                   | withdraw done incorrectly                                       | false         |
|                                    |                                 | generateStatement(): StringBuilder                | generates bank statement                                        | StringBuilder |
|                                    |                                 | withdrawFromDebit(double amount):boolean          | if debit >0 && debit>amount                                     | true          |
|                                    |                                 |                                                   | else                                                            | false         |
|                                    |                                 |                                                   |                                                                 |               |
| SavingsAccount expends BankAccount | double balance                  | deposit(double amount):boolean                    | deposit done correctly, transaction added to transactions list  | true          |
|                                    | long accountNumber              |                                                   | deposit done incorrectly                                        | false         |
|                                    | List<Transaction> transactions  | withdraw(double amount):boolean                   | withdraw done correctly, transaction added to transactions list | true          |
|                                    |                                 |                                                   | withdraw done incorrectly                                       | false         |
|                                    |                                 | generateStatement(): StringBuilder                | generates bank statement                                        | StringBuilder |
|                                    |                                 |                                                   |                                                                 |               |
| Customer                           | NormalAccount normalAccount     |                                                   |                                                                 |               |
|                                    | SavingsAccount savingsAccount   |                                                   |                                                                 |               |
|                                    | String fullName                 |                                                   |                                                                 |               |
|                                    |                                 |                                                   |                                                                 |               |
| Transaction                        | LocalDate date                  |                                                   |                                                                 |               |
|                                    | double amount                   |                                                   |                                                                 |               |
|                                    | TransactionType transactionType |                                                   |                                                                 |               |
|                                    | double balance                  |                                                   |                                                                 |               |
| TransactionType                    | credit,debit                    |                                                   |                                                                 |               |
|                                    |                                 |                                                   |                                                                 |               |
| Engineer                           | String fullName                 | getAccountBalance(BankAccount bankAccount):double | calculates account balance using only transactions              | double        |
|                                    |                                 |                                                   |                                                                 |               |

