````mermaid
classDiagram
    class User{
        - userName : String
        - birthdate : LocalDate
        - userID : String
        - accounts : ArrayList< Account >
        + createUser(String name, LocalDate birthdate) : boolean
    }
    class Account{
        - accountName : String
        - accountID : String
        - transactions : ArrayList< Transaction >
        + createAccount(String name) : boolean
        + deposit(int amount) : boolean
        + deposit(double amount) : boolean
        + withdraw(int amount) : boolean
        + withdraw(double amount) : boolean
        + getBalance() : Integer
    }
    class CurrentAccount{
        
    }
    class SavingsAccount{
        
    }
    class Transaction{
        - date : LocalDate
        - amount : int
        - isDeposit : boolean
        + getDate() : LocalDate
        + getAmount() : int
        + getAmountAsDouble() : double
        + getType() : boolean
    }
    
    Account <|-- CurrentAccount
    Account <|-- SavingsAccount
    Account "1"--"0..*" Transaction 
    User "1" -- "0..*" Account
````