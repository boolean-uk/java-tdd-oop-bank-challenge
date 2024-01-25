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

| Class members | Methods                                        | Scenario                       | Return |
|---------------|------------------------------------------------|--------------------------------|--------|
|               | generateBankStatement(Transaction transaction) | if bank statement is generated | true   |
|               |                                                |                                |        |

Class Transaction

| Class members                   | Methods                                                                  | Scenario | Return |
|---------------------------------|--------------------------------------------------------------------------|----------|--------|
| String date                     | Transaction(String date, double amount, double balanceBeforeTransaction) |          |        |
| double amount                   |                                                                          |          |        |
| double balanceBeforeTransaction |                                                                          |          |        |


Class Account

| Class members                       | Methods                                      | Scenario                               | Return |
|-------------------------------------|----------------------------------------------|----------------------------------------|--------|
| int accountId                       | Account(int accountId)                       |                                        |        |
| double balance                      | deposit(double amount)                       | if amount is added to balance          | true   |
| ArrayList<Transaction> transactions | withdraw(double amount)                      | if amount is withdrawn from balance    | true   |
|                                     | getBalance()                                 |                                        |        |
|                                     | getBankStatement()                           | if bank statement has all transactions | true   |
|                                     | getAccountId()                               |                                        |        |
|                                     | generateNewTransaction(char transactionType) |                                        |        |


Class SavingsAccount extends Account

| Class members | Methods                       | Scenario                            | Return |
|---------------|-------------------------------|-------------------------------------|--------|
|               | SavingsAccount(int accountId) |                                     |        |
|               | withdraw(double amount)       | if there is enough funds in account | true   |


Class CurrentAccount extends Account

| Class members | Methods                       | Scenario | Return |
|---------------|-------------------------------|----------|--------|
|               | CurrentAccount(int accountId) |          |        |
