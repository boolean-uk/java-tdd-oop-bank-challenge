# Domain Model

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

As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.
```

| Class          | Method                            | Member                           | Scenario                            | Return                |
|----------------|-----------------------------------|----------------------------------|-------------------------------------|-----------------------|
| Branch         | getName()                         | String name                      | get branch name                     | return branch name    |
| Account        | setCustomer(customer)             | Class Customer                   |                                     |                       |
|                | deposit(amount)                   | Double amount                    | add new deposit to account          |                       |
|                | withdraw(amount)                  | Double amount                    | Withdraw from account               |                       |
|                |                                   |                                  | Not enough funds in account         | String information    |
|                | setOverDrawAmount(overDrawAmount) | double overDrawAmount            | Insufficient balance                | String information    |
|                |                                   |                                  | Set new over draw amount            | Set amount            |
|                | getBalance()                      | List transaction                 | get balance                         | sum                   |
|                | getTransactions()                 | List transaction                 | get all transactions                | List transactions     |
|                | getBranch()                       | Class Branch                     |                                     | branch                |
| CurrentAccount |                                   | Class Branch                     |                                     |                       |
| SavingsAccount |                                   | Class Branch                     |                                     |                       |
|                | withdraw(amount)                  | Double amount                    | Withdraw from account               |                       |
|                |                                   |                                  | Not enough funds in account         | String information    |
|                |                                   |                                  | Withdraw interrupted                | String information    |
| Customer       | getCustomerID()                   | String customerID                |                                     | CustomerID            |
|                | getCurrentAccount()               | currentAccount                   |                                     | currentAccount        |
|                | getSavingsAccount()               | savingsAccount                   |                                     | savingsAccount        |
| BankStatement  | printStatement(account)           | Class Account, Class Transaction | Get transaction history and balance | String bank statement |
