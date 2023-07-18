| Class         | Methods                                            | Scenario           | Outcome                                   |
|---------------|----------------------------------------------------|--------------------|-------------------------------------------|
| BankBranch    | createAccount(boolean isCurrentAccount)            | is current account | current account is created                |
|               |                                                    | is savings account | savings account is created                |
|               | getBankStatement(int accountNumber)                |                    | returns bank statement                    |
|               | depositMoney(int accountNumber, double amount)     |                    | deposits money on given account           |
|               | withdrawMoney(int accountNumber, double amount)    |                    | withdraws money from given account        |
|               | requestOverdraft(int accountNumber, double amount) | is current account | changes overdraft limit on given account  |
|               |                                                    | is savings account | does nothing                              |
|               |                                                    |                    |                                           |
| BankAccount   | generateBankStatement()                            |                    | generates bank statement                  |
|               | depositMoney(double amount)                        |                    | deposits money                            |
|               | withdrawMoney(double amount)                       |                    | withdraws money                           |
|               | calculateBalance()                                 |                    | returns account balance                   |
|               | requestOverdraft(double amount)                    | is current account | changes overdraft limit                   |
|               |                                                    | is savings account | does nothing                              |
|               |                                                    |                    |                                           |
| UserInterface | main(String[] args)                                |                    | displays user interface in terminal       |
