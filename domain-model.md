

### Bank class ###

| Method                                               | Description                          | Outcomes                  |
|------------------------------------------------------|--------------------------------------|---------------------------|
| createAccount(String accountNumber, Account account) | Create an empty account and give ID. | Return void.              |
| getAccount(String accountNumber)                     | Retrieve given account.              | Return specified account. |
| printStatement(String accountNumber)                 | Design and print the bank statement. | Return bank statement.    |

### Bank attributes ###

| Map<String, Account> accounts | 
|-------------------------------|


--------------------------------------------------------------------------------------------------

### Account class ###


| Method                                         | Description                                     | Outcomes                         |
|------------------------------------------------|-------------------------------------------------|----------------------------------|
| deposit(double amount)                         | Add funds to specified account.                 | Return new value of account.     |
| withdraw(double amount, double overdraftLimit) | Remove funds from specified account.            | Return new value of account.     |
| calculateBalance()                             | Retrieve account balance based on transactions. | Return current value of account. |
| getTransactions()                              |                                                 |                                  |


### Account attributes ###

| List <Transactions> transactions |   
|----------------------------------|

--------------------------------------------------------------------------------------------------

### Transaction class ###

| Method      | Description                | Outcomes         |
|-------------|----------------------------|------------------|
| getCredit() |                            | Return credit.   |
| getDebit()  |                            | Return debit.    |
| toString()  | Format the bank statement. | Return as string |



