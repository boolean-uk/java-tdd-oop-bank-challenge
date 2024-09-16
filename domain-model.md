| Class          | Attributes                                                           | Methods                         | Scenario/Output    |
|----------------|----------------------------------------------------------------------|---------------------------------|--------------------|
| Account        | balance: BigDecimal, transactions:List<Transaction>                  | deposit(BigDecimal amount)      | account.deposit()  |
|                |                                                                      | withdraw(BigDecimal amount)     | account.withdraw() |
| Transaction    | dateTime: LocalDateTime, amount: BigDecimal, type: TransactionType   | getDateTime()                   |                    |
|                |                                                                      | getAmount()                     |                    |
|                |                                                                      | getType()                       |                    |
|                |                                                                      | toSring()                       |                    |
| CurrentAccount | balance: BigDecimal, transactions: List<Transaction>                 | deposit( BigDecimal amount)     |                    |
|                |                                                                      | withdraw( BigDecimal amount)    |                    |
|                |                                                                      | generateRandomDateTime()        |                    |
| SaningsAccount | balance: BigDecimal, transactions: List<Transaction>                 | deposit( BigDecimal amount)     |                    |
|                |                                                                      | withdraw( BigDecimal amount)    |                    |
|                |                                                                      | generateRandomDateTime()        |                    |
| BankStatement  |                                                                      | printStatement(Account account) |                    |
