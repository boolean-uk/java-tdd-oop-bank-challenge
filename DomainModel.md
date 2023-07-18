# Domain Model

| Class                    | methods                     | attributes                                                | scenario                                            | output |
|--------------------------|-----------------------------|-----------------------------------------------------------|-----------------------------------------------------|--------|
| Account                  |                             | string accountNr, Branch branch, list<Transfer> transfers |                                                     |        |
|                          | deposit(int amountOfMoney)  |                                                           | deposit money to account                            |        |
|                          | withdraw(int amountOfMoney) |                                                           | withdraw money from account                         |        |
|                          | generateBankStatements()    |                                                           | generate nicely formatted bank statements           | String |
|                          | calculateBalance()          |                                                           | calculates current balance                          | int    |
|                          |                             |                                                           |                                                     |        |
| CurrentAccount : Account |                             |                                                           |                                                     |        |
|                          | overdraft()                 |                                                           | throws an IllegalStateException if overdraft occurs |        |
|                          |                             |                                                           | if there is no overdraft                            | false  |
|                          |                             |                                                           |                                                     |        |
| SavingsAccount : Account |                             |                                                           |                                                     |        |
|                          |                             |                                                           |                                                     |        |
| Transfer                 |                             | int amountOfMoney, Date date                              |                                                     |        |
|                          |                             |                                                           |                                                     |        |
| Deposit : Transfer       |                             |                                                           |                                                     |        |
|                          |                             |                                                           |                                                     |        |
| Withdraw : Transfer      |                             |                                                           |                                                     |        |
|                          |                             |                                                           |                                                     |        |
| Branch                   |                             | string code, String country, String city                  |                                                     |        |
|                          |                             |                                                           |                                                     |        |
