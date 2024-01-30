```
1. 
As a customer,
So I can safely store and use my money,
I want to create a current account.
```

```
2.
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```

```
3.
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```

```
4.
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```


# Extension:

```
5.
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.
```

```
6.
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.
```

```
7.
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.
```

```
8.
As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.
```

```
9.
As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.
```

| Class                          | Methods                                                         | Scenario                                                         |  
|--------------------------------|-----------------------------------------------------------------|------------------------------------------------------------------|
| Account                        | calculateBalance():                                             | return tx dates, amounts, balance.                               |              
|                                | deposit(int double)                                             | debit account.                                                   |        
|                                | withdraw(int double)                                            | credit account.                                                  |        
|                                | sendStatement()                                                 | Send statement by sms.                                           |        
| SavingsAccount extends Account | createSavingsAccount(Customer, Branch)                          | Create a savings account by customer id and branch name.         |        
| CurrentAccount extends Account | createCurrentAccount(Customer, Branch)<br/>requestOverdraft()   | Create a current account by customer id and branch name.         |        
| Branches:                      | generate(branch)                                                | Manager can create a branch.                                     |        
|                                | add(Account)                                                    | Manager can add a Account to a branch.                           |        
|                                | assessOverdraftRequest(currentAccount)                          | Manager can approve Overdraft request by current account number. |        
| Customers:                     | createCustomer(id, prefix, number)                              | Create a customer id, add phone number include country prefix.   |        


