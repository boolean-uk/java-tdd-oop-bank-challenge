## Extension domain model

Uses the same logic as Core but with added functionality


## BankManager

| Variable                          | Method                         | Scenario                                                   | Output |
|-----------------------------------|--------------------------------|------------------------------------------------------------|--------|
| HashMap<String, Account> branches | addAccount(float firstDeposit) | Make a new account for a customer and add it to the branch |        |
|                                   |                                |                                                            |        |
|                                   |                                |                                                            |        |
|                                   |                                |                                                            |        |
|                                   |                                |                                                            |        |
|                                   |                                |                                                            |        |
Variables has a get


## Account
| Variable                                | Method                          | Scenario                                        | Outcome                          |
|-----------------------------------------|---------------------------------|-------------------------------------------------|----------------------------------|
| id: int                                 | Deposit(float amount): void     | Put in amount to deposit into account           | Add the deposit to the balance   |
| balanceChecker: float                   |                                 |                                                 |                                  |
| ArrayList<Transaction> transactionsList |                                 |                                                 |                                  |
| String branch                           | Withdraw(float amount): void    | Get the amount from balance                     | Returns "money" from the balance |
|                                         |                                 |                                                 | Insufficient amount              |
|                                         | calculateAccountBalance(): void | Calculate the account balance from transactions |                                  |
|    