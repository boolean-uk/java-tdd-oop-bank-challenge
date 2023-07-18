| Class         | Members        | Methods | Scenarios | Outputs |
|---------------|----------------|---------|-----------|---------|
| `Transaction` | `Date date`    |         |           |         |
|               | `float amount` |         |           |         |

| Class         | Members                                       | Methods                                                        | Scenarios                                                   | Outputs |
|---------------|-----------------------------------------------|----------------------------------------------------------------|-------------------------------------------------------------|---------|
| `BankAccount` | `HashMap<String, List<Transaction>> accounts` | `getAccountHistory(String accountName)`                        | showing accounts history if accountName is valid            | String  |
|               |                                               |                                                                | showing error if accountName is not valid                   | String  |
|               |                                               | `deposite(String accountName, int amount)`                     | account with given accountName exists and amount is valid   | true    |
|               |                                               |                                                                | account with given accountName do not exists                | false   |
|               |                                               |                                                                | amount is in valid                                          | false   |
|               |                                               | `withdraw(String accountName, int ammount)`                    | account with given accountName exists and amount is valid   | float   |
|               |                                               |                                                                | account with given accountName not exists                   | float   |
|               |                                               |                                                                | amount is invalid                                           | float   |
