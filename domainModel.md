# Domain model
As a customer,
So I can safely store and use my money,
I want to create a current account.

As a customer,
So I can save for a rainy day,
I want to create a savings account.

As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

As a customer,
So I can use my account,
I want to deposit and withdraw funds.

# Extension Domain
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.


| Classes     | Variables                                             | Methods                         |
|-------------|-------------------------------------------------------|---------------------------------|
| User        | String: id                                            |                                 |
|             | String: name                                          |                                 |
| Account     | String: accountType                                   | deposit(): double               |
|             | String: accountNumber                                 | withdraw(): String              |
| Transaction | String: date                                          |                                 |
|             | double: credit                                        | getDebit(): double              |
|             | double: debit                                         | getCredit(): double             |
|             | LocalDateTime: dateTime                               | getBalance(): double            |
| Bank        | List<Account>                                         | createAccount(): boolean        |
|             | List<Transaction>                                     | addTransaction():               |
|             | List<Branch>                                          | generateBankStatement(): String |
| Branch      | enum: Gothenburg, Stockholm, Oslo, Copenhagen, Berlin |                                 |
|             |                                                       |                                 |


