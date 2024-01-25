As a customer,
So I can safely store and use my money,
I want to create a current account.

| Classes           | Methods            | Members                                           | Scenario                  | Output            |
|-------------------|--------------------|---------------------------------------------------|---------------------------|-------------------|
| Interface Account | getName()          | String accountNumber, String name, double balance | user adds correct details | returns statement |
| Class Current     | getAccountNumber() |                                                   | user adds correct details | returns "";       |
|                   | getBalance()       |                                                   |                           |                   |
|                   | createCurrent()    |                                                   |                           |                   |
|                   |                    |                                                   |                           |                   |



As a customer,
So I can save for a rainy day,
I want to create a savings account.

| Classes           | Methods            | Members                                            | Scenario                  | Output            |
|-------------------|--------------------|----------------------------------------------------|---------------------------|-------------------|
| Interface Account | getName()          | String accountNumber, String name, double balance  | user adds correct details | returns statement |
| Class Savings     | getAccountNumber() |                                                    | user adds false details   | returns "";       |
|                   | getBalance()       |                                                    |                           |                   |
|                   | createSavings()    |                                                    |                           |                   |

As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

| Classes | Methods                 | Members        | Scenario                         | Output          |
|---------|-------------------------|----------------|----------------------------------|-----------------|
| Bank    | String bankStatements() | double balance | User has added correct details   | bankStatements  |
|         |                         | double credit  | User has not add correct details | empty statement |
|         |                         | double debit   |                                  |                 |
|         |                         | String date    |                                  |                 |

As a customer,
So I can use my account,
I want to deposit and withdraw funds.

| Classes | Methods                           | Members        | Scenario                                                                | Output     |
|---------|-----------------------------------|----------------|-------------------------------------------------------------------------|------------|
| Bank    | boolean deposit(double amount)    | double balance | user adds amount bigger than 10/user does not add amount bigger than 10 | true/false |
|         | boolean withdrawal(double amount) | double balance | user adds positive amount/user adds negative amount                     | true/false |
|         |                                   |                |                                                                         |            |