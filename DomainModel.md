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
All variables in each class is private and has setters and getters.
In constructor of Account, the user has to do a deposit so the balance is not 0.
## Account
| Variable               | Method                          | Scenario                                        | Outcome                          |
|------------------------|---------------------------------|-------------------------------------------------|----------------------------------|
| id                     | Deposit(float amount): void     | Put in amount to deposit into account           | Add the deposit to the balance   |
| Balance                |                                 |                                                 |                                  |
| ArrayList<Transaction> |                                 |                                                 |                                  |
|                        | Withdraw(float amount): void    | Get the amount from balance                     | Returns "money" from the balance |
|                        |                                 |                                                 | Insufficient amount              |
|                        | calculateAccountBalance(): void | Calculate the account balance from transactions |                                  |
|                        |                                 |                                                 |                                  |


## currentAccount extends Account
Same functions as account.


## SavingAccount extends Account
Same function as accounts.


## Transaction

| Variable               | Method | Scenario | Outcome |
|------------------------|--------|----------|---------|
| ID int                 |        |          |         |
| amount float           |        |          |         |
| date LocalDateTime     |        |          |         |
| transactionType binary |        |          |         |
Transactions tracks how much a user deposit or withdraw from the account. 
TransactionType holds if it's a deposit or withdraw. Deposit is 0 and withdraw is a 1.
Transactions can never be removed from the list, therefore the ID is the size of the arraylist

