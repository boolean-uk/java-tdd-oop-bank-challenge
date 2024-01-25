#Domain model for Bank challenge
## User Stories
```
As a customer,
So I can safely store and use my money,
I want to create a current account.

As a customer,
So I can save for a rainy day,
I want to create a savings account.

As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```

| Classes         | Members        | Methods               | Scenario                | Result/output                    |
|-----------------|----------------|-----------------------|-------------------------|----------------------------------|
| Account         | int balance    | getBalance()          | User wants to know      | Returns the balance amount       |
|                 |                |                       | the account balance.    |                                  |
|                 | int overdraft  | setBalance()          | User wants to update    | Sets a new balance amount.       |
|                 |                |                       | the account balance.    |                                  |
|                 | User user      | getOverdraft()        | Gets the overdraft      | Returns the current overdraft    |
|                 |                |                       | amount, default 0.      | amount                           |
|                 | StringBuilder  | withdraw()            | User wants to withdraw  | Returns nothing. Updates balance |
|                 | transactionLog |                       | money from the account. | after withdrawal.                |
|                 |                | deposit()             | User wants to deposit   | Returns nothing. Updates balance |
|                 |                |                       | money into the account  | after deposit.                   |
|                 |                | printTransactionLog() | Prints the transaction  | Returns a string of the          |
|                 |                |                       | log of the account.     | transaction history              |
| SavingsAccount  |                |                       |                         |                                  |
| extends Account |                |                       |                         |                                  |
|                 |                |                       |                         |                                  |
|                 |                |                       |                         |                                  |
| CurrentAccount  |                | setOverdraft()        | User wants to take out  | Returns new overdraft amount.    |
| extends Account |                |                       | more money than they    |                                  |
|                 |                |                       | have                    |                                  |
|                 |                |                       |                         |                                  |
| User            | int id         | getId()               |                         |                                  |
|                 | String name    | getName()             |                         |                                  |
|                 | String branch  | getBranch()           |                         |                                  |
|                 |                |                       |                         |                                  |
