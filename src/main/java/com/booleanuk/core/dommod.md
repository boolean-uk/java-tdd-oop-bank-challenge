


| Class           | Class members            | Methods                  | Scenario                     | Output        |
|-----------------|--------------------------|--------------------------|------------------------------|---------------|
| Bank            | HashMap<String, Account> | newAccount(firstName,    | account added                | accountNumber |
|                 | accountNr key            | lastName, type, branch,  |                              |               |
|                 |                          | amount)                  |                              |               |
|                 | int accountIterator      |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          | getAccount(accountNr)    |                              | account       |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          | getBalance(accountNr)    | checks statements and add up | balance       |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          | deposit(accountNr,       | updates account information  | true          |
|                 |                          | amount)                  |                              |               |
|                 |                          |                          |                              |               |
|                 |                          | deposit(accountNr,       | updates account information  | amount        |
|                 |                          | amount)                  |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
| Account         | String accountNumber     | Getters Setters          |                              |               |
|                 | String firstName         |                          |                              |               |
|                 | String lastName          |                          |                              |               |
|                 | String branch            |                          |                              |               |
|                 | String type              |                          |                              |               |
|                 |                          |                          |                              |               |
|                 | ArrayList<Transaction>   |                          |                              |               |
|                 | transactions             |                          |                              |               |
|                 |                          |                          |                              |               |
|                 | double balance           |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
| Transaction     | String time              |                          |                              |               |
|                 | double amount            |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
| Statement       | Bank                     | makeStatement(accountNr) |                              | statement     |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
| CurrentAccount  |                          |                          |                              |               |
| inherit Account |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
| SavingsAccount  |                          |                          |                              |               |
| inherit Account |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |
|                 |                          |                          |                              |               |





