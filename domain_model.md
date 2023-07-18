# Domain model
## Bank challenge

| Classes                            | Attributes                     | Methods                                  | Scenario                    | Outcomes   |
|------------------------------------|--------------------------------|------------------------------------------|-----------------------------|------------|
| BankAccount                        | double balance                 | deposit(double amount):boolean           | deposit done correctly      | true       |
|                                    | long accountNumber             |                                          | deposit done incorrectly    | false      |
|                                    | List<Transaction>              | withdraw(double amount):boolean          | withdraw done correctly     | true       |
|                                    |                                |                                          | withdraw done incorrectly   | false      |
|                                    |                                | generateStatement(): void                | generates bank statement    | void       |
|                                    |                                |                                          |                             |            |
| NormalAccount expends BankAccount  | double balance                 | deposit(double amount):boolean           | deposit done correctly      | true       |
|                                    | long accountNumber             |                                          | deposit done incorrectly    | false      |
|                                    | List<Transaction> transactions | withdraw(double amount):boolean          | withdraw done correctly     | true       |
|                                    | double debit =500              |                                          | withdraw done incorrectly   | false      |
|                                    |                                | generateStatement(): void                | generates bank statement    | void       |
|                                    |                                | withdrawFromDebit(double amount):boolean | if debit >0 && debit>amount | true       |
|                                    |                                |                                          | else                        | false      |
|                                    |                                |                                          |                             |            |
| SavingsAccount expends BankAccount | double balance                 | deposit(double amount):boolean           | deposit done correctly      | true       |
|                                    | long accountNumber             |                                          | deposit done incorrectly    | false      |
|                                    | List<Transaction>              | withdraw(double amount):boolean          | withdraw done correctly     | true       |
|                                    |                                |                                          | withdraw done incorrectly   | false      |
|                                    |                                | generateStatement(): void                | generates bank statement    | void       |
|                                    |                                |                                          |                             |            |
| Customer                           | NormalAccount normalAccount    |                                          |                             |            |
|                                    | SavingsAccount savingsAccount  |                                          |                             |            |
|                                    |                                |                                          |                             |            |
| Transaction                        | LocalDate date                 |                                          |                             |            |
|                                    | double credit                  |                                          |                             |            |
|                                    | double debit                   |                                          |                             |            |
|                                    | double balance                 |                                          |                             |            |

