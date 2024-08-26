## Extension domain model

Uses the same logic as Core but with added functionality


## BankManager

| Variable                                                              | Method                                                             | Scenario                                                                    | Output                                                                  |
|-----------------------------------------------------------------------|--------------------------------------------------------------------|-----------------------------------------------------------------------------|-------------------------------------------------------------------------|
| HashMap<String, HashMap<String, HashMap<Integer, Account>>> branches; | addAccount(float firstDeposit, String typeOfAccount String branch) | Make a new account for a customer and add it to the branch                  | typeOfAccount is for adding either a savingsAccount or a currentAccount |
| HashMap<String, HashMap<Integer, Account>> currentAccountsList;       |                                                                    |                                                                             |                                                                         |
| HashMap<String, HashMap<Integer, Account>> savingAccountsList;        | overdraftChecker(float amount);                                    | Checks if the user has to take an overdraft for when user wants to withdraw | true if its less than overdraftLimit                                    |
| HashMap<Integer, Account> currentAccounts;                            |                                                                    |                                                                             | false if its over the overdraftLimit                                    |
| HashMap<Integer, Account> savingAccounts;                             |                                                                    |                                                                             |                                                                         |
| float overDraftLimit;                                                 |                                                                    |                                                                             |                                                                         |

Each branch has a HashMap for currentAccounts and one for savingAccounts with a corresponding ID.
The user does not need to create a saving accounts when creating a currentAccount.
To create a savingsAccount or a currentAccount the user has to specify it when creating an account.

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