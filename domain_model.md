## User Stories

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

## Domain model

| Classes          | Members               | Methods                      | Scenario                                    | Outputs                                                    |
|------------------|-----------------------|------------------------------|---------------------------------------------|------------------------------------------------------------|
| `CurrentAccount` | accountNumber: string | `deposit(amount: decimal) `  | Customer creates a current account.         | Updated account balance after each deposit or withdrawal.  |
|                  | balance: decimal      | `withdraw(amount: decimal) ` | Customer deposits funds into the account.   |                                                            |
|                  |                       |                              | Customer withdraws funds from the account.  |                                                            |

| Classes          | Members               | Methods                     | Scenario                                    | Outputs                                                    |
|------------------|-----------------------|-----------------------------|---------------------------------------------|------------------------------------------------------------|
| `SavingsAccount` | accountNumber: string | `deposit(amount: decimal)`  | Customer creates a savings account.         | Updated account balance after each deposit or withdrawal.  |
|                  | balance: decimal      | `withdraw(amount: decimal)` | Customer deposits funds into the account.   |                                                            |
|                  |                       |                             | Customer withdraws funds from the account.  |                                                            |


| Classes         | Members                                    | Methods                                    | Scenario                                      | Outputs                                                                                       |
|-----------------|--------------------------------------------|--------------------------------------------|-----------------------------------------------|-----------------------------------------------------------------------------------------------|
| `BankStatement` | statementId: string                        | `generateStatement()`                      | Customer generates a bank statement.          | Bank statement with transaction dates, amounts, and balance at the time of each transaction.  |
|                 | accountNumber: string                      | `addTransaction(transaction: Transaction)` | Customer adds transactions to the statement.  |                                                                                               |
|                 | transactions: list of Transaction objects  |                                            |                                               |                                                                                               |


| Classes       | Members               | Methods       | Scenario                         | Outputs              |
|---------------|-----------------------|---------------|----------------------------------|----------------------|
| `Transaction` | transactionId: string | `getAmount()` | Customer creates a transaction.  | Transaction amount.  |
|               | date: date            |               |                                  |                      |
|               | amount: decimal       |               |                                  |                      |


| Classes   | Members                            | Methods                            | Scenario                                        | Outputs                                               |
|-----------|------------------------------------|------------------------------------|-------------------------------------------------|-------------------------------------------------------|
| `Branch`  | branchId: string                   | `addAccount(account: Account) `    | Bank manager creates a branch.                  | Updated list of accounts associated with the branch.  |
|           | accounts: list of Account objects  | `removeAccount(account: Account) ` | Bank manager adds accounts to the branch.       |                                                       |
|           |                                    |                                    | Bank manager removes accounts from the branch.  |                                                       |



| Classes             | Members                                     | Methods                            | Scenario                                                 | Outputs                    |
|---------------------|---------------------------------------------|------------------------------------|----------------------------------------------------------|----------------------------|
| `OverdraftRequest ` | requestId: string                           | `getStatus()`                      | Customer requests an overdraft on their account.         | Overdraft request status.  |
|                     | accountNumber: string                       | `updateStatus(newStatus: string) ` | Bank manager approves or rejects the overdraft request.  |                            |
|                     | amount: decimal                             |                                    |                                                          |                            |
|                     | status: string (pending/approved/rejected)  |                                    |                                                          |                            |


| Classes         | Members             | Methods         | Scenario                                                         | Outputs                                               |
|-----------------|---------------------|-----------------|------------------------------------------------------------------|-------------------------------------------------------|
| `PhoneMessage ` | messageId: string   | `sendMessage()` | Customer receives a bank statement as a message on their phone.  | Bank statement message sent to the customer's phone.  |
|                 | phoneNumber: string |                 |                                                                  |                                                       |
|                 | message: string     |                 |                                                                  |                                                       |
