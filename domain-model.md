### Domain Model:

##### Customer:

- Attributes:
  - List\<BankAccount\> accounts
  - List\<BankStatement\> bankStatements
  - ID
  - Phone
  - Email
  - Name
- Actions:
  - Create account(accountType)
  - Deposit funds(accountNumber) throws exception("Can't deposit negative ammount")
  - Withdraw funds(accountNumber) throws exception("Can't withdraw negative ammount"), exception("Not enough funds")

##### (A) BankAccount:

- Attributes:
  - Account holder
  - Account number
  - List\<Transaction\>
- Actions:
  - Deposit funds
  - Withdraw funds

##### Current Account extends BankAccount

##### Savings Account extends BankAccount

##### Bank:

Attributes:

- List\<BankAccount\> accounts
- statements: List\<BankStatement\>

Actions:

- addAccount(BankAccount account)
- addStatement(BankStatement statement)
- generateAccountNumber()

##### BankStatement

Attributes:

- accountNumber: String
- transactions : ListTransactions

Actions:

- addTransaction(Transaction t): void
- addStatement(BankStatement statement)
- toString() : String

##### Transaction

Attributes:

- balanceAfter
- date
- transactionType
- amount

