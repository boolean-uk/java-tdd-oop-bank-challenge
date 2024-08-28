## User Stories


As a customer,
So I can safely store and use my money,
I want to create a current account.

Class Bank

| Member variables              | Method                         | Scenario                       | Output                                                       |   |   |
|-------------------------------|--------------------------------|--------------------------------|--------------------------------------------------------------|---|---|
| ArrayList<Customer> customers | newCustomer(Customer customer) | Customer doesn't exist already | Create customer obj, add to customers arraylist, return true |   |   |
| private int customerID;       |                                | Customer already exists in map | print error, return false                                    |   |   |
|                               |                                |                                |                                                              |   |   |


As a customer,
So I can save for a rainy day,
I want to create a savings account.

Class Bank

| Member variables              | Method                                            | Scenario                       | Output                                                  |   |   |
|-------------------------------|---------------------------------------------------|--------------------------------|---------------------------------------------------------|---|---|
| ArrayList<Customer> customers | newAccount(Customer customer, String accountType) | Customer doesn't exist already | Create customer obj, add to customers list, return true |   |   |
|                               |                                                   | Customer already exists in map | print error, return false                               |   |   |
|                               |                                                   |                                |                                                         |   |   |



As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

Class Account

| Member variables                    | Method                    | Scenario                         | Output                                                    |                                        |   |
|-------------------------------------|---------------------------|----------------------------------|-----------------------------------------------------------|----------------------------------------|---|
| ArrayList<Transaction> transactions | getBalance()              | No transactions for this account | print error, return false                                 | Calls calculateAccountBalance function |   |
|                                     |                           | account has transactions         | print transaction history, return current account balance |                                        |   |
|                                     | calculateAccountBalance() |                                  |                                                           |                                        |   |


As a customer,
So I can use my account,
I want to deposit and withdraw funds.

Class account

| Member variables                    | Method                                                                         | Scenario                               | Output                                           |                                                         |   |
|-------------------------------------|--------------------------------------------------------------------------------|----------------------------------------|--------------------------------------------------|---------------------------------------------------------|---|
| ArrayList<Transaction> transactions | newTransaction(double depositAmount, double withdrawAmount, int transactionID) | No overdraft                           | Allow transaction and return new balance         | Calls calculateAccountBalance to determine overdrafting |   |
| double overdraftAmount              |                                                                                | Overdrafting, but within limit         | Allow overdraft, return new balance              |                                                         |   |
|                                     |                                                                                | Overdrafting more than overdraftAmount | print error, return balance prior to transaction |                                                         |   |

As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

Class account

| Member variables                    | Method                    | Scenario                       | Output                                       |   |   |
|-------------------------------------|---------------------------|--------------------------------|----------------------------------------------|---|---|
| ArrayList<Transaction> transactions | calculateAccountBalance() | Customer has no transactions   | return 0                                     |   |   |
|                                     |                           | Customer already exists in map | Loop transactions, return calculated balance |   |   |
|                                     |


As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

Class account

| Member variables                    | Method                    | Scenario                     | Output                                                           |   |   |
|-------------------------------------|---------------------------|------------------------------|------------------------------------------------------------------|---|---|
| ArrayList<Transaction> transactions | calculateAccountBalance() | account is a savings account | Print error                                                      |   |   |
| double overdraftAmount              | requestOverdraft()        | account is a current account | create new OverdraftRequest, add to Bank's overdraftRequest list |   |   |
|                                     |


As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

Class Bank

| Member variables                              | Method             | Scenario                      | Output                                                 |   |   |
|-----------------------------------------------|--------------------|-------------------------------|--------------------------------------------------------|---|---|
| ArrayList<OverdraftRequest> overdraftRequests | reviewOverdrafts() | bank manager allows overdraft | print approve message, adjust accounts overdraftAmount |   |   |
|                                               |                    | bank manager denies overdraft | print error                                            |   |   |

