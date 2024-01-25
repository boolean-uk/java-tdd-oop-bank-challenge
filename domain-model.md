# Domain Model for Bank System

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

As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.
```

## Domain Model

Account (Abstract)

| Member Variables | Methods               | Scenario                        | Result/Output                              | User Story |
|------------------|-----------------------|---------------------------------|--------------------------------------------|------------|
| int ID           | boolean withdraw(int) | To take out money from account. | True if withdraw successful, false if not. | S4         |
| int overdraft    | boolean deposit(int)  | To put money in account.        | True if deposit successful, false if not.  | S4         |
|                  | double getBalance()   | To know money in account.       | The balance of the account.                | S5         |
|                  | void transactions()   | To keep record of finances.     | Displays history of transactions.          | S3         |
|                  | int getID()           |                                 |                                            |            |

SavingsAccount extends Account


CurrentAccount extends Account

| Member Variables | Methods           | Scenario | Result/Output | User Story |
|------------------|-------------------|----------|---------------|------------|
|                  | setOverdraft(int) |          |               | S6         |

User 

| Member Variables            | Methods                       | Scenario                                   | Result/Output                             | User Stories |
|-----------------------------|-------------------------------|--------------------------------------------|-------------------------------------------|--------------|
| int ID                      | void newAccount()             | To make a new account.                     |                                           | S1, S2       |
| String firstName            | void printBankStatement()     | To keep record of finances.                |                                           | S3           |
| String lastName             | boolean withdraw(int, int)    | To withdraw money from account of choice.  |                                           | S4           |
| ArrayList<Account> accounts | boolean deposit(int, int)     | To deposit money from account of choice.   |                                           | S4           |
|                             | void accountOverview()        | To see all accounts and following balance. |                                           |              |
|                             | Account getAccount(int)       |                                            |                                           |              |
|                             | boolean requestOverdraft(int) | To have an emergency fund.                 | True if overdraft approved, false if not. | S6           |
