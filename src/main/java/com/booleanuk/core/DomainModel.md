# Java Bank Challenge
## User Stories
### Core
```
1. (Completed) As a customer,
   So I can safely store and use my money,
   I want to create a current account.

2. (Completed) As a customer,
   So I can save for a rainy day,
   I want to create a savings account.

3. (Completed) As a customer,
   So I can keep a record of my finances,
   I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

4. (Completed) As a customer,
   So I can use my account,
   I want to deposit and withdraw funds.
```
### Extensions
```
5. (Completed) As an engineer,
   So I don't need to keep track of state,
   I want account balances to be calculated based on transaction history instead of stored in memory.

6. (Completed) As a bank manager,
   So I can expand,
   I want accounts to be associated with specific branches.

7. As a customer,
   So I have an emergency fund,
   I want to be able to request an overdraft on my account.

8. As a bank manager,
   So I can safeguard our funds,
   I want to approve or reject overdraft requests.

9. As a customer,
   So I can stay up to date,
   I want statements to be sent as messages to my phone.
```
## UML Diagram
## Domain Model

| Class                              | Method                                 | Description                               | Output                          |
|------------------------------------|----------------------------------------|-------------------------------------------|---------------------------------|
| `AccountsList`                     | `AccountsList()`                       | constructor, initiates `accounts` Hashmap | `void`                          |
|                                    | `generateAccountId()`                  | generates a new unique `accountID`        | `String`: `accountId`           |
| `Account`                          | `Account(String branchId)`             | constructor                               | `void`                          |
|                                    | `getAccoutnId()`                       | getter                                    | `String`: `accountId`           |
|                                    | `toString()`                           | displays accountID and balance info       | `String`                        |
| `CurrentAccount` extends `Account` | `CurrentAccount(String branchId)`      | constructor                               | `void`                          |
| `SavingsAccount` extends `Account` | `SavingsAccount(String branchId)`      | constructor                               | `void`                          |
| `Statement`                        | `Statement(double amount,int balance)` | constructor                               | `void`                          |
|                                    | `getDate()`                            | getter                                    | `Date`: statement object's date |
|                                    | `toString()`                           | generates a Statement info String         | `String`                        |
