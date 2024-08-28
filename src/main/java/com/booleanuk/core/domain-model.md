# Domain Model


## Table
| Classes                                                            | Variables                                              | Methods                                                            | Scenario                                                                                                       | Output                 |
|--------------------------------------------------------------------|--------------------------------------------------------|--------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------|------------------------|
| `Bank`                                                             | `-Map<String requestId, Request> requests`             | `-addRequest(Request request)`                                     | Validate, add to the list requests if possible.                                                                | void / throw exception |
|                                                                    |                                                        | `-removeRequest(String requestId)`                                 | Remove request by providing id.                                                                                | void / throw exception |
|                                                                    |                                                        | `+makeRequest(Request request)`                                    | Make a request as a user.                                                                                      | Request object / null  |
|                                                                    |                                                        |                                                                    |                                                                                                                |                        |
| `Request(Account account, Double overdraftSum)`                    | `-String id`                                           | `+getId()`                                                         |                                                                                                                | String                 |
|                                                                    | `-String accountNumber`                                | `+getAccountNumber()`                                              |                                                                                                                | String                 |
|                                                                    | `-Double overdraftSum`                                 | `+getOverdraftSum()`                                               |                                                                                                                |                        |
|                                                                    |                                                        | `+approve()`                                                       | Update account with facility to make overdrafts.                                                               |                        |
|                                                                    |                                                        | `+reject()`                                                        | Reject request, it should not be possible to make overdrafts.                                                  |                        |
|                                                                    |                                                        |                                                                    |                                                                                                                |                        |
| `Customer(String personalNumber)`                                  | `-String personalNumber`                               |                                                                    |                                                                                                                |                        |
|                                                                    | `-Map<String accountNumber, Account> accounts`         |                                                                    |                                                                                                                |                        |  
|                                                                    |                                                        | `+addAccount(Account newAcount)`                                   |                                                                                                                | void / throw exception |
|                                                                    |                                                        | `+removeAccount(String accountNumber)`                             | If possible to remove account, provide user with confirmation question<br>before the account is fully removed. | void / throw exception |
|                                                                    |                                                        |                                                                    |                                                                                                                |                        |
| abstract `Account`                                                 | `-String accountNumber`                                | `+getAccountNumber()`                                              | Auto-generate account number.                                                                                  |                        |
|                                                                    | `-Branch branch`                                       | `+getBranch()`                                                     |                                                                                                                |                        |
|                                                                    |                                                        | `+setBranch()`                                                     |                                                                                                                |                        |
|                                                                    | `-boolean isPossibleToOvedraft`                        | `+isPossibleToOverdraft()`                                         |                                                                                                                | boolean                |
|                                                                    |                                                        | `+setPossibleToOverdraft(boolean isPossibleToOvedraft)`            |                                                                                                                |                        |
|                                                                    | `-Map<String transactionId, Transaction> transactions` |                                                                    |                                                                                                                |                        |
|                                                                    |                                                        | `-addTransaction(Transaction transaction)`                         |                                                                                                                |                        |
|                                                                    |                                                        | `+deposit(Double sum)`                                             |                                                                                                                | void / throw exception |
|                                                                    |                                                        | `#validateOverdraft(Double currentBalance, Double withdrawAmount)` |                                                                                                                |                        |
|                                                                    |                                                        | `+withdraw(Double sum)`                                            |                                                                                                                | void / throw exception |
|                                                                    |                                                        | `#calculateBalance()`                                              |                                                                                                                | Double                 |
|                                                                    |                                                        | `+getBalance()`                                                    |                                                                                                                |                        |
|                                                                    |                                                        | `+printTransctionHistory()`    TODO: not implemented               |                                                                                                                |                        |
| `CurrentAccount` extends `Account`                                 |                                                        |                                                                    |                                                                                                                |                        |
|                                                                    |                                                        |                                                                    |                                                                                                                |                        |
| `SavingAccount` extends `Account`                                  | `-Double interestRate`                                 |                                                                    |                                                                                                                |                        |
|                                                                    |                                                        |                                                                    |                                                                                                                |                        |
| enum `Branch`                                                      | `BRANCH_1, BRANCH_2, BRANCH_3`                         |                                                                    |                                                                                                                |                        |
|                                                                    |                                                        |                                                                    |                                                                                                                |                        |
| `Transaction(Double amount, TransactionTYpe type, Double balance)` | `-String id`                                           | `+getId()`                                                         | Get id. Id is created via IdGenerator.                                                                         | String                 |
|                                                                    | `-LocalDateTime transactionDate`                       | `+getTransactionDate()`                                            | Get LocalDateTime, this is created when a Transaction is created.                                              | String                 |
|                                                                    | `-Double amount`                                       | `+getAmount()`                                                     |                                                                                                                | Double                 |
|                                                                    | `-TransactionType type`                                | `+getTransactionType()`                                            | Could be CREDIT or DEBIT.                                                                                      | TransactionType        |
|                                                                    | `-Double currentBalance`                               | `+getCurrentBalance()`                                             | Get the balance the account had when this transaction was made.                                                | Double                 |
|                                                                    |                                                        |                                                                    |                                                                                                                |                        |
| enum `TransactionType`                                             | `DEBIT, CREDIT`                                        |                                                                    |                                                                                                                |                        |
|                                                                    |                                                        |                                                                    |                                                                                                                |                        |
| `IdGenerator(IdPrefix prefix)`                                     | `-static int currentAC`                                |                                                                    |                                                                                                                |                        |
|                                                                    | `-static int currentRE`                                |                                                                    | Generate different Id's based on provided prefix.                                                              |                        |
|                                                                    | `-static int currentTR`                                |                                                                    |                                                                                                                |                        |
|                                                                    | `-IdPrefix prefix`                                     |                                                                    |                                                                                                                |                        |
|                                                                    | `-String id`                                           | `-setId(int currentNumber)`                                        | Generate id by prefix and current id number.                                                                   |                        |
|                                                                    |                                                        | `+getId()`                                                         |                                                                                                                | String                 |

## Class Diagram


## User Stories - Core
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

## Acceptance Criteria

**Given** a client makes a deposit of 1000 on 10-01-2012  
**And** a deposit of 2000 on 13-01-2012  
**And** a withdrawal of 500 on 14-01-2012  
**When** she prints her bank statement  
**Then** she would see:

```
date       || credit  || debit  || balance
14/01/2012 ||         || 500.00 || 2500.00
13/01/2012 || 2000.00 ||        || 3000.00
10/01/2012 || 1000.00 ||        || 1000.00
```

## User Stories - Extensions
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
