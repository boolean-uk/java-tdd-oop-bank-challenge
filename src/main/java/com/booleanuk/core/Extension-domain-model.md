I have no idea if it's a good idea to use interfaces for this, but I still decided to use interfaces for practice.

# Interface: Branch

| Members   | Methods                                                         |
|-----------|-----------------------------------------------------------------|
| enum Type | void createAndAddAccount((int accountNumber, Type accountType)  |
|           | boolean handleOverdraftRequest(double amount, Account account)  |


# Class: NorwayBranch

| Implements interface | Members                      | Methods                                                        | Scenario                                           | Result/Output                                                         |
|----------------------|------------------------------|----------------------------------------------------------------|----------------------------------------------------|-----------------------------------------------------------------------|
| Branch               | ArrayList\<Account> accounts | void createAndAddAccount(int accountNumber, Type accountType)  |                                                    | account gets created with norwayPrefix and added to the accounts-list |
|                      | int norwayPrefix             | boolean handleOverdraftRequest(double amount, Account account) | account type == SavingsAccount                     | return false (deny)                                                   |
|                      |                              |                                                                | account type == CurrentAccount, but amount > 1000  | return false (deny)                                                   |
|                      |                              |                                                                | account type == CurrentAccount, and amount <= 1000 | return true (grant)                                                   |



# Class: SwedenBranch

| Implements interface | Members                      | Methods                                                        | Scenario                                          | Result/Output                                                         |
|----------------------|------------------------------|----------------------------------------------------------------|---------------------------------------------------|-----------------------------------------------------------------------|
| Branch               | ArrayList\<Account> accounts | void createAndAddAccount(int accountNumber, Type accountType)  |                                                   | account gets created with swedenPrefix and added to the accounts-list |
|                      | int swedenPrefix             | boolean handleOverdraftRequest(double amount, Account account) | account type == SavingsAccount                    | return false (deny)                                                   |
|                      |                              |                                                                | account type == CurrentAccount, but amount > 982  | return false (deny)                                                   |
|                      |                              |                                                                | account type == CurrentAccount, and amount <= 982 | return true (grant)                                                   |



# Class: UKBranch

| Implements interface | Members                      | Methods                                                        | Scenario                                         | Result/Output                                                     |
|----------------------|------------------------------|----------------------------------------------------------------|--------------------------------------------------|-------------------------------------------------------------------|
| Branch               | ArrayList\<Account> accounts | void createAndAddAccount(int accountNumber, Type accountType)  |                                                  | account gets created with ukPrefix and added to the accounts-list |
|                      | int ukPrefix                 | boolean handleOverdraftRequest(double amount, Account account) | account type == SavingsAccount                   | return false (deny)                                               |
|                      |                              |                                                                | account type == CurrentAccount, but amount > 72  | return false (deny)                                               |
|                      |                              |                                                                | account type == CurrentAccount, and amount <= 72 | return true (grant)                                               |



