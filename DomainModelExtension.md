## Extension domain model

Uses the same logic as Core but with added functionality


## BankManager

| Variable                                                              | Method                                        | Scenario                                                   | Output |
|-----------------------------------------------------------------------|-----------------------------------------------|------------------------------------------------------------|--------|
| HashMap<String, HashMap<String, HashMap<Integer, Account>>> branches; | addAccount(float firstDeposit, String branch) | Make a new account for a customer and add it to the branch |        |
| HashMap<String, HashMap<Integer, Account>> currentAccountsList;       |                                               |                                                            |        |
| HashMap<String, HashMap<Integer, Account>> savingAccountsList;        |                                               |                                                            |        |
| HashMap<Integer, Account> currentAccounts;                            |                                               |                                                            |        |
| HashMap<Integer, Account> savingAccounts;                             |                                               |                                                            |        |
|                                                                       |                                               |                                                            |        |
Variables has a getter and setter 
Each branch has a HashMap for currentAccounts and one for savingAccounts with a corresponding ID.
The user does not need to create a saving accounts when creating a currentAccount.

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