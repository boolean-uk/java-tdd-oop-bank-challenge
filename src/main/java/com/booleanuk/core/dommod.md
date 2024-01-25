


| Class           | Class members            | Methods                  | Scenario                     | Output        |
|-----------------|--------------------------|--------------------------|------------------------------|---------------|
| Bank            | HashMap<String, Account> | newAccount(firstName,    | account added to accounts    | accountNumber |
|                 | accounts (accountNr key) | lastName, type, branch,  |                              |               |
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
|                 | String lastName          | addTransaction(amount)   | adds element to transaction  |               |
|                 | String branch            |                          | list                         |               |
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
| Statement       | Account account          | makeStatement() |                              | statement     |
|                 |                          |                          |                              |               |
|                 | ArrayList<String>        |                          |                              |               |
|                 | bankStatement            |                          |                              |               |
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





