### Class Person
| Member Variables | Methods                 | Return    | Output |
|------------------|-------------------------|-----------|--------|
| name: String     |                         |           |        |
| UID: int         |                         |           |        |
|                  | getName()               | this.name | void   |
|                  | setName()               | void      | void   |
|                  | getUID()                | this.ID   | void   |
|                  | setUID()                | void      | void   |
|                  | generateAccountNumber() | int       | void   |


### Class Manager EXTENDS Person
| Member Variables | Methods        | Return | Output |
|------------------|----------------|--------|--------|
|                  | setOverdraft() |        |        |
|                  |                |        |        |

### Class Customer EXTENDS Person
| Member Variables | Methods                 | Return  | Output  |
|------------------|-------------------------|---------|---------|
|                  | createCurrentAccount()  | boolean | Sys.out |
|                  | createSavingsAccount()  | boolean | Sys.out |
|                  | generateBankStatement() | void    | Sys.out |
|                  | deposit()               | boolean | void    |
|                  | withdraw()              | boolean | Sys.out |
|                  | requestOverdraft()      | boolean | Sys.out |



### Class Bank
| Member Variables | Methods       | Return  | Output |
|------------------|---------------|---------|--------|
|                  | getName()     | String  | void   |
|                  | setName()     | void    | void   |
|                  | getLocation() | String  | void   |
|                  | setLocation() | void    | void   |
|                  | getBranchID() | int     | void   |
|                  | setBranchID() | void    | void   |
|                  | getManager()  | Manager | void   |
|                  | setManager()  | void    | void   |

### Class Branch IMPLEMENTS Bank
| Member Variables | Methods | Return | Output |
|------------------|---------|--------|--------|
| name: String     |         |        |        |
| location: String |         |        |        |
| branchID: int    |         |        |        |
| manager: Manager |         |        |        |
|                  |         |        |        |




### Class Account
| Member Variables                      | Methods                 | Return    | Output |
|---------------------------------------|-------------------------|-----------|--------|
| branch: Branch                        |                         |           |        |
| accountNumber: int                    |                         |           |        |
| accountOwner: Person                  |                         |           |        |
| balance: double                       |                         |           |        |
| transactionHistory: List<Transaction> |                         |           |        |
|                                       | getBranch()             | int       | void   |
|                                       | setBranch()             | void      | void   |
|                                       | getAccountNumber()      | int       | void   |
|                                       | setAccountNumber()      | void      | void   |
|                                       | getAccountOwner()       | Person    | void   |
|                                       | setAccountOwner()       | void      | void   |
|                                       | getBalance()            | double    | void   |
|                                       | setBalance()            | void      | void   |
|                                       | getTransactionHistory() | ArrayList | void   |
|                                       | setTransactionHistory() | void      | void   |

### SavingsAccount EXTENDS Account
| Member Variables | Methods | Return | Output |
|------------------|---------|--------|--------|
|                  |         |        |        |
|                  |         |        |        |

### CurrentAccount EXTENDS Account
| Member Variables       | Methods                | Return | Output |
|------------------------|------------------------|--------|--------|
| allowed_overdraft: int |                        |        |        |
|                        | setAllowed_overdraft() |        |        |




### Transaction
| Member Variables | Methods      | Return   | Output |
|------------------|--------------|----------|--------|
| date: String     |              |          |        |
| credit: double   |              |          |        |
| debit: double    |              |          |        |
| balance: double  |              |          |        |
|                  | getDate()    | DateTime | void   |
|                  | setDate()    | void     | void   |
|                  | getCredit()  | double   | void   |
|                  | setCredit()  | void     | void   |
|                  | getDebit()   | double   | void   |
|                  | setDebit()   | void     | void   |
|                  | getBalance() | double   | void   |
|                  | setBalance() | void     | void   |

