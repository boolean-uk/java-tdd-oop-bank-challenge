| Class         | Members        | Methods | Scenarios | Outputs |
|---------------|----------------|---------|-----------|---------|
| `Transaction` | `Date date`    |         |           |         |
|               | `float amount` |         |           |         |

| Class         | Members                                       | Methods                                     | Scenarios                                                   | Outputs |
|---------------|-----------------------------------------------|---------------------------------------------|-------------------------------------------------------------|---------|
| `BankAccount` | `HashMap<String, List<Transaction>> accounts` | `makeTransaction(Transaction transaction)`  | transaction is valid                                        | true    |
|               |                                               |                                             | transaction is invalid                                      | false   |
|               |                                               |                                             | client wants to withdrawal money but has not enough         | false   |
|               |                                               | `getAccountHistory(String accountName)`     | showing accounts history if accountName is valid            | String  |
|               |                                               |                                             | showing error if accountName is not valid                   | String  |
|               |                                               | `getCurrentBalance(String accountName)`     | showing current account balance if accountName is valid     | float   |
|               |                                               |                                             | showing current account balance if accountName is not valid | float   |
|               |                                               | `deposite(String accountName, int amount)`  | account with given accountName exists and amount is valid   | true    |
|               |                                               |                                             | account with given accountName do not exists                | false   |
|               |                                               |                                             | amount is in valid                                          | false   |
|               |                                               | `withdraw(String accountName, int ammount)` | account with given accountName exists and amount is valid   | float   |
|               |                                               |                                             | account with given accountName not exists                   | float   |
|               |                                               |                                             | amount is invalid                                           | float   |
