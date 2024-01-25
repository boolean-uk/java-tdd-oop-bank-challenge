## CORE

```
1.
As a customer,
So I can safely store and use my money,
I want to create a current account.

2.
As a customer,
So I can save for a rainy day,
I want to create a savings account.

3.
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

4.
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```
## Extensions

```

5.
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

6.
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

7.
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

8.
As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

9.
As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.

```


| Classes   | Methods                                   | Variables                             | Scenario                                 | Return | Story |
|-----------|-------------------------------------------|---------------------------------------|------------------------------------------|--------|-------|
| Bank      | createCurrAccount(String customerId)      | HashMap<String, Account> accountsCurr | Add new account to HashMap               |        | 1     |
|           | createSaveAccount(String customer Id)     | HashMap<String,Account> accountSave   | Add new account to HashMap               |        | 2     |
|           | generateStatements(String accountId)      | Account.getStatements()               | Get all statements from an account       | String | 3     |
|           | getBalance(String accountId)              | Account.calcBalance()                 | Get balance from account                 | double | 5     |
|           | answerRequests()                          | ArrayList<String> requests            | Answer all pending requests              |        | 8     |
|           | requestOverdraft(String accountId)        | ArrayList<String> requests            | Add new request                          |        | 7     |
|           |                                           |                                       |                                          |        |       |
| Account   | Account(String customerId, String branch) |                                       |                                          |        | 1,2,6 |
|           | setOverdraft(boolean enable)              | boolean overdraftEnabled              | Enable/disable overdraft                 |        |       |
|           | deposit(int amount)                       | ArrayList <Statement> statements      | Add new deposit Statement to statements  |        | 4     |
|           | withdraw(int amount)                      | ArrayList <Statement> statements      | Add new withdraw Statement to statements |        | 4     |
|           | calcBalance()                             | ArrayList <Statement> statements      |                                          | int    | 5     |
|           |                                           |                                       |                                          |        |       |
| Statement | Statement(String type, int amount)        | type                                  |                                          |        |       |
|           |                                           | amount                                |                                          |        |       |
|           |                                           |                                       |                                          |        |       |



```