# Domain model for banking system

## Domain model OverdraftException class
| Extends            | Methods          | Scenario                                                  | Output                      |
|--------------------|------------------|-----------------------------------------------------------|-----------------------------|
| `RuntimeException` |                  |                                                           |                             |
|                    | `void accept()`  | Bank manager wants to accept the given overdraft request  | Users balance goes negative |
|                    | `void decline()` | Bank manager wants to decline the given overdraft request |                             | 

## Domain model Branch enum
| Variants    |
|-------------|
| Oslo        |
| Karlskrona  |
| Southampton |
| Bournemouth |

## Domain model Account interface
| Methods                                                                   |
|---------------------------------------------------------------------------|
| `int balance()`                                                           |
|                                                                           |
| `void deposit(int amount)`                                                |
| `void deposit(int amount, LocalDateTime time)`                            |
|                                                                           |
| `void withdraw(int amount) throws OverdraftException`                     |
| `void withdraw(int amount, LocalDateTime time) throws OverdraftException` |
|                                                                           |
| `void forceWithdraw(int amount)`                                          |
| `void forceWithdraw(int amount, LocalDateTime time)`                      |
|                                                                           |
| `String getHistory()`                                                     |

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
| Implements |
|------------|
| `Account`  |

## Domain model SavingsAccount class
- This class is just a copy of `CurrentAccount` with no difference in behavior.

| Extends          |
|------------------|
| `CurrentAccount` |

## Domain model MessageController class
| Variables                    | Methods                                                   | Scenario                                                 | Output                                   |
|------------------------------|-----------------------------------------------------------|----------------------------------------------------------|------------------------------------------|
| `String TWILIO_ACCOUNT_SID`  |                                                           |                                                          |                                          |
| `String TWILIO_AUTH_TOKEN`   |                                                           |                                                          |                                          |
| `String TWILIO_PHONE_NUMBER` |                                                           |                                                          |                                          |
|                              | `void notifyUser(String messageContent, String toNumber)` | User wants to get a text message of their bank statement | A text message with their bank statement |