# Core section user stories

```
1. As a customer,
So I can safely store and use my money,
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
```
# Extension section user stories 

```
1. As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

2. As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

3. As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

4. As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.
```

| Classes  | Fields                               | Methods                                                              | Scenario                                                                                                         | Output                                         | User Story  |
|----------|--------------------------------------|----------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|------------------------------------------------|-------------|
| Bank     | ArrayList<Account> accounts          | boolean addCustomer(int id)                                          | Called to add a customer by id.                                                                                  |                                                |             |
|          | ArrayList<Customer> customers        |                                                                      |                                                                                                                  | true                                           |             |
|          | ArrayList<Request> overdraftRequests |                                                                      |                                                                                                                  | false                                          | Extension 3 |
|          |                                      | void addAccount(int customerId, String accountType, int initDeposit) | Called to add an account.                                                                                        |                                                |             |
|          |                                      | void addOverdraft(int accountId, int amountRequested)                | Called to add a overdraft.                                                                                       |                                                |             |
|          |                                      | void evaluateOverdraft()                                             | Called to evaluate overdraft.                                                                                    |                                                |             |
| Info     | DateTime dateTime                    | Date Time getDateNow()                                               | Called to get the actual date.                                                                                   |                                                |             |
|          | int credit, debit                    |                                                                      |                                                                                                                  |                                                |             |
|          | int balance                          |                                                                      |                                                                                                                  |                                                |             |
|          | int customerId, accountId            |                                                                      |                                                                                                                  |                                                |             |
| Account  | ArrayList <Info> info                | void generateInfo()                                                  | Called to generate bank statements with transaction dates, <br/> amounts, and balance at the time of transaction |                                                |             |
|          | int id                               | void addDepositInfo(int amount)                                      | Called to add a deposit info.                                                                                    |                                                |             |
|          | String type                          | void addWithdrawInfo(int amount)                                     | Called to add a withdraw info.                                                                                   |                                                |             |
|          | int balance                          | int getRandomAccountId()                                             | Called to get unique id for account.                                                                             |                                                |             |
|          | int customerId                       | int calculateBalance()                                               | Called to calculate balance on account.                                                                          |                                                | Extension 1 |
|          |                                      |                                                                      |                                                                                                                  |                                                |             |
| Customer | Account[] accounts                   | boolean createCurrentAccount(String accountType,int initMoney)       | Called when customer wants to create a current account.                                                          |                                                |             |
|          | int id                               |                                                                      | When customer doesn't have current account                                                                       | true                                           |             |
|          |                                      |                                                                      | When customer has current account                                                                                | false                                          |             |
|          |                                      | boolean createSavingAccount(String accountType,int initMoney)        | Called when customer wants to create a saving account.                                                           |                                                |             |
|          |                                      |                                                                      | When customer doesn't have saving account                                                                        | true                                           |             |
|          |                                      |                                                                      | When customer has saving account                                                                                 | false                                          |             |
|          |                                      | boolean deposit(int amount, String accountType)                      | Called when customer wants to make a deposit.                                                                    |                                                |             |
|          |                                      |                                                                      | customer doesn't have this type of account.                                                                      | false                                          |             |
|          |                                      |                                                                      | customer has this type of account                                                                                | true (and balance of the account is increased) |             |
|          |                                      | boolean withdraw(int amount, String accountType)                     | Called when customer wants to make a withdraw.                                                                   |                                                |             |
|          |                                      |                                                                      | customer doesn't have this type of account.                                                                      |                                                |             |
|          |                                      |                                                                      | customer has this type of account                                                                                |                                                |             |
|          |                                      | boolean hasCurrentAccount()                                          | Called to check if customer has current account.                                                                 |                                                |             |
|          |                                      |                                                                      | When customer has that account.                                                                                  | true                                           |             |
|          |                                      |                                                                      | When customer has not that account.                                                                              | false                                          |             |
|          |                                      | boolean hasSavingAccount()                                           | Called to check if customer has saving account.                                                                  |                                                |             |
|          |                                      |                                                                      | When customer has that account.                                                                                  | true                                           |             |
|          |                                      |                                                                      | When customer has not that account.                                                                              | false                                          |             |
| Request  | int accountId                        |                                                                      |                                                                                                                  |                                                |
|          | int amountRequested                  |                                                                      |                                                                                                                  |                                                |             |
