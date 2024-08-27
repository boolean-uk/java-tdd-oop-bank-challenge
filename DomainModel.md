# Bank
Object that manages a list of all customers, managers and bank accounts
## Variables

| Variable            | Use                                                    |
|---------------------|--------------------------------------------------------|
| `customers`         | Holds the list of all `Customer` objects.              |
| `managers`          | Holds the list of all `Manager` objects.               |
| `bankAccounts`      | Holds the list of all `BankAccount` objects.           |
| `overdraftRequests` | Holds the list of all `OverdraftRequest` objects.      |
| `branch`            | Represents the associated `Branch` object.             |

## Methods

| Method                                    | Use                                                                                                                     |
|-------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
| `getOverdraftRequest(int index)`          | Removes and returns the `OverdraftRequest` at the specified index.                                                      |
| `createOverdraftRequest(BankAccount ba)`  | Creates a new `OverdraftRequest` for the specified `BankAccount` and adds it to the list.                               |
| `addCustomer(Customer c)`                 | Adds a new `Customer` to the list of customers.                                                                         |
| `addManager(Manager m)`                   | Adds a new `Manager` to the list of managers.                                                                           |
| `addBankAccount(BankAccount bankAccount)` | Adds a new `BankAccount` to the list of bank accounts.                                                                  |
| `createCustomer(String name)`             | Creates a new `Customer` with the given name and adds it to the list of customers, returning the new `Customer` object. |


# BankAccount
An abstract class that manages transactions. Parent of debit- and savingsaccounts.
## Variables

| Variable       | Use                                                                      |
|----------------|--------------------------------------------------------------------------|
| `customer`     | Represents the `Customer` associated with the bank account.              |
| `canOverdraft` | Indicates whether the account is allowed to overdraft.                   |
| `transactions` | Holds the list of all `Transaction` objects associated with the account. |

## Methods

| Method                                     | Use                                                                                          |
|--------------------------------------------|----------------------------------------------------------------------------------------------|
| `generateStatement()`                      | Generates and returns a formatted bank statement string with transaction details.            |
| `deposit(double amount)`                   | Adds a new deposit transaction with the specified amount and returns a confirmation message. |
| `getBalance()`                             | Calculates and returns the current balance by summing all transactions.                      |
| `withdraw(double amount)`                  | Placeholder method for withdrawing an amount; currently not implemented.                     |
| `requestOverdraft()`                       | Requests an overdraft for the account by notifying the `Customer` object.                    |
| `formatDoubleToTwoDigits(double amount)`   | Formats a double value to two decimal places for consistency in financial calculations.      |


# BankAccountDebit
Instance of a BankAccount. Can withdraw and make overdraftrequests.

## Methods

| Method                                 | Use                                                                                                                         |
|----------------------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| `withdraw(double amount)`              | Withdraws the specified amount if conditions are met (overdraft or sufficient balance), otherwise returns an error message. |

# BankAccountSavings
Instance of a BankAccount. Can not withdraw and make overdraftrequests.
## Methods

| Method                      | Use                                                                  |
|-----------------------------|----------------------------------------------------------------------|
| `withdraw(double amount)`   | Can not withdraw from savings. Returns a String with request denied. |
| `requestOverdraft()`        | Returns false. Can not overdraft as a `BankAccountSavings`.          |

# BankType
Used when you want to specify which type of bankaccount to create.
## Enum: BankType

| Value     | Description                             |
|-----------|-----------------------------------------|
| `Savings` | Represents a savings bank account type. |
| `Debit`   | Represents a debit bank account type.   |



# Branch
Used to differentiate different branches. Banks and Managers both have a branch. Serves no futher functionality.
## Enum: Branch

| Value       | Description                      |
|-------------|----------------------------------|
| `Oslo`      | Represents the Oslo branch.      |
| `Stockholm` | Represents the Stockholm branch. |
| `London`    | Represents the London branch.    |


# Customer
Customer has a list of bankaccounts. Also has a name string which could later become a unique id.
## Variables

| Variable    | Use                                                                       |
|-------------|---------------------------------------------------------------------------|
| `accounts`  | Holds the list of all `BankAccount` objects associated with the customer. |
| `bank`      | Represents the `Bank` object that the customer is associated with.        |
| `name`      | Stores the name of the customer.                                          |

## Methods

| Method                             | Use                                                                                                                                             |
|------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| `createAccount(BankType banktype)` | Creates a new `BankAccount` (either `BankAccountDebit` or `BankAccountSavings`) based on the `BankType` and adds it to the customer's accounts. |
| `requestOverdraft(BankAccount ba)` | Requests an overdraft for the specified `BankAccount` by using the bank's overdraft request system.                                             |
| `getAccount(int index)`            | Retrieves the `BankAccount` at the specified index from the customer's list of accounts.                                                        |
| `generateStatements()`             | Generates and returns a formatted string of statements for all the customer's accounts.                                                         |


# Manager
Main role is to manage overdraftrequests.
## Variables

| Variable | Use                                                               |
|----------|-------------------------------------------------------------------|
| `branch` | Represents the `Branch` associated with the manager.              |
| `bank`   | Represents the `Bank` object that the manager is associated with. |


## Methods

| Method                                                           | Use                                                                                                               |
|------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| `concludeOverdraftRequestByIndex(boolean isAccepted, int index)` | Handles the conclusion of an overdraft request by its index: accepts or denies it based on the `isAccepted` flag. |


# OverdraftRequest
Sent by customers who want to make overdrafts on their debit accounts

## Variables

| Variable        | Use                                                                        |
|-----------------|----------------------------------------------------------------------------|
| `bankAccount`   | Represents the `BankAccount` object associated with the overdraft request. |


## Methods

| Method          | Use                                                                                               |
|-----------------|---------------------------------------------------------------------------------------------------|
| `accept()`      | Grants overdraft permission to the associated `BankAccount` by setting `canOverdraft` to `true`.  |
| `deny()`        | Denies overdraft permission to the associated `BankAccount` by setting `canOverdraft` to `false`. |


# StringUtils
Used to format transactions and output.
## Methods

| Method                                            | Use                                                                    |
|---------------------------------------------------|------------------------------------------------------------------------|
| `leftAlignStringWithPadding(String s, int pad)`   | Aligns the string `s` to the left with a padding of `pad` spaces.      |
| `rightAlignStringWithPadding(String s, int pad)`  | Aligns the string `s` to the right with a padding of `pad` spaces.     |
| `centerAlignStringWithPadding(String s, int pad)` | Centers the string `s` with padding of `pad` spaces on both sides.     |



# Transaction
Hold information about transactions done by user to a bankaccount.
## Variables

| Variable | Use                                               |
|----------|---------------------------------------------------|
| `amount` | Represents the amount of the transaction.         |
| `date`   | Represents the date and time of the transaction . |


## Methods

| Method        | Use                                    |
|---------------|----------------------------------------|
| `getAmount()` | Returns the amount of the transaction. |



