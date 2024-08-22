````mermaid
classDiagram
    class User{
        - userName : String
        - birthdate : LocalDate
        - userID : String
        - accounts : ArrayList< Account >
        + createUser(String, LocalDate) : boolean
        + requestOverdraft(String, int) : boolean
    }
    class Account{
        - accountName : String
        - accountID : String
        - branch : Branch
        - transactions : ArrayList< Transaction >
        + createAccount(String) : boolean
        + deposit(int) : boolean
        + deposit(double) : boolean
        + withdraw(int) : boolean
        + withdraw(double) : boolean
        + getBalance() : int
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
        - funds : int
        + addAccount(String accountID) : boolean
        + getAccounts() : ArrayList< String >
        + getName() : String
        + processOverdraftRequest(int) : boolean
    }
    class Bank{
        - branches : ArrayList< Branch >
        - funds : int
        + getBranch(String) : Branch
        + getFunds() : int
        + setFunds(int) : void
    }
    
    Account <|-- CurrentAccount
    Account <|-- SavingsAccount
    Account "1"--"0..*" Transaction 
    User "1" -- "0..*" Account
    Branch "1" -- "0..*" Account
    Account ..|> Branch
    Bank "1" .. "1..*" Branch
````