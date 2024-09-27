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

5. As an engineer,
   So I don't need to keep track of state,
   I want account balances to be calculated based on transaction history instead of stored in memory.

6. As a bank manager,
   So I can expand,
   I want accounts to be associated with specific branches.


| Classes          | Members                                   | Methods                                                | Scenario                                                  | Results                                 |
|------------------|-------------------------------------------|--------------------------------------------------------|-----------------------------------------------------------|-----------------------------------------|
| `Transaction`    | `String date`                             | setDate(String date)                                   | set the date                                              | void                                    |
|                  | `double credit`                           | getDate()                                              | get the date                                              | Return String                           |
|                  | `double debit`                            | setCredit(double credit)                               | set the credit                                            | void                                    |
|                  | `double balance`                          | getCredit()                                            | get the credit                                            | Return double                           |
|                  |                                           | setDebit(double debit)                                 | set the debit                                             | void                                    |
|                  |                                           | getDebit()                                             | get the debit                                             | Return double                           |
|                  |                                           | setBalance(double balance)                             | set the balance                                           | void                                    |
|                  |                                           | getBalance()                                           | get the balance                                           | Return double                           |
|                  |                                           |                                                        |                                                           |                                         |
| `Account`        | `String accountNumber`                    | getBalance()                                           | get the balance                                           | Return double                           |
|                  | `double balance`                          | getHistory()                                           | get the history of transaction                            | Return List<Transaction>                |
|                  | `List<Transaction> history`               | getAccountNumber()                                     | get the number of the account                             | Return String                           |
|                  |                                           |                                                        |                                                           |                                         |
|                  |                                           |                                                        | 4.                                                        |                                         |
|                  |                                           | deposit(double amount, Date date)                      | if amount is greater than 0                               | Output success message                  |
|                  |                                           |                                                        |                                                           | Update balance                          |
|                  |                                           |                                                        |                                                           | Add new transaction to history          |
|                  |                                           |                                                        | 4.                                                        |                                         |
|                  |                                           |                                                        | if amount is less than or equal to 0                      | Output failure message                  |
|                  |                                           |                                                        |                                                           | Don't update the balance                |
|                  |                                           |                                                        |                                                           | Don't add new transaction               |
|                  |                                           |                                                        |                                                           |                                         |
|                  |                                           | withdraw(double amount, Date date)                     | nothing                                                   | nothing                                 |
|                  |                                           |                                                        |                                                           |                                         |
|                  |                                           |                                                        | 4.                                                        |                                         |
| `CurrentAccount` |                                           | withdraw(double amount, Date date)                     | if amount is greater than 0 and                           | Output success message                  |
|                  |                                           |                                                        | balance is greater than or equal to amount                | Update balance                          |
|                  |                                           |                                                        |                                                           | Add new transaction to history          |
|                  |                                           |                                                        | 4.                                                        |                                         |
|                  |                                           |                                                        | if amount is less than or equal to 0 and                  | Output failure message                  |
|                  |                                           |                                                        | balance is less than amount                               | Don't update the balance                |
|                  |                                           |                                                        |                                                           | Don't add new transaction               |
| `SavingsAccount` |                                           | withdraw(double amount, Date date)                     | 4.                                                        |                                         |
|                  |                                           |                                                        | if amount is greater than 0 and                           | Output success message                  |
|                  |                                           |                                                        | balance is greater than or equal to amount                | Update balance                          |
|                  |                                           |                                                        |                                                           | Add new transaction to history          |
|                  |                                           |                                                        | 4.                                                        |                                         |
|                  |                                           |                                                        | if amount is less than or equal to 0 and                  | Output failure message                  |
|                  |                                           |                                                        | balance is less than amount                               | Don't update the balance                |
|                  |                                           |                                                        |                                                           | Don't add new transaction               |
| `Bank`           | `List<Account> accounts`                  | addAccount(Account account)                            | 1. and 2.                                                 |                                         |
|                  | `List<Branch> listOfBranches`             |                                                        | adds the account to the accounts list if it doesn't exist | Output success message                  |
|                  | `HashMap<Account, Branch> accountsBranch` |                                                        |                                                           | void                                    |
|                  |                                           |                                                        |                                                           |                                         |
|                  |                                           |                                                        | if the account already exist                              | Output failure message                  |
|                  |                                           |                                                        |                                                           |                                         |
|                  |                                           | getAccounts()                                          | get the list of accounts                                  | Return List<Account>                    |
|                  |                                           |                                                        |                                                           |                                         |
|                  |                                           | bankStatement(Account account)                         | 3.                                                        |                                         |
|                  |                                           |                                                        | prints all the transactions that have been done           | Output details of transactions          |
|                  |                                           |                                                        |                                                           |                                         |
|                  |                                           | printBalance(Account account)                          | 5.                                                        |                                         |
|                  |                                           |                                                        | prints the total balance of the history transaction       | Return double                           |
|                  |                                           |                                                        | of a specific account                                     |                                         |
|                  |                                           |                                                        |                                                           |                                         |
|                  |                                           | getAccountBranch()                                     | gets the hashMap of account associated with a branch      | Return HashMap<Account, Branch>         |
|                  |                                           |                                                        |                                                           |                                         |
|                  |                                           | fillBranches()                                         | fills a list with branches                                | A list of Branch objects                |
|                  |                                           |                                                        |                                                           | void                                    |
|                  |                                           | addAccountAtBranch(Account account, String branchName) | 6.                                                        |                                         |
|                  |                                           |                                                        | if branchName isn't empty and account exists              | Output success message                  |
|                  |                                           |                                                        | add this account to a specific branch                     | Update the hashMap accountsBranch       |
|                  |                                           |                                                        |                                                           | void                                    |
|                  |                                           |                                                        |                                                           |                                         |
|                  |                                           |                                                        | if branchName is empty or account doesn't exist           | Output failure message                  |
|                  |                                           |                                                        |                                                           | Don't update the hashMap accountsBranch |
|                  |                                           |                                                        |                                                           | void                                    |
|                  |                                           |                                                        |                                                           |                                         |
| `Branch`         | `String branchName`                       | setBranchName(String branchName)                       | set the name of branch                                    | void                                    |
|                  | `String location`                         | getBranchName()                                        | get the name of branch                                    | Return String                           |
|                  |                                           | setLocation(String location)                           | set the location of branch                                | void                                    |
|                  |                                           | getLocation()                                          | get the location of branch                                | Return String                           |
