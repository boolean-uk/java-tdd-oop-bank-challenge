
| Class          | Member variables    | Methods                                    | Scenario | Output |
|----------------|---------------------|--------------------------------------------|----------|--------|
| `AccountOwner` |                     |                                            |          |        |
|                | bankName : String   |                                            |          |        |
|                | bankBranch : String |                                            |          |        |
|                | ownerID : String    |                                            |          |        |
|                | name : String       |                                            |          |        |
|                | Arraylist<Account>  |                                            |          |        | 
|                |                     | createAccount(accountType : String)        |          |        |
|                |                     | generateBankStatement(accountNumber : int) |          |        |


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

| Class                            | Member Variable         | Methods                         | Scenario                           | Output |
|----------------------------------|-------------------------|---------------------------------|------------------------------------|--------|
| `currentAccount extends Account` | overdraftLimit : double |                                 |                                    |        |
|                                  |                         | applyOverdraft(amount : double) | applies  overdraft to the balance. |        |
|                                  |                         |                                 |                                    |        |

| Class                            | Member Variable       | Methods             | Scenario                             | Output |
|----------------------------------|-----------------------|---------------------|--------------------------------------|--------|
| `SavingsAccount extends Account` |                       |                     |                                      |        |
|                                  | interestRate : double |                     |                                      |        |
|                                  |                       | applyInterestRate() | applies interest rate to the account |        |
    
| Class         | Member Variable      | Methods   | Scenario                 | Output   |
|---------------|----------------------|-----------|--------------------------|----------|
| `Transaction` | date : String        |           |                          |          |
|               | deposit : double     |           |                          |          |
|               | withdrawal : double  |           |                          |          |
|               | balance : double     |           |                          |          | 
|               | description : String |           |                          |          |
|               |                      | getDate() | use Datetime to get date | Datetime |        
