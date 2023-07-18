| Classes | Members                               | Methods                                 | Scenario                                                                    | Outputs |
|---------|---------------------------------------|-----------------------------------------|-----------------------------------------------------------------------------|---------|
| Account | double balance                        | deposit(double amount, LocalDate date)  | If user want to deposit valid amount, save transaction with positive amount | String  |
|         |                                       |                                         | If user want to deposit invalid amount (e.g. negative), show message        | String  |
|         | List<Transaction> transactionsHistory | withdraw(double amount, LocalDate date) | If user want to withdraw more money than he/she got, show message           | String  |
|         |                                       |                                         | If user want to withdraw valid amount,save transaction with negative amount | String  |
|         |                                       |                                         | If user want to withdraw invalid amount (e.g. negative), show message       | String  |
|         |                                       | generateBankStatement()                 | If user want to print him/her bank statement                                | String  |

| Classes        | Members | Methods | Scenario | Outputs |
|----------------|---------|---------|----------|---------|
| CurrentAccount |         |         |          |         |
|                |         |         |          |         |

| Classes        | Members | Methods | Scenario | Outputs |
|----------------|---------|---------|----------|---------|
| SavingsAccount |         |         |          |         |
|                |         |         |          |         |

| Classes     | Members        | Methods | Scenario | Outputs |
|-------------|----------------|---------|----------|---------|
| Transaction | LocalDate date |         |          |         |
|             | double amount  |         |          |         |
