# Domain Model

# UserStories
(1) As a customer,
So I can safely store use my money,
I want to create a current account.

(2) As a customer,
So I can save for a rainy day,
I want to create a savings account.

(3) As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

(4) As a customer,
So I can use my account,
I want to deposit and withdraw funds.

# Bank Account 
| US | Members                         | Methods                                        | Scenarios                                        | Output/Outcome                                                                                    |
|----|---------------------------------|------------------------------------------------|--------------------------------------------------|---------------------------------------------------------------------------------------------------|
|    | `ArrayList<Account> accounts`   |                                                |                                                  |                                                                                                   |
|    | `Arraylist<Customer> customers` |                                                |                                                  |                                                                                                   |
|    |                                 |                                                |                                                  |                                                                                                   |
| 3  | `int balance`                   |                                                |                                                  |                                                                                                   |
|    | `int formerDeposit`             |                                                |                                                  |                                                                                                   |
|    | `double transactions`           |                                                |                                                  |                                                                                                   |
|    |                                 | `double getCurrentAccount()`                   |                                                  |                                                                                                   |
| 2  |                                 | `double getSavings`                            |                                                  |                                                                                                   |
|    |                                 | `double getBalance()`                          |                                                  |                                                                                                   |
|    |                                 | `double setBalance()`                          |                                                  |                                                                                                   |
| 4  |                                 | `double deposit()`                             |                                                  |                                                                                                   |
|    |                                 | `boolean depositAmount(String AccountNumber)`  | Amount is successfully added to BankAccount      | Return true                                                                                       |
|    |                                 |                                                | Amount is not successfully added to BankAccount  | Print message: The amount is not added to your bank account. Return false                         |
|    |                                 | `boolean withdrawAmount(String accountNumber)` | Amount is successfully removed from Bank Account | Print message: The amount is successfully taken off your account. Return true                     |
| 4  |                                 | `double withdraw()`                            |                                                  | Print message: The amount is not taken off your account. Return false                             |
|    |                                 | `boolean updateBalance(int newBalance)`        | Balance is successfully updated                  |                                                                                                   |
|    |                                 |                                                | There is no money on the Bank Account            | Return 0.00                                                                                       |
|    |                                 |                                                | Balance can not be a negative number             | Print error message: You can't take money from your account because it cant be a negative number. |
| 3  |                                 | `double totalBalance()`                        |                                                  |                                                                                                   |
| 4  |                                 | `String returnDateTime()`                      |                                                  |                                                                                                   |
|    |                                 | `void printReceipt()`                          |                                                  |                                                                                                   |
|    |                                 | `toString()`                                   |                                                  |                                                                                                   |
|    |                                 | `@Override??`                                  |                                                  |                                                                                                   |

# Accounts
// Maybe need this one later on

| US | Members                           | Methods                                                                   | Scenario | Outcome/Output |
|----|-----------------------------------|---------------------------------------------------------------------------|----------|----------------|
|    | `String accountNumber`            |                                                                           |          |                |
|    | `double balance`                  |                                                                           |          |                |
|    | `String accountType`              |                                                                           |          |                |
|    | `String customerId`               |                                                                           |          |                |
|    | `int id`                          |                                                                           |          |                |
| 3  | `ArrayList<String> transactions`  |                                                                           |          |                |
|    |                                   | `account(String accountNumber, double formerDeposit, String accountType)` |          |                |
|    |                                   | `boolean withdraw (double Amount)`                                        |          |                |
|    |                                   | `void formerDeposit(double formerDeposit, LocalDate localDate)`           |          |                |
|    |                                   | `getters and setters`                                                     |          |                |

# Customer

| US | Members                | Methods | Scenario | Outcome/Output |
|----|------------------------|---------|----------|----------------|
|    | `double balance`       |         |          |                |
|    | `double transactions`  |         |          |                |
|    | `String date and time` |         |          |                |
|    |                        |         |          |                |

