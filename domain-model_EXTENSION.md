| Class          | Attributes                                                                 | Methods                        | Scenario/Output                   |
|----------------|----------------------------------------------------------------------------|--------------------------------|-----------------------------------|
| Account        | balance: BigDecimal, transactions:List<Transaction>, accountNumber: String | deposit(BigDecimal amount)     | account.deposit()                 |
|                |                                                                            | withdraw(BigDecimal amount)    | account.withdraw()                |
|                |                                                                            | generateRandomDateTime()       |                                   |
|                |                                                                            | setOverdraftLimit(BigDecimal overdraftLimit)            |                                   |
|                |                                                                            | requestOverdraft(BigDecimal amount)                                                      |                                   |
| Transaction    | dateTime: LocalDateTime, amount: BigDecimal, type: TransactionType         | getDateTime()                  |                                   |
|                |                                                                            | getAmount()                    |                                   |
|                |                                                                            | getType()                      |                                   |
|                |                                                                            | toSring()                      |                                   |
| CurrentAccount | verdraftRequestPending: boolean , requestedOverdraftAmount: BigDecimal     | deposit( BigDecimal amount)    |                                   |
|                |                                                                            | withdraw( BigDecimal amount)   |                                   |
|                |                                                                            | isOverdraftRequestPending()                               |                                   |
|                |                                                                            | getRequestedOverdraftAmount()                              |                                   |
|                |                                                                            | requestOverdraft(BigDecimal amount)                                                          |                                   |
|                |                                                                            | approveOverdraftRequest()                                                                                            |                                   |
|                |                                                                            | rejectOverdraftRequest()                                                                                                                     |                                   |
| SaningsAccount |                                                                            | deposit( BigDecimal amount)    |                                   |
|                |                                                                            | withdraw( BigDecimal amount)   |                                   |
|                |                                                                            | requestOverdraft(BigDecimal amount)                               |                                   |
| BankStatement  |                                                                            | printStatement(Account account) |                                   |
| BankManager    | branches :List<Branch> ,clients : List<Client>                             | addBranch()                    |                                   |
|                |                                                                            | removeBranch()                 |                                   |
|                |                                                                            | getClients()                   |                                   |
|                |                                                                            | getBranches()                  |                                   |
|                |                                                                            | addClient()                    |                                   |
|                |                                                                            | getClientById(String clientId) | if client exists -> return client |
| Branch         | branchName : String, accounts: List<Account>, clients List<Client>         | addAccount()                   |                                   |
|                |                                                                            | removeAccount()                |                                   |
| Client         | name: String, clientId: String                                             |                                |                                   |
