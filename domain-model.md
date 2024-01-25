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

| Class           | Methods                             | Member Variables     | Scenario               | Results          |
|-----------------|-------------------------------------|----------------------|------------------------|------------------|
| Bank            | createCurrentAccount(accountNumber) | String accountNumber | If accountNumber exist | return false     |
|                 | createSavingsAccount(accountNumber) | List<Account>        |                        |                  |
|                 |                                     |                      |                        |                  |
| Account         | addFunds(amount)                    | double balance       | If withdraw < balance  | return true      |
|                 | viewTransactions()                  | double amount        | If withdraw > balance  | return false     |
|                 | withdraw(amount)                    | type                 |                        |                  |
|                 |                                     | List<Transactions>   |                        |                  |
|                 |                                     |                      |                        |                  |
| CurrentAccount  | viewTransactions()                  |                      |                        | return current   |
| extends Account |                                     |                      |                        | account as title |
|                 |                                     |                      |                        |                  |
| SavingsAccount  | viewTransactions()                  |                      |                        | return saving    |
| extends Account |                                     |                      |                        | account as title |
|                 |                                     |                      |                        |                  |
| Transactions    | getters and setters()               | date                 |                        |                  |
|                 | toString()                          | debit                |                        |                  |
|                 |                                     | credit               |                        |                  |
|                 |                                     | balance              |                        |                  |
