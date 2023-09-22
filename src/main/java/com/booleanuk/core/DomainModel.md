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

7. (Completed) As a customer,
   So I have an emergency fund,
   I want to be able to request an overdraft on my account.

8. (Completed) As a bank manager,
   So I can safeguard our funds,
   I want to approve or reject overdraft requests.

9. As a customer,
   So I can stay up to date,
   I want statements to be sent as messages to my phone.
```
## UML Diagram
![UML.png](..%2F..%2F..%2F..%2F..%2F..%2Fassets%2FUML.png)
## Domain Model

| Class                              | Method                                 | Description                                                     | Output                                                                                                                                      |
|------------------------------------|----------------------------------------|-----------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| `AccountsList`                     | `AccountsList()`                       | constructor, initiates `accounts` Hashmap                       | `void`                                                                                                                                      |
|                                    | `generateAccountId()`                  | generates a new unique `accountID`                              | `String`: `accountId`                                                                                                                       |
| `Account`                          | `Account(String branchId)`             | constructor                                                     | `void`                                                                                                                                      |
|                                    | `getAccoutnId()`                       | getter                                                          | `String`: `accountId`                                                                                                                       |
|                                    | `getStatements()`                      | getter                                                          | `String`: all the statements                                                                                                                |
|                                    | `getBalance()`                         | getter                                                          | `double`: `balance`                                                                                                                         |
|                                    | `setBalance()`                         | calculates and sets the total balance using the statements list | `void`                                                                                                                                      |
|                                    | `deposit()`                            | makes a new deposit statement and saves it to the list          | `boolean`: <br/>`true` if process is completed<br/>`false` if not                                                                           |
|                                    | `withdraw()`                           | makes a new withdraw statement and saves it to the list         | `boolean`: <br/>`true` if balance is greater than withdraw amount<br/>or the overdraw criteria are met`false` if non of the criteria is met |
|                                    | `overdraft()`                          | checks if overdraft criteria are met                            | `boolean`: <br/>`true` if overdraw amount is less than 10% of the previously deposited amount<br/>`false` if not                            |
|                                    | `getStatements()`                      | getter                                                          | `String`: of all the statements                                                                                                             |
|                                    | `toString()`                           | displays accountID and balance info                             | `String`                                                                                                                                    |
| `CurrentAccount` extends `Account` | `CurrentAccount(String branchId)`      | constructor                                                     | `void`                                                                                                                                      |
| `SavingsAccount` extends `Account` | `SavingsAccount(String branchId)`      | constructor                                                     | `void`                                                                                                                                      |
| `Statement`                        | `Statement(double amount,int balance)` | constructor                                                     | `void`                                                                                                                                      |
|                                    | `getDate()`                            | getter                                                          | `Date`: statement object's date                                                                                                             |
|                                    | `getAmount()`                          | getter                                                          | `double`: statement object's amount                                                                                                         |
|                                    | `toString()`                           | generates a Statement info String                               | `String`                                                                                                                                    |
