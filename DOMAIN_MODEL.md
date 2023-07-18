
## Standard Requirements Domain Model
<br>

### User Stories

1. ```
    As a customer,
    So I can safely store use my money,
    I want to create a current account.
    ```
   
2. ```
    As a customer,
    So I can save for a rainy day,
    I want to create a savings account.
    ```

3. ```
    As a customer,
    So I can keep a record of my finances,
    I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
    ```
4. ```
    As a customer,
    So I can use my account,
    I want to deposit and withdraw funds.
    ```
<br>

| Class                            | Properties                        | Methods                                                                  | Scenarios/User Stories                     | Outputs/Outcomes                                                                                                                                                          |
|----------------------------------|-----------------------------------|--------------------------------------------------------------------------|--------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Bank`                           |                                   |                                                                          |                                            |                                                                                                                                                                           |
|                                  | `AccountType: enum`               |                                                                          |                                            |                                                                                                                                                                           |
|                                  | `accounts: List<Acount>`          |                                                                          |                                            |                                                                                                                                                                           |
|                                  |                                   | `createAccount(AccountType accountType, double initialBalance): boolean` | User Story 1, 2                            | Returns true if account was created                                                                                                                                       |
|                                  |                                   |                                                                          |                                            | Returns false if account was not created                                                                                                                                  |
|                                  |                                   |                                                                          | InitialBalance is set to a negative number | Returns true. Creates an account with a balance of 0.00                                                                                                                   |
| `Account`                        |                                   |                                                                          |                                            |                                                                                                                                                                           |
|                                  | `ACCOUNT_ID: int`                 |                                                                          |                                            |                                                                                                                                                                           |
|                                  | `monthlyTransactionLimit: byte`   |                                                                          |                                            |                                                                                                                                                                           |
|                                  | `canOverdraft: boolean`           |                                                                          |                                            |                                                                                                                                                                           |
|                                  | `interest: float`                 |                                                                          |                                            |                                                                                                                                                                           |
|                                  | `transactions: List<Transaction>` |                                                                          |                                            |                                                                                                                                                                           |
|                                  | `balance: BigDecimal`             |                                                                          |                                            |                                                                                                                                                                           |
|                                  |                                   | `deposit(double amount): boolean`                                        | User Story 4                               | Returns true if amount is greater than zero. Creates a transaction with the value of given amount                                                                         |
|                                  |                                   |                                                                          |                                            | Returns false if amount is negative                                                                                                                                       |
|                                  |                                   | `withdraw(double amount): boolean`                                       | User Story 4                               | Returns true if amount is greater than zero and amount is less than or equal to the account's balance. <br/>Creates a transaction with the negative value of given amount |
|                                  |                                   |                                                                          |                                            | Returns false if amount is negative or grater than the balance                                                                                                            |
| `SavingsAccount extends Account` |                                   |                                                                          |                                            |                                                                                                                                                                           |
| `CurrentAccount extends Account` |                                   |                                                                          |                                            |                                                                                                                                                                           |
| `Transaction`                    |                                   |                                                                          |                                            |                                                                                                                                                                           |
|                                  | `date: DateTime`                  |                                                                          |                                            |                                                                                                                                                                           | 
|                                  | `amount: BigDecimal`              |                                                                          |                                            |                                                                                                                                                                           |
| `BankStatement`                  |                                   |                                                                          |                                            |                                                                                                                                                                           |
|                                  | `account: Account`                |                                                                          |                                            |                                                                                                                                                                           |
|                                  |                                   | `print(): void`                                                          | User Story 3                               | Prints the full bank statement for a specific account                                                                                                                     |
|                                  |                                   | `print(LocalDateTime fromDate, LocalDateTime toDate): void`              | User Story 3                               | Prints the bank statement including transactions starting from `fromDate` until `toDate`                                                                                  |



## Extension Requirements changes

- Added `Main`,  `Branch`, `BankManager`, `OverdraftRequest`, `TwilioHanler` and `Customer` classes

### Main
Contains a main method with an example `account` with `transactions`

### Branch
1. A `Bank` is consisted of a Map of `Branches` <br><br>
2. A `Branch` contains a Map of `Customers` <br><br>
3. Each `Branch` is responsible for creating `Customers` and `Accounts`


### BankManager
1. The `BankManager` class is responsible for evaluating `OverdraftRequests`, namely setting their status to `OverdraftStatus` enumerator values


### Overdraft Request
1. A `Customer` can request an overdraft for a specific `CurrentAccount` with a given amount
<br><br>
2. The `BankManager` can `ACCEPT` or `REJECT` the request.
<br><br>
3. If a request gets accepted, the customer can withdraw money from his account until the debt amount is reached.
<br> For example given a `CurrentAccount` with a balance of 2.000 euros and a request for 40.000 euros <br>
the maximum debt the `Customer` can reach is -38.000 euros. If the debt is met, the `OverdraftRequest` for this account gets a status of `NONE` <br>
so the user cannot withdraw any more money and can also make another `OverdraftRequest`

### TwilioHandler
This class is responsible for creating and sending SMS to the customers regarding their funds


### Customer
Each `Customer` contains a Map of `Accounts`

### Account
1. In `SavingsAccounts` if the customer has reached the `monthlyTransactionLimit`, then he can no longer `deposit` or `withdraw` cash <br><br>
