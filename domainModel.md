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

| Classes     | Variables               | Method                          |
|-------------|-------------------------|---------------------------------|
| User        | String: id              |                                 |
|             | String: name            |                                 |
| Account     | String: accountType     | deposit(): double               |
|             | String: accountNumber   | withdraw(): String              |
| Transaction | String: date            |                                 |
|             | double: credit          | getDebit(): double              |
|             | double: debit           | getCredit(): double             |
|             | LocalDateTime: dateTime | getBalance(): double            |
| Bank        | ArrayList<Account>      | createAccount(): boolean        |
|             |                         | addTransaction():               |
|             |                         | generateBankStatement(): String |
