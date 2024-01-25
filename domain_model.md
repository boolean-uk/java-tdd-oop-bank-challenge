## class Account

| Members                                | Methods                          | Scenario                                                                                                | Output                 |
|----------------------------------------|----------------------------------|---------------------------------------------------------------------------------------------------------|------------------------|
| `ArrayList<Transaction> transactions`  | `deposit(double amount)`         | Adds a transaction with a deposit request. Returns a `Status` type, depending on what action was taken. | Status                 |
| `final int monthlyMaxTransactionCount` | `withdraw(double amount)`        | Adds a transaction with a withdraw request. Returns a `Status` type.                                    | Status                 |
| `final double maxBalance`              | `getBankStatement()`             | Returns the bank statement for this account. Basically returns a new copy of the `transactions` member. | TransactionStatement[] |
| `int currentWithdrawalCount`           | `hasExceededMonthlyWithdrawal()` | Returns either true or false depending on if the account has exceeded the monthly withdrawal count.     | boolean                |
|                                        | `getBalance()`                   | Returns the current balance of the account.                                                             | double                 |

## class Transaction

| Members                | Methods       | Scenario                                        | Output          |
|------------------------|---------------|-------------------------------------------------|-----------------|
| `double credit`        | `getCredit()` | Returns this transaction's credit.              | double          |
| `String date`          | `getDate()`   | Returns this transaction's creation date.       | String          |
| `TransactionType type` | `getType()`   | Returns this transaction's type of transaction. | TransactionType |

## record TransactionStatement

| Members                |
|------------------------|
| `double credit`        |
| `double balance`       |
| `String date`          |
| `TransactionType type` |


## enum TransactionType

| Type       |
|------------|
| `DEPOSIT`  |
| `WITHDRAW` |

## enum Status

| Types                        |
|------------------------------|
| `OK`                         |
| `ERROR`                      |
| `EMPTY`                      |
| `UNAUTHORIZED`               |
| `EXCEEDED_BALANCE`           |
| `EXCEEDED_WITHDRAWAL_AMOUNT` |
| `INVALID_NUMBER`             |
| `BALANCE_TOO_SMALL`          |