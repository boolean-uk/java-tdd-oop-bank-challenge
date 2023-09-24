<!--
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
-->

| Classes               | Methods                 | Scenario                                                 | Output   |
|-----------------------|-------------------------|----------------------------------------------------------|----------|
| BankAccount           | getBalance()            | The user asks the program for his balance                | double   |
|                       |                         |                                                          |          |
|                       | withdraw(double amount) | The amount to withdraw is smaller than balance           | true     |
|                       |                         |                                                          | double   |
|                       |                         | The amount to withdraw is bigger than balance            | false    |
|                       |                         |                                                          | double   |
|                       |                         |                                                          |          |
|                       | deposit(double amount)  | The amount to deposit is bigger than 0                   | true     |
|                       |                         |                                                          | double   |
|                       |                         | The amount to deposit is smaller than 0                  | false    |
|                       |                         |                                                          | double   |
|                       |                         |                                                          |          |
|                       | getDate()               | The user receives the date for the deposit or withdrawal | new Date |
|                       |                         |                                                          |          |
|                       |                         |                                                          |          |
| CurrentAccount        | getBankType()           | The user knows which banktype the information comes from | String   |
| (extends Bankaccount) |                         |                                                          |          |
|                       |                         |                                                          |          |
| SavingsAccount        | getBankType()           | The user knows which banktype the information comes from | String   |
| (extends Bankaccount) |                         |                                                          |          |
|                       |                         |                                                          |          |
|                       |                         |                                                          |          |
