

```
1. As a customer,
   So I can safely store and use my money,
   I want to create a current account.
   
2. As a customer,
   So I can save for a rainy day,
   I want to create a savings account.
```

| Classes | Methods                                | Scenario               | Returns      |
|---------|----------------------------------------|------------------------|--------------|
| Bank    | boolean createAccount(Account account) | Account already exists | return false |
|         |                                        | Account does not exist | return true  |

```
3. As a customer,
   So I can keep a record of my finances,
   I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```

| Classes | Methods                                                        | Scenario                    | Returns                                                     |
|---------|----------------------------------------------------------------|-----------------------------|-------------------------------------------------------------|
| Account | String getBankStatements(DateTime startDate, DateTime endDate) | Not a valid date            | "No bank statements between these dates"                    |
|         |                                                                | Valid date                  | String containing all transactions made between given dates |
| Bank    | Account getAccount(int accountNumber)                          | Existing account number     | returns account                                             |
|         |                                                                | Non-existent account number | returns null                                                |

```
4. As a customer,
   So I can use my account,
   I want to deposit and withdraw funds.
```

| Classes | Methods                                                       | Scenario                         | Returns |
|---------|---------------------------------------------------------------|----------------------------------|---------|
| Account | boolean deposit(double amount)                                | Valid amount                     | true    |
|         |                                                               | Invalid amount                   | false   |
| Bank    | boolean depositToAccount(int accountNumber, double amount)    | Valid account number and amount  | true    |
|         |                                                               | invalid Account number or amount | false   |
| Account | boolean withdraw(double amount)                               | Valid amount                     | true    |
|         |                                                               | invalid amount                   | false   |
| Bank    | boolean withdrawFromAccount(int accountNumber, double amount) | valid amount                     | true    |
|         |                                                               | invalid amount                   | false   |
