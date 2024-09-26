# Domain Model

| Classes            | Attributes                          | Methods                                                | Scenario                                                         | Output |
|--------------------|-------------------------------------|--------------------------------------------------------|------------------------------------------------------------------|--------|
| BaseEntity         | id: UUID                            | getters, setters                                       |                                                                  |        |
| /abstract/         |                                     |                                                        |                                                                  |        |
| -------            | ----------------------              | ------------------------------------------------------ | -----------------------------------------------------------      | -----  |
| User               | name: String                        | getters, setters                                       |                                                                  |        |
| /abstract/         | phoneNumber: String                 |                                                        |                                                                  |        |
| extends BaseEntity |                                     |                                                        |                                                                  |        |
| -------            | ----------------------              | ------------------------------------------------------ | -----------------------------------------------------------      | -----  |
| Client             | currentAccount: Account             | openSavingsAccount(SavingsAccount savingsAccount)      | - Customer has no savings account. A new account is successfully | true   |
| extends User       | savingsAccount: Account             |                                                        | associated with the customer.                                    |        |
|                    |                                     |                                                        | - Customer already has a savings account.                        | false  |
|                    |                                     |                                                        | (e.g., an account type that doesn't exist)                       |        |
|                    |                                     | openCurrentAccount(CurrentAccount currentAccount)      | - Customer has no current account. A new account is successfully | true   |
|                    |                                     |                                                        | associated with the customer.                                    |        |
|                    |                                     |                                                        | - Customer already has a current account.                        | false  |
|                    |                                     | requestOverdraft(Account account, BigDecimal amount)   | - request made successfully on this account                      | true   |
|                    |                                     |                                                        | - request on this account/with this amount unsuccessful          | false  |
| -------            | ----------------------              | ------------------------------------------------------ | -----------------------------------------------------------      | -----  |
| Manager            | branch: Branch                      | reviewOverdraftRequests()                              | - request meets the criteria                                     | void   |
| extends User       | MINIMUM_OVERDRAFT_RATIO: BigDecimal |                                                        | - request doesn't meet the criteria                              |        |
|                    |                                     |                                                        |                                                                  |        |



| Classes            | Attributes                              | Methods                             | Scenario                                     | Output                   |
|--------------------|-----------------------------------------|-------------------------------------|----------------------------------------------|--------------------------|
| Account            | balance: BigDecimal                     | depositFunds(amount: BigDecimal)    | - successful + transaction added             | Transaction              |
| extends BaseEntity | transactions: List<Transaction>         |                                     | - amount is negative                         | IllegalArgumentException |
| /abstract/         | accountHolder: Client                   |                                     |                                              |                          |
|                    | branch: Branch                          | withdrawFunds(amount: BigDecimal)   |                                              |                          |
|                    |                                         | /abstract method/                   |                                              |                          |
|                    |                                         |                                     |                                              |                          |
|                    |                                         | requestOverdraft()                  |                                              |                          |
|                    |                                         | /abstract method/                   |                                              |                          |
|                    |                                         | generateStatement()                 | - successfully generated                     | String                   |
|                    |                                         |                                     | - no transaction history                     | String                   |
|                    |                                         | getBalance()                        | calculates balance based on                  | BigDecimal               |
|                    |                                         |                                     | transaction history, else returns 0          |                          |
| -------            | ----------------------                  | --------------------------------    | -----------------------------------          | ------------------------ |
| CurrentAccount     | overdraftRequest: OverdraftRequest      | requestOverdraft(BigDecimal amount) | amount is positive                           | true                     |
| extends Account    |                                         |                                     | amount is negative                           | IllegalArgumentException |
|                    |                                         | withdrawFunds(BigDecimal amount)    | amount is negative                           | IllegalArgumentException |
|                    |                                         |                                     | amount will make account go below limit or 0 | IllegalArgumentException |
|                    |                                         |                                     | amount is positive and within limit          | Transaction              |
| -------            | ----------------------                  | --------------------------------    | -----------------------------------          | ------------------------ |
| SavingsAccount     | final interestRate: BigDecimal          | requestOverdraft(BigDecimal amount) | always unsuccessful                          | false                    |
| extends Account    | final initialDepositMinimum: BigDecimal | withdrawFunds(BigDecimal amount)    | amount is negative                           | IllegalArgumentException |
|                    |                                         |                                     | amount will make account go below minimum    | IllegalArgumentException |
|                    |                                         |                                     | amount is positive and within limits         | Transaction              |

| Classes            | Attributes                      | Methods                     | Scenario                                   | Output               |
|--------------------|---------------------------------|-----------------------------|--------------------------------------------|----------------------|
| Branch             | branchLocation: Branches (enum) | addAccount(Account account) |                                            | boolean              |
| extends BaseEntity | manager: Manager                | getSavingsAccounts()        | filters the accounts list for savings accs | List<SavingsAccount> |
|                    | accounts: List<Account>         |                             | and returns a list with the results        |                      |
|                    |                                 | getCurrentAccounts()        | filters the accounts list for current accs | List<CurrentAccount> |
|                    |                                 |                             | and returns a list with the results        |                      |


| Classes            | Attributes                   | Methods | Scenario | Output |
|--------------------|------------------------------|---------|----------|--------|
| Transaction        | amount: BigDecimal           | getters |          |        |
| extends BaseEntity | timestamp: Instant           | setters |          |        |
|                    | type: TransactionType (enum) |         |          |        |


| Classes            | Attributes            | Methods | Scenario | Output |
|--------------------|-----------------------|---------|----------|--------|
| OverdraftRequest   | status: Status (enum) | getters |          |        |
| extends BaseEntity | amount: BigDecimal    | setters |          |        |
|                    |                       |         |          |        |
|                    |                       |         |          |        |
|                    |                       |         |          |        |

| Classes       | Attributes | Methods                                   | Scenario | Output |
|---------------|------------|-------------------------------------------|----------|--------|
| BankStatement |            | static generateStatement(Account account) |          | String |
|               |            |                                           |          |        |
|               |            |                                           |          |        |
|               |            |                                           |          |        |

| Enums           |   |
|-----------------|---|
| Branches        |   |
| Status          |   |
| TransactionType |   |
