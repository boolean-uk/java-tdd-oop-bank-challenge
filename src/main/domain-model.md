| Class       | Methods                      | Scenario                     | Outcome                                        |
|-------------|------------------------------|------------------------------|------------------------------------------------|
| Account     | addTransaction()             |                              | new transaction is added                       |
|             | getCurrentBalance()          |                              | returns current balance                        |
|             | generateBankStatement()      |                              | returns string with all transactions           |
|             |                              |                              |                                                |
| Customer    | createAccount(String,String) |                              | creates new account with given type and branch |
|             | depositMoney(Account,int)    |                              | adds balance to given account                  |
|             | withdrawMoney(Account,int)   | not enough money to withdraw | overdraft is requested                         |
|             |                              | enough money to withdraw     | new transaction is added, money gets withdrawn |
|             | checkAccountBalance(Account) |                              | returns currentBalance                         |
| Transaction |                              |                              |                                                |