# Domain Model

base model:

| Classes          | Methods                      | Fields                         | Scenario                                                                                         |
|------------------|------------------------------|--------------------------------|--------------------------------------------------------------------------------------------------|
| Account          |                              | AccountType type,              |                                                                                                  |
|                  |                              | List<Transaction> transactions |                                                                                                  |
|                  |                              |                                |                                                                                                  |
|                  | void deposit(double amount)  |                                | if amount is a positive number add new transaction to transaction list                           |
|                  |                              |                                | otherwise throw exception                                                                        |
|                  |                              |                                |                                                                                                  |
|                  | void withdraw(double amount) |                                | if amount is a positive number and balance is sufficient add new transaction to transaction list | 
|                  |                              |                                | otherwise throw exception                                                                        | 
|                  |                              |                                |                                                                                                  | 
|                  | String generateStatement()   |                                | generate bank statement with transaction dates, amounts, and balance at the time of transaction  | 
|                  |                              |                                |                                                                                                  | 
|                  | double getBalance()          |                                | returns balance based on transactions                                                            | 
|                  |                              |                                |                                                                                                  | 
| Transaction      |                              | LocalTimeDate dateTime         |                                                                                                  | 
|                  |                              | double amount                  |                                                                                                  | 
|                  |                              |                                |                                                                                                  | 
| AccountType enum |                              | CURRENT, SAVINGS               |                                                                                                  | 
|                  |                              |                                |                                                                                                  | 

extension model:

| Classes                 | Methods                        | Fields                         | Scenario                                                                                        |
|-------------------------|--------------------------------|--------------------------------|-------------------------------------------------------------------------------------------------|
| Account                 |                                | AccountType type,              |                                                                                                 |
|                         |                                | List<Transaction> transactions |                                                                                                 |
|                         |                                | Branch branch                  |                                                                                                 |
|                         |                                |                                |                                                                                                 |
|                         | void deposit(double amount)    |                                | if amount is a positive number add new transaction to transaction list                          |
|                         |                                |                                | otherwise throw exception                                                                       |
|                         |                                |                                |                                                                                                 |
|                         | void withdraw(double amount)   |                                | if amount is a positive number add new transaction to transaction list                          | 
|                         |                                |                                | otherwise throw exception                                                                       | 
|                         |                                |                                |                                                                                                 | 
|                         | String generateStatement()     |                                | generate bank statement with transaction dates, amounts, and balance at the time of transaction | 
|                         | void sendStatement()           |                                | send bank statement via sms                                                                     | 
|                         |                                |                                |                                                                                                 | 
|                         | double getBalance()            |                                | returns balance based on transactions                                                           |
|                         |                                |                                |                                                                                                 | 
| CurrentAccount: Account |                                |                                |                                                                                                 | 
|                         |                                | boolean overdraftAllowed       |                                                                                                 | 
|                         |                                | boolean overdraftRequested     |                                                                                                 | 
|                         |                                |                                |                                                                                                 | 
|                         | void requestOverdraft()        |                                | set overdraftRequested to true                                                                  | 
|                         | void approveOverdraftRequest() |                                | set overdraftAllowed to true, overdraftRequested to false                                       | 
|                         | void rejectOverdraftRequest()  |                                | set overdraftAllowed to false, overdraftRequested to false                                      | 
|                         |                                |                                |                                                                                                 | 
| Branch                  |                                | String name                    |                                                                                                 | 
|                         |                                | String address                 |                                                                                                 | 
|                         |                                |                                |                                                                                                 | 
| Transaction             |                                | LocalTimeDate date             |                                                                                                 | 
|                         |                                | long amount                    |                                                                                                 | 
|                         |                                |                                |                                                                                                 | 
| AccountType enum        |                                | CURRENT, SAVINGS               |                                                                                                 | 
|                         |                                |                                |                                                                                                 | 
