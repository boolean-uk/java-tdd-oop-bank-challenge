| Class           | Members                              | Methods                         | Output | Story                                                                                                                                                                                   |
|-----------------|--------------------------------------|---------------------------------|--------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Account         | long accountCount                    | addTransaction(Transaction)     | void   | adds transaction to the transactionHistory, sets isAccpeted in transaction to true if the balance of the account after is positive, else it sends overdraft request to the bank manager |
|                 | long id                              | calculateBalance(LocalDateTime) | void   | calculates balance up to a certain date, takes into account only acepted transactions                                                                                                   |
|                 | List<Transaction> transactionHistory | printAccountStatement()         | String | returns an account statement with dates, amounts and balance after every transaction                                                                                                    |
|                 | Customer user                        |                                 |        |                                                                                                                                                                                         |
|                 | double maxOverdraft                  |                                 |        |                                                                                                                                                                                         |
| StandardAccount |                                      | setMaxOverdraft(double)         | void   | sets maxOverdraft to a given amount                                                                                                                                                     |
| SavingsAccount  | double bankRate                      | earnInterest()                  | void   | adds an interest transaction, the amount is equal to one month of earned interest                                                                                                       |

| Class       | Members                             | Methods                                  | Output | Story                                                               |
|-------------|-------------------------------------|------------------------------------------|--------|---------------------------------------------------------------------|
| User        | String id                           |                                          |        |                                                                     |
|             | String name                         |                                          |        |                                                                     |
|             | String surname                      |                                          |        |                                                                     |
|             | String password                     |                                          |        |                                                                     |
|             | String branchId                     |                                          |        |                                                                     |
| Customer    | int customerCount                   | createStandardAccount()                  | void   | creates new Standard account for this user                          |
|             | List<Account> accounts              | createSavingsAccount(double)             | void   | creates new savings account for this user                           |
|             |                                     | deposit(double amount, long accountId)   | void   | adds new transaction to the particular account                      |
|             |                                     | withdraw(double amount, long accountId)  | void   | adds new transaction to the particular account                      |
|             |                                     | printStatements()                        | String | prints statements of all accounts for one user                      |
| BankManager | int managerCount                    | decideOverdraft(Transaction, boolean)    | void   | decides whether to accept or decline overdraft                      |
|             | List<Customer> customers            | addOverdraftRequest(Transaction)         | void   | adds transaction to the list of transactions waiting for a decision |
|             | List<Transaction> overdraftRequests | setMaxOverdraft(StandardAccount, double) | void   | sets new max overdraft for a particular account                     |
|             |                                     | addCustomer(Customer)                    | void   | adds new customer to the list of operated customers                 |

| Class       | Members            | Methods    | Output  | Story                  |
|-------------|--------------------|------------|---------|------------------------|
| Transaction | double amount      | isAccepted | boolean | returns accepted field |
|             | LocalDateTime date |            |         |                        |
|             | Account account    |            |         |                        |
|             | boolean accepted   |            |         |                        |

| Class | Members                           | Methods                                     | Output | Story                                     |
|-------|-----------------------------------|---------------------------------------------|--------|-------------------------------------------|
| Bank  | List<Customer> customerList       | getBranch(String BranchId)                  | void   | returns a branch of a given id            |
|       | List<BankManager> bankManagerList | addCustomer(String, String, String, String) | void   | creates and adds new customer to the list |
|       |                                   | addManager(String, String, String, String)  | void   | creates and adds new manager to the list  |
|       |                                   | reset()                                     | void   | resets all static fields in the project   |
