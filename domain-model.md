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

## Extensions

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

## Model
| Classes        | Members             | Methods                   | Scenario                                 | Output         |
|----------------|---------------------|---------------------------|------------------------------------------|----------------|
| Account        | List\<Account>      | create()                  | adds new account to list                 | Account        |
|                | List\<ITransaction> | transaction()             | adds new transaction to list             | boolean        |
|                |                     |                           | If withdraw <= balance                   | true           |
|                |                     |                           | Else                                     | false          |
|                |                     | statement()               | print list of transactions               |                |
|                |                     | balance()                 | get calculated balance from transactions | double         |
|                | String branch       |                           |                                          |                |
|                | boolean overdraft   |                           |                                          |                |
| SavingsAccount |                     | create()                  | adds new savings account to list         | SavingsAccount |
| Manager        | List\<Account>      | overdraftRequest(Account) | adds request to list                     |                |
|                |                     | acceptRequest(boolean)    |                                          |                |
| ITransaction   |                     | date()                    | get date of transaction                  | LocalDate      |
|                |                     | amount()                  | get absolute amount                      | double         |
|                |                     | signedAmount()            | get signed amount (+/-)                  | double         |
| Deposit        |                     | toString()                |                                          | String         |
| Withdraw       |                     | toString()                |                                          | String         |
