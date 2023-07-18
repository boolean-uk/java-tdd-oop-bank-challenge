## Domain model

## Bank Challange

### User stories

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


## Extension

### User Stories


```
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.
```



### Classes with methods:


| Class          | Method                                               | Field                                   | Outcome                                                |
|----------------|------------------------------------------------------|-----------------------------------------|--------------------------------------------------------|
| Account        |                                                      |                                         |                                                        |
| SavingAccount  |                                                      |                                         |                                                        |
| Transaction    |                                                      |                                         |                                                        |
| AccountManager | void generateBankStatement();                        | `ArrayList<Transaction> statements `    | It will print bank statement                           |
|                | void deposit(BigDecimal deposit)                     | `ArrayList<Transaction> statements `    | It will add money to account balance                   |
|                | void withdraw(BigDecimal withdraw)                   | `ArrayList<Transaction> statements `    | It subtract money from account balance                 |
|                | Account createAccount()                              |                                         | It will return new account for Client                  |
|                | Account createSavingAccount()                        |                                         | It will return new saving account for Client           |
|                | BigDecimal calculateAccountBalance()                 | `ArrayList<Transaction> statements `    | It Will return account balance depends on transactions |
|                | boolean linkToBranch(Account account, Branch branch) |                                         | It will add account to selected branch                 |
|                | void addRequestToOverdraft(BigDecimal overdraft)     | `ArrayList<Request> overdraftRequests ` | it will add new overdraft request                      |
|                | void  approveOverdraft(Account Account)              | `ArrayList<Request> overdraftRequests ` | it will accept overdraft request                       |
|                | void  rejectOverdraft(Account Account)               | `ArrayList<Request> overdraftRequests ` | it will reject overdraft request                       |





