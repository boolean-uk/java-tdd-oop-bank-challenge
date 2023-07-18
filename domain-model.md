#Core

| Class     | Members                                | Methods                   | Scenario                                                                  | Outputs |
|-----------|----------------------------------------|---------------------------|---------------------------------------------------------------------------|---------|
| `Account` | `balance`                              | `deposit(float amount)`   | deposits given amount of money if amount > 0                              | true    |
|           | `ArrayList<Transaction> transactions`  |                           | does not deposit given amount of money if amount < 0                      | false   |
|           |                                        | `withdraw(float amount)`  | withdraws given amount of money if amount > 0 and balance >= amount       | true    |
|           |                                        |                           | does not withdraw given amount of money if amount < 0 or balance < amount | false   |
|           |                                        | `generateBankStatement()` | generates bank statement                                                  | String  |
|           |                                        | `checkBalance()`          | returns balance                                                           | float   |

| Class         | Members   |
|---------------|-----------|
| `Transaction` | `date`    |
|               | `credit`  |
|               | `debit`   |
|               | `balance` |

| Class                            |
|----------------------------------|
| `CurrentAccount extends Account` |

| Class                            |
|----------------------------------|
| `SavingsAccount extends Account` |

#Extension

| Class     | Members                                | Methods                      | Scenario                                                                  | Outputs |
|-----------|----------------------------------------|------------------------------|---------------------------------------------------------------------------|---------|
| `Account` | `ArrayList<Transaction> transactions`  | `deposit(float amount)`      | deposits given amount of money if amount > 0                              | true    |
|           |                                        |                              | does not deposit given amount of money if amount < 0                      | false   |
|           |                                        | `withdraw(float amount)`     | withdraws given amount of money if amount > 0 and balance >= amount       | true    |
|           |                                        |                              | does not withdraw given amount of money if amount < 0 or balance < amount | false   |
|           |                                        | `generateBankStatement()`    | generates bank statement                                                  | String  |
|           |                                        | `checkBalance()`             | returns balance based on list of transactions                             | float   |
|           |                                        | `sendBankStatementViaSms()`  | sends bank statement via sms                                              | void    |

| Class         | Members   |
|---------------|-----------|
| `Transaction` | `date`    |
|               | `credit`  |
|               | `debit`   |
|               | `balance` |

| Class                            | Methods                                            |
|----------------------------------|----------------------------------------------------|
| `CurrentAccount extends Account` | `withdraw(float amount, boolean managerApproved)`  |

| Class                            |
|----------------------------------|
| `SavingsAccount extends Account` |