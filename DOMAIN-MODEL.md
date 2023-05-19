# Domain model (Core)
getters and setters are not included in the domain model.

| Class/Interface/Enum   | Field                               | Method                  | Scenario | Outcome |
|------------------------|-------------------------------------|-------------------------|----------|---------|
| Bank                   | ArrayList<Account> accounts         |                         |          |         |
| Account (Interface)    |                                     |                         |          |         |
|                        |                                     | withdraw(double amount) |          | void    |
|                        |                                     | deposit(double amount)  |          | void    |
|                        |                                     | generateStatement()     |          |         |
| CurrentAccount         | int balance                         |                         |          |         |
|                        | ArrayList<Transaction> transactions |                         |          |         |
|                        |                                     | withdraw(double amount) |          | void    |
|                        |                                     | deposit(double amount)  |          | void    |
|                        |                                     | generateStatement()     |          | print   |
| SavingAccount          | int balance                         |                         |          |         |
|                        | ArrayList<Transaction> transactions |                         |          |         |
|                        |                                     | withdraw(double amount) |          | void    |
|                        |                                     | deposit(double amount)  |          | void    |
|                        |                                     | generateStatement()     |          | print   |
| Transaction            | LocalDate date                      |                         |          |         |
|                        | TransactionType type                |                         |          |         |
|                        | int amount                          |                         |          |         |
|                        | int balance                         |                         |          |         |
| TransactionType (Enum) | CREDIT                              |                         |          |         |
|                        | DEBIT                               |                         |          |         |
|                        |                                     |                         |          |         |









