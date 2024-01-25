| Classes           | Members                              | Methods                                       | Outputs                             |
|---------------------|--------------------------------------|-----------------------------------------------|-------------------------------------|
| BankAccount        | - accountType: String                | + deposit(amount: double): void               | - generateStatement(): String       |
|                    | - balance: double                    | + withdraw(amount: double): void              | - getBalance(): double              |
|                    | - transactions: List<Transaction>    | + getBalance(): double                       |                                     |
|                    |                                      | + generateStatement(): String                |                                     |
|---------------------|--------------------------------------|-----------------------------------------------|-------------------------------------|
| Transaction        | - transactionDate: String            | + getDate(): String                          | - transactionDate: String           |
|                    | - transactionType: String            | + getType(): String                          | - transactionType: String           |
|                    | - amount: double                     | + getAmount(): double                        | - amount: double                    |
|---------------------|--------------------------------------|-----------------------------------------------|-------------------------------------|
| CurrentAccount      | - overdraftLimit: double             | + applyOverdraft(): void                     |                                     |
|                    |                                      | + checkOverdraft(): boolean                  |                                     |
|---------------------|--------------------------------------|-----------------------------------------------|-------------------------------------|
| SavingsAccount      | - interestRate: double               | + accrueInterest(): void                     |                                     |
|                    |                                      | + checkInterestRate(): double                |                                     |
