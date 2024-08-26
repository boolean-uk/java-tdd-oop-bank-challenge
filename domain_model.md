| Class          | Methods                     | Scenarios                | Output                       |
|----------------|-----------------------------|--------------------------|------------------------------|
| Customer       | getAccounts()               | Customer has accounts    | List of 'Account'            |
|                |                             | Customer has no accounts | Empty list                   |
|                |                             |                          |                              |
|                | addAccount()                | Always                   | void                         |
|                | getFirstName()              | Always                   | String                       |
|                | getLastName()               | Always                   | String                       |
|                |                             |                          |                              |
| Account        | getBranch()                 | Always                   | Branch object                |
|                | getBalance()                | Always                   | double                       |
|                | deposit(double)             | if amount > 0            | String "Deposit sucessful"   |
|                |                             | if amount <= 0           | Amount should be positive    |
|                |                             |                          |                              |
|                |                             |                          |                              |
|                | Withdraw(double)            | Sufficient balance       | String "Withdraw Successful" |
|                |                             | Insufficient balance     | String "Insufficient funds!" |
|                |                             |                          |                              |
|                | getTransactions()           | Always                   | List<String>                 |
|                |                             |                          |                              |
| CurrentAccount | requestOverdraft(double)    | Always                   | void                         |
|                | approveOverdraft(double)    | Always                   | boolean                      |
|                | rejectOverdraft()           | Always                   | void                         |
|                |                             |                          |                              |
|                | getApprovedOverdraftLimit() | Overdraft approved       | double                       |
|                |                             | Overdraft not approved   | 0                            |
|                |                             |                          |                              |
| SavingsAccount | getInterestRate()           | Always                   | double                       |
|                | applyInterest()             | Always                   | void                         |
|                |                             |                          |                              |
