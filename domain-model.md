#### Bank Challenge Domain Models

### Core Exercise User Stories

## User Story 1
```
As a customer,
So I can safely store and use my money,
I want to create a current account.
```
# Domain Model For User Story 1

Version 1

| Class         | Member Variables           | Methods                                       | Scenario                          | Result/Output |
|---------------|----------------------------|-----------------------------------------------|-----------------------------------|---------------|
| BankAccount   | String accountHolder       |                                               |                                   |               |
|               | String accountNumber       |                                               |                                   |               |
|               | String accountType         |                                               |                                   |               |
|               | String accountBranch       |                                               |                                   |               |
|               | double balance             |                                               |                                   |               |
|               |                            |                                               |                                   |               |
| BankAffiliate | String fullName            | boolean createCurrentAccount(Account account) | If current account is created     | Return true   |
|               | String affiliation         |                                               | If current account is not created | Return false  |
|               | BankAccount currentAccount |                                               |                                   |               |
|               | BankAccount savingsAccount |                                               |                                   |               |


## User Story 3
```
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```

## User Story 4
```
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```

## User Story 5
```
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```