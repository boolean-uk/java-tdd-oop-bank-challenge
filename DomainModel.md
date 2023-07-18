# Domain Model

| Class                    | methods                     | attributes                                              | scenario                                  | output |
|--------------------------|-----------------------------|---------------------------------------------------------|-------------------------------------------|--------|
| Account                  |                             | string accountNr, int balance, list<Transfer> transfers |                                           |        |
|                          | deposit(int amountOfMoney)  |                                                         | deposit money to account                  |        |
|                          | withdraw(int amountOfMoney) |                                                         | withdraw money from account               |        |
|                          | generateBankStatements()    |                                                         | generate nicely formatted bank statements |        |
|                          |                             |                                                         |                                           |        |
| CurrentAccount : Account |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
| SavingsAccount : Account |                             |                                                         |                                           |        |
|                          | overdraft()                 |                                                         | if overdraft is possible (less than 500)  | true   |
|                          |                             |                                                         | if overdraft is not possible              | false  |
| Transfer                 |                             | int amountOfMoney, Date date                            |                                           |        |
|                          |                             |                                                         |                                           |        |
| Deposit : Transfer       |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
| Withdraw : Transfer      |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
|                          |                             |                                                         |                                           |        |
