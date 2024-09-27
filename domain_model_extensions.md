| Classes | Members                               | Methods                                 | Scenario                                                                    | Outputs |
|---------|---------------------------------------|-----------------------------------------|-----------------------------------------------------------------------------|---------|
| Account | List<Transaction> transactionsHistory | deposit(double amount, LocalDate date)  | If user want to deposit valid amount, save transaction with positive amount | String  |
|         |                                       |                                         | If user want to deposit invalid amount (e.g. negative), show message        | String  |
|         |                                       | withdraw(double amount, LocalDate date) | If user want to withdraw more money than he/she got, show message           | String  |
|         |                                       |                                         | If user want to withdraw valid amount,save transaction with negative amount | String  |
|         |                                       |                                         | If user want to withdraw invalid amount (e.g. negative), show message       | String  |
|         |                                       | generateBankStatement()                 | If user want to print his/her bank statement                                | String  |
|         |                                       | countTheBalance()                       | If user want to check his/her balance                                       | float   |

| Classes        | Members                   | Methods                                 | Scenario                                                                                   | Outputs |
|----------------|---------------------------|-----------------------------------------|--------------------------------------------------------------------------------------------|---------|
| CurrentAccount | boolean approvedOverdraft | setOverdraft(boolean choice)            | If user want to approve an overdraft request                                               | -       |
|                |                           |                                         | If user want to reject an overdraft request                                                | -       |
|                |                           | withdraw(double amount, LocalDate date) | If user want to withdraw more money than he/she got, save transaction with negative amount | String  |

| Classes        | Members | Methods | Scenario | Outputs |
|----------------|---------|---------|----------|---------|
| SavingsAccount |         |         |          |         |
|                |         |         |          |         |

| Classes       | Members       | Methods | Scenario | Outputs |
|---------------|---------------|---------|----------|---------|
| BranchAccount | String branch |         |          |         |
|               |               |         |          |         |

| Classes        | Members                            | Methods                            | Scenario                                                                  | Outputs |
|----------------|------------------------------------|------------------------------------|---------------------------------------------------------------------------|---------|
| CompanyAccount | List<BranchAccount> branchAccounts | createBranchAccount(String branch) | If company want to create an account for a new branch                     | String  |
|                |                                    |                                    | If company want to create an account for an existing branch, show message | String  |
|                |                                    | getBalanceFromAllBranches()        | If company want to check balance in all branches                          | float   |

| Classes     | Members        | Methods | Scenario | Outputs |
|-------------|----------------|---------|----------|---------|
| Transaction | LocalDate date |         |          |         |
|             | double amount  |         |          |         |
