| Class         | Member Variables                     | Methods                                  | Scenario                                                                         | Output                        |
|---------------|--------------------------------------|------------------------------------------|----------------------------------------------------------------------------------|-------------------------------|
| `BankManager` | name : String                        |                                          |                                                                                  |                               |
|               | branch : Integer                     |                                          |                                                                                  |                               |
|               | overdraftHistory : Arraylist<String> |                                          |                                                                                  |                               |
|               |                                      |                                          |                                                                                  |                               |
|               |                                      | getOverdraftRequest(Account)             | Access the account's pendingOverdrafts arraylist and get the overdraft at idx 0. | Overdraft/ message and amount |
|               |                                      | grantOverdraft(Account, amount : double) | Should provide the account with the granted overdraft amount.                    | String                        |

| Class          | Member variables    |
|----------------|---------------------|
| `AccountOwner` |                     |
|                | bankName : String   |
|                | bankBranch : String |
|                | name : String       |
|                | Arraylist<Account>  | 

| Class     | Member Variables                       | Methods                                           | Scenario                                                                                                | Output                         |
|-----------|----------------------------------------|---------------------------------------------------|---------------------------------------------------------------------------------------------------------|--------------------------------|
| `Account` |                                        |                                                   |                                                                                                         |                                |
|           | accountNumber : int                    |                                                   |                                                                                                         |                                |
|           | owner : AccountOwner                   |                                                   |                                                                                                         |                                |
|           | bankStatement : ArrayList<Transaction> |                                                   |                                                                                                         |                                |
|           | balance : double                       |                                                   |                                                                                                         |                                |
|           |                                        | deposit(amount : double, description : String)    | Adds the deposit to the balance, creates a transaction, adds it to bankStatement                        | updated balance, bankStatement |
|           |                                        | withdrawal(amount : double, description : String) | Should remove the withdrawal from the balance, create a transaction for it and add it to bankStatement. | updated balance, bankStatement |
|           |                                        |                                                   |                                                                                                         |                                |
|           |                                        |                                                   |                                                                                                         |                                |

| Class                            | Member Variable                                 | Methods                                                       | Scenario                                                                                                                                      | Output |
|----------------------------------|-------------------------------------------------|---------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|--------|
| `currentAccount extends Account` | overdraftLimit : double                         |                                                               |                                                                                                                                               |        |
|                                  | pendingOverdraftRequests : Arraylist<Overdraft> |                                                               |                                                                                                                                               |        |
|                                  |                                                 | makeOverdraftRequest(amount : double, message : String)       | creates an instance of Overdraft and adds it to the pendingOverdrafts list                                                                    | String |
|                                  |                                                 | deposit(amount : double, description : String)<<Override>>    | Adds the deposit to the balance, creates a transaction, adds it to bankStatement                                                              | String |
|                                  |                                                 | withdrawal(amount : double, description : String)<<Override>> | Should remove the withdrawal from the balance taking into account the overdraftLimit, create a transaction for it and add it to bankStatement | String |
|                                  |                                                 |                                                               |                                                                                                                                               |        |

| Class                            | Member Variable | Methods                                            | Scenario                                                                                                | Output |
|----------------------------------|-----------------|----------------------------------------------------|---------------------------------------------------------------------------------------------------------|--------|
| `SavingsAccount extends Account` |                 |                                                    |                                                                                                         |        |
|                                  |                 | deposit(amount : double, description : String)     | Adds the deposit to the balance, creates a transaction, adds it to bankStatement                        | String |
|                                  |                 | withdrawal(amount : double, description : String)  | Should remove the withdrawal from the balance, create a transaction for it and add it to bankStatement. | String |
    
| Class         | Member Variable     |
|---------------|---------------------|
| `Transaction` | date : String       |
|               | deposit : double    |
|               | withdrawal : double |
|               | balance : double    | 
|               |                     |
|               |                     |        

| Class       | Member variable  |
|-------------|------------------|
| `Overdraft` |                  |
|             | message : String |
|             | amount : double  |

