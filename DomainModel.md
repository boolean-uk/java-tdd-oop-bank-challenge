
Bank

| Method                                                             | Member variable                     | Scenario                                                                                                                              | Output                                                           |
|--------------------------------------------------------------------|-------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------|
| createCurrentAccount(Customer customer)                            | HashMap<Customer, Account> accounts | Customer wants to create a current account                                                                                            | bankid as int                                                    |
| createSavingsAccount(Customer customer)                            |                                     | Customer wants to create a savings account                                                                                            | bankid as int                                                    |
| generateBankStatement(Customer customer, int accountId)            |                                     | Customer wants to see account data of transaction dates, amounts, and balance at the time of transaction of an account they own       | Statement                                                        |
| generateBankStatement(Customer customer, int accountId)            |                                     | Customer wants to see account data of transaction dates, amounts, and balance at the time of transaction of an account they don't own | "Account doesn't exist."                                         |
| generateBankStatement(Customer customer, int accountId)            |                                     | Non-existent customer wants to see account data of transaction dates, amounts, and balance at the time of transaction                 | "Customer doesn't exist."                                        |
| deposit(double amount, Customer customer, int accountId)           |                                     | Customer wants to deposit money into their account                                                                                    | "The deposit has been performed."                                |
| deposit(double amount, Customer customer, int accountId)           |                                     | Customer wants to deposit money into an account that doesn't exist                                                                    | "Account doesn't exist."                                         |
| deposit(double amount, Customer customer, int accountId)           |                                     | Non-existent customer wants to deposit money into an account                                                                          | "Customer doesn't exist."                                        |
| withdraw(double amount, Customer customer, int accountId)          |                                     | Customer wants to withdraw an amount of money from their account, less than exists on the account                                     | "The withdrawal has been performed."                             |
| withdraw(double amount, Customer customer, int accountId)          |                                     | Customer wants to withdraw an amount of money from their account, more than exists on the account                                     | "The withdrawal could not be performed. The balance is too low." |
| withdraw(double amount, Customer customer, int accountId)          |                                     | Customer wants to withdraw money from an account that doesn't exist                                                                   | "Account doesn't exist."                                         |
| withdraw(double amount, Customer customer, int accountId)          |                                     | Non-existent customer wants to withdraw money from an account                                                                         | "Customer doesn't exist."                                        |

Customer

| Member variable |
|-----------------|
| String name     |
| int id          |

Account

| Method                  | Member variable                 | Scenario                                                                                      | Output     |
|-------------------------|---------------------------------|-----------------------------------------------------------------------------------------------|------------|
| deposit(double amount)  | double balance                  | Customer wants to deposit money, where amount >= 0                                            | true       |
| deposit(double amount)  | int id                          | Customer wants to deposit money, where amount < 0                                             | false      |
| withdraw(double amount) |                                 | Customer wants to withdraw a valid amount of money                                            | true       |
| withdraw(double amount) |                                 | Customer wants to withdraw an invalid amount of money (either amount < 0 or amount > balance) | false      |
| getStatements()         | ArrayList<Statement> statements | Customer wants to see statements                                                              | statements |

SavingsAccount

CurrentAccount

Statement

| Member variable |
|-----------------|
| Date date       |
| double amount   |
| double balance  |
