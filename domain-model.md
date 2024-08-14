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

# Bank Challenge Extension

## User Stories

```
5.
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

6.
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

7.
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

8.
As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

9.
As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.
```

## Domain Model

### Class Account

Account is extended with one method.

| Methods                 | Member variables                    | Scenario       | Output/Return      |
|-------------------------|-------------------------------------|----------------|--------------------|
| {5}`calculateBalance()` | ArrayList<Transaction> transactions | Empty list     | double balance 0.0 |
|                         | transaction.getAmount()             | Not empty list | double balance     |


### Class CurrentAccount

CurrentAccount is extended to request and approve/reject overdrafts.

| Methods                                          | Member variables           | Scenario                     | Output/Return                                                     |
|--------------------------------------------------|----------------------------|------------------------------|-------------------------------------------------------------------|
| {7,8}`requestOverdraft()`                        | boolean overdraftRequested | overdraftRequested = false   | boolean true, overdraftRequested = true                           |
|                                                  |                            | overdraftRequested = true    | boolean false, system.out.println("Overdraft already requested.") |
| {7,8}`answearOverdraftRequest(boolean confirm, ` | boolean overdraftRequested | overdraftRequested = true && |                                                                   |
| `double overdraftAmount)`                        | double overdraftAmount     | confirm = true               | double overdraftAmount is set                                     |
|                                                  |                            | overdraftRequested = false   | system.out.println("The owner has not requested overdraft.")      |
|                                                  |                            | overdraftRequested = true && |                                                                   |
|                                                  |                            | confirm = false              | overdraftRequested = false                                        |