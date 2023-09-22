# Domain Model

| Classes  | Attributes            | Methods                                                 | Scenario                                                     | Output |
|----------|-----------------------|---------------------------------------------------------|--------------------------------------------------------------|--------|
| Customer | customerId            | createAccount(accountType: AccountType)                 | - A new account of the specified type is successfully        |        |
|          | name                  |                                                         | created and associated with the customer.                    |        |
|          | email                 |                                                         | - Invalid account type is provided                           |        |
|          | phoneNumber (for SMS) |                                                         | (e.g., an account type that doesn't exist)                   |        |
|          | account(s)            | requestOverdraft(account: Account, amount: BigDecimal)  | - successfully submitted for approval                        |        |
|          |                       |                                                         | - requested amount exceeds the allowed limit for the account |        |
|          |                       |                                                         | - account is not eligible for overdraft requests             |        |
|          |                       |                                                         |                                                              |        |
|          |                       |                                                         |                                                              |        |
|          |                       |                                                         |                                                              |        |
|          |                       |                                                         |                                                              |        |



| Classes  | Attributes                         | Methods                      | Scenario                                                 | Output |
|----------|------------------------------------|------------------------------|----------------------------------------------------------|--------|
| Account  | accountNumber                      | deposit(amount: BigDecimal)  | - successful + balance is updated                        |        |
|          |                                    |                              | - amount is negative                                     |        |
|          |                                    |                              |                                                          |        |
|          | accountType (current or savings)   | withdraw(amount: BigDecimal) | - successful + balance is updated                        |        |
|          |                                    |                              | - amount is negative                                     |        |
|          |                                    |                              | - balance is not sufficient                              |        |
|          | balance(can be calculated based on | calculateBalance()           | - accurately calculated based on the transaction history |        |
|          |                                    |                              | - no transaction history                                 |        |
|          | transaction history)               | generateStatement()          | - successfully generated                                 |        |
|          |                                    |                              | - no transaction history                                 |        |
|          |                                    |                              |                                                          |        |
|          |                                    |                              |                                                          |        |
|          |                                    |                              |                                                          |        |
|          |                                    |                              |                                                          |        |


| Classes | Attributes | Methods | Scenario | Output |
|---------|------------|---------|----------|--------|
| Branch  | branchId   |         |          |        |
|         | branchName |         |          |        |
|         | accounts?  |         |          |        |
|         | clients?   |         |          |        |
|         |            |         |          |        |
|         |            |         |          |        |
|         |            |         |          |        |
|         |            |         |          |        |
|         |            |         |          |        |



| Classes     | Attributes                | Methods | Scenario | Output |
|-------------|---------------------------|---------|----------|--------|
| Transaction | transactionId             |         |          |        |
|             | transactionDateTime       |         |          |        |
|             | amount                    |         |          |        |
|             | type(withdrawal/deposit)? |         |          |        |


| Classes          | Attributes                           | Methods          | Scenario                               | Output |
|------------------|--------------------------------------|------------------|----------------------------------------|--------|
| OverdraftRequest | requestId                            | approveRequest() | - overdraft request is approved        |        |
|                  |                                      |                  | - request already approved or rejected |        |
|                  | requestDate                          | rejectRequest()  | - overdraft request is rejected        |        |
|                  | amount                               |                  | - request already approved or rejected |        |
|                  | status /pending, approved, rejected/ |                  |                                        |        |

| Classes       | Attributes                 | Methods                          | Scenario          | Output |
|---------------|----------------------------|----------------------------------|-------------------|--------|
| BankStatement | statementId                | sendMessage(customer: Customer)  | successfully sent |        |
|               | statementDateTime          |                                  | invalid number ?  |        |
|               | message/statement itself/? |                                  |                   |        |
|               |                            |                                  |                   |        |