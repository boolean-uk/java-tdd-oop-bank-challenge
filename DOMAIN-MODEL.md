# Domain model (Core)

| Class          | Field                                | Method                  | Scenario | Outcome |
|----------------|--------------------------------------|-------------------------|----------|---------|
| Bank           | ArrayList<Account> accounts          |                         |          |         |
| Account        |                                      |                         |          |         |
|                |                                      | withdraw(double amount) |          |         |
|                |                                      | deposit(double amount)  |          |         |
|                |                                      | generateStatement()     |          |         |
| CurrentAccount | int balance                          |                         |          |         |
|                | ArrayList<Transaction> transactions  |                         |          |         |
|                |                                      | withdraw(double amount) |          |         |
|                |                                      | deposit(double amount)  |          |         |
|                |                                      | generateStatement()     |          |         |
| SavingAccount  | int balance                          |                         |          |         |
|                | ArrayList<Transaction> transactions  |                         |          |         |
|                |                                      | withdraw(double amount) |          |         |
|                |                                      | deposit(double amount)  |          |         |
|                |                                      | generateStatement()     |          |         |
|                |                                      |                         |          |         |
|                |                                      |                         |          |         |
|                |                                      |                         |          |         |
|                |                                      |                         |          |         |
| Transaction    | LocalDate date                       |                         |          |         |
|                | int amount                           |                         |          |         |
|                | int balance                          |                         |          |         |
|                |                                      |                         |          |         |









