# Goal
Design a domain model from the following user stories before developing the application.

## User Stories
```
1.
As a customer,
So I can safely store and use my money,
I want to create a current account.
```
```
2.
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```
```
3.
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```
```
4.
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```
```
5.
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.
```
```
6.
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.
```
```
7.
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.
```
```
8.
As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.
```

### Domain Model

| Class                  | Method                   | Attributes                                | Scenario                                          | Outcome          |
|------------------------|--------------------------|-------------------------------------------|---------------------------------------------------|------------------|
| Branch (Record)        |                          | String name, String Address, String phone |                                                   |                  |
| BankAccount (Abstract) | deposit()                | ArrayList<Transaction> transactions       | 4.Deposit money to account                        | void             |
|                        | abstract withdraw()      |                                           | 4.Withdraw money from account                     | boolean          |
|                        | generateStatements()     |                                           | 3.Generate statements based on transactions' info | String           |
|                        | getBalance()             |                                           | 5.Generate balance based on transactions          | double           |
|                        | setBranch(Branch branch) | Branch branch                             | 6.Set the account's branch                        |                  |
|                        |                          |                                           | - If branch doesn't exist:                        | true, Branch set |
|                        |                          |                                           | - If branch exists:                               | false            |
|                        | getBranch()              |                                           | Get the account's branch                          | Branch/null      |
| CurrentAccount         |                          |                                           | 1,7,8.Inherit from BankAccount                    |                  |
| SavingsAccount         |                          |                                           | 2.Inherit from BankAccount                        |                  |
|                        |                          |                                           |                                                   |                  |
| Transaction            | getAmount()              | double amount                             | Get the amount of the transaction                 | double           |
|                        | isDeposit()              | boolean isDeposit                         | Differentiate deposits and withdrawals:           |                  |
|                        |                          |                                           | - If deposit:                                     | true             |
|                        |                          |                                           | - If withdrawal:                                  | false            |
|                        | printData()              | String date                               | Generate transaction info (date + credit/debit)   | String           |
