

 The entire project has been implemented using: 
 - Encapsulation on accounts
 - Abstraction on all classes
 - Dependency injection, where an account gets passes into the statement class
 - Inheritance, savings- and current account inherit account class
 - Polymorphism on all account class instances and data type specifications.

| Class           | Class members            | Methods                 | Scenario           | Output        |
|-----------------|--------------------------|-------------------------|--------------------|---------------|
| Bank            | HashMap<String, Account> | newAccount(firstName,   | account added to   | accountNumber |
|                 | accounts (accountNr key) | lastName, type, branch, | accounts           |               |
|                 |                          | amount)                 |                    |               |
|                 | int accountIterator      |                         |                    |               |
|                 |                          |                         |                    |               |
|                 |                          | getAccount(accountNr)   |                    | account       |
|                 |                          |                         |                    |               |
|                 |                          |                         |                    |               |
|                 |                          |                         |                    |               |
|                 |                          | getBalance(accountNr)   | checks statements  | balance       |
|                 |                          |                         | and add up         |               |
|                 |                          |                         |                    |               |
|                 |                          | deposit(accountNr,      | updates account    | true          |
|                 |                          | amount)                 | information        |               |
|                 |                          |                         |                    |               |
|                 |                          | deposit(accountNr,      | updates account    | amount        |
|                 |                          | amount)                 | information        |               |
|                 |                          |                         |                    |               |
| Account         | String accountNumber     | Getters Setters         |                    |               |
|                 | String firstName         |                         |                    |               |
|                 | String lastName          | addTransaction(amount)  | adds element to    |               |
|                 | String branch            |                         | transaction list   |               |
|                 | String type              |                         |                    |               |
|                 |                          |                         |                    |               |
|                 | ArrayList<Transaction>   |                         |                    |               |
|                 | transactions             |                         |                    |               |
|                 |                          |                         |                    |               |
| Transaction     | String time              | Getters                 |                    |               |
|                 | double amount            |                         |                    |               |
|                 |                          |                         |                    |               |
|                 |                          |                         |                    |               |
|                 |                          |                         |                    |               |
| Statement       | Account account          | makeStatement()         |                    | statement     |
|                 |                          |                         |                    |               |
|                 | ArrayList<String>        |                         |                    |               |
|                 | bankStatement            |                         |                    |               |
|                 |                          |                         |                    |               |
| CurrentAccount  |                          |                         |                    |               |
| inherit Account |                          |                         |                    |               |
|                 |                          |                         |                    |               |
| SavingsAccount  |                          |                         |                    |               |
| inherit Account |                          |                         |                    |               |
|                 |                          |                         |                    |               |





