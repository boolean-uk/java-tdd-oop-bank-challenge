# Domain model for Bank

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
Class BankStatementGenerator

| Class members | Methods                                        | Scenario | Return |
|---------------|------------------------------------------------|----------|--------|
|               | generateBankStatement(Transaction transaction) |          |        |
|               |                                                |          |        |

Class Transaction

| Class members                   | Methods                                                                | Scenario | Return |
|---------------------------------|------------------------------------------------------------------------|----------|--------|
| Date date                       | Transaction(Date date, double amount, double balanceBeforeTransaction) |          |        |
| double amount                   |                                                                        |          |        |
| double balanceBeforeTransaction |                                                                        |          |        |


Class Account

| Class members                       | Methods                 | Scenario | Return |
|-------------------------------------|-------------------------|----------|--------|
| double balance                      | Account(int accountId)  |          |        |
| ArrayList<Transaction> transactions | deposit(double amount)  |          |        |
|                                     | withdraw(double amount) |          |        |
|                                     | getBalance()            |          |        |
|                                     | getStatement()          |          |        |


Class SavingsAccount extends Account

| Class members | Methods                       | Scenario | Return |
|---------------|-------------------------------|----------|--------|
|               | SavingsAccount(int accountId) |          |        |
|               | withdraw(double amount)       |          |        |


Class CurrentAccount extends Account

| Class members | Methods                       | Scenario | Return |
|---------------|-------------------------------|----------|--------|
|               | CurrentAccount(int accountId) |          |        |
