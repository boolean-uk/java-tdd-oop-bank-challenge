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

As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

| Class    | Member variables                                | Methods                       | Scenario                                        | Outputs                 |
|----------|-------------------------------------------------|-------------------------------|-------------------------------------------------|-------------------------|
| Customer | `ArrayList<Accounts>`, `ArrayList<Transaction>` | `getBalance(Account account)` | customer/engineer wants balance from an account | account balance, double |

As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

| Class   | Member variables            | Methods                       | Scenario                                                                         | Outputs |
|---------|-----------------------------|-------------------------------|----------------------------------------------------------------------------------|---------|
| Bank    | `HashMap<String, Customer>` | `newAccount(Account account)` | customer wants to create an acount and bank manager wants to link it to a branch | -       |
| Account | `-`                         | `Account(... Branch b ...)`   | during account creation, this account gets linked to a bank branch               | -       |

As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

| Class         | Member variables                                  | Methods                                                               | Scenario                                    | Outputs              |
|---------------|---------------------------------------------------|-----------------------------------------------------------------------|---------------------------------------------|----------------------|
| Customer/Bank | `HashMap<String, Customer>, ArrayList<Overdraft>` | `requestOverdraft(Customer c, Account c, Overdraft overdraftRequest)` | customer wants to request overdraft request | overdraft registered |

As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

| Class     | Member variables            | Methods                         | Scenario                                                   | Outputs                            |
|-----------|-----------------------------|---------------------------------|------------------------------------------------------------|------------------------------------|
| Bank      | `HashMap<String, Customer>` | `getPendingOverdraftRequests()` | bank manager wants to reject or approve overdraft requests | list of pending overdraft requests |
| Overdraft | `ArrayList<Overdraft>`      | `rejectOverdraft()`             | bank manager rejected this overdraft                       | overdraft rejected                 |
| Overdraft | `ArrayList<Overdraft>`      | `approveOverdraft()`            | bank manager approved this overdraft                       | overdraft approved                 |
