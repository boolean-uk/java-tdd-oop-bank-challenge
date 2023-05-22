## user stories
As a customer,
So I can safely store use my money,
I want to create a current account.

As a customer,
So I can save for a rainy day,
I want to create a savings account.

As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

As a customer,
So I can use my account,
I want to deposit and withdraw funds.

| Classes             | Attributes                                  | Methods                                                             | Scenarios                                         | Outcomes                                                       |
|---------------------|---------------------------------------------|---------------------------------------------------------------------|---------------------------------------------------|----------------------------------------------------------------|
| `Account`           |                                             |                                                                     |                                                   |                                                                |
|                     | `-accountNumber: String`                    |                                                                     |                                                   |                                                                |
|                     | `-balance: double`                          |                                                                     |                                                   |                                                                |
|                     | `-branch:Branch`                            |                                                                     |                                                   |                                                                |
|                     | `-transactions: List<Transaction>`          |                                                                     |                                                   |                                                                |
|                     |                                             | `deposit(amount:double):boolean`                                    | 1.Deposit a specified amount into the account     | Amount is deposited into the account,add new transaction,true. |
|                     |                                             | `withdraw(amount:double):boolean`                                   | 2.withdraw, enough balance                        | Amount is withdrawn from the account,add new transaction,true. |
|                     |                                             |                                                                     | 2.withdraw, not enough balance                    | false                                                          |
|                     |                                             | `getStatement():String`                                             |                                                   | prints statement                                               |
|                     |                                             | `calculateBalance():double`                                         |                                                   |                                                                |
| `CurrentAccount`    | `extends Account`                           |                                                                     |                                                   |                                                                |
| `SavingsAccount`    | `extends Account`                           |                                                                     |                                                   |                                                                |
|                     |                                             |                                                                     |                                                   |                                                                |
| `Customer`          | `-name:String`                              |                                                                     |                                                   |                                                                |
|                     | `-phone: String`                            |                                                                     |                                                   |                                                                |
|                     | `-address: String`                          |                                                                     |                                                   |                                                                |
|                     | `-accounts:List<Account>`                   | `createCurrentAccount(accountNumber:String):CurrentAccount`         | 3. Create a current account of  for the customer. | CurrentAccount                                                 |
|                     |                                             | `createSavingsAccount(accountNumber:String):SavingsAccount`         | 4. Create a savings account of  for the customer. | SavingsAccount                                                 |
|                     |                                             | `requestOverdraft(account:Account, amount:double):OverdraftRequest` |                                                   |                                                                |
| `Transaction`       | `-date:Date`                                | `sendStatementAsMessage(account:Account, phone:String):boolean`     |                                                   |                                                                |
|                     | `-amount:double`                            |                                                                     |                                                   |                                                                |
|                     | `-currentBalance:double`                    |                                                                     |                                                   |                                                                |
|                     | `-type:TransactionType`                     |                                                                     |                                                   |                                                                |
| `TransactionType`   | `-CREDIT`                                   |                                                                     |                                                   |                                                                |
|                     | `-DEBIT`                                    |                                                                     |                                                   |                                                                |
| `Branch`            | `-branchCode:String`                        |                                                                     |                                                   |                                                                |
|                     | `-accounts:List<Account>`                   |                                                                     |                                                   |                                                                |
| `OverdraftRequest ` |                                             |                                                                     |                                                   |                                                                |
|                     | `-account: Account`                         |                                                                     |                                                   |                                                                |
|                     | `-requestAmount:double`                     |                                                                     |                                                   |                                                                |
|                     | `-approved:boolean`                         |                                                                     |                                                   |                                                                |
| `BankManager`       |                                             |                                                                     |                                                   |                                                                |
|                     | `-overdraftRequests:List<OverdraftRequest>` |                                                                     |                                                   |                                                                |
|                     |                                             | `approveOverdraftRequest(request:OverdraftRequest):void`            |                                                   |                                                                |
|                     |                                             | `rejectOverdraftRequest(request:OverdraftRequest):void`             |                                                   |                                                                |

## Extensions
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.

