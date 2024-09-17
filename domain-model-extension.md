```
#1
As a customer,
So I can safely store and use my money,
I want to create a current account.

#2
As a customer,
So I can save for a rainy day,
I want to create a savings account.

#3
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

#4
As a customer,
So I can use my account,
I want to deposit and withdraw funds.

#5
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

#6
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

#7
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

#8
As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

#9
As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.
```


| Class | Field                            | Method                              | Condition                             | Output |
|-------|----------------------------------|-------------------------------------|---------------------------------------|--------|
| Bank  | HashMap<String, Branch> branches | Branch getBranch(String branchCode) | if there is a branch with given code  | branch |
|       |                                  |                                     | if there is no branch with given code | null   |


| Class       | Field                          | Method                                                    | Condition                            | Output |
|-------------|--------------------------------|-----------------------------------------------------------|--------------------------------------|--------|
| BankAccount | List<Transaction> transactions | boolean deposit(int amount)                               | if operation ended successfully      | true   |
|             | String branchCode              |                                                           | if operation didn't end successfully | false  |
|             | String userPhoneNumber         | boolean withdraw(int amount)                              | if operation ended successfully      | true   |
|             |                                |                                                           | if operation didn't end successfully | false  |
|             |                                | boolean sendDepositNotification(Transaction transaction)  | if operation ended successfully      | true   |
|             |                                |                                                           | if operation didn't end successfully | false  |
|             |                                | boolean sendWithdrawNotification(Transaction transaction) | if operation ended successfully      | true   |
|             |                                |                                                           | if operation didn't end successfully | false  |


| Class          | Field | Method                       | Condition                            | Output |
|----------------|-------|------------------------------|--------------------------------------|--------|
| CurrentAccount |       | boolean withdraw(int amount) | if operation ended successfully      | true   |
|                |       |                              | if operation didn't end successfully | false  |


| Class          | Field | Method                       | Condition                            | Output |
|----------------|-------|------------------------------|--------------------------------------|--------|
| SavingsAccount |       | boolean withdraw(int amount) | if operation ended successfully      | true   |
|                |       |                              | if operation didn't end successfully | false  |


| Class       | Field              | Method | Condition | Output |
|-------------|--------------------|--------|-----------|--------|
| Transaction | LocalDateTime date |        |           |        |
|             | int amount         |        |           |        |
|             | boolean deposit    |        |           |        |


| Class                  | Field | Method                                                       | Condition | Output         |
|------------------------|-------|--------------------------------------------------------------|-----------|----------------|
| BankStatementGenerator |       | String generateBankStatement(List<Transaction> transactions) |           | bank statement |


| Class  | Field              | Method | Condition | Output |
|--------|--------------------|--------|-----------|--------|
| Branch | String city        |        |           |        |
|        | String code        |        |           |        |
|        | int overdraftLimit |        |           |        |
