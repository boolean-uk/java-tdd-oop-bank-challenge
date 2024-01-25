# User Stories

```
As a customer,
So I can safely store and use my money,
I want to create a current account.
```

| Classes | Method               |
|---------|----------------------|
| Bank    | openCurrentAccount() |
|         |                      |


```
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```

| Classes | Methods              |
|---------|----------------------|
| Bank    | openSavingsAccount() |
|         |                      |


```
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```

| Classes | Methods           | Scenario                      | Output/Results |
|---------|-------------------|-------------------------------|----------------|
| Account | getTransactions() | If transactions *don't* exist | false          |
|         |                   | If transactions *do* exist    | transactions   |


```
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```

| Method               | Member variables   | Scenario                                            | Output/Results |
|----------------------|--------------------|-----------------------------------------------------|----------------|
| deposit(int amount)  | int accountBalance | if withdraw amount *is* greater than the balance    | false          |
|                      |                    | if withdraw amount *isn't* greater than the balance | true           |
| withdraw(int amount) |                    |                                                     |                |



## Extension User Stories

```
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.
```


| Classes        | Methods              | Scenario                                 | Output/Results       |
|----------------|----------------------|------------------------------------------|----------------------|
| Account        | deposit(int amount)  |                                          |                      |
|                | getBalance()         |                                          |                      |
|                | withdraw(int amount) | If withdrawal amount *is* less than 0    | String error message |
|                |                      | If withdrawal amount *isn't* less than 0 | void                 |
| CurrentAccount |                      |                                          |                      |
| SavingsAccount |                      |                                          |                      |

```
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.
```

| Classes | Member variables       |
|---------|------------------------|
| Branch  | int branchId           |
|         | String branchName      |
|         | List<Account> accounts |


```
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.
```

| Classes        | Methods            |
|----------------|--------------------|
| CurrentAccount | requestOverdraft() |
|                |                    |


```
As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.
```

| Classes | Methods                                 | Scenario                       | Output/Results |
|---------|-----------------------------------------|--------------------------------|----------------|
| Bank    | acceptOverdraftRequest(Account account) | If overdraft *is* requested    | true           |
|         |                                         | If overdraft *isn't* requested | false          |
|         |                                         |                                |                |
|         | denyOverdraftRequest(Account account)   |                                |                |


```
As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.
```


### Class diagram

![img.png](img.png)