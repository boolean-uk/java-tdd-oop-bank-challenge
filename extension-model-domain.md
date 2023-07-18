### Bank Challenge

## Core User Stories

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

## Extension User Stories

1. ```
   As an engineer,
    So I don't need to keep track of state,
    I want account balances to be calculated based on transaction history instead of stored in memory.
    ```
2. ```
   As a bank manager,
    So I can expand,
    I want accounts to be associated with specific branches.
    ```
3. ```
   As a customer,
    So I have an emergency fund,
    I want to be able to request an overdraft on my account.
    ```
4. ```
    As a bank manager,
    So I can safeguard our funds,
    I want to approve or reject overdraft requests.
    ```

| Class                          | Members                                  | Method                                                         | Scenario                                      | Outcome/Output                      |
|--------------------------------|------------------------------------------|----------------------------------------------------------------|-----------------------------------------------|-------------------------------------|
| Bank                           |                                          |                                                                |                                               |                                     |
|                                | ArrayList<Account> accounts              |                                                                |                                               |                                     |
|                                | ArrayList<Branch> branches               |                                                                |                                               |                                     |
|                                |                                          | createAccount(String firstname, String lastname, String type, String branchName) | Type of account doesn't exist for this user   | Creates a new account / True        |
|                                |                                          |                                                                | User already has this type of account         | Fail message / False                |
|                                |                                          | printStatement(Account account)                                | If account exists                             | Prints Statement / True             |
|                                |                                          |                                                                | If account exists but is not activated        | Prints message / False              |
|                                |                                          |                                                                | If account doesn't exist                      | Fail message / False                |
|                                |                                          | approveOverdraft(Account account, double amount)               | If account exists and amount is appropriate   | Approves overdraft / True           |
|                                |                                          |                                                                | If account doesn't exist or amount is too high| Fail message / False                |
| Abstract Account               |                                          |                                                                |                                               |                                     |
|                                | String firstname                         |                                                                |                                               |                                     |
|                                | String lastname                          |                                                                |                                               |                                     |
|                                | String branchName                        |                                                                |                                               |                                     |
|                                | boolean activated                        |                                                                | Set to false when first creating an account   |                                     |
|                                |                                          |                                                                | True after a deposit.                         |                                     |
|                                | `ArrayList<Integer> balanceMoveHistory`  |                                                                |                                               |                                     |
|                                | `ArrayList<Date> dateHistory`            |                                                                |                                               |                                     |
|                                | double overdraftLimit                    |                                                                |                                               |                                     |
|                                | boolean overdraftRequested               |                                                                |                                               |                                     |
|                                |                                          | deposit(double balance)                                        | Valid value                                  | Updates balance history / True      |
|                                |                                          |                                                                | Invalid value                                | Fail message / False                |
|                                |                                          | withdraw(double balance)                                       | Valid value                                  | Updates balance history / True      |
|                                |                                          |                                                                | Invalid value                                | Fail message / False                |
|                                |                                          | requestOverdraft(double amount)                               | Valid value                                  | Request Overdraft / True            |
|                                |                                          |                                                                | Invalid value                                | Fail message / False                |
|                                |                                          | getCurrentBalance()                                           | Calculates the current balance               | Returns calculated balance          |
|                                |                                          | doubleToIntBalance(double balance)                             | Takes a double and makes it an integer       | Integer of amount in cents          |
|                                |                                          | getDate()                                                      | Returns date of transaction                  | Date formatted                      |
| CurrentAccount extends Account |                                          |                                                                |                                               |                                     |
|                                | String type                              |                                                                |                                               |                                     |
| SavingAccount extends Account  |                                          |                                                                |                                               |                                     |
|                                | String type                              |                                                                |                                               |                                     |
| Branch                         |                                          |                                                                |                                               |                                     |
|                                | String branchName                        |                                                                |                                               |                                     |
|                                | ArrayList<Account> accounts              |                                                                |                                               |                                     |

