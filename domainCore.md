| CLass          | Attributes                                                       | Methods                 | Scenario                                                           | result     |     
|----------------|------------------------------------------------------------------|-------------------------|--------------------------------------------------------------------|------------|
| BankAccount    |                                                                  | deposit(double amount)  |                                                                    |            |     
|                |                                                                  | withdraw(double amount) |                                                                    |            |     
|                |                                                                  | generateBankStatement() |                                                                    |            |     
| CurrentAccount |                                                                  | deposit(double amount)  | amount > 0                                                         | true       |     
|                |                                                                  |                         | amount <= 0                                                        | false      |     
|                |                                                                  | withdraw(double amount) | amount > 0 && balance - amount >=0 && canBeOverDrafted == false    | true       |     
|                |                                                                  |                         | amount > 0 && balance - amount < 0 && canBeOverDrafted == false    | false      |
|                |                                                                  |                         | amount < 0                                                         | false      |     
|                |                                                                  |                         | amount > 0 && balance - amount >= -500 && canBeOverDrafted == true | true       |
|                |                                                                  |                         | amount > 0 && balance - amount < -500 && canBeOverDrafted == true  | false      |
|                |                                                                  | overdraftRequest()      | true/false                                                         | false/true |
|                |                                                                  | generateBankStatement() |                                                                    |            |
| Transaction    | Date date, String TypeOfOperation, double amount, double balance |                         |                                                                    |            |     
| Bank           |                                                                  |                         |                                                                    |            |     
| SavingAccount  |                                                                  | deposit(double amount)  | amount > 0                                                         | true       |     
|                |                                                                  |                         | amount < 0                                                         | false      |
|                |                                                                  | withdraw(double amount) | amount <= 0                                                        | false      |
|                |                                                                  |                         | amount > 0 && (getBalance() - amount) >= 0                         | true       |
|                |                                                                  |                         | (getBalance() - amount) < 0                                        | false      |
|                |                                                                  | generateBankStatement() |                                                                    |            |
