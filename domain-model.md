```
As a customer,
So I can safely store and use my money,
I want to create a current account.
```

| Class | Member Variable                                    | Method          | Description                  | Output                    |
|-------|----------------------------------------------------|-----------------|------------------------------|---------------------------|
| User  | String name<br/>String email, String accountNumber | User()          | Creates a user               |                           |
| User  | String accountNumber<br/>Account account           | createCurrent() | User creates current account | return true if successful |

```
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```
| Class | Member Variable                  | Method            | Description                  | Output                    |
|-------|----------------------------------|-------------------|------------------------------|---------------------------|
| User  | String accountNumber<br/>Account | createSavings()   | User creates savings account | return true if successful |
|       |                                  |                   |                              |                           |

```
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```
| Class       | Member Variable                             | Method                   | Description                | Output         |
|-------------|---------------------------------------------|--------------------------|----------------------------|----------------|
| User        | String accountNumber<br/> List<Transaction> | generateBankStatements() | Prints out bank statements | return String  |
| Transaction |                                             | makeTransaction()        | Makes a transaction        | return balance |

```
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```

| Class | Member Variable | Method                   | Description                               | Output                |
|-------|-----------------|--------------------------|-------------------------------------------|-----------------------|
| User  | double funds    | deposit(funds, account)  | Deposits funds into the selected account  | return double balance |
|       |                 | withdraw(funds, account) | Withdraws funds from the selected account | return double balance |


```
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

```
| Class   | Member Variable   | Method                   | Description                             | Output        |
|---------|-------------------|--------------------------|-----------------------------------------|---------------|
| User    | List<Transaction> | generateBankStatements() | Prints out bank statements              | return String |
| Account |                   | getBalance()             | Calculates balance from all transaction | return double |


```
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.
```

| Class | Member Variable                      | Method                                 | Description                             | Output      |
|-------|--------------------------------------|----------------------------------------|-----------------------------------------|-------------|
| Bank  | User user, String name, String email | createUser(String name, String email)) | Creates user within that branch of bank | return user |
|       |                                      |                                        |                                         |             |
