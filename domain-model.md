| Class          | Attributes             | Method                      | Scenario                                                        | Output       |
|----------------|------------------------|-----------------------------|-----------------------------------------------------------------|--------------|
| BankAccount    | double totalCurrent    | balance()                   | show total amount in the account                                | double       |
|                | double amount, Date    | depositMoneyToCurrent()     | add an amount to the current account with date                  | double, Date |
|                |                        | totalCurrent()              | show total amount only on the current account                   | double, Date |
|                | void                   | listDepositAmountsCurrent() | print out the list of deposits to the current account with date |              |
|                | double amount, Date    | depositMoneyToSavings()     | add an amount to the savings account with date                  | double, Date |              
|                |                        | totalSavings()              | show total amount on the savings account                        | double, Date |               
|                | void                   | listDepositAmountsSavings() | print out the list of deposits to the current account with date |              |
|                | double amount, Date    | withdrawMoney()             | withdraw money from the current account                         | double, Date |
|                | void                   | listWithdrawalAmounts()     | list all withdrawal amounts with dates                          | double, Date |
|                |                        |                             |                                                                 |              |
| SavingsAccount | ArrayList<Savings>     |                             |                                                                 |              |
| Withdrawal     | ArrayList<Withdrawals> |                             |                                                                 |              |
| Current        | ArrayList<Current>     |                             |                                                                 |              |
| Currency       | Interface              | getValue() & getSymbol()    | Interface for being able to use different currencies            |              |


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