## Domain model

As a customer,
So I can safely store and use my money,
I want to create a current account.

As a customer,
So I can save for a rainy day,
I want to create a savings account.

| Class         | Member variables      | Methods                                     | Scenario                                                    | Outputs    |
|---------------|-----------------------|---------------------------------------------|-------------------------------------------------------------|------------|
| Bank/Customer | `ArrayList<Customer>` | `addAccount(User user, Account newAccount)` | customer wants to create a new account (savings or current) | true/false |

As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

| Class         | Member variables      | Methods                        | Scenario                              | Outputs                |
|---------------|-----------------------|--------------------------------|---------------------------------------|------------------------|
| Bank/Customer | `ArrayList<Customer>` | `getStatements(String userId)` | customer wants to get bank statements | List with transactions |

As a customer,
So I can use my account,
I want to deposit and withdraw funds.

| Class         | Member variables      | Methods                                               | Scenario                         | Outputs      |
|---------------|-----------------------|-------------------------------------------------------|----------------------------------|--------------|
| Bank/Customer | `ArrayList<Customer>` | `deposit(User user, Account account, double amount)`  | customer wants to deposit money  | success/fail |
| Bank/Customer | `ArrayList<Customer>` | `withdraw(User user, Account account, double amount)` | customer wants to withdraw money | success/fail |
