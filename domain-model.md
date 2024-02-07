| Class           | Methods               | Variable                                      | Scenario | Output |
|-----------------|-----------------------|-----------------------------------------------|----------|--------|
| CustomerAccount | void setBalanceCent() | String accountNum                             |          |        |
|                 |                       | String name                                   |          |        |
|                 |                       | String branchNum                              |          |        |
|                 |                       | Integer balanceCent                           |          |        |
|                 |                       | LocalDateTime dateTime                        |          |        |
|                 |                       | SortedMap<LocalDateTime, Integer> transaction |          |        |
|                 |                       | boolean approvedOverdraft                     |          |        |


| Class                  | Methods                  | Variable | Scenario | Output |
|------------------------|--------------------------|----------|----------|--------|
| CurrentCustomerAccount | CurrentCustomerAccount() |          |          |        |
|                        |                          |          |          |        |
|                        |                          |          |          |        |

| Class                 | Methods                 | Variable | Scenario | Output |
|-----------------------|-------------------------|----------|----------|--------|
| CustomerSavingAccount | CustomerSavingAccount() |          |          |        |
|                       |                         |          |          |        |
|                       |                         |          |          |        |
|                       |                         |          |          |        |
|                       |                         |          |          |        |

| Class   | Methods                                                                                              | Variable                               | Scenario                                        | Output         |
|---------|------------------------------------------------------------------------------------------------------|----------------------------------------|-------------------------------------------------|----------------|
| Account | boolean addCustomerAccount(String accountType, String accountNumber, String name, String branchCode) | double balance                         | Account can be created                          | Return true    |
|         |                                                                                                      | List<CustomerAccount> customerAccounts | Account can't be created                        | Return false   |
|         | CustomerAccount findCustomerAccount(String accountNumber)                                            |                                        | Account exists                                  | Return account |
|         |                                                                                                      |                                        | Account don't exists                            | Return null    |
|         | boolean deposit(String accountNumber, double amountToDeposit)                                        |                                        | Account exists can deposit                      | Return true    |
|         |                                                                                                      |                                        | Account don't exists can't deposit              | Return false   |
|         | boolean withdraw(String accountNumber, double amountToWithdrawDollar)                                |                                        | Account exists can withdraw                     | Return true    |
|         |                                                                                                      |                                        | Account don't exists                            | Return false   |
|         |                                                                                                      |                                        | Account exists but not enough money to withdraw | Return false   |
|         | boolean approvedOverdraft(String accountNumber)                                                      |                                        | Account exists and approved                     | Return true    |
|         |                                                                                                      |                                        | Account don't exists                            | Return false   |
|         | void receiveStatement(String accountNumber)                                                          |                                        |                                                 |                |
|         |                                                                                                      |                                        |                                                 |                |

![img.png](img.png)