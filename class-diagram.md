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
        - branchID : String
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
    class Branch{
        - name : String
        - location : String
        - accountIDs : ArrayList< String >
        + addAccount(String accountID) : boolean
        + getAccounts() : ArrayList< String >
    }
    
    Account <|-- CurrentAccount
    Account <|-- SavingsAccount
    Account "1"--"0..*" Transaction 
    User "1" -- "0..*" Account
    Branch "1" -- "0..*" Account
````