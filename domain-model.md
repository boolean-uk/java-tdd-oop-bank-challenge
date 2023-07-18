**User stories:**
- As a customer,
So I can safely store and use my money,
I want to create a current account.

- As a customer,
So I can save for a rainy day,
I want to create a savings account.

- As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

- As a customer,
So I can use my account,
I want to deposit and withdraw funds.

**Domain model:**

| Class              | Fields                              | Methods                                | Scenario                                                     | Outcome                                                     |
|--------------------|-------------------------------------|----------------------------------------|--------------------------------------------------------------|-------------------------------------------------------------|
| <enum> AccountType | SAVINGS                             | N/A                                    | N/A                                                          | N/A                                                         |
|                    | CURRENT                             |                                        |                                                              |                                                             |
|                    |                                     |                                        |                                                              |                                                             |
| <abstract> Account | double balance                      | deposit(double amount)                 | User wants to deposit money and the amount value is positive | User deposits money to the account / True                   |
|                    | ArrayList<Transaction> transactions |                                        | User wants to deposit money and the amount value is negative | User is prompted with an error / False                      |
|                    |                                     | withdraw(double amount)                | User wants to deposit money and the amount value is negative | User withdraws money from the account / True                |
|                    |                                     |                                        | User wants to deposit money and the amount value is positive | User is prompted with an error / False                      |
|                    |                                     | printStatement()                       | User wants to see his transaction history                    | The history is being printed to the console / True          |
|                    |                                     |                                        |                                                              |                                                             |
| CurrentAccount     | N/A                                 | N/A                                    | N/A                                                          | N/A                                                         |
|                    |                                     |                                        |                                                              |                                                             |
| SavingsAccount     | N/A                                 | N/A                                    | N/A                                                          | N/A                                                         |
|                    |                                     |                                        |                                                              |                                                             |
| BankManager        | HashMap<String, Account>            | createAccount(AccountType accountType) | User wants to open an account with given accountType         | A new account is being created with a unique account number |
|                    |                                     |                                        |                                                              |                                                             |
| Transaction        | Date date                           |                                        |                                                              |                                                             |
|                    | double amount                       |                                        |                                                              |                                                             |
|                    | double balance                      |                                        |                                                              |                                                             |