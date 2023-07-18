# Domain Model

| Class                    | methods                     | attributes                                                | scenario                                  | output |
|--------------------------|-----------------------------|-----------------------------------------------------------|-------------------------------------------|--------|
| Account                  |                             | string accountNr, Branch branch, list<Transfer> transfers |                                           |        |
|                          | deposit(int amountOfMoney)  |                                                           | deposit money to account                  |        |
|                          | withdraw(int amountOfMoney) |                                                           | withdraw money from account               |        |
|                          | generateBankStatements()    |                                                           | generate nicely formatted bank statements | String |
|                          | calculateBalance()          |                                                           | calculates current balance                | double |
|                          |                             |                                                           |                                           |        |
| CurrentAccount : Account |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
| SavingsAccount : Account |                             |                                                           |                                           |        |
|                          | overdraft()                 |                                                           | if overdraft is possible (less than 500)  | true   |
|                          |                             |                                                           | if overdraft is not possible              | false  |
| Transfer                 |                             | int amountOfMoney, Date date                              |                                           |        |
|                          |                             |                                                           |                                           |        |
| Deposit : Transfer       |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
| Withdraw : Transfer      |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
| Branch                   |                             | string code, String country, String city                  |                                           |        |
|                          |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
|                          |                             |                                                           |                                           |        |
