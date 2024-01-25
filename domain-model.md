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
| Class       | Methods             | Member variables     | Scenario                    | Outputs/Results          |
|-------------|---------------------|----------------------|-----------------------------|--------------------------|
| Account     | String getRecords() | double balance       | if account has had activity | get all bank statements  |
| Transaction |                     | Date transactionDate | if no activity on account   | get empty bank statement |
|             |                     | double amount        |                             |                          |



```
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```
| Class       | Methods                      | Member variables | Scenario       | Outputs/Results           |
|-------------|------------------------------|------------------|----------------|---------------------------|
| Account     | void deposit(double amount)  | double balance   | deposit(100.0) | balance = balance + 100.0 |
| Transaction | void withdraw(double amount) |                  | withdraw(50.0) | balance = balance - 50.0  |
|             |                              |                  |                |                           |


## Extension exercise

```
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.
```
| Class   | Methods                 | Member variables  | Scenario                         | Outputs/Results   |
|---------|-------------------------|-------------------|----------------------------------|-------------------|
| Account | void requestOverdraft() | boolean overdraft | requestOverdraft() is not called | overdraft = false |
|         |                         |                   | requestOverdraft() is called     | overdraft = true  |
|         |                         |                   |                                  |                   |

```
As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.
```
| Class | Methods | Member variables | Scenario | Outputs/Results |
|-------|---------|------------------|----------|-----------------|
|       |         |                  |          |                 |
|       |         |                  |          |                 |
|       |         |                  |          |                 |

