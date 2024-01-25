# Bank Challenge Core

## User Stories

```
1.
As a customer,
So I can safely store and use my money,
I want to create a current account.

2.
As a customer,
So I can save for a rainy day,
I want to create a savings account.

3.
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

4.
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```

## Domain Model

### Class User

| Methods                                      | Member variables                   | Scenario                     | Output/Return     |
|----------------------------------------------|------------------------------------|------------------------------|-------------------|
| {1,2,3,4}`createAccount(String accountType)` | ArrayList<Account acount> accounts | Allowed to make new account. | int accountNumber |
|                                              |                                    |                              |                   |
|                                              | int userId                         |                              |                   |
|                                              | String name                        |                              |                   |


### Class Account

| Methods                        | Member variables                                | Scenario                     | Output/Return                                      |
|--------------------------------|-------------------------------------------------|------------------------------|----------------------------------------------------|
| {1,2,3,4}`Account(User owner)` | ArrayList<Transaction transaction> transactions | Allowed to make new account. | int accountNumber                                  |
|                                | User owner                                      |                              |                                                    |
|                                | int balance                                     |                              |                                                    |
|                                | int accountNumber                               |                              |                                                    |
| {1,2} `setAccountNumber()`     |                                                 |                              | int accountNumber                                  |
| {3} `getBankStatement()`       | ArrayList<Transaction transaction> transactions | Transactions not empty       | String                                             |
|                                |                                                 | Transactions empty           | String "No transactions made yet in this account." |
| {4} `deposit(double credit)`   | ArrayList<Transaction transaction> transactions | credit > 0                   | boolean true                                       |
|                                | int balance                                     | credit <= 0                  | boolean false                                      |
| {4} `withdraw(double debit)`   | ArrayList<Transaction transaction> transactions | balance < 0                  | boolean false                                      |
|                                | int balance                                     | balance >= 0                 | boolean true                                       |
| `toInt(double amount)`         |                                                 |                              | int amount                                         |
| `toDouble(int amount)`         |                                                 |                              | double amount                                      |

### Class SavingsAccount

Extends Account.

### Class CurrentAccount

Extends Account.

### Class Transaction

| Methods                                   | Member variables        | Scenario             | Output/Return |
|-------------------------------------------|-------------------------|----------------------|---------------|
| {3}`Transaction(int amount, int balance)` | LocalDateTime dateTime  | New transaction made |               |
|                                           | int amount              |                      |               |
|                                           | int balance             |                      |               |

