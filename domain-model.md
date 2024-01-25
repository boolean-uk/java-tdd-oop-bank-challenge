# Bank Challenge

````dtd
As a customer,
So I can safely store and use my money,
I want to create a current account.
````

| Classes                                | Methods                                             | Member Variable                           | Scenario                           | Output/Result                                                                   |
|----------------------------------------|-----------------------------------------------------|-------------------------------------------|------------------------------------|---------------------------------------------------------------------------------|
| User, Account, Account::CurrentAccount | User::createCurrentAccount(String name, String ...) | String userName                           | I want to create a current account | A current account is made, with a generated ID, 0 funds, and saved creationDate |
|                                        | Account::CurrentAccount(String name, String ...)    | LocalDate creationDate                    |                                    |                                                                                 |
|                                        |                                                     | Integer balance                           |                                    |                                                                                 |
|                                        |                                                     | ArrayList<Transaction> transactionHistory |                                    |                                                                                 |
|                                        |                                                     | String userID                             |                                    |                                                                                 |
|                                        |                                                     | String accountID                          |                                    |                                                                                 |

````dtd
As a customer,
So I can save for a rainy day,
I want to create a savings account.
````

| Classes                                   | Methods                                             | Member Variables                          | Scenario                           | Output/Result                                                                  |
|-------------------------------------------|-----------------------------------------------------|-------------------------------------------|------------------------------------|--------------------------------------------------------------------------------|
| User, Account, Account::SavingsAccount,   | User::createSavingsAccount(String name, String ...) | String userName                           | I want to create a savings account | A savings account is made,with a generated ID, 0 funds, and saved creationDate |
|                                           | Account::SavingsAccount(String name, String ...)    | LocalDate creationDate                    |                                    |                                                                                |
|                                           |                                                     | Integer balance                           |                                    |                                                                                |
|                                           |                                                     | ArrayList<Transaction> transactionHistory |                                    |                                                                                |
|                                           |                                                     | String userID                             |                                    |                                                                                |
|                                           |                                                     | String accountID                          |                                    |                                                                                |

````dtd
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
````

| Classes                                                                      | Methods                                       | Member Variables                                   | Scenario                             | Output/Result                                                 |
|------------------------------------------------------------------------------|-----------------------------------------------|----------------------------------------------------|--------------------------------------|---------------------------------------------------------------|
| User, Account, Account::SavingsAccount, Account::CurrentAccount, Transaction | User::generateBankStatement(String accountID) | Account::ArrayList<Transaction> transactionHistory | I have made one or more transactions | The transactions in the lsit are shown as a table             |
|                                                                              |                                               | String userName                                    | I have made no transactions          | The transactions list is empty, and the table has no contents |
|                                                                              |                                               | String userID                                      |                                      |                                                               |
|                                                                              |                                               | String accountID                                   |                                      |                                                               |

````dtd
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
````

| Classes                                                                      | Methods                                   | Member Variables                          | Scenario                                                            | Output/Results                                                                             |
|------------------------------------------------------------------------------|-------------------------------------------|-------------------------------------------|---------------------------------------------------------------------|--------------------------------------------------------------------------------------------|
| User, Account, Account::SavingsAccount, Account::CurrentAccount, Transaction | SavingsAccount::withdrawFunds(int amount) | ArrayList<Transaction> transactionHistory | I want to deposit to my current/savings account 500 money           | 500 is added to the balance of the account                                                 |
|                                                                              | CurrentAccount::withdrawFunds(int amount) | String accountID                          | I want to withdraw 500 from my current/savings account, it has 1000 | 500 is withdrawn, account balance is now 500                                               |
|                                                                              | SavingsAccount::depositFunds(int amount)  | LocalDate transactionDate                 | I want to withdraw 500 from my current account, it has 300          | 500 is withdrawn, account balance is now -200                                              |
|                                                                              | CurrentAccount::depositFunds(int amount)  | LocalTime transactionTime                 | I want to withdraw 500 from my savings account, it has 300          | A message is displayed showing user the account does not have enough funds. No action done |

## Extension

````dtd
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.
````

| Classes                                                                      | Methods               | Member Variables | Scenario                                                              | Output/Result                        |
|------------------------------------------------------------------------------|-----------------------|------------------|-----------------------------------------------------------------------|--------------------------------------|
| User, Account, Account::SavingsAccount, Account::CurrentAccount, Transaction | Account::getBalance() | int balance      | User wants to see balance, with a deposit of 300 av withdrawal of 100 | The balance is calculated, being 200 |
|                                                                              |                       |                  |                                                                       |                                      |
