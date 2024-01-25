# Domain model for Bank

```
-Core-
User story 1
As a customer,
So I can safely store and use my money,
I want to create a current account.

User story 2
As a customer,
So I can save for a rainy day,
I want to create a savings account.

User story 3
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

User story 4
As a customer,
So I can use my account,
I want to deposit and withdraw funds.

-Extensions-
User story 5
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

User story 6
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

User story 7
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

User story 8
As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

User story 9
As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.
```

### Class BankStatementGenerator

| Class members | Methods                                                    | Scenario                       | Return |
|---------------|------------------------------------------------------------|--------------------------------|--------|
|               | generateBankStatement(ArrayList<Transaction> transactions) | if bank statement is generated | true   |
|               |                                                            |                                |        |

### Class Transaction

| Class members                  | Methods                                                                                         | Scenario | Return |
|--------------------------------|-------------------------------------------------------------------------------------------------|----------|--------|
| String date                    | Transaction(String transactionType, String date, double amount, double balanceAfterTransaction) |          |        |
| double amount                  | getTransactionType()                                                                            |          |        |
| double balanceAfterTransaction | getDate()                                                                                       |          |        |
|                                | getAmount()                                                                                     |          |        |
|                                | getBalance()                                                                                    |          |        |


### Class Account

| Class members                                 | Methods                                        | Scenario                                   | Return |
|-----------------------------------------------|------------------------------------------------|--------------------------------------------|--------|
| int accountId                                 | Account(int accountId)                         |                                            |        |
| double balance                                | deposit(double amount)                         | if amount is added to balance              | true   |
| ArrayList<Transaction> transactions           | withdraw(double amount)                        | if amount is withdrawn from balance        | true   |
| BankStatementGenerator bankStatementGenerator | getBalance()                                   |                                            |        |
|                                               | getBankStatement()                             | if bank statement has all transactions     | true   |
|                                               | getAccountId()                                 |                                            |        |
|                                               | generateNewTransaction(String transactionType) |                                            |        |
|                                               | getBalanceFromTransactions()                   | if balance is calculated from transactions |        |


### Class SavingsAccount extends Account

| Class members | Methods                       | Scenario                            | Return |
|---------------|-------------------------------|-------------------------------------|--------|
|               | SavingsAccount(int accountId) |                                     |        |
|               | withdraw(double amount)       | if there is enough funds in account | true   |


### Class CurrentAccount extends Account

| Class members | Methods                       | Scenario | Return |
|---------------|-------------------------------|----------|--------|
|               | CurrentAccount(int accountId) |          |        |
