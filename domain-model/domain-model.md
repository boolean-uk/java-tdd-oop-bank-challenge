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


#### Extension User Stories
5. As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

6. As a bank manager,
   So I can expand,
   I want accounts to be associated with specific branches.

7. As a customer,
   So I have an emergency fund,
   I want to be able to request an overdraft on my account.

8. As a bank manager,
   So I can safeguard our funds,
   I want to approve or reject overdraft requests.

9. As a customer,
   So I can stay up to date,
   I want statements to be sent as messages to my phone.


# Domain Model
| Classes   | Attributes                             | Methods                                                                            | Scenarios                                                                                             | Outcomes                                                                            |
|-----------|----------------------------------------|------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| Bank      | `ArrayList<Customer> customers`        |                                                                                    |                                                                                                       |                                                                                     |
|           | `ArrayList<Request> overdraftRequests` |                                                                                    |                                                                                                       |                                                                                     |
|           | `ArrayList<Branch> branches`           |                                                                                    |                                                                                                       |                                                                                     |
|           |                                        | `addCustomer(int id):boolean`                                                      | Bank already has a customer with this id                                                              | returns false                                                                       |
|           |                                        |                                                                                    | id is unused, customer can be created                                                                 | customer is created and inserted in the customers arraylist, returns true           |
|           |                                        | `addAccount(int customerId, String accountType, int initalDeposit):void`           | used whenever a customer creates an account                                                           | account is inserted in the accounts arraylist                                       |
|           |                                        | `addOverdraft(int accountId, int ammountRequested):void`                           | static method that is called when a customer wants to make a request                                  | creates an OverdraftRequest object and adds it to the overdraftRequests arraylist   |
|           |                                        | `evaluateOverdraft():void`                                                         | 8. bank manager is shown a menu where he goes through the requests made by the customers, one by one. | requests get approved (option 1 is selected) or rejected (option 2 is selected)     |
|           |                                        |                                                                                    | 8. manager can quit if he does not want to evaluate any more requests                                 | selects 3, quits the method                                                         |
|           |                                        |                                                                                    |                                                                                                       |                                                                                     |
| Statement | `String date`                          |                                                                                    |                                                                                                       |                                                                                     |
|           | `int credit`                           |                                                                                    |                                                                                                       |                                                                                     |
|           | `int debit`                            |                                                                                    |                                                                                                       |                                                                                     |
|           | `int customerId`                       |                                                                                    |                                                                                                       |                                                                                     |
|           | `int accountId`                        |                                                                                    |                                                                                                       |                                                                                     |
|           |                                        | `getDateNow():String`                                                              | used to get the date of statement's creation                                                          | returns a date formatted as a string                                                |
| Account   | `ArrayList<Statement> statements`      |                                                                                    |                                                                                                       |                                                                                     |
|           | `int id`                               |                                                                                    |                                                                                                       |                                                                                     |
|           | `String type`                          |                                                                                    |                                                                                                       |                                                                                     |
|           | `int customerId`                       |                                                                                    |                                                                                                       |                                                                                     |
|           |                                        | `addDepositStatement(int ammount):void`                                            | used when an account is created and for every deposit                                                 | creates statement and adds it to the statements arraylist of the particular account |
|           |                                        | `addWithdrawStatement(int ammount):void`                                           | used whenever a withdraw happens                                                                      | creates statement and adds it to the statements arraylist of the particular account |
|           |                                        | `getUniqueRandomAccountId():int`                                                   | used when an account needs to be created                                                              | creates 4 random integers, concatenates them and returns the id                     |
|           |                                        | `generateStatements():void`                                                        |                                                                                                       | prints out all the statements of the account in a specific format                   |
|           |                                        | `calculateBalance():int`                                                           | 5.                                                                                                    |                                                                                     |
| Customer  | `Account[] accounts`                   |                                                                                    |                                                                                                       |                                                                                     |
|           | `int id`                               |                                                                                    |                                                                                                       |                                                                                     |
|           |                                        | `hasCurrentAccount():boolean / hasSavingsAccount():boolean`                        | customer has such an account                                                                          | returns true                                                                        |
|           |                                        |                                                                                    | customer does not have such an account                                                                | returns false                                                                       |
|           |                                        | `createCurrentAccount(int initialDeposit):boolean`                                 | 1. customer does not already have current account                                                     | creates current account, returns true                                               |
|           |                                        |                                                                                    | 1. customer already has a current account                                                             | returns false                                                                       |
|           |                                        | `createSavingsAccount(int initalDeposit):boolaen`                                  | 2. customer already has a savings account                                                             | returns false                                                                       |
|           |                                        |                                                                                    | 2. customer does not already have a savings account                                                   | creates savings account, returns true                                               |
|           |                                        | `deposit(String accountType, int ammount):boolean`                                 | 4. customer does not have such an account                                                             | returns false                                                                       |
|           |                                        |                                                                                    | 4. customer has such an account                                                                       | increases the account's balance, returns true                                       |
|           |                                        | `withdraw(String accountType, int ammount):boolean`                                | 4. asking for more money than the account has                                                         | returns false                                                                       |
|           |                                        |                                                                                    | 4. customer does not have such an account                                                             | returns false                                                                       |
|           |                                        |                                                                                    | 4. try to withdraw more than 200 from savings account                                                 | returns false                                                                       |
|           |                                        |                                                                                    | 4. account exists and has enough balance to make this withdraw                                        | returns true                                                                        |
|           |                                        | `generateCurrentAccountStatements():void/ generateSavingsAccountStatements():void` | 3. account exists                                                                                     | prints all statements made for the chosen account                                   |
|           |                                        |                                                                                    | 3. no such account                                                                                    | returns false                                                                       |
|           |                                        | `requestOverdraft(int ammount):void`                                               | 7. user has a current account, can make the request                                                   | overdraft request is created                                                        |
|           |                                        |                                                                                    | 7. customer does not have a current account                                                           | does not create request, prints corresponding message                               |
|           |                                        |                                                                                    | 7. customer has a current account with enough balance, so he does not need to request overdraft       | does not create request, prints corresponding message                               |
|           |                                        | `getOverdraftRequestStatus():String`                                               | 7,8. user can see the status of his overdraft request                                                 | possible outcomes: not evaluated, approved, rejected                                |
| Request   | `boolean answer`                       |                                                                                    |                                                                                                       |                                                                                     |
|           | `int accountId`                        |                                                                                    |                                                                                                       |                                                                                     |
|           | `int ammountRequested`                 |                                                                                    |                                                                                                       |                                                                                     |
| Branch    | `String name`                          |                                                                                    |                                                                                                       |                                                                                     |
|           | `ArrayList<Account> accounts`          |                                                                                    |                                                                                                       |                                                                                     |


## Assumptions:
1. Bank allows customers to have one current account and one savings account
2. Customer can not withdraw more than 200 from his savings account
3. All attributes are private with getters and setters
4. Customer class accounts array contains the current account in position 0 and the savings account in 1. When customer is created the array is [null, null]
5. Overdraft requests are made for current accounts only, not savings
