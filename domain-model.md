# Domain model Bank Challange core 

1 As a customer,
So I can safely store and use my money,
I want to create a current account.

2 As a customer,
So I can save for a rainy day,
I want to create a savings account.

3 As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

4 As a customer,
So I can use my account,
I want to deposit and withdraw funds.


| Classes  | Methods                                           | Member Variables       | Scenario                                           | Result/Output                                       |
|----------|---------------------------------------------------|------------------------|----------------------------------------------------|-----------------------------------------------------|
| Customer |                                                   | Account savingsAccount |                                                    |                                                     |
|          |                                                   | Account currentAccount |                                                    |                                                     |
|          |                                                   |                        |                                                    |                                                     |
|          | boolean createAccount(String type)                |                        | 1. if type equals "Current"                        | initializes a current account return true           |
|          |                                                   |                        | 2. if type equals "Savings"                        | initializes a savings account return true           |
|          |                                                   |                        | else                                               | output message invalid account type return false    |
|          |                                                   |                        |                                                    |                                                     |
|          | String generateBankStatement(Account account)     |                        | 3. generate a bank statement for the given account | Returns a bank statement                            |
|          |                                                   |                        |                                                    |                                                     |
|          | boolean deposit(Account account, double amount)   |                        | 4. if amount > 0                                   | add amount to balance of giving account return true |
|          |                                                   |                        | if amount < 0                                      | return false                                        |
|          |                                                   |                        |                                                    |                                                     |
|          | boolean withdraw (Account account, double amount) |                        | 4. if amount < balance                             | remove amount from balance return true              |
|          |                                                   |                        | if amount > balance or amount < 0                  | return false                                        |
|          |                                                   |                        |                                                    |                                                     |
|          |                                                   |                        |                                                    |                                                     |


| Classes                    | Methods               | Member Variables               | Scenario | Result/Output                                                   |
|----------------------------|-----------------------|--------------------------------|----------|-----------------------------------------------------------------|
| Account                    |                       | double balance                 |          |                                                                 |
|                            |                       | List<Transaction> transactions |          |                                                                 |
|                            |                       | int accountNr;                 |          |                                                                 |
|                            | add(double amount)    |                                |          | adds amount to balance, generates date and adds to transactions |
|                            |                       |                                |          |                                                                 |
|                            | remove(double amount) |                                |          | adds amount to balance, generates date and adds to transactions |
|                            |                       |                                |          |                                                                 |
|                            | getBalance()          |                                |          | returns current balance                                         |
|                            |                       |                                |          |                                                                 |
|                            | getTransactions()     |                                |          | returns transactions                                            |
|                            | getAccountNr()        |                                |          | returns accountNr                                               |
| SavingsAccount             |                       |                                |          |                                                                 |
| CurrentAccount             |                       |                                |          |                                                                 |
| both inherits from Account |                       |                                |          |                                                                 |

| Classes     | Methods    | Member Variables | Scenario | Result/Output  |
|-------------|------------|------------------|----------|----------------|
| Transaction |            | String Date      |          |                |
|             |            | double Amount    |          |                |
|             |            | double Balance   |          |                |
|             |            |                  |          |                |
|             | getDate    |                  |          | return date    |
|             | getAmount  |                  |          | return amount  |
|             | getBalance |                  |          | return balance |
|             |            |                  |          |                |




# Extension 


5 As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

6 As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

7 As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

8 As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

9 As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.



| Classes  | Methods                                                         | Member Variables         | Scenario                                                     | Result/Output                                       |
|----------|-----------------------------------------------------------------|--------------------------|--------------------------------------------------------------|-----------------------------------------------------|
| Customer |                                                                 | Account savingsAccount   |                                                              |                                                     |
|          |                                                                 | Account currentAccount   |                                                              |                                                     |
|          |                                                                 | OverDraftRequest request |                                                              |                                                     |
|          | boolean createAccount(String type)                              |                          | 1. if type equals "Current"                                  | initializes a current account return true           |
|          |                                                                 |                          | 2. if type equals "Savings"                                  | initializes a savings account return true           |
|          |                                                                 |                          | else                                                         | output message invalid account type return false    |
|          |                                                                 |                          |                                                              |                                                     |
|          | String generateBankStatement(Account account)                   |                          | 3. generate a bank statement for the given account           | Returns a bank statement                            |
|          |                                                                 |                          |                                                              |                                                     |
|          | boolean deposit(Account account, double amount)                 |                          | 4. if amount > 0                                             | add amount to balance of giving account return true |
|          |                                                                 |                          | if amount < 0                                                | return false                                        |
|          |                                                                 |                          |                                                              |                                                     |
|          | boolean withdraw (Account account, double amount)               |                          | 4. if amount < balance + accounts overDraftLimit             | remove amount from balance return true              |
|          |                                                                 |                          | if amount >  balance + accounts overDraftLimit or amount < 0 | return false                                        |
|          |                                                                 |                          |                                                              |                                                     |
|          | boolean requestOverDraft(CurrentAccount account, double amount) |                          | if amount > 0                                                | 7. creates new overDraftRequest return true         |
|          |                                                                 |                          | if amount < 0                                                | return false                                        |
|          |                                                                 |                          |                                                              |                                                     |
|          |                                                                 |                          |                                                              |                                                     |

