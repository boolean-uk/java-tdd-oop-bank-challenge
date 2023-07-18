# Extension domain model

## User stories:
### Core
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
### Extensions

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

| Classes        | Fields                                     | Methods                                                                        | Scenario                                | Outcomes           |
|----------------|--------------------------------------------|--------------------------------------------------------------------------------|-----------------------------------------|--------------------|
| BankAccount    | List\<Transaction> transactionHistory      | boolean withdraw(double amount)                                                | balance >= amount                       | true               |
|                | double balance                             |                                                                                | balance < amount                        | false              |
|                | localDateTime openDate                     | void deposit(double amount)                                                    | always                                  | void               |
|                | String number                              | String generateStatement()                                                     | always                                  |                    |
| CurrentAccount | Inherits from BankAccount                  | Inherits from BankAccount                                                      |                                         |                    |
| SavingsAccount | Inherits from BankAccount                  | Inherits from BankAccount                                                      |                                         |                    |
|                | double interest                            | override boolean withdraw(double amount)                                       | balance >= amount + 5.0(fee)            | true               |
|                |                                            |                                                                                | balance < amount + 5.0(fee)             | false              |
|                |                                            | double calculateInterestGain()                                                 | always                                  | interest gain      |
| Transaction    | double amount                              |                                                                                |                                         |                    |
|                | double fee                                 |                                                                                |                                         |                    |
|                | LocalDateTime date                         |                                                                                |                                         |                    |
| User           | String firstName                           | boolean createNewAccount(String accountType, double initialBalance, String id) | account with provided id does not exist | true               |
|                | String lastName                            |                                                                                | else                                    | false              |
|                | HashMap<String, BankAccount> ownedAccounts | BankAccount getAccountById(String id)                                          | account with provided id does  exist    | chosen BankAccount |
|                |                                            |                                                                                | else                                    | null               |

