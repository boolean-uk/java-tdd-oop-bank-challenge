## Class diagram
![](./class_diagram.jpg)


### Customer class
| Method                        | Scenario                                            | Output                                                                           |
|-------------------------------|-----------------------------------------------------|----------------------------------------------------------------------------------|
| `openAccount(String): String` | Account name unique<br/>Account name already exists | "Account 'Account.name' opened."<br/>"Your already have an account by this name." |


### Transaction class
| Method | Scenario | Output |
|--------|----------|--------|
| -      | -        | -      |


### Account class
| Method                            | Scenario                                                | Output                                                   |
|-----------------------------------|---------------------------------------------------------|----------------------------------------------------------|
| `generateBankStatement(): String` | existing transaction<br/>no transaction                 | transactions<br/>"No account transactions available."    |
| `deposit(float): void`            | -                                                       | funds are added to account                               |
| `withdraw(float): String`         | enough funds in account<br/>not enough funds in account | "Funds withdrawed from account."<br/>"Not enough funds." |


### CurrentAccount extends Account class
| Method | Scenario | Output |
|--------|----------|--------|
| -      | -        | -      |


### SavingsAccount extends Account class
| Method | Scenario | Output |
|--------|----------|--------|
| -      | -        | -      |