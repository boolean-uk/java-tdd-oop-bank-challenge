## Domain model

As a customer,
So I can safely store and use my money,
I want to create a current account.

As a customer,
So I can save for a rainy day,
I want to create a savings account.

| Class         | Member variables           | Methods                                          | Scenario                                                    | Outputs                                 |
|---------------|----------------------------|--------------------------------------------------|-------------------------------------------------------------|-----------------------------------------|
| Bank/Customer | `HasMap<String, Customer>` | `newAccount(Customer customer, Account account)` | customer wants to create a new account (savings or current) | newly created account, or null if error |

As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

| Class    | Member variables           | Methods                            | Scenario                                  | Outputs                |
|----------|----------------------------|------------------------------------|-------------------------------------------|------------------------|
| Bank     | `HasMap<String, Customer>` | `getStatements(Customer customer)` | customer wants to get bank statements     | List with transactions |
| Customer | `ArrayList<Transactions>`  | `getTransactions()`                | caller wants this customer's transactions | List with transactions |

As a customer,
So I can use my account,
I want to deposit and withdraw funds.

| Class | Member variables            | Methods                                                       | Scenario                         | Outputs      |
|-------|-----------------------------|---------------------------------------------------------------|----------------------------------|--------------|
| Bank  | `HashMap<String, Customer>` | `deposit(Customer customer, Account account, double amount)`  | customer wants to deposit money  | success/fail |
| Bank  | `HashMap<String, Customer>` | `withdraw(Customer customer, Account account, double amount)` | customer wants to withdraw money | success/fail |
