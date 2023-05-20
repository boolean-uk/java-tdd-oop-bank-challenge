# Banking Application
## User Stories
1. As a customer, so I can safely store use my money, I want to create a current account.
2. As a customer, so I can save for a rainy day, I want to create a savings account.
3. As a customer, so I can keep a record of my finances, I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
4. As a customer, so I can use my account, I want to deposit and withdraw funds.
5. As an engineer, so I don't need to keep track of state, I want account balances to be calculated based on transaction history instead of stored in memory.
6. As a bank manager, so I can expand, I want accounts to be associated with specific branches.
7. As a customer, so I have an emergency fund, I want to be able to request an overdraft on my account.
8. As a bank manager, so I can safeguard our funds, I want to approve or reject overdraft requests.
9. As a customer, so I can stay up to date, I want statements to be sent as messages to my phone.

## Domain Model
### Account (Parent of CurrentAccount & SavingsAccount)
| Members                         | Methods     | Scenarios | Outcomes | User Stories |
|---------------------------------|-------------|-----------|----------|--------------|
| `String accountNumber`          |             |           |          |              |
| `String accountHolderFirstName` |             |           |          |              |
| `String accountHolderLastName`  |             |           |          |              |
| `String branchCode`             |             |           |          | 6            |
| `int balanceInCents`            |             |           |          |              |
| `boolean approvedForOverdraft`  |             |           |          | 7, 8         |
|                                 | `Account()` |           |          |              |


### CurrentAccount (Child of Account)
| Members | Methods            | Scenarios | Outcomes | User Stories |
|---------|--------------------|-----------|----------|--------------|
|         |                    |           |          |              |
|         | `CurrentAccount()` |           |          |              |
|         |                    |           |          |              |
|         |                    |           |          |              |

### SavingsAccount (Child of Account)
| Members | Methods            | Scenarios | Outcomes | User Stories |
|---------|--------------------|-----------|----------|--------------|
|         |                    |           |          |              |
|         | `SavingsAccount()` |           |          |              |
|         |                    |           |          |              |
|         |                    |           |          |              |

### AccountActions
| Members                      | Methods                                                                                                                       | Scenarios                                                                         | Outcomes                                                      | User Stories |
|------------------------------|-------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------|---------------------------------------------------------------|--------------|
| `List<Integer> transactions` |                                                                                                                               |                                                                                   |                                                               |              |
| `List<Account> accounts`     |                                                                                                                               |                                                                                   |                                                               |              |
|                              | `boolean createAccount(String accountNumber, String accountHolderFirstName, String accountHolderLastName, String branchCode)` | accountNumber does not already exist                                              | print success message and return true                         | 1, 2         |
|                              |                                                                                                                               | accountNumber already exists                                                      | print failure message and return false                        | 1, 2         |
|                              |                                                                                                                               | accountType is invalid                                                            | print failure message and return false                        | 1, 2         |
|                              | `generateStatement`                                                                                                           |                                                                                   |                                                               | 3            |
|                              | `boolean deposit(String accountNumber, double amountInDollars)`                                                               | accountNumber exists                                                              | change balance to include value of deposit and return true    | 4            |
|                              |                                                                                                                               | accountNumber does not exist                                                      | print failure message and return false                        | 4            |
|                              | `boolean withdraw(String accountNumber, double amountInDollars)`                                                              | accountNumber exists and sufficient funds in account                              | change balance to include value of withdrawal and return true | 4            |
|                              |                                                                                                                               | accountNumber exists and insufficient funds in account, overdraft is approved     | change balance to include value of withdrawal and return true | 4, 7, 8      |
|                              |                                                                                                                               | accountNumber exists and insufficient funds in account, overdraft is not approved | print failure message and return false                        | 4            |
|                              |                                                                                                                               | accountNumber does not exist                                                      | print failure message and return false                        | 4            |
|                              | `Account searchAccount(String accountNumber)`                                                                                 | accountNumber already exists                                                      | Return Account object                                         |              |
|                              |                                                                                                                               | accountNumber does not exist                                                      | print failure message and return null                         |              |
|                              | `boolean approveOverdraft(String accountNumber)`                                                                              | accountNumber exists                                                              | change value of approvedForOverdraft to true and return true  | 8            |
|                              |                                                                                                                               | accountNumber does not exist                                                      | print failure message and return false                        | 8            |

### Main
| Members | Methods | Scenarios | Outcomes | User Stories |
|---------|---------|-----------|----------|--------------|
|         |         |           |          |              |
|         |         |           |          |              |
|         |         |           |          |              |
|         |         |           |          |              |