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

| Class                                | Fields                         | Methods                               | Scenario                               | Output |
|--------------------------------------|--------------------------------|---------------------------------------|----------------------------------------|--------|
| Customer                             | String fullName                |                                       |                                        |        |
|                                      | List<Account> accounts         |                                       |                                        |        |
|                                      |                                | createCurrentAccount(Account account) | User wants to create a current account |        |
|                                      |                                | createSavingAccount(Account account)  | User wants to create a saving account  |        |
|                                      |                                |                                       |                                        |        |
| Account                              | String accountNumber           |                                       |                                        |        |
|                                      | double balance                 |                                       |                                        |        |
|                                      | Customer customer              |                                       |                                        |        |
|                                      | List<Transaction> transactions |                                       |                                        |        |
|                                      |                                | depositFunds(double amount)           | User wants to deposit his funds        |        |
|                                      |                                | withdrawFunds(double amount)          | User wants to withdraw his funds       |        |
|                                      |                                |                                       |                                        |        |
| CurrentAccount (subclass of Account) | String accountType             |                                       |                                        |        |
| SavingAccount (subclass of Account)  | String accountType             |                                       |                                        |        |
|                                      |                                |                                       |                                        |        |
| Transaction                          | LocalDate dateOfTransaction    |                                       |                                        |        |
|                                      | double amount                  |                                       |                                        |        |
|                                      | String typeOfTransaction       |                                       |                                        |        |
