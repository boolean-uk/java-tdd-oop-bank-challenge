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
```
5.
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.
```
```
6.
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.
```

### Account Class

| Methods                                                      | Member Variables                     |
|--------------------------------------------------------------|--------------------------------------|
| getAccountNumber()                                           | int accountNumber                    |
| changeBalance(double amount)                                 | double balance                       |
| getStatements()                                              | double minLimit                      |
| getBranch()                                                  | ArrayList\<BankStatement> statements |
| addNewBankStatement(String date, double amount, String type) | Branches branch                      |
| getMinLimit()                                                | maxLimit = 100,000,000.00            |

### SavingsAccount Class extends Account

| Methods | Member Variables |
|---------|------------------|
|         | minLimit = 0.00  |


### CurrentAccount Class extends Account

| Methods | Member Variables   |
|---------|--------------------|
|         | minLimit = -100.00 |

### Branches Enum Class

| Member Variables |
|------------------|
| STOCKHOLM        |
| OSLO             |
| COPENHAGEN       |
| HELSINKI         |  

### BankStatement Class

| Methods              | Member Variables       |
|----------------------|------------------------|
| getTransactionDate() | String transactionDate |
| getType()            | String type            |
| getAmount()          | double amount          |
| getBalanceAfter()    | double balanceAfter    |   


### Customer Class

| Methods                                        | Member Variables             |
|------------------------------------------------|------------------------------|
| addAccount(Account account)                    | String owner                 |
| getAccount()                                   | ArrayList\<Account> accounts |
| depositFounds(double amount, Account account)  |                              |
| withdrawFounds(double amount, Account account) |                              |   
| showCurrentBalance(Account account)            |                              |
| printBankStatements(Account account)           |                              |

| Scenario                                                       | Return Value/Output/Result                                                                                  |
|----------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| Customer creates a savings account                             | Adds a savings account to the customers accounts list.                                                      |
| Customer creates a current account                             | Adds a current account to the customer accounts list.                                                       |
|                                                                |                                                                                                             |
| Customer deposits £500 to a savings account                    | Returns true. Adds £500 to the account and creates a bank statement.                                        |
| Customer withdraws £300 from a savings account. Balance = £500 | Returns true. Removes £300 from the account and creates a bank statement.                                   |
| Customer withdraws £300 from a savings account. Balance = £200 | Returns false and prints "Can't withdraw that much money from that account!". No bank statement is created. |
| Customer withdraws £300 from a current account. Balance = £200 | Return true. Removes £300 (new balance = -£100) from the account and creates a bank statement.              |
|                                                                |                                                                                                             |
| Customer generates bank statements for a specific account      | Prints out a all bank statements made for that account.                                                     |
| Customer generates bank statements for newly created account   | Prints "No bank statements has been made for this account".                                                 |
|                                                                |                                                                                                             |
| Manager adds a branch to a specific account                    | Adds branch to specified account                                                                            |