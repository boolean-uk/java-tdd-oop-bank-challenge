# Domain model for banking system

## Domain model OverdraftException class
| Extends            | Methods          |
|--------------------|------------------|
| `RuntimeException` |                  |
|                    | `void accept()`  |
|                    | `void decline()` |

## Domain model Branch enum
| Variants    |
|-------------|
| Oslo        |
| Karlskrona  |
| Southampton |
| Bournemouth |


## Domain model Account interface
| Methods                                         |
|-------------------------------------------------|
| `int balance()`                                 |
| `void deposit(int amount)`                      |
| `void deposit(int amount, LocalDateTime time)`  |
| `void withdraw(int amount)`                     |
| `void withdraw(int amount, LocalDateTime time)` |
| `String getHistory()`                           |

## Domain model TransactionType enum
| Variants     |
|--------------|
| `DEPOSIT`    |
| `WITHDRAWAL` |

## Domain model Transaction record
| Variables              | Methods             |
|------------------------|---------------------|
| `int amount`           |                     |
| `TransactionType type` |                     |
| `LocalDateTime time`   |                     | 
|                        | `String toString()` | 

## Domain model CurrentAccount class
| Implements | Variables     | Methods | Scenario | Output |
|------------|---------------|---------|----------|--------|
| `Account`  |               |         |          |        |
|            | `int balance` |         |          |        |

## Domain model SavingsAccount class
| Implements | Variables     | Methods | Scenario | Output |
|------------|---------------|---------|----------|--------|
| `Account`  |               |         |          |        |
|            | `int balance` |         |          |        |