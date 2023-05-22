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

| Classes           | Attributes                         | Methods                                                       | Scenarios                                         | Outcomes                                   |
|-------------------|------------------------------------|---------------------------------------------------------------|---------------------------------------------------|--------------------------------------------|
|                   |                                    |                                                               |                                                   |                                            |
| `Account`         |                                    |                                                               |                                                   |                                            |
|                   |                                    |                                                               |                                                   |                                            |
|                   | `-accountNumber: String`           |                                                               |                                                   |                                            |
|                   | `-balance: double`                 |                                                               |                                                   |                                            |
|                   | `-transactions: List<Transaction>` |                                                               |                                                   |                                            |
|                   |                                    | `deposit(amount:double):boolean`                              | 1.Deposit a specified amount into the account     | Amount is deposited into the account,true. |
|                   |                                    | `withdraw(amount:double):boolean`                             | 2.withdraw, enough balance                        | Amount is withdrawn from the account,true. |
|                   |                                    |                                                               | 2.withdraw, not enough balance                    | false                                      |
|                   |                                    | `getStatement():String`                                       |                                                   | prints statement                           |
| `CurrentAccount`  | `extends Account`                  |                                                               |                                                   |                                            |
| `SavingsAccount`  | `extends Account`                  |                                                               |                                                   |                                            |
|                   |                                    |                                                               |                                                   |                                            |
| `Customer`        | `-name:String`                     |                                                               |                                                   |                                            |
|                   | `-phone: String`                   |                                                               |                                                   |                                            |
|                   | `-address: String`                 |                                                               |                                                   |                                            |
|                   | `-accounts:List<Account>`          | `createCurrentAccount(account:CurrentAccount):CurrentAccount` | 3. Create a current account of  for the customer. | CurrentAccount                             |
|                   |                                    | `createSavingsAccount(account:SavingsAccount):SavingsAccount` | 4. Create a savings account of  for the customer. | SavingsAccount                             |
| `Transaction`     | `-date:Date`                       |                                                               |                                                   |                                            |
|                   | `-amount:double`                   |                                                               |                                                   |                                            |
|                   | `-currentBalance:double`           |                                                               |                                                   |                                            |
|                   | `-type:TransactionType`            |                                                               |                                                   |                                            |
| `TransactionType` | `-CREDIT`                          |                                                               |                                                   |                                            |
|                   | `-DEBIT`                           |                                                               |                                                   |                                            |
