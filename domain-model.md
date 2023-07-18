# Bank Challenge

## Domain model

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

| Class                                | Fields                         | Methods                               | Scenario                                                      | Output                              |
|--------------------------------------|--------------------------------|---------------------------------------|---------------------------------------------------------------|-------------------------------------|
| Customer                             | String fullName                |                                       |                                                               |                                     |
|                                      | List<Account> accounts         |                                       |                                                               |                                     |
|                                      |                                | createSavingAccount()                 | User wants to create a saving account                         | Object of SavingAccount type        |
|                                      |                                | createCurrentAccount()                | User wants to create a current account                        | Object of CurrentAccount type       |
|                                      |                                | generateBankStatement()               | User wants to generate bank statement for each account he has |                                     |
|                                      |                                | getAllAccounts()                      | User wants to see all his account he's created                | List of accounts                    |
|                                      |                                | getAccountsByType(String accountType) | User wants to see all his account of particular type          | List of accounts of particular type |
|                                      |                                |                                       |                                                               |                                     |
| Account                              | String accountNumber           |                                       |                                                               |                                     |
|                                      | double balance                 |                                       |                                                               |                                     |
|                                      | String typeOfAccount           |                                       |                                                               |                                     |
|                                      | List<Transaction> transactions |                                       |                                                               |                                     |
|                                      |                                | depositFunds(double amount)           | User wants to deposit his funds                               |                                     |
|                                      |                                | withdrawFunds(double amount)          | User wants to withdraw his funds                              |                                     |
|                                      |                                |                                       |                                                               |                                     |
| CurrentAccount (subclass of Account) | String typeOfAccount           |                                       |                                                               |                                     |
| SavingAccount (subclass of Account)  | String typeOfAccount           |                                       |                                                               |                                     |
|                                      |                                |                                       |                                                               |                                     |
| Transaction                          | LocalDate dateOfTransaction    |                                       |                                                               |                                     |
|                                      | double amount                  |                                       |                                                               |                                     |
|                                      | String typeOfTransaction       |                                       |                                                               |                                     |
|                                      | Localtime time                 |                                       |                                                               |                                     |
|                                      | double balanceAfterTransaction |                                       |                                                               |                                     |
