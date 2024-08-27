## Class diagram
![](./class_diagram.jpg)


### Customer class
| Method                                       | Scenario                                                                  | Output                                                                                                                    |
|----------------------------------------------|---------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| `openCurrentAccount(String, String): String` | New current account<br/>Account name already exists                       | "Opened a new current account: 'Account.name', at branch: 'branch.name'."<br/>"You already have an account by this name." |
| `openSavingsAccount(String, String): String` | New savings account<br/>Account name already exists                       | "Opened a new savings account: 'Account.name', at branch: 'branch.name'."<br/>"You already have an account by this name." |
| `getAccount(String): Account`                | Account with given name exists<br/>Account with given name does not exist | Account<br/>null                                                                                                          |


### Manager class
| Method                                   | Scenario                                                                    | Output       |
|------------------------------------------|-----------------------------------------------------------------------------|--------------|
| `approveOverdraftRequest(Account): void` | Request for overdraft sent and account branch is the same as manager branch | approved     |
| `denyOverdraftRequest(Account): void`    | Request for overdraft sent and account branch is the same as manager branch | not approved |



### Transaction class
| Method | Scenario | Output |
|--------|----------|--------|
| -      | -        | -      |


### Account class
| Method                          | Scenario                                                          | Output                                                  |
|---------------------------------|-------------------------------------------------------------------|---------------------------------------------------------|
| `deposit(float): void`          | -                                                                 | funds are added to account                              |
| `withdraw(float): String`       | enough funds in account<br/>not enough funds in account           | "Funds withdrawn from account."<br/>"Not enough funds." |
| `getBalanceInCents(): int`      | Transaction history is not empty<br/>Transaction history is empty | balance<br/>0                                           |
| `generateBankStatement(): void` | existing transaction<br/>no transaction                           | transactions<br/>"No account transactions available."   |
| `printBankStatement(): void`    | existing transaction<br/>no transaction                           | transactions<br/>"No account transactions available."   |


### CurrentAccount extends Account class
| Method                        | Scenario                                                                      | Output                                                  |
|-------------------------------|-------------------------------------------------------------------------------|---------------------------------------------------------|
| `requestOverdraft(): Boolean` | Request sent<br/>Request not sent                                             | true<br/>false                                          |
| `withdraw(float): String`     | enough funds in account or overdraft approved<br/>not enough funds in account | "Funds withdrawn from account."<br/>"Not enough funds." |


### SavingsAccount extends Account class
| Method | Scenario | Output |
|--------|----------|--------|
| -      | -        | -      |