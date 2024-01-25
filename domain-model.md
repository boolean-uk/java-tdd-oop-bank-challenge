# Domain model Bank challenge
```
As a customer,
So I can safely store and use my money,
I want to create a current account.
```
#### Create CurrentAccount and Customer classes
| CurrentAccount     |
|--------------------|
| accountId: String  |
| customer: Customer |
| balance: double    |

| Customer            |
|---------------------|
| customerId: String  |
| name: String        |
| phoneNumber: String |
| email: String       |

```
As a customer,
So I can save for a rainy day,
I want to create a savings account.
```

#### Create Account class and make Current- and SavingsAccount inherit from this
| Account            |
|--------------------|
| accountId: String  |
| customer: Customer |
| balance: double    |

| CurrentAccount |
|----------------|
| super(Account) |

| SavingsAccount |
|----------------|
| super(Account) |

```
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
```
#### Create Transaction class and add a Transaction list to Account. Then create getBankStatement() class in Account
| Transaction    |
|----------------|
| Date date      |
| double amount  |
| double balance |

| Account                         |
|---------------------------------|
| accountId: String               |
| customer: Customer              |
| balance: double                 |
| transactions: List<Transaction> |

| Class   | Method             | Variables                      | Scenario                                                                                    | Return                        |
|---------|--------------------|--------------------------------|---------------------------------------------------------------------------------------------|-------------------------------|
| Account | getBankStatement() | List<Transaction> transactions | The transaction history is blank                                                            | Return "No transactions"      |
|         |                    |                                | There are transactions in the list. The transactions are built into a nice organized String | Return String of transactions |
```
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```
| Class   | Method                  | Variables       | Scenario                                                                                                   | Return                                                                     |
|---------|-------------------------|-----------------|------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|
| Account | withdraw(double amount) | balance: double | The amount of money being withdrawn is larger than the balance                                             | Return "Withdraw failed. Amount withdrawn is more than balance in account" |
|         |                         |                 | The amount of money withdrawn is lower than balance, transaction successful and added to transactions list | Return "Withdraw successful. $(amount) has been withdrawn."                |
| Account | deposit(double amount)  | balance: double | The amount of money deposited to the account, transaction added to transactions list                       | Return "$(amount) deposited"                                               |
|         |                         |                 |                                                                                                            |                                                                            |
| Account | Both                    | balance: double | The amount is set to a negative number. Transaction fails                                                  | Return "The amount cannot be a negative number"                            |


## Class Diagram
![](assets/class-diagram.png)
```
Customer
	- customerId: String
	- name: String
	- phoneNumber: String
	- email: String
Account
	- accountId: String
	- customer: Customer
	- balance: double
	- transactions: List<Transaction>
	+ getBankStatement() String
	+ withdraw(amount: double) String
	+ deposit(amount: double) String
CurrentAccount
	- super(Account)
SavingsAccount
	- super(Account)
Transaction
	- date: Date
	- amount: double
	- balance: double
```