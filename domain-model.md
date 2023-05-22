## Domain Model Bank Challenge

### User Stories

```
1. As a customer, so I can safely store / use my money,
I want to create a current account.

2. As a customer, so I can save for a rainy day,
I want to create a savings account.

3. As a customer, so I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

4. As a customer, so I can use my account,
I want to deposit and withdraw funds.

```
### Extension User Stories

```
As an engineer, so I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

As a bank manager, so I can expand,
I want accounts to be associated with specific branches.

As a customer, so I have an emergency fund,
I want to be able to request an overdraft on my account.

As a bank manager, so I can safeguard our funds,
I want to approve or reject overdraft requests.

As a customer, so I can stay up to date,
I want statements to be sent as messages to my phone.

```

### Domain model
Getters & Setters are not included in the model

BankAccount Class (interface)

| Members                              | Methods                                  | Scenarios                                        | Outcome                                        | User story |
|--------------------------------------|------------------------------------------|--------------------------------------------------|------------------------------------------------|------------|
| double balance                       |                                          |                                                  |                                                |            |
| String accountNumber                 |                                          |                                                  |                                                |            |
| ArrayList<Transactions> transactions | makeTransaction(Transaction transaction) | to withdraw and deposit money                    | change the balance of the account with amount  | 4          |
|                                      | printStatement()                         | create bank statement with date amount & balance | print String of statement                      | 3          |
|                                      |                                          |                                                  |                                                |            |

CurrentAccount Class (implements BankAccount)
- User story: create a current account - 1
SavingsAccount Class (implements BankAccount)
- User story: create a savings account - 2


Transaction Class

| Members       | Methods         | Scenarios                                           | Outcome               | User Story |
|---------------|-----------------|-----------------------------------------------------|-----------------------|------------|
| Date date     | makeDateStamp() | Get the date at the time of creation of transaction | return string of date | 3          |
| double amount |                 |                                                     |                       |            |
| String type   |                 |                                                     |                       |            |
|               |                 |                                                     |                       |            |

