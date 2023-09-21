| Classes                       | Members                        | Methods                 |
|-------------------------------|--------------------------------|-------------------------|
| Account                       | double balance                 | deposit(double amount)  |
|                               | List<Transaction> transactions | withdraw(double amount) |
|                               |                                | generateBankStatement() |
|                               |                                | getBalance()            |
|                               |                                | getTransaction()        |
|                               |                                |                         |
| CurrentAccount extend Account |                                |                         |
|                               |                                |                         |
| SavingAccount extend Account  |                                |                         |
|                               |                                |                         |
| Transaction                   | Date transactionDate           | Getters()               |
|                               | double amount                  | Setters()               |
|                               | double balanceAtTime           |                         |
|                               | TransactionType type           |                         |
|                               |                                |                         |
| TransactionType (enum)        | DEPOSIT, WITHDRAW              |                         |
