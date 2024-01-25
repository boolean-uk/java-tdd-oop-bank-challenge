# Bob's Bagels

## User Stories
```
1.
As a customer,
So I can safely store and use my money,
I want to create a current account.
```
```
2.
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```
```
3.
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transact
```
```
4.
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```

### Account Class

| Methods                               | Member Variables                     |
|---------------------------------------|--------------------------------------|
| getName()                             | String name                          |
| getAccountNumber()                    | int accountNumber                    |
| getClearingNumber                     | int clearingNumber                   |
| getBalance()                          | double balance                       |
| changeBalance(double amount)          | double minLimit                      |
| getMinLimit()                         | ArrayList\<BankStatement> statements |
| getStatements()                       |                                      |
| addStatement(BankStatement statement) |                                      |


### SavingsAccount Class extends Account

| Methods | Member Variables |
|---------|------------------|
|         | minLimit = 0.00  |


### CurrentAccount Class extends Account

| Methods | Member Variables   |
|---------|--------------------|
|         | minLimit = -100.00 |


### BankStatement Class

| Methods              | Member Variables     |
|----------------------|----------------------|
| getTransactionDate() | Date transactionDate |
| getAmount()          | double amount        |
| getBalanceAfter()    | double balanceAfter  |   


### Customer Class

| Methods                                        | Member Variables             |
|------------------------------------------------|------------------------------|
| showCurrentBalance(Account account)            | String owner                 |
| printBankStatements(Account account)           | ArrayList\<Account> accounts |
| depositFounds(double amount, Account account)  |                              |
| withdrawFounds(double amount, Account account) |                              |   
|                                                |                              |


### Bank Class

| Methods | Member Variables |
|---------|------------------|
|         |                  |


| Scenario                                                       | Return Value/Output/Result                                                                     |
|----------------------------------------------------------------|------------------------------------------------------------------------------------------------|
| Customer creates a savings account                             | Adds a savings account to the customers accounts list.                                         |
| Customer creates a current account                             | Adds a current account to the customer accounts list.                                          |
|                                                                |                                                                                                |
| Customer generates bank statements for a specific account      | Prints out a all bank statements made for that account.                                        |
| Customer generates bank statements for newly created account   | Prints "No bank statements has been made for this account".                                    |
|                                                                |                                                                                                |
| Customer deposits £500 to a savings account                    | Returns true. Adds £500 to the account and creates a bank statement.                           |
| Customer withdraws £300 from a savings account. Balance = £500 | Returns true. Removes £300 from the account and creates a bank statement.                      |
| Customer withdraws £300 from a savings account. Balance = £200 | Returns false and prints "Can't withdraw that much money". No bank statement is created.       |
| Customer withdraws £300 from a current account. Balance = £200 | Return true. Removes £300 (new balance = -£100) from the account and creates a bank statement. |
|                                                                |                                                                                                |

                                                                              |