# Bank challenge
### Dorota Wlazło


```
As a customer,
So I can safely store and use my money,
I want to create a current account.
```
```
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```
```
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```
```
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```
| Class   | Field                                      | Method                                        | Condition                                                | Output                |
|---------|--------------------------------------------|-----------------------------------------------|----------------------------------------------------------|-----------------------|
| Account | ArrayList<Transaction> transactionHistory; | void depositMoney(double amountDeposited)     |                                                          |                       |
|         |                                            |                                               |                                                          |                       |
|         | String accountOwner                        | boolean withdrawMoney(double amountWithdrawn) | if the amount of money in the account >= amountWithdrawn | true                  |
|         |                                            |                                               | if the amount of money in the account < amountWithdrawn  | false                 |
|         |                                            |                                               |                                                          |                       |
|         |                                            | double calculateBalance()                     | always                                                   | double accountBalance |


| Class       | Field                     | Method | Condition | Output |
|-------------|---------------------------|--------|-----------|--------|
| Transaction | LocalDate transactionDate |        |           |        |
|             | int amount                |        |           |        |
|             | String type               |        |           |        |

| Class | Field                                            | Method                                   | Condition | Output               |
|-------|--------------------------------------------------|------------------------------------------|-----------|----------------------|
| Bank  | Hashmap<Integer, SavingsAccount> savingsAccounts | int openSavingsAccount(String ownerName) | always    | int newAccountNumber |
|       | Hashmap<Integer, CurrentAccount> currentAccounts | int openCurrentAccount(String ownerName) | always    | int newAccountNumber |
|       | int currentAccountsCounter                       |                                          |           |                      |
|       | int savingsAccountsCounter                       | Account getAccountById(int id)           | always    | Account account      |


| Class                  | Field | Method                         | Condition | Output               |
|------------------------|-------|--------------------------------|-----------|----------------------|
| BankStatementGenerator |       | String generateBankStatement() | always    | String bankStatement |
|                        |       |                                |           |                      |
|                        |       |                                |           |                      |
