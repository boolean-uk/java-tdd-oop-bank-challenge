| Class   | Methods         | Variable           | Scenario                         | Output |
|---------|-----------------|--------------------|----------------------------------|--------|
| Account | createAccount() | int safeStoreMoney | Can add account to store money   | true   |
|         |                 |                    | Can't add account to store money | false  |
|         |                 |                    |                                  |        |


| Class   | Methods               | Variable           | Scenario                                 | Output |
|---------|-----------------------|--------------------|------------------------------------------|--------|
| Account | createSavingAccount() | int safeStoreMoney | Can add account to store savings money   | true   |
|         |                       |                    | Can't add account to store savings money | false  |
|         |                       |                    |                                          |        |

| Class   | Methods       | Variable                                     | Scenario                        | Output |
|---------|---------------|----------------------------------------------|---------------------------------|--------|
| Account | transaction() | date transactionDate                         | Can keep track of transaction   | true   |
|         |               | double balance                               | Can't keep track of transaction | false  |
|         |               | double amount                                |                                 |        |
|         |               | HashMap<Integer, Transaction> transactionMap |                                 |        |
|         |               | String transaction                           |                                 |        |

| Class   | Methods         | Variable          | Scenario             | Output |
|---------|-----------------|-------------------|----------------------|--------|
| Account | depositFound()  | int depositMoney  | Can store money      | true   |
|         |                 | int withdrawMoney | Can't store money    | false  |
|         | withdrawFound() |                   | Can retrieve money   | true   |
|         |                 |                   | Can't retrieve money | false  |

![img.png](img.png)