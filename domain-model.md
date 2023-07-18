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
| Class               | Fields                            | Methods                                       | Scenario                                                                                 | Output                         |
|---------------------|-----------------------------------|-----------------------------------------------|------------------------------------------------------------------------------------------|--------------------------------|
| Customer            | String name                       | createCurrent(long number)                    | No current account previously created                                                    | creates an account, no output  |
|                     | currentAcc current                |                                               | There is existing current account                                                        | prints a message, no output    |
|                     | savingsAcc savings                | createSavings(long number)                    | No savings account previously created                                                    | creates an account, no output  |
|                     |                                   |                                               | There is existing savings account                                                        | prints a message, no output    |
|                     |                                   | BankAccount accountCheck(long number)         | Provided number is a number of existing account                                          | returns account Object         |
|                     |                                   |                                               | Provided number is not a number of any existing accounts                                 | returns null, prints a message |
|                     |                                   | depositFunds(long number, BigDecimal amount)  | Customer wants to deposit money on existing account                                      | adds a transaction, no output  |
|                     |                                   |                                               | Customer wants to deposit money on non-existing account                                  | prints a message, no output    |
|                     |                                   | withdrawFunds(long number, BigDecimal amount) | Customer wants to withdraw money from existing account with enough funds                 | adds a transaction, no output  |
|                     |                                   |                                               | Customer wants to withdraw money from existing account with NO enough funds              | prints a message, no output    |
|                     |                                   |                                               | Customer wants to withdraw money from non-existing account                               | prints a message, no output    |
|                     |                                   | String generateBankStatement(long number)     | Customer wants to receive a bank statement of all transactions from existing account     | returns String statement       |
|                     |                                   |                                               | Customer wants to receive a bank statement of all transactions from non-existing account | returns null, prints a message |
| Transaction         | LocalDate date                    |                                               |                                                                                          |                                |
|                     | BigDecimal amount                 |                                               |                                                                                          |                                |
| BankAccount         | long number                       |                                               |                                                                                          |                                |
|                     | BigDecimal balance                |                                               |                                                                                          |                                |
|                     | List<Transaction> transactionList |                                               |                                                                                          |                                |
| CurrentAccount      |                                   |                                               |                                                                                          |                                |
| extends BankAccount |                                   |                                               |                                                                                          |                                |
| SavingsAccount      |                                   |                                               |                                                                                          |                                |
| extends BankAccount |                                   |                                               |                                                                                          |                                |