| Classes          | Methods                | Member Variables       | Scenario | Result/Output                                                                                                             |
|------------------|------------------------|------------------------|----------|---------------------------------------------------------------------------------------------------------------------------|
| OverDraftRequest |                        | boolean isAccepted     |          |                                                                                                                           |
|                  |                        | boolean isPending      |          |                                                                                                                           |
|                  |                        | double limit           |          |                                                                                                                           |
|                  |                        | CurrentAccount account |          |                                                                                                                           |
|                  |                        |                        |          |                                                                                                                           |
|                  | String acceptRequest() |                        |          | change isPending to false, change isAccepted to true set accounts overdraftLimit to limit, return message saying accepted |
|                  |                        |                        |          |                                                                                                                           |
|                  | String rejectRequest() |                        |          | return message saying rejected                                                                                            |

| Classes     | Methods                                                   | Member Variables | Scenario              | Result/Output                  |
|-------------|-----------------------------------------------------------|------------------|-----------------------|--------------------------------|
| BankManager |                                                           |                  |                       |                                |
|             |                                                           |                  |                       |                                |
|             | 8 DecideRequest(OverDraftRequest request, boolean accept) |                  | 8. if accept is true  | call acceptRequest on request  |
|             |                                                           |                  | 8. if accept is false | call reject request on request |
|             |                                                           |                  |                       |                                |

| Classes                    | Methods                       | Member Variables               | Scenario                          | Result/Output                                                   |
|----------------------------|-------------------------------|--------------------------------|-----------------------------------|-----------------------------------------------------------------|
| Account                    |                               | double balance                 |                                   |                                                                 |
|                            |                               | List<Transaction> transactions |                                   |                                                                 |
|                            |                               | int accountNr;                 |                                   |                                                                 |
|                            |                               |                                |                                   |                                                                 |
|                            |                               |                                |                                   |                                                                 |
|                            | boolean add(double amount)    |                                | if amount < balance               | adds amount to balance, generates date and adds to transactions |
|                            |                               |                                | if amount > balance or amount < 0 | return false;                                                   |
|                            |                               |                                |                                   |                                                                 |
|                            | boolean remove(double amount) |                                |                                   | adds amount to balance, generates date and adds to transactions |
|                            |                               |                                |                                   |                                                                 |
|                            | getBalance()                  |                                |                                   | returns current balance                                         |
|                            |                               |                                |                                   |                                                                 |
|                            | getTransactions()             |                                |                                   | returns transactions                                            |
|                            | getAccountNr()                |                                |                                   | returns accountNr                                               |
|                            |                               |                                |                                   |                                                                 |
| SavingsAccount             |                               |                                |                                   |                                                                 |
| CurrentAccount             |                               |                                |                                   |                                                                 |
| both inherits from Account |                               |                                |                                   |                                                                 |


| Classes                    | Methods                               | Member Variables       | Scenario                                                      | Result/Output                          |
|----------------------------|---------------------------------------|------------------------|---------------------------------------------------------------|----------------------------------------|
| CurrentAccount             |                                       | double overDraftLimit  |                                                               |                                        |
|                            |                                       |                        |                                                               |                                        |
|                            | boolean setOverDraftLimit             |                        | if overDraftLimit > 0                                         | set new overDraftLimit return true     |
|                            |                                       |                        | else                                                          | return false                           |
|                            |                                       |                        |                                                               |                                        |
|                            | @Override Account add (double amount) |                        | if amount < balance + accounts overDraftLimit                 | remove amount from balance return true |
|                            |                                       |                        | if amount >  balance + accounts overDraftLimit or amount < 0  | return false                           |
|                            |                                       |                        |                                                               |                                        |



| Classes     | Methods    | Member Variables | Scenario | Result/Output  |
|-------------|------------|------------------|----------|----------------|
| Transaction |            | String Date      |          |                |
|             |            | double Amount    |          |                |
|             |            | double Balance   |          |                |
|             |            |                  |          |                |
|             | getDate    |                  |          | return date    |
|             | getAmount  |                  |          | return amount  |
|             | getBalance |                  |          | return balance |
|             |            |                  |          |                |


