
Bank

| Method                                                                     | Member variable                                | Scenario                                                                                                                              | Output                                                                |
|----------------------------------------------------------------------------|------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------|
| createCurrentAccount(Customer customer)                                    | HashMap<Customer, ArrayList<Account>> accounts | Customer wants to create a current account                                                                                            | account id as int                                                     |
| createSavingsAccount(Customer customer)                                    |                                                | Customer wants to create a savings account                                                                                            | account id as int                                                     |
| generateBankStatements(Customer customer, int accountId)                   |                                                | Customer wants to see account data of transaction dates, amounts, and balance at the time of transaction of an account they own       | Statement as String                                                   |
| generateBankStatements(Customer customer, int accountId)                   |                                                | Customer wants to see account data of transaction dates, amounts, and balance at the time of transaction of an account they don't own | "Account doesn't exist."                                              |
| generateBankStatement(Customer customer, int accountId)                    |                                                | Non-existent customer wants to see account data of transaction dates, amounts, and balance at the time of transaction                 | "Customer doesn't exist."                                             |
| deposit(double amount, Customer customer, int accountId)                   |                                                | Customer wants to deposit money into their account                                                                                    | "The deposit has been performed."                                     |
| deposit(double amount, Customer customer, int accountId)                   |                                                | Customer wants to deposit money into an account that doesn't exist                                                                    | "Account doesn't exist."                                              |
| deposit(double amount, Customer customer, int accountId)                   |                                                | Non-existent customer wants to deposit money into an account                                                                          | "Customer doesn't exist."                                             |
| withdraw(double amount, Customer customer, int accountId)                  |                                                | Customer wants to withdraw an amount of money from their savings account, less than exists on the account                             | "The withdrawal has been performed."                                  |
| withdraw(double amount, Customer customer, int accountId)                  |                                                | Customer wants to withdraw an amount of money from their savings account, more than exists on the account                             | "The withdrawal could not be performed. The balance is too low."      |
| withdraw(double amount, Customer customer, int accountId)                  |                                                | Customer wants to withdraw an amount of money from their current account                                                              | "The withdrawal has been performed."                                  |
| withdraw(double amount, Customer customer, int accountId)                  |                                                | Customer wants to withdraw money from an account that doesn't exist                                                                   | "Account doesn't exist."                                              |
| withdraw(double amount, Customer customer, int accountId)                  |                                                | Non-existent customer wants to withdraw money from an account                                                                         | "Customer doesn't exist."                                             |
| requestOverdraft(Customer customer, int accountId, double sizeOfOverdraft) | ArrayList<OverdraftRequest> overdraftRequests  | Customer wants to request an overdraft for an account where they already have overdraft of the size                                   | "You already have an approved overdraft for this account and amount." |
| requestOverdraft(Customer customer, int accountId, double sizeOfOverdraft) |                                                | Customer wants to request an overdraft for an account where they don't have an overdraft of that size                                 | "Your request has been sent."                                         |
| requestOverdraft(Customer customer, int accountId, double sizeOfOverdraft) |                                                | Customer wants to request an overdraft for a savings account                                                                          | "You can't have an overdraft on a savings account."                   |
| requestOverdraft(Customer customer, int accountId, double sizeOfOverdraft) |                                                | Customer wants to request an overdraft for a non-existent account                                                                     | "Account doesn't exist."                                              |
| requestOverdraft(Customer customer, int accountId, double sizeOfOverdraft) |                                                | Non-existent customer wants to request an overdraft for an account                                                                    | "Customer doesn't exist."                                             |
| goThroughOverdraftRequests()                                               |                                                | Bank manager wants to approve or reject requests                                                                                      | void                                                                  |

OverdraftRequest

| Member variable   |
|-------------------|
| Customer customer |
| Account account   |
| double overdraft  |

Customer

| Member variable |
|-----------------|
| String name     |
| int id          |

Account

| Method                  | Member variable                 | Scenario                                                     | Output     |
|-------------------------|---------------------------------|--------------------------------------------------------------|------------|
| deposit(double amount)  | double balance                  | Customer wants to deposit money, where amount >= 0           | true       |
| deposit(double amount)  | int id                          | Customer wants to deposit money, where amount < 0            | false      |
| withdraw(double amount) |                                 | Customer wants to withdraw a valid amount of money           | true       |
| withdraw(double amount) |                                 | Customer wants to withdraw an invalid amount of money (< 0)  | false      |
| getStatements()         | ArrayList<Statement> statements | Customer wants to see statements                             | statements |

SavingsAccount

| Method                    | Member variable | Scenario                                                                               | Output    |
|---------------------------|-----------------|----------------------------------------------------------------------------------------|-----------|
| withdraw(double amount)   |                 | Customer wants to withdraw a valid amount of money (amount <= balance)                 | true      |
| withdraw(double amount)   |                 | Customer wants to withdraw an invalid amount of money (amount > balance or amount < 0) | false     |

CurrentAccount

| Method                    | Member variable           | Scenario                                                                                                   | Output    |
|---------------------------|---------------------------|------------------------------------------------------------------------------------------------------------|-----------|
| withdraw(double amount)   | double approvedOverdraft  | Customer wants to withdraw a valid amount of money (amount <= balance + approvedOverdraft)                 | true      |
| withdraw(double amount)   |                           | Customer wants to withdraw an invalid amount of money (amount > balance + approvedOverdraft or amount < 0) | false     |

Statement

| Member variable |
|-----------------|
| Date date       |
| double amount   |
| double balance  |

WithdrawStatement

DepositStatement

