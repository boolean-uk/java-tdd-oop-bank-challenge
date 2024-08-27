# Domain model for banking system

## Domain model OverdraftException class
| Extends            | Methods          | Scenario                                                  | Output                      |
|--------------------|------------------|-----------------------------------------------------------|-----------------------------|
| `RuntimeException` |                  |                                                           |                             |
|                    | `void accept()`  | Bank manager wants to accept the given overdraft request  | Users balance goes negative |
|                    | `void decline()` | Bank manager wants to decline the given overdraft request |                             | 

## Domain model CantOverdraftException class
| Extends            |
|--------------------|
| `RuntimeException` |

## Domain model Branch enum
| Variants    |
|-------------|
| Oslo        |
| Karlskrona  |
| Southampton |
| Bournemouth |

## Domain model abstract Account class
| Methods                                                                   | Scenario                                                  | Output                                             |
|---------------------------------------------------------------------------|-----------------------------------------------------------|----------------------------------------------------|
| `int balance()`                                                           | User wants to know the balance in their account           |                                                    |
|                                                                           |                                                           |                                                    |
| `void deposit(int amount)`                                                | User wants to deposit some money into their account       |                                                    |
| `void deposit(int amount, LocalDateTime time)`                            | User wants to deposit some money into their account       |                                                    |
|                                                                           |                                                           |                                                    |
| `void withdraw(int amount) throws OverdraftException`                     | User wants to withdraw some money from their account      |                                                    |
| `void withdraw(int amount, LocalDateTime time) throws OverdraftException` | User wants to withdraw some money from their account      |                                                    |
|                                                                           |                                                           |                                                    |
| `void forceWithdraw(int amount)`                                          | Manager wants to force a withdrawal to allow an overdraft |                                                    |
| `void forceWithdraw(int amount, LocalDateTime time)`                      | Manager wants to force a withdrawal to allow an overdraft |                                                    |
|                                                                           |                                                           |                                                    |
| `String getHistory()`                                                     | User wants to get a bank statement                        | Nicely formatted history of all their transactions |

## Domain model TransactionType enum
| Variants     |
|--------------|
| `DEPOSIT`    |
| `WITHDRAWAL` |

## Domain model Transaction record
| Variables              | Methods                                   | Scenario                                                         | Output                                         |
|------------------------|-------------------------------------------|------------------------------------------------------------------|------------------------------------------------|
| `int amount`           |                                           |                                                                  |                                                |
| `TransactionType type` |                                           |                                                                  |                                                |
| `LocalDateTime time`   |                                           |                                                                  |                                                | 
|                        | `String toStringWithBalance(int balance)` | User wants to get a nicely formatted statement for a transaction | A nicely formatted statement for a transaction | 

## Domain model CurrentAccount class
| Extends   |
|-----------|
| `Account` |

## Domain model SavingsAccount class
| Extends   | Overrides                                                                     | Scenario                      | Output    |
|-----------|-------------------------------------------------------------------------------|-------------------------------|-----------|
| `Account` |                                                                               |                               |           |
|           | `void withdraw(int amount) throws CantOverdraftException`                     | User withdraws a valid amount |           |
|           |                                                                               | User tries to overdraft       | Exception |
|           | `void withdraw(int amount, LocalDateTime time) throws CantOverdraftException` | User withdraws a valid amount |           |
|           |                                                                               | User tries to overdraft       | Exception |

## Domain model MessageController class
| Variables                    | Methods                                                   | Scenario                                                 | Output                                   |
|------------------------------|-----------------------------------------------------------|----------------------------------------------------------|------------------------------------------|
| `String TWILIO_ACCOUNT_SID`  |                                                           |                                                          |                                          |
| `String TWILIO_AUTH_TOKEN`   |                                                           |                                                          |                                          |
| `String TWILIO_PHONE_NUMBER` |                                                           |                                                          |                                          |
|                              | `void notifyUser(String messageContent, String toNumber)` | User wants to get a text message of their bank statement | A text message with their bank statement |
