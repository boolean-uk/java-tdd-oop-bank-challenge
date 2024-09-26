## User stories and domain models

### Story 1

Also have to change some of the existing methods to now use this calculated balance. Keep the balance as a class variable to potentially cross-reference.
```
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.
```

| Class   | Method                       | Return value | Class variable                        | Description                                                   |
|---------|------------------------------|--------------|---------------------------------------|---------------------------------------------------------------|
| Account | getBalanceFromTransactions() | int          | List\<Transaction> transactionHistory | Calculate what should be the balance from transaction history |

### Story 2

Current Bank class acts like a branch. Rename Bank to Branch and create a new Bank class to contain all branches.
```
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.
```

### Story 3 & 4
```
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.
```

| Class            | Method                                     | Return value | Class variable | Description                                                                                                                                |
|------------------|--------------------------------------------|--------------|----------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| OverdraftManager | requestOverdraft(OverdraftRequest request) | void         |                | Either approves or denies the account overdraft. Current logic denies if new balance would exceed maximum overdraft value for that account |
