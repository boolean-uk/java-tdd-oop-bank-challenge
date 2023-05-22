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

# Domain model (Extension)
getters and setters are not included in the domain model.

| Class/Interface/Enum   | Field                                | Method                                              | Scenario                     | Outcome               |
|------------------------|--------------------------------------|-----------------------------------------------------|------------------------------|-----------------------|
| Bank                   | ArrayList<Account> accounts          |                                                     |                              |                       |
|                        | ArrayList<Account> overdraftRequests |                                                     |                              |                       |
|                        |                                      | requestOverdraft(Account account)                   | request for overdraft        |                       |
|                        |                                      | requestOverdraft(Account account, boolean approval) | Overdraft request approval   | Approved              |
|                        |                                      |                                                     |                              | Rejected              |
|                        |                                      |                                                     |                              | Overdraft not allowed |
|                        |                                      |                                                     |                              | Invalid request       |
| Account (Interface)    |                                      |                                                     |                              |                       |
|                        |                                      | withdraw(double amount)                             |                              | String message        |
|                        |                                      | deposit(double amount)                              |                              | void                  |
|                        |                                      | generateStatement()                                 |                              | string                |
| CurrentAccount         | int balance                          |                                                     |                              |                       |
|                        | ArrayList<Transaction> transactions  |                                                     |                              |                       |
|                        | boolean overdraft                    |                                                     |                              |                       |
|                        |                                      | withdraw(double amount)                             | Withdrawal of funds          | Transaction succeeded |
|                        |                                      |                                                     |                              | Overdraft not allowed |
|                        |                                      |                                                     |                              |                       |
|                        |                                      | deposit(double amount)                              |                              | void                  |
|                        |                                      | generateStatement()                                 | Generation of bank statement | string                |
| SavingAccount          | int balance                          |                                                     |                              |                       |
|                        | ArrayList<Transaction> transactions  |                                                     |                              |                       |
|                        | boolean overdraft                    |                                                     |                              |                       |
|                        |                                      | withdraw(double amount)                             |                              | void                  |
|                        |                                      | deposit(double amount)                              |                              | void                  |
|                        |                                      | generateStatement()                                 | Generation of bank statement | String                |
| Transaction            | LocalDate date                       |                                                     |                              |                       |
|                        | TransactionType type                 |                                                     |                              |                       |
|                        | int amount                           |                                                     |                              |                       |
|                        | int balance                          |                                                     |                              |                       |
| TransactionType (Enum) | CREDIT                               |                                                     |                              |                       |
|                        | DEBIT                                |                                                     |                              |                       |

## Testing Twilio
In order to use twilio (sending sms) you should do the following:
1. Create the necessary environment variables
2. Use the main method to send a message as testing was not possible with junit 





