### Bank Challenge

## User Stories 
1.  ```
    As a customer,
    So I can safely store and use my money,
    I want to create a current account.
    ```

2.  ```
    As a customer,
    So I can save for a rainy day,
    I want to create a savings account.
    ```

3.  ```
    As a customer,
    So I can keep a record of my finances,
    I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
    ```

4.  ```
    As a customer,
    So I can use my account,
    I want to deposit and withdraw funds.
    ```

| Class                          | Members                                  | Method                                                        | Scenario                                    | Outcome/Output                     |
|--------------------------------|------------------------------------------|---------------------------------------------------------------|---------------------------------------------|------------------------------------|
| Bank                           |                                          |                                                               |                                             |                                    |
|                                | ArrayList<Account> accounts              |                                                               |                                             |                                    |
|                                |                                          | createAccount(String firstname, String lastname, String type) | Type of account doesn't exist for this user | Creates a new account / True       |
|                                |                                          |                                                               | User already has this type of account       | Fail message / False               |
|                                |                                          | printStatement(Account account)                               | If account exists                           | Prints Statement / True            |
|                                |                                          |                                                               | If account exists but is not activated      | Prints message / False             |
|                                |                                          |                                                               | If account doesn't exist                    | Fail message / False               |
|                                |                                          |                                                               |                                             |                                    |
| Abstract Account               |                                          |                                                               |                                             |                                    |
|                                | String firstname                         |                                                               |                                             |                                    |
|                                | String lastname                          |                                                               |                                             |                                    |
|                                | int currentBalance                       |                                                               |                                             |                                    |
|                                | boolean activated                        |                                                               | Set to false when first creating an account |                                    |
|                                |                                          |                                                               | True after a deposit.                       |                                    |
|                                | `ArrayList<Integer> balanceHistory`      |                                                               |                                             |                                    |
|                                | `ArrayList<Date> dateHistory`            |                                                               |                                             |                                    |
|                                | `ArrayList<Integers> balanceMoveHistory` |                                                               |                                             |                                    |
|                                |                                          | deposit(double balance)                                       | Valid value                                 | updates balance and history / True |
|                                |                                          |                                                               | Invalid value                               | Fail message / False               |
|                                |                                          | withdraw(double balance)                                      | Valid value                                 | updates balance and history / True |
|                                |                                          |                                                               | Invalid value                               | Fail message / False               |
|                                |                                          | doubleToIntBalance(double balance)                            | Takes a double and makes it an integer      | Integer of amount in cents         |
|                                |                                          | getDate()                                                     | Returns date of transaction                 | Date formatted                     |
|                                |                                          |                                                               |                                             |                                    |
| CurrentAccount extends Account |                                          |                                                               |                                             |                                    |
|                                | String type                              |                                                               |                                             |                                    |
|                                |                                          |                                                               |                                             |                                    |
| SavingAccount extends Account  |                                          |                                                               |                                             |                                    |
|                                | String type                              |                                                               |                                             |                                    |
|                                |                                          |                                                               |                                             |                                    |