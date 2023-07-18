| Class          | Attributes                                                                 | Methods                         | Scenario/Output    |
|----------------|----------------------------------------------------------------------------|---------------------------------|--------------------|
| Account        | balance: BigDecimal, transactions:List<Transaction>, accountNumber: String | deposit(BigDecimal amount)      | account.deposit()  |
|                |                                                                            | withdraw(BigDecimal amount)     | account.withdraw() |
|                |                                                                            | generateRandomDateTime()        |                    |
| Transaction    | dateTime: LocalDateTime, amount: BigDecimal, type: TransactionType         | getDateTime()                   |                    |
|                |                                                                            | getAmount()                     |                    |
|                |                                                                            | getType()                       |                    |
|                |                                                                            | toSring()                       |                    |
| CurrentAccount | balance: BigDecimal, transactions: List<Transaction>                       | deposit( BigDecimal amount)     |                    |
|                |                                                                            | withdraw( BigDecimal amount)    |                    |
| SaningsAccount | balance: BigDecimal, transactions: List<Transaction>                       | deposit( BigDecimal amount)     |                    |
|                |                                                                            | withdraw( BigDecimal amount)    |                    |
| BankStatement  |                                                                            | printStatement(Account account) |                    |
