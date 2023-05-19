
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

| Class                            | Properties                        | Methods                                                           | Scenarios/User Stories | Outputs/Outcomes                         |
|----------------------------------|-----------------------------------|-------------------------------------------------------------------|------------------------|------------------------------------------|
| `Bank`                           |                                   |                                                                   |                        |                                          |
|                                  | `AccountType: enum`               |                                                                   |                        |                                          |
|                                  | `accounts: List<Acount>`          |                                                                   |                        |                                          |
|                                  |                                   | `createAccount(AccountType accountType, double balance): boolean` | User Story 1, 2        | Returns true if account was created      |
|                                  |                                   |                                                                   |                        | Returns false if account was not created |
| `Account`                        |                                   |                                                                   |                        |                                          |
|                                  | `monthlyTransactionLimit: byte`   |                                                                   |                        |                                          |
|                                  | `canOverdraft: boolean`           |                                                                   |                        |                                          |
|                                  | `interest: float`                 |                                                                   |                        |                                          |
|                                  | `transactions: List<Transaction>` |                                                                   |                        |                                          |
|                                  | `balance: BigDecimal`             |                                                                   |                        |                                          |
|                                  |                                   | `deposit(double amount): boolean`                                 |                        |                                          |
|                                  |                                   | `withdraw(double amount): boolean`                                |                        |                                          |
|                                  |                                   |                                                                   |                        |                                          |
| `SavingsAccount extends Account` |                                   |                                                                   |                        |                                          |
| `CurrentAccount extends Account` |                                   |                                                                   |                        |                                          |
| `Transaction`                    |                                   |                                                                   |                        |                                          |
|                                  | `date: DateTime`                  |                                                                   |                        |                                          | 
|                                  | `amount: BigDecimal`              |                                                                   |                        |                                          |
