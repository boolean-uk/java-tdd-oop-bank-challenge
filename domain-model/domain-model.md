### User Stories
1. As a customer,
So I can safely store use my money,
I want to create a current account.

2. As a customer,
So I can save for a rainy day,
I want to create a savings account.

3. As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

4. As a customer,
So I can use my account,
I want to deposit and withdraw funds.


# Domain Model
| Classes   | Attributes                        | Methods                                                      | Scenarios                                                      | Outcomes                                                        |
|-----------|-----------------------------------|--------------------------------------------------------------|----------------------------------------------------------------|-----------------------------------------------------------------|
| Bank      | `ArrayList<Account> accounts`     |                                                              |                                                                |                                                                 |
|           | `ArrayList<Customer> customers`   |                                                              |                                                                |                                                                 |
| Statement | `DateTime dateTime`               |                                                              |                                                                |                                                                 |
|           | `int credit`                      |                                                              |                                                                |                                                                 |
|           | `int debit`                       |                                                              |                                                                |                                                                 |
|           | `int balance`                     |                                                              |                                                                |                                                                 |
|           | `int customerId`                  |                                                              |                                                                |                                                                 |
|           | `int accountId`                   |                                                              |                                                                |                                                                 |
| Account   | `ArrayList<Statement> statements` |                                                              |                                                                |                                                                 |
|           | `int id`                          |                                                              |                                                                |                                                                 |
|           | `String type`                     |                                                              |                                                                |                                                                 |
|           | `int balance`                     |                                                              |                                                                |                                                                 |
|           | `int customerId`                  |                                                              |                                                                |                                                                 |
|           |                                   | `addStatement():void`                                        | used when withdraw or deposit happens                          | Creates statement and adds it to the statements arraylist       |
| Customer  | `Account[] accounts`              |                                                              |                                                                |                                                                 |
|           | `int id`                          |                                                              |                                                                |                                                                 |
|           |                                   |                                                              |                                                                |                                                                 |
|           |                                   | `createAccount(String accountType,int initialMoney):boolean` | 1. customer does not already have current account              | creates current account, returns true                           |
|           |                                   |                                                              | 1. customer already has a current account                      | returns false                                                   |
|           |                                   |                                                              | 2. customer does not already have a savings account            | creates savings account, returns true                           |
|           |                                   |                                                              | 2. customer already has a savings account                      | returns false                                                   |
|           |                                   | `deposit(int ammount, String accountType):boolean`           | 4. customer does not have such an account                      | returns false                                                   |
|           |                                   |                                                              | 4. customer has such an account                                | increases the account's balance, returns true                   |
|           |                                   | `withdraw(int ammount, String accountType):boolean`          | 4. asking for more money than the account has                  | returns false                                                   |
|           |                                   |                                                              | 4. customer does not have such an account                      | returns false                                                   |
|           |                                   |                                                              | 4. try to withdraw more than 200 from savings account          | returns false                                                   |
|           |                                   |                                                              | 4. account exists and has enough balance to make this withdraw | returns true                                                    |
|           |                                   | `generateStatements():void`                                  | 5. account exists                                              | prints all statements made for the chosen account, returns true |
|           |                                   |                                                              | 5. no such account                                             | returns false                                                   |


## Assumptions:
1. Bank allows customers to have one current account and one savings account
2. Customer can not withdraw more than 200 from his savings account
3. All attributes are private with getters and setters
4. Customer class accounts array contains the current account in position 0 and the savings account in 1. When customer is created the array is [null, null]