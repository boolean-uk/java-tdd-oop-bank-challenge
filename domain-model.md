# Bank Challenge Domain Model

## Core

### User Stories

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

### Domain model

| Class          | Field                           | Field role                     | Method                                                      | Method Scenario                                              | Method Outcome                              |
| -------------- | ------------------------------- | ------------------------------ | ----------------------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------- |
| Bank           | Map<UUID, Account> accounts     | Account registry               | registerCustomer()                                          | Registers new customer                                       | Customer id                                 |
|                | Map<UUID, Customer> customer    | Customer registry              | openAccount(UUID customerId, Class<T> accountType)          | Open account for a given customer                            | Account id                                  |
|                |                                 |                                | deposit(UUID accountId, BigDecimal funds)                   | If deposit is successful                                     | Return true                                 |
|                |                                 |                                |                                                             | If deposit is unsuccessful                                   | Return false                                |
|                |                                 |                                | withdraw(UUID customerId, UUID accountId, BigDecimal funds) | If withdrawal is successful                                  | Return true                                 |
|                |                                 |                                |                                                             | If withdrawal is unsuccessful                                | Return false                                |
|                |                                 |                                | generateStatement(UUID customerId, UUID accountId)          | If authentication successful and transactions list not empty | Return bank statement                       |
|                |                                 |                                |                                                             | If authentication unsuccessful or transactions list empty    | Return empty String                         |
| Account        | Customer holder                 | Account holder                 | deposit(BigDecimal funds)                                   | If funds amount correct                                      | Add funds to balance and return true        |
|                | BigDecimal balance              | Account balance                |                                                             | If funds amount incorrect                                    | Return false                                |
|                | List\<Transaction> transactions | List of transactions           | withdraw(BigDecimal funds)                                  | If funds amount correct and <= balance                       | Subtract funds from balance and return true |
|                |                                 |                                |                                                             | If funds amount incorrect or > balance                       | Return false                                |
|                |                                 |                                | String generateStatement()                                  | If transactions list not empty                               | Return bank statement                       |
|                |                                 |                                |                                                             | If transactions list empty                                   | Return empty String                         |
| CurrentAccount |                                 |                                |                                                             |                                                              |                                             |
| SavingsAccount |                                 |                                |                                                             |                                                              |                                             |
| Customer       | UUID id                         | Customer id                    |                                                             |                                                              |                                             |
| Transaction    | LocalDateTime date              | Date and time of transaction   |                                                             |                                                              |                                             |
|                | BigDecimal credit               | Amount added to balance        |                                                             |                                                              |                                             |
|                | BigDecimal debit                | Amount subtracted from balance |                                                             |                                                              |                                             |
|                | BigDecimal balance              | Balance amount                 |                                                             |                                                              |                                             |

## Extension

### User Stories

```
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.
```
```
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.
```
```
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.
```
```
As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.
```
```
As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.
```

### Domain Model

| Class               | Field                           | Field role                                             | Method                                                       | Method Scenario                                              | Method Outcome        |
| ------------------- | ------------------------------- | ------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | --------------------- |
| BankHQ              | int branchCount                 | Counter of branches and basis for branch id generation | openBranch()                                                 | Creates new branch and adds it to list                       | Return created branch |
|                     | List\<BankBranch> branches      | List of opened branches                                |                                                              |                                                              |                       |
| ~~Bank~~ BankBranch | String branchId                 | Branch id                                              | requestOverDraft(UUID customerId, UUID accountId, BigDecimal amount) | If authentication successful                                 | Returns request       |
|                     |                                 |                                                        |                                                              | If authentication unsuccessful                               | Returns null          |
|                     |                                 |                                                        | reviewOverdraftRequest(Request request, Request.Status decision) | Overdraft request review procedure                           | void                  |
| Account             | String branchId                 | Id of the branch managing given account                | calculateBalance()                                           | Calculate balance based of transactions list (history)       | Return balance amount |
|                     |                                 |                                                        | generateAccountId(String branchId)                           | Create account id with branch id in which it was opened as its last digits | Return account id     |
| Request             | UUID customerId                 | Customer id                                            | accept()                                                     | Changes status to accepted                                   |                       |
|                     | UUID accountId                  | Account id                                             | reject()                                                     | Changes status to rejected                                   |                       |
|                     | BigDecimal overdraftAmount      | Requested overdraft                                    |                                                              |                                                              |                       |
|                     | LocalDateTime dateTime          | Date and time of request                               |                                                              |                                                              |                       |
|                     | Status status                   | Request status                                         |                                                              |                                                              |                       |
| Status (enum)       | *PENDING*, *ACCEPTED*, REJECTED | Request status constants                               |                                                              |                                                              |                       |