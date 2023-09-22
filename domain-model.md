| Classes                        | Members                           | Methods                                                                    |
|--------------------------------|-----------------------------------|----------------------------------------------------------------------------|
| Account                        | Branch branch                     | deposit(double amount)                                                     |
|                                | List<Transaction> transactions    | withdraw(double amount)                                                    |
|                                | boolean overdraftRequest = false; | generateBankStatement()                                                    |
|                                | MessageService messageService;    | getCurrentBalance()                                                        |
|                                | String customerPhoneNumber;       | getTransaction()                                                           |
|                                |                                   | getBranch()                                                                |
|                                |                                   | requestAnOverdraftAndWithdraw(double amount)                               |
|                                |                                   |                                                                            |
| CurrentAccount extends Account |                                   |                                                                            |
|                                |                                   |                                                                            |
| SavingAccount extends Account  |                                   |                                                                            |
|                                |                                   |                                                                            |
| Transaction                    | Date transactionDate              | Getters()                                                                  |
|                                | double amount                     | Setters()                                                                  |
|                                | double balanceAtTime              |                                                                            |
|                                | TransactionType type              |                                                                            |
|                                |                                   |                                                                            |
| TransactionType (enum)         | DEPOSIT, WITHDRAW                 |                                                                            |
|                                |                                   |                                                                            |
| Branch                         | String id                         | Getters()                                                                  |
|                                | String name                       | Setters()                                                                  |
|                                | String phoneNumber                |                                                                            |
|                                | String address                    |                                                                            |
|                                |                                   |                                                                            |
| BankManager                    | final double OVERDRAFT_LIMIT      | isRequestAmountInValid(double amount)                                      |
|                                |                                   | hasNoTransactionHistory(ArrayList<Transaction> transactions)               |
|                                |                                   | isWithinOverdraftLimit(double amount, ArrayList<Transaction> transactions) |
|                                |                                   | evaluateRequest (double amount, ArrayList<Transaction> transactions)       |
|                                |                                   |                                                                            |
| MessageService                 |                                   | sendSMS(String phoneNumber, String message)                                |
