## User Stories

1. Customer create a current account✔️
2. Customer create a savings account✔️
3. Customer create bank statements(dates,amount,balance.(at transaction))✔️
4. Customer can deposit and withdraw from account✔️

## Extensions

5. Engineer want to transaction history generate account balance✔️
6. Bank Manager accounts associated with branches✔️
7. Customer request an overdraft on my account✔️
8. Bank Manager approve/reject overdraft requests✔️
9. Customer get statements sent to the customer phone?

| Class                               | Member                                | Method                                     | Scenario                                     | Output  |
|-------------------------------------|---------------------------------------|--------------------------------------------|----------------------------------------------|---------|
| Customer                            |                                       |                                            |                                              |         |
|                                     | CustomerAccount[] accounts            |                                            |                                              |         |
|                                     | CUSTOMERCODE code                     |                                            |                                              |         | 
|                                     |                                       | (1) createCurrent()                        | if exists                                    | false   |
|                                     |                                       | (2)createSavings()                         | if exists                                    | false   |
|                                     |                                       | (3)printStatement(Account account)         |                                              | void    |
|                                     |                                       | (4)deposit(Account account,double amount)  | true if account exists and amount make sense | boolean |
|                                     |                                       | (4)withdraw(Account account,double amount) | true if account exists and amount make sense | boolean |
|                                     |                                       |                                            |                                              |         |
| BankAccount                         |                                       |                                            |                                              |         |
|                                     | `ArrayList<BankStatement> statements` |                                            |                                              |         |
|                                     | boolean overdraft                     |                                            |                                              |         |
|                                     |                                       | printStatements(BankAccount account)       |                                              |         |
|                                     |                                       | deposit(double deposit)                    |                                              |         |
|                                     |                                       | withdraw(double withdraw)                  |                                              |         |
| CustomerAccount extends BankAccount |                                       |                                            |                                              |         |
|                                     | ACCOUNTYPE type                       |                                            |                                              |         |
|                                     | BALANCETYPE balanceType               |                                            |                                              |         |
|                                     |                                       | boolean checkBalance(double amount)        |                                              |         |
|                                     |                                       | double getBalance()                        |                                              |         |
|                                     |                                       |                                            |                                              |         |
| BankStatement                       |                                       |                                            |                                              |         |
|                                     | Date date                             |                                            |                                              |         |
|                                     | double credit                         |                                            |                                              |         |
|                                     | double debit                          |                                            |                                              |         |
|                                     | double balance                        |                                            |                                              |         |
|                                     |                                       | withdraw(double debit,double balance)      |                                              |         |
|                                     |                                       | deposit(double credit,double balance)      |                                              |         |
|                                     |                                       |                                            |                                              |         |
