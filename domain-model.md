| Class  | Member Variables                                       | Methods                                                      | Scenario                                                                                                                                                               | Output           |
|--------|--------------------------------------------------------|--------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------|
| `Bank` | Hashmap <AccountOwner, Arraylist<Account> accounts     |                                                              |                                                                                                                                                                        |                  |
|        | Hashmap <String branchName, int branchNumber> branches |                                                              |                                                                                                                                                                        |                  |
|        |                                                        | checkEmergencyFundRequests(accountNumber)                    | Takes a look into an account and see if any requests is put. The bank can eiter accept the EmergencyFundRequest or reject. Should update the account's overdraftLimit. | Accept or reject | 
|        |                                                        |                                                              |                                                                                                                                                                        |                  |
|        | openNewAccount(AccountOwner, accountType : String)     | Should create a new account and add it to Arraylist accounts | "New account successfully opened" / rejected                                                                                                                           |                  |
|        |                                                        |                                                              |                                                                                                                                                                        |                  |

As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.


| Class          | Member variables | Methods                                    | Scenario                                                                    | Output                            |
|----------------|------------------|--------------------------------------------|-----------------------------------------------------------------------------|-----------------------------------|
| `AccountOwner` |                  |                                            |                                                                             |                                   |
|                |                  |                                            |                                                                             |                                   |
|                | ownerID : String |                                            |                                                                             |                                   |
|                | name : String    |                                            |                                                                             |                                   |
|                |                  |                                            |                                                                             |                                   | 
|                |                  |                                            |                                                                             | "New account successfully opened" |
|                |                  | generateBankStatement(accountNumber : int) | Takes the accountable and then retrieves the bankStatement for that account |                                   |


| Class     | Member Variables                       | Methods                              | Scenario                                                                                                | Output                                  |
|-----------|----------------------------------------|--------------------------------------|---------------------------------------------------------------------------------------------------------|-----------------------------------------|
| `Account` | bankBranch : String                    |                                      |                                                                                                         |                                         |
|           | accountNumber : int                    |                                      |                                                                                                         |                                         |
|           | owner : AccountOwner                   |                                      |                                                                                                         |                                         |
|           | bankStatement : ArrayList<Transaction> |                                      |                                                                                                         |                                         |
|           | balance : double                       |                                      |                                                                                                         |                                         |
|           |                                        | deposit(amount : double )            | Adds the deposit to the balance, creates a transaction, adds it to bankStatement                        | updated balance, bankStatement          |
|           |                                        | withdrawal(amount : double )         | Should remove the withdrawal from the balance, create a transaction for it and add it to bankStatement. | updated balance, bankStatement          |
|           |                                        |                                      | Should ask for an emergency fund, if the amount is permission then it can be used.                      | "Emergency fund of amount permissioned" |
|           |                                        |                                      |                                                                                                         |                                         |
|           | pendingEmergencyFundRequest : double   |                                      |                                                                                                         |                                         |
|           |                                        | requestEmergencyFund(mount : double) | Updated the pendingEmergencyFundRequest for the bank manager to later accept or reject.                 |                                         |
|           | overdraftLimit : double                |                                      |                                                                                                         |                                         |

| Class                            | Member Variable | Methods | Scenario | Output |
|----------------------------------|-----------------|---------|----------|--------|
| `currentAccount extends Account` |                 |         |          |        |
|                                  |                 |         |          |        |
|                                  |                 |         |          |        |

| Class                            | Member Variable | Methods | Scenario | Output |
|----------------------------------|-----------------|---------|----------|--------|
| `SavingsAccount extends Account` |                 |         |          |        |
|                                  |                 |         |          |        |
|                                  |                 |         |          |        |
    
| Class         | Member Variable      | Methods   | Scenario                 | Output   |
|---------------|----------------------|-----------|--------------------------|----------|
| `Transaction` | date : String        |           |                          |          |
|               | deposit : double     |           |                          |          |
|               | withdrawal : double  |           |                          |          |
|               | balance : double     |           |                          |          | 
|               | description : String |           |                          |          |
|               |                      | getDate() | use Datetime to get date | Datetime |        
