1.  As a customer,
    So I can safely store and use my money,
    I want to create a current account.

2.  As a customer,
    So I can save for a rainy day,
    I want to create a savings account.

3.  As a customer,
    So I can keep a record of my finances,
    I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

4.  As a customer,
    So I can use my account,
    I want to deposit and withdraw funds.


| Classes          | Members                     | Methods                            | Scenario                                        | Results                        |
|------------------|-----------------------------|------------------------------------|-------------------------------------------------|--------------------------------|
| `Transaction`    | `String date`               | setDate(String date)               | set the date                                    | void                           |
|                  | `double credit`             | getDate()                          | get the date                                    | Return String                  |
|                  | `double debit`              | setCredit(double credit)           | set the credit                                  | void                           |
|                  | `double balance`            | getCredit()                        | get the credit                                  | Return double                  |
|                  |                             | setDebit(double debit)             | set the debit                                   | void                           |
|                  |                             | getDebit()                         | get the debit                                   | Return double                  |
|                  |                             | setBalance(double balance)         | set the balance                                 | void                           |
|                  |                             | getBalance()                       | get the balance                                 | Return double                  |
|                  |                             |                                    |                                                 |                                |
| `Account`        | `String accountNumber`      | getBalance()                       | get the balance                                 | Return double                  |
|                  | `double balance`            | getHistory()                       | get the history of transaction                  | Return List<Transaction>       |
|                  | `List<Transaction> history` | getAccountNumber()                 | get the number of the account                   | Return String                  |
|                  |                             |                                    |                                                 |                                |
|                  |                             |                                    | 4.                                              |                                |
|                  |                             | deposit(double amount, Date date)  | if amount is greater than 0                     | Output success message         |
|                  |                             |                                    |                                                 | Update balance                 |
|                  |                             |                                    |                                                 | Add new transaction to history |
|                  |                             |                                    | 4.                                              |                                |
|                  |                             |                                    | if amount is less than or equal to 0            | Output failure message         |
|                  |                             |                                    |                                                 | Don't update the balance       |
|                  |                             |                                    |                                                 | Don't add new transaction      |
|                  |                             |                                    |                                                 |                                |
|                  |                             | withdraw(double amount, Date date) | nothing                                         | nothing                        |
|                  |                             |                                    |                                                 |                                |
|                  |                             |                                    | 4.                                              |                                |
| `CurrentAccount` |                             | withdraw(double amount, Date date) | if amount is greater than 0 and                 | Output success message         |
|                  |                             |                                    | balance is greater than or equal to amount      | Update balance                 |
|                  |                             |                                    |                                                 | Add new transaction to history |
|                  |                             |                                    | 4.                                              |                                |
|                  |                             |                                    | if amount is less than or equal to 0 and        | Output failure message         |
|                  |                             |                                    | balance is less than amount                     | Don't update the balance       |
|                  |                             |                                    |                                                 | Don't add new transaction      |
| `SavingsAccount` |                             | withdraw(double amount, Date date) | 4.                                              |                                |
|                  |                             |                                    | if amount is greater than 0 and                 | Output success message         |
|                  |                             |                                    | balance is greater than or equal to amount      | Update balance                 |
|                  |                             |                                    |                                                 | Add new transaction to history |
|                  |                             |                                    | 4.                                              |                                |
|                  |                             |                                    | if amount is less than or equal to 0 and        | Output failure message         |
|                  |                             |                                    | balance is less than amount                     | Don't update the balance       |
|                  |                             |                                    |                                                 | Don't add new transaction      |
| `Bank`           | `List<Account> accounts`    | addAccount(Account account)        | 1. and 2.                                       |                                |
|                  |                             |                                    | adds the account to the list of accounts        | void                           |
|                  |                             |                                    |                                                 |                                |
|                  |                             | getAccounts()                      | get the list of accounts                        | Return List<Account>           |
|                  |                             |                                    |                                                 |                                |
|                  |                             | bankStatement(Account account)     | 3.                                              |                                |
|                  |                             |                                    | prints all the transactions that have been done | Output details of transactions |
