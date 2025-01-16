I have no idea if it's a good idea to use interfaces for this, but I still decided to use interfaces for practice.

# Interface: Branch

| Members   | Methods                                                        |
|-----------|----------------------------------------------------------------|
| enum Type | void createAndAddAccount((int accountNumber, Type accountType) |
|           | void handleOverdraftRequest(double amount, Account account)    |


# Class: NorwayBranch

| Implements interface | Members                      | Methods                                                       | Scenario                                           | Result/Output                                                         |
|----------------------|------------------------------|---------------------------------------------------------------|----------------------------------------------------|-----------------------------------------------------------------------|
| Branch               | ArrayList\<Account> accounts | void createAndAddAccount(int accountNumber, Type accountType) |                                                    | account gets created with norwayPrefix and added to the accounts-list |
|                      | int norwayPrefix             | void handleOverdraftRequest(double amount, Account account)   | account type == SavingsAccount                     | Deny (do nothing)                                                     |
|                      |                              |                                                               | account type == CurrentAccount, but amount > 1000  | Deny (do nothing)                                                     |
|                      |                              |                                                               | account type == CurrentAccount, and amount <= 1000 | Accept (update the lower limit)                                       |



# Class: SwedenBranch

| Implements interface | Members                      | Methods                                                       | Scenario                                          | Result/Output                                                         |
|----------------------|------------------------------|---------------------------------------------------------------|---------------------------------------------------|-----------------------------------------------------------------------|
| Branch               | ArrayList\<Account> accounts | void createAndAddAccount(int accountNumber, Type accountType) |                                                   | account gets created with swedenPrefix and added to the accounts-list |
|                      | int swedenPrefix             | void handleOverdraftRequest(double amount, Account account)   | account type == SavingsAccount                    | Deny (do nothing)                                                     |
|                      |                              |                                                               | account type == CurrentAccount, but amount > 982  | Deny (do nothing)                                                     |
|                      |                              |                                                               | account type == CurrentAccount, and amount <= 982 | Accept (update the lower limit)                                       |



# Class: UKBranch

| Implements interface | Members                      | Methods                                                       | Scenario                                         | Result/Output                                                     |
|----------------------|------------------------------|---------------------------------------------------------------|--------------------------------------------------|-------------------------------------------------------------------|
| Branch               | ArrayList\<Account> accounts | void createAndAddAccount(int accountNumber, Type accountType) |                                                  | account gets created with ukPrefix and added to the accounts-list |
|                      | int ukPrefix                 | void handleOverdraftRequest(double amount, Account account)   | account type == SavingsAccount                   | Deny (do nothing)                                                 |
|                      |                              |                                                               | account type == CurrentAccount, but amount > 72  | Deny (do nothing)                                                 |
|                      |                              |                                                               | account type == CurrentAccount, and amount <= 72 | Accept (update the lower limit)                                   |



