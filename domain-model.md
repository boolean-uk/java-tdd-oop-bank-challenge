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

| Name | Parameter | Return | Description |
|------|-----------|--------|-------------|







