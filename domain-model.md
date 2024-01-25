| Class               | Implements/Extends | Attributes                          | Methods                         | T | I | Situation | Return / Output |   |
|---------------------|--------------------|-------------------------------------|---------------------------------|---|---|-----------|-----------------|---|
| User                |                    | String identifier                   |                                 |   |   |           |                 |   |
|                     |                    |                                     |                                 |   |   |           |                 |   |
| Customer            | User               |                                     |                                 |   |   |           |                 |   |
|                     |                    | ArrayList<Account> accounts         |                                 |   |   |           |                 |   |
|                     |                    |                                     | createAccount(AccountType type) |   |   |           |                 |   |
| Account             |                    |                                     |                                 |   |   |           |                 |   |
|                     |                    | String identifier                   |                                 |   |   |           |                 |   |
|                     |                    | int amount                          |                                 |   |   |           |                 |   |
|                     |                    | ArrayList<Transaction> transactions |                                 |   |   |           |                 |   |
|                     |                    |                                     | void withdraw(  int amount)     |   |   |           |                 |   |
|                     |                    |                                     | void deposit( int amount)       |   |   |           |                 |   |
|                     |                    |                                     | String getBankStatement()       |   |   |           |                 |   |
| CurrentAccount      | Account            |                                     |                                 |   |   |           |                 |   |
| SavingsAccount      | Account            |                                     |                                 |   |   |           |                 |   |
| Transaction         |                    | int amount                          |                                 |   |   |           |                 |   |
|                     |                    | int newBalance                      |                                 |   |   |           |                 |   |
|                     |                    | Account account                     |                                 |   |   |           |                 |   |
|                     |                    | LocalDate date                      |                                 |   |   |           |                 |   |
|                     |                    | LocalTime time                      |                                 |   |   |           |                 |   |
|                     |                    |                                     | String toString()               |   |   |           |                 |   |
| (E)TransactionTypes |                    | DEPOSIT, WITHDRAWAL                 |                                 |   |   |           |                 |   |
| (E)AccountTypes     |                    | CURRENT, SAVINGS                    |                                 |   |   |           |                 |   |
|                     |                    |                                     |                                 |   |   |           |                 |   |


As a customer, Dx
So I can safely store and use my money,
I want to create a current account.

As a customer, Dx
So I can save for a rainy day,
I want to create a savings account.

As a customer, Dx
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

As a customer, Dx
So I can use my account,
I want to deposit and withdraw funds.