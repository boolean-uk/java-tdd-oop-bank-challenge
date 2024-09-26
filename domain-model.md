## Domain Model

| Class            | Method                                           | Return value       | Class variable                  | Description                                      |
|------------------|--------------------------------------------------|--------------------|---------------------------------|--------------------------------------------------|
| Bank             | createAccount(Account account)                   | boolean            | List\<Account> accounts         | Adds a new account to the bank                   |
|                  | getAccountByAccountNumber(int accountNumber)     | Account : null     | List\<Account> accounts         | Fetches the account if it exists                 |
|                  | performDeposit(int accountNum, double amount)    | double             | List\<Transaction> transactions | Adds funds from a given account                  |
|                  | performWithdrawal(int accountNum, double amount) | double             | List\<Transaction> transactions | Removes funds from a given account               |
|                  | getAccountTransactions(int accountNum)           | List\<Transaction> | List\<Transaction> transactions | Gets all account transactions or a empty list    |
|                  | getAccountBankStatement(int accountNumber)       | String             |                                 | Returns a generated bank statement               |
| Account          | getBalanceInBaseUnits()                          | double             | int balance                     | Returns the account balance in base units        |
|                  | deposit(double amount)                           | void               | int balance                     | Adds funds to the account balance                |
|                  | withdraw(double amount)                          | void               | int balance                     | Removes funds from the account balance           |
| CurrencyUtils    | toBaseUnits(int amount)                          | double             |                                 | Converts currency                                |
|                  | toSubUnits(double amount)                        | int                |                                 | Converts currency                                |
| StatementService | generateBankStatement(int accountNumber)         | String             | Bank bank                       | Generates a bank statement for the given account |

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
