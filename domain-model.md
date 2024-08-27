# Domain Model - Core Requirements

------------------------------------

## User Stories

------------------------------------

```
1.
As a customer,
So I can safely store and use my money,
I want to create a current account.

2.
As a customer,
So I can save for a rainy day,
I want to create a savings account.

3.
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

4.
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```

## Class Structure

-----------------------------------

| Class         | Description                                    | Relation                |
|---------------|------------------------------------------------|-------------------------|
| `Account`     | Abstract class representing a general account. | Aggregates transaction. |
| `Current`     | Specific class for current account.            |                         |
| `Saving`      | Specific class for savings account.            |                         |
| `Transaction` | Represents one transaction in a  account.      | Is used in account.     |


### Members (Fields)

-----------------------------------

These are the members in the `Account` class.

| Member           | Type                     | Description                                  |
|------------------|--------------------------|----------------------------------------------|
| `fullName`       | `String`                 | The name of the account holder.              |
| `accountNumber`  | `String`                 | Unique number that identifies the account.   |
| `balance`        | `Double`                 | Account balance.                             |
| `transaction`    | `ArrayList<Transaction>` | List of all the transactions on the account. |

And these are the members in the `Transaction` class.

| Member    | Type        | Description                             |
|-----------|-------------|-----------------------------------------|
| `date`    | `LocalDate` | The date when the transaction was made. |
| `amount`  | `Double`    | The amount in the transaction.          |
| `balance` | `Double`    | Balance after transaction.              |

### Methods

---------------------------------------------

These are the methods in the `Account` class.

| Name             | Parameter       | Return | Description                                           |
|------------------|-----------------|--------|-------------------------------------------------------|
| `deposit`        | `double amount` | `void` | Adds amount to balance and register transaction.      |
| `withdraw`       | `double amount` | `void` | Deducts amount from balance and register transaction. |
| `printStatement` |                 | `void` | Prints bank statement based on transactions.          |

And these are the methods in the `Transaction` class.

| Name       | Parameter | Return   | Description                             |
|------------|-----------|----------|-----------------------------------------|
| `toString` |           | `String` | Outputs a transaction in a nice format. |

# Extensions

---------------------------------------------

## User Stories

---------------------------------------------

```
1.
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

2.
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

3.
As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.
```

## Changes made to the existing code

--------------------------------------

To complete the first user story, I have updated the `getBalance()` getter in the abstract `Account` class
to calculate the balance by using the *transactions* arraylist instead of the local *balance* member.

| Method       | Parameter | Return   | Description                                     |
|--------------|-----------|----------|-------------------------------------------------|
| `getBalance` |           | `Double` | Iterate over transactions and sums the amounts. |

## New Classes

--------------------------------------

These are the new classes that has been implemented to complete user story 2 and 3:

| Class              | Description                                     | Relation                     |
|--------------------|-------------------------------------------------|------------------------------|
| `OverdraftRequest` | Object representing a single overdraft request. | Used in the Account class.   |
| `Bankmanager`      | Used to approve/reject pending requests.        | Aggregates OverdraftRequest. |

### Members (Fields)

--------------------------------------

Here is an overview of the members in the OverdraftRequest class:

| Member          | Type      | Description                                        |
|-----------------|-----------|----------------------------------------------------|
| `account`       | `Account` | The account associated with the overdraft request. |
| `requestLimit`  | `Double`  | The requested overdraft amount.                    |
| `isApproved`    | `Boolean` | To keep track of approved/rejected requests.       |

And these are the members in BankManager:

| Member            | Type        | Description                             |
|-------------------|-------------|-----------------------------------------|
| `pendingRequests` | `ArrayList` | The date when the transaction was made. |
| `MIN`             | `Double`    | Constant for min request limit.         |
| `MAX`             | `Double`    | Constant for max request limit.         |

### Methods

------------------------------------

This is the methods in the OverdraftRequest class:

| Name         | Parameter | Return    | Description                            |
|--------------|-----------|-----------|----------------------------------------|
| `approve`    |           | `void`    | Sets the value of isApproved to true.  |
| `reject`     |           | `void`    | Sets the value of isApproved to false. |
| `isApproved` |           | `Boolean` | Returns the isApproved value.          |





















