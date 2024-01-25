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


## User story 1

Class Customer

| Class variables               | Method                                                            | Scenario                                       | Return  |
|-------------------------------|-------------------------------------------------------------------|------------------------------------------------|---------|
| ArrayList<Account> accounts   | createAccount(Account account)                                    | Creates and adds account to accounts list      | boolean |
|                               | deleteAccount(Account account)                                    | Removes account from accounts list             | boolean |
|                               | printBankStatements()                                             | Prints bankStatements                          | String  |
|                               | transferCredit(Account account1, Account account2, double credit) | Creates a transaction for the account provided | boolean |
|                               |                                                                   |                                                |         |


Class Account


| Class variables                          | Method                                         | Scenario                                    | Return  |
|------------------------------------------|------------------------------------------------|---------------------------------------------|---------|
| ArrayList<BankStatements> bankStatements | addBankStatement(BankStatements bankStatement) | Adds a bankStatement to bankStatements list | boolean |
|                                          | clearBankStatements()                          | Clears bankStatements list                  | boolean |
|                                          |                                                |                                             |         |
|                                          |                                                |                                             |         |


Class CurrentAccount extends Account


| Class variables               | Method                         | Scenario                                  | Return  |
|-------------------------------|--------------------------------|-------------------------------------------|---------|
|                               |                                |                                           |         |
|                               |                                |                                           |         |
|                               |                                |                                           |         |
|                               |                                |                                           |         |



## User story 2

Class SavingsAccount extends Account


| Class variables               | Method                         | Scenario                                  | Return  |
|-------------------------------|--------------------------------|-------------------------------------------|---------|
|                               |                                |                                           |         |
|                               |                                |                                           |         |
|                               |                                |                                           |         |
|                               |                                |                                           |         |



## User story 3

Abstract Class BankStatement

| Class variables      | Method                  | Scenario                              | Return |
|----------------------|-------------------------|---------------------------------------|--------|
| Date transactionDate | getStatementAsString()  | Gets a formatted string for statement | String |
| double amount        |                         |                                       |        |
| double balance       |                         |                                       |        |
|                      |                         |                                       |        |

Class WithdrawStatement extends BankStatement

| Class variables | Method                         | Scenario                                  | Return  |
|-----------------|--------------------------------|-------------------------------------------|---------|
|                 |                                |                                           |         |
|                 |                                |                                           |         |
|                 |                                |                                           |         |
|                 |                                |                                           |         |

Class DepositStatement extends BankStatement

| Class variables | Method                         | Scenario                                  | Return  |
|-----------------|--------------------------------|-------------------------------------------|---------|
|                 |                                |                                           |         |
|                 |                                |                                           |         |
|                 |                                |                                           |         |
|                 |                                |                                           |         |


## User story 4

Class Customer  

| Class variables               | Method                                   | Scenario                                   | Return  |
|-------------------------------|------------------------------------------|--------------------------------------------|---------|
|                               | deposit(Account account, double amount)  | Deposits amount from provided account      | boolean |
|                               | withdraw(Account account, double amount) | Withdraws the amount from provided account | boolean |
|                               |                                          |                                            |         |
|                               |                                          |                                            |         |

Class Account

| Class variables | Method                   | Scenario                              | Return  |
|-----------------|--------------------------|---------------------------------------|---------|
| double balance  | deposit(double amount)   | Deposits amount from provided account | boolean |
|                 | withdraw(double amount)  | Withdraws the amount from the account | boolean |
|                 |                          |                                       |         |
|                 |                          |                                       |         |
