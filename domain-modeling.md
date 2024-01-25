| Classes          | Members                              | Methods                                | Outputs                                 |
|------------------|--------------------------------------|----------------------------------------|-----------------------------------------|
| BankAccount      | - accountType: String                | + deposit(amount: double, date: String) | - generateStatement(): String           |
|                  | - balance: double                    | + withdraw(amount: double, date: String)| - getBalance(): double                  |
|                  | - transactions: List<Transaction>    | + getBalance(): double                 |                                         |
|                  |                                      | + generateStatement(): String         |                                         |
|------------------|--------------------------------------|----------------------------------------|-----------------------------------------|
| Transaction      | - date: String                       | + getDate(): String                   | - date: String                          |
|                  | - type: String                       | + getType(): String                   | - type: String (Deposit/Withdrawal)     |
|                  | - amount: double                     | + getAmount(): double                 | - amount: double                        |
|                  |                                      | + getBalance(): double                | - balance: double (for the transaction) |
