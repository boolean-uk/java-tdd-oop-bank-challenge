## User Stories

```
As a customer,
So I can safely store use my money,
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

| Type        | Class                                         | Attributes                   | Methods                   | Scenario                      | Results                                          |
|-------------|-----------------------------------------------|------------------------------|---------------------------|-------------------------------|--------------------------------------------------|
| `Interface` | `BankAccount`                                 |                              |                           |                               |                                                  |
|             |                                               |                              | `deposit(double amount)`  |                               |                                                  |
|             |                                               |                              | `withdraw(double amount)` |                               |                                                  |
|             |                                               |                              | `statement()`             |                               |                                                  |
| `Concrete`  | `BasicBankAccount`                            |                              |                           |                               |                                                  |
|             |                                               | `double balance`             |                           |                               |                                                  |
|             |                                               | `List<Statement> statements` |                           |                               |                                                  |
|             |                                               |                              | `deposit(double amount)`  | if amount is negative         | print message and return balance                 |
|             |                                               |                              |                           | if amount is zero or positive | return new balance                               |
|             |                                               |                              | `withdraw(double amount)` | if amount is negative         | print message and return balance                 |
|             |                                               |                              |                           | if amount is zero or positive | return new balance                               |
|             |                                               |                              | `statement()`             |                               | return a String representation of the statements |
| `Concrete`  | `CurrentBankAccount extends BasicBankAccount` |                              |                           |                               |                                                  |
| `Concrete`  | `SavingsBankAccount extends BasicBankAccount` |                              |                           |                               |                                                  |

## Class Diagram
![](.\core-diagram.png)