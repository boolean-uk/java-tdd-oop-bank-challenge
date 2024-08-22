| Classes                  | Variables                    | Methods                     | Scenarios | Outcomes |
|--------------------------|------------------------------|-----------------------------|-----------|----------|
| `Bank`                   | `Branches[] branches`        |                             |           |          |
|                          | `Manager[] managers`         |                             |           |          |
|                          | `Costumer[] costumers`       |                             |           |          |
|                          |                              |                             |           |          |
| `Branch`                 | `Account accounts[]`         |                             |           |          |
|                          | `Manager manager`            |                             |           |          |
|                          | `Costumer[] costumers`       |                             |           |          |
|                          |                              |                             |           |          |
| `Manager`                | `OverDrafts[] overdrafts`    |                             |           |          |
|                          | `Branch branch`              |                             |           |          |
|                          |                              |                             |           |          |
| `OverDrafts`             |                              |                             |           |          |
|                          |                              |                             |           |          |
| `interface`              |                              | `double getBalance`         |           |          |
| `Transaction`            |                              | `void deposit(int amount)`  |           |          |
|                          |                              | `void withdraw(int amount)` |           |          |
|                          |                              |                             |           |          |
|                          |                              |                             |           |          |
| `Account`                | `Costumer costumer`          |                             |           |          |
|                          | `Transaction[] transactions` |                             |           |          |
|                          |                              |                             |           |          |
|                          |                              |                             |           |          |
| `SavingsAccount`         |                              |                             |           |          |
| `inherits from Account`  |                              |                             |           |          |
|                          |                              |                             |           |          |
| `CurrentAccount`         |                              |                             |           |          |
| `inherits from Account`  |                              |                             |           |          |
|                          |                              |                             |           |          |
|                          |                              |                             |           |          |
|                          |                              |                             |           |          |
| `Costumer`               | `String id`                  |                             |           |          |
|                          | `String name`                |                             |           |          |
|                          |                              |                             |           |          |
|                          |                              |                             |           |          |
|                          |                              |                             |           |          |
| `Individual`             |                              |                             |           |          |
| `inherits from cosutmer` |                              |                             |           |          |
|                          |                              |                             |           |          |
|                          |                              |                             |           |          |
| `Company`                |                              |                             |           |          |
| `inherits from costumer` |                              |                             |           |          |
|                          |                              |                             |           |          |
