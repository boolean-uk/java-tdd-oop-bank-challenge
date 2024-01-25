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
|          |                                                   |                        | if amount > balance                                | return false                                        |
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

| Classes     | Methods               | Member Variables | Scenario | Result/Output                                                   |
|-------------|-----------------------|------------------|----------|-----------------------------------------------------------------|
| Transaction |                       | String Date      |          |                                                                 |
|             |                       | double Amount    |          |                                                                 |
|             |                       |                  |          |                                                                 |



