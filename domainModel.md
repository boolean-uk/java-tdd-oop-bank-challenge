# Domain model

## User stories
### 1
```
As a customer,
So I can safely store and use my money,
I want to create a current account.
```

### 2 
```
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```

### 3 
```
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```

### 4 
```
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```

### 5 
```
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.
```

### 6
```
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.
```

### 7
```
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.
```

### 8
```
As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.
```

### 9
```
As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.
```

## Classes
`Construcors, getters and setters have been omitted from the model.`

### Customer Class
| Variables                     | Description                                                 |
|-------------------------------|-------------------------------------------------------------|
| `ArrayList<Account> accounts` | List of all the accounts belonging to a specific customer.  |

| Methods                                                      | Scenario                             | Outputs |
|--------------------------------------------------------------|--------------------------------------|---------|
| `void createAccount(AccountType accountType, Branch branch)` | Customer wants to create an account. | -       |


### Account Abstract Class
| Variables                                   | Description                                                                        |
|---------------------------------------------|------------------------------------------------------------------------------------|
| `ArrayList<Transaction> transactionHistory` | Contains the history of transactions.                                              |
| `boolean canOverdraft`                      | Decides if customer can overdraft account.                                         |
| `boolean overdraftRequested`                | Contains information whether overdrafted has been requested for the given account. |
| `Branch ownerBranch`                        | Branch associated with account.                                                    |
| `int maxOverdraft`                          | Max amount the can be overdrafted from the account.                                |

| Methods                                        | Scenario                                                                                       | Outputs                                                                                          |
|------------------------------------------------|------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| `void deposit(int amount)`                     | Customer wants to deposit money into the account.                                              | -                                                                                                |
| `boolean withdraw(int amount)`                 | Customer wants to withdraw money from the account.                                             | If customer has sufficient money in account, or overdraft has been accepted.                     |
|                                                |                                                                                                | False if customer does not have sufficient money in account and overdraft has not been accepted. |
| `void generateBankStatement()`                 | Creates list of transactions, including dates, amounts and balance.                            | -                                                                                                |
| `void printBankStatement()`                    | Prints the bank statement.                                                                     | -                                                                                                |
| `int calculateBalanceFromTransactionHistory()` | Customer wants account balance to be based on transaction history instead of stored in memory. | -                                                                                                |
| `void printBankStatement()`                    | Prints either of the aforementioned bank statements.                                           |                                                                                                  |
| `void requestOverdraft()`                      | Customer wants to be allowed to overdraft the account.                                         | -                                                                                                |
| `void rejectOverdraftRequest()`                | The manager wants to reject an overdraft request.                                              | -                                                                                                |
| `void acceptOverdraftRequest()`                | The manager wants to accept an overdraft request.                                              ||

### SavingsAccount extends Account Class


### CurrentAccount extends Account Class

### Transaction 
| Variables            | Description                                      |
|----------------------|--------------------------------------------------|
| `String date`        | Contains the date of the transaction.            |
| `int amount`         | Contains the amount of the transaction.          |
| `int currentBalance` | Contains the balance at the time of transaction. | 

### Branch Class
| Variables     | Description                      |
|---------------|----------------------------------|
| `String name` | Contains the name of the branch. |

