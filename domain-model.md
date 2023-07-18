## Core

```
As a customer,
So I can safely store and use my money,
I want to create a current account.
```
```
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```
```
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```
```
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```

### Domain model

| Class                            | Fields                                                     | Methods                                          | Scenario                                 | Output                                                      |
|----------------------------------|------------------------------------------------------------|--------------------------------------------------|------------------------------------------|-------------------------------------------------------------|
| *Account*                        | List<Transaction> transactions                             | void deposit(BigDecimal amount, LocalDate date)  | Customer is making a deposit             |                                                             |
|                                  | List<Transaction> transactions                             | void withdraw(BigDecimal amount, LocalDate date) | Customer is making a withdrawal          |                                                             |
|                                  | List<Transaction> transactions                             | BigDecimal getBalance()                          | Customer checks their balance            | Current balance                                             |
|                                  |                                                            |                                                  |                                          |                                                             |
| CurrentAccount extends *Account* |                                                            |                                                  |                                          |                                                             |
|                                  |                                                            |                                                  |                                          |                                                             |
| SavingAccount extends *Account*  | BigDecimal interestRate<br/>List<Transaction> transactions | void addInterests(LocalDate date)                | Banking system adds interests to account |                                                             |
|                                  |                                                            |                                                  |                                          |                                                             |
| BankStatement                    | Account account                                            | String print()                                   | Customer requests bank statement         | String representation of all transactions in a table format |
|                                  |                                                            |                                                  |                                          |                                                             |
| Transaction                      |                                                            |                                                  |                                          |                                                             |
|                                  |                                                            |                                                  |                                          |                                                             |
