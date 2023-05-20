
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
