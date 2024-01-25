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

````dtd
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.
````

| Classes               | Methods                               | Member Variables | Scenario                                                         | Output/Result                                                       |
|-----------------------|---------------------------------------|------------------|------------------------------------------------------------------|---------------------------------------------------------------------|
| User, Account, Branch | User::createAccount(String name, ...) | String branch    | A user in Trondheim wants to create an account                   | The account is created, and is associated with the Trondheim branch |
|                       | Account::assignBranch(Branch branch)  |                  | A user in Oslo wants ot create an account                        | The account is created, and is associated with the Oslo branch      |
|                       |                                       |                  | A user with an account in Trondheim wants to transfer it to Oslo | The branch the account is associated with is changed to Oslo        |

````dtd
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.
````

| Classes      | Methods                                              | Member Variables | Scenario                                              | Output/Result                                                           |
|--------------|------------------------------------------------------|------------------|-------------------------------------------------------|-------------------------------------------------------------------------|
| User, Branch | User::requestOverdraft(String accountID, int amount) |                  | A user wants an overdraft of 5000, they have 100 left | 5000 is withdrawn, and their balance is -4900                           |
|              |                                                      |                  | A user wants an overdraft of 100, they have 101 left  | The money is withdrawn as normal, as the user has enough funds for this |
