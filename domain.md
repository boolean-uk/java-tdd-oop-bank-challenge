## Bank
| Class | Fields                | Methods                                  | Scenarios         | Output                                |
|-------|-----------------------|------------------------------------------|-------------------|---------------------------------------|
| Bank  | String name           | approveOverDraft(CurrentAccount account) | approve overdraft | change overdraft status to 'approved' |
|       | List<Branch> branches | rejectOverdraft(CurrentAccount account)  | reject overdraft  | change overdraft status to 'rejected' |

## BankAccount
| Class       | Fields                              | Methods                                               | Scenarios                                | Output                       |
|-------------|-------------------------------------|-------------------------------------------------------|------------------------------------------|------------------------------|
| BankAccount | String accountNumber                | deposit(BigDecimal amount, String date, String type)  | user wants to deposit money              | adds transaction to history  |
|             | List<Transaction> transactionHistor | withdraw(BigDecimal amount, String date, String type) | user wants to withdraw money             | adds transaction to history  |
|             | Branch branch                       | BigDecimal getBalance()                               | user wants to know his balance           | BigDecimal balance           |
|             |                                     | String generateBankStatement()                        | user wants to see bank statement         | return String with statement |
|             |                                     | void sendSmsWithStatement()                           | user wants to get statement on his phone | send sms to his number       |

## Savings Account
| Class                              | Fields                   | Methods                                               | Scenarios                             | Output                          |
|------------------------------------|--------------------------|-------------------------------------------------------|---------------------------------------|---------------------------------|
| SavingsAccount extends BankAccount | BigDecimal interest rate | void applyInterest(String date)                       | bank applies interest rate to balance | balance + interest rate applied |
|                                    |                          | withdraw(BigDecimal amount, String date, String type) | balance after transaction <0          | print message                   |
|                                    |                          |                                                       | balance after transaction >=0         | invoke superclass withdraw()    |

## Current Account
| Class                              | Fields              | Methods                                               | Scenarios                          | Output                            |
|------------------------------------|---------------------|-------------------------------------------------------|------------------------------------|-----------------------------------|
| CurrentAccount extends BankAccount | Overdraft overdraft | requestOverdraft()                                    | user requests overdraft with limit | change overdraft limit and status |
|                                    |                     | withdraw(BigDecimal amount, String date, String type) | overdraft approved                 | invoke superclass withdraw        |
|                                    |                     |                                                       | overdraft not approved             | print message                     |
|                                    |                     |                                                       | overdraft limit reached            | print message                     |

## OverDraft
| Class     | Fields           | Methods | Scenarios | Output |
|-----------|------------------|---------|-----------|--------|
| Overdraft | String status    |         |           |        |
|           | BigDecimal limit |         |           |        |

## Branch
| Class  | Fields                     | Methods                                 | Scenarios                        | Output      |
|--------|----------------------------|-----------------------------------------|----------------------------------|-------------|
| Branch | String name                | void addAccount(BankAccount account)    | bank adds account to branch      | void        |
|        | String location            | void removeAccount(BankAccount account) | bank removes account to branch   | void        |
|        | List<BankAccount> accounts | int branchSize()                        | bank wants to know branch's size | branch size |
|        | Bank bank                  |                                         |                                  |             |

## SmsSender
| Class     | Fields | Methods              | Scenarios                       | Output    |
|-----------|--------|----------------------|---------------------------------|-----------|
| SmsSender |        | sendSms(String body) | banks wants to send sms to user | sends sms |

## Transaction
| Class       | Fields            | Methods | Scenarios | Output |
|-------------|-------------------|---------|-----------|--------|
| Transaction | String date       |         |           |        |
|             | String type       |         |           |        |
|             | BigDecimal amount |         |           |        |
