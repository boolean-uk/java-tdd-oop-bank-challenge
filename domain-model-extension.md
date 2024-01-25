```
1. As a bank manager,
   So I can expand,
   I want accounts to be associated with specific branches.
```

| Classes | Methods                                                                                                                                 | Scenario                     | Returns                     |
|---------|-----------------------------------------------------------------------------------------------------------------------------------------|------------------------------|-----------------------------|
| Bank    | boolean createSavingsAccount(String accountHolder, Branch branch)<br/>boolean createCurrentAccount(String accountHolder, Branch branch) | account does not exist       | true                        |
|         |                                                                                                                                         | account already exists       | false                       |
| Bank    | ArrayList<String> getAccountsInBranch(Branch branch)                                                                                    | accounts exists in branch    | populated ArrayList<String> |
|         |                                                                                                                                         | no accounts exists in branch | empty ArrayList<String>     |

```
2. As a customer,
   So I have an emergency fund,
   I want to be able to request an overdraft on my account.
```

| Classes | Methods                                     | Scenario                                  | Returns |
|---------|---------------------------------------------|-------------------------------------------|---------|
| Bank    | boolean requestOverdraft(int accountNumber) | account does not have overdraft activated | true    |
|         |                                             | account is not a savings account          | true    |
|         |                                             | account is a savings account              | false   |
|         |                                             | account has overdraft already activated   | false   |
```
3. As a bank manager,
   So I can safeguard our funds,
   I want to approve or reject overdraft requests.
```

| Classes | Methods                                   | Scenario              | Returns                     |
|---------|-------------------------------------------|-----------------------|-----------------------------|
| Bank    | ArrayList<String>getRequestedOverdrafts() | there are requests    | populated ArrayList<String> |
|         |                                           | there are no requests | empty ArrayList<String>     |
| Bank    | void approveOverDraft(int accountNumber)  |                       |                             |
|         |                                           |                       |                             |
