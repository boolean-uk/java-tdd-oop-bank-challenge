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
```

| Class       | Field                          | Method                                                    | Condition                            | Output |
|-------------|--------------------------------|-----------------------------------------------------------|--------------------------------------|--------|
| BankAccount | List<Transaction> transactions | boolean deposit(int amount)                               | if operation ended successfully      | true   |
|             |                                |                                                           | if operation didn't end successfully | false  |
|             |                                | boolean withdraw(int amount)                              | if operation ended successfully      | true   |
|             |                                |                                                           | if operation didn't end successfully | false  |


| Class          | Field | Method                       | Condition                            | Output |
|----------------|-------|------------------------------|--------------------------------------|--------|
| CurrentAccount |       |                              |                                      |        |


| Class          | Field | Method                       | Condition                            | Output |
|----------------|-------|------------------------------|--------------------------------------|--------|
| SavingsAccount |       |                              |                                      |        |


| Class       | Field              | Method | Condition | Output |
|-------------|--------------------|--------|-----------|--------|
| Transaction | LocalDateTime date |        |           |        |
|             | int amount         |        |           |        |
|             | boolean deposit    |        |           |        |


| Class                  | Field | Method                                                       | Condition | Output         |
|------------------------|-------|--------------------------------------------------------------|-----------|----------------|
| BankStatementGenerator |       | String generateBankStatement(List<Transaction> transactions) |           | bank statement |
