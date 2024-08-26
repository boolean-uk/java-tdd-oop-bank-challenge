## Class diagram
![](./class_diagram.jpg)


### Customer class
| Method                                       | Scenario                                            | Output                                                                                                                     |
|----------------------------------------------|-----------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|
| `openCurrentAccount(String, String): String` | New current account<br/>Account name already exists | "Opened a new current account: 'Account.name', at branch: 'branch.name'."<br/>"Your already have an account by this name." |
| `openSavingsAccount(String, String): String` | New savings account<br/>Account name already exists | "Opened a new savings account: 'Account.name', at branch: 'branch.name'."<br/>"Your already have an account by this name." |


### Transaction class
| Method | Scenario | Output |
|--------|----------|--------|
| -      | -        | -      |


### Account class
| Method                            | Scenario                                                          | Output                                                   |
|-----------------------------------|-------------------------------------------------------------------|----------------------------------------------------------|
| `generateBankStatement(): String` | existing transaction<br/>no transaction                           | transactions<br/>"No account transactions available."    |
| `deposit(float): void`            | -                                                                 | funds are added to account                               |
| `withdraw(float): String`         | enough funds in account<br/>not enough funds in account           | "Funds withdrawed from account."<br/>"Not enough funds." |
| `getBalance(): float`             | Transaction history is not empty<br/>Transaction history is empty | balance<br/>0                                            |


### CurrentAccount extends Account class
| Method | Scenario | Output |
|--------|----------|--------|
| -      | -        | -      |


### SavingsAccount extends Account class
| Method | Scenario | Output |
|--------|----------|--------|
| -      | -        | -      |