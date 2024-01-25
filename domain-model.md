# User Stories


## Core exercise

```
As a customer,
So I can safely store and use my money,
I want to create a current account.
```
| Class          | Methods | Member variables | Scenario | Outputs/Results |
|----------------|---------|------------------|----------|-----------------|
| Account        |         | double balance   |          |                 |
| CurrentAccount |         |                  |          |                 |
|                |         |                  |          |                 |


```
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```
| Class          | Methods | Member variables | Scenario | Outputs/Results |
|----------------|---------|------------------|----------|-----------------|
| Account        |         | double balance   |          |                 |
| SavingsAccount |         |                  |          |                 |


```
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```
| Class   | Methods             | Member variables     | Scenario                    | Outputs/Results          |
|---------|---------------------|----------------------|-----------------------------|--------------------------|
| Account | String getRecords() | double balance       | if account has had activity | get all bank statements  |
|         |                     | Date transactionDate | if no activity on account   | get empty bank statement |
|         |                     | double amount        |                             |                          |



```
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```
| Class   | Methods                      | Member variables | Scenario       | Outputs/Results           |
|---------|------------------------------|------------------|----------------|---------------------------|
| Account | void deposit(double amount)  | double balance   | deposit(100.0) | balance = balance + 100.0 |
|         | void withdraw(double amount) |                  | withdraw(50.0) | balance = balance - 50.0  |
|         |                              |                  |                |                           |

