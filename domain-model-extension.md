## User stories and domain models

### Story 3
```
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.
```

| Class   | Method                          | Return value | Class variable                       | Description                                     |
|---------|---------------------------------|--------------|--------------------------------------|-------------------------------------------------|
| Account | requestOverdraft(double amount) | void         | int balance<br/>int maximumOverdraft | Either approves or denies the account overdraft |

### Story 1

Also have to change some of the existing methods to now use this calculated balance. Keep the balance as a class variable to potentially cross-reference .
```
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.
```

| Class   | Method                       | Return value | Class variable                        | Description                                                   |
|---------|------------------------------|--------------|---------------------------------------|---------------------------------------------------------------|
| Account | getBalanceFromTransactions() | int          | List\<Transaction> transactionHistory | Calculate what should be the balance from transaction history |
