| Classes    | Methods                                  | Scenario                               | Outputs                                           |
|------------|------------------------------------------|----------------------------------------|---------------------------------------------------|
| `Account`  | `addDeposit(BigDecimal addBalance)`      | Adds `addBalance` to balance           | Balance updated : `balance`                       |
|            | `addDeposit(BigDecimal addBalance)`      | If `addBalance` is negative            | Throw Exception `You cannot add negative balance` |
|            | `withdraw(BigDecimal removeFromBalance)` | Subtract balance - `removeFromBalance` | Balance updated : `balance`                       |
|            | `withdraw(BigDecimal removeFromBalance)` | If `balance - removeFromBalance` < 0   | Throw Exception `You cannot overdraft`            |                                                   |
| `Customer` | `createSavingsAccount()`                 | Create SavingsAccount                  | Savings account created                           |
|            | `createSavingsAccount()`                 | If savingsAccount exist                | Throw Exception `You have savingsAccount`         |
|            | `createCurrentAccount()`                 | Create CurrentAccount                  | Current account created                           |
|            | `createCurrentAccount()`                 | If currentAccount exist                | Throw Exception `You have savingsAccount`         | 


~~~
    public class Account {
        private BigDecimal balance;
        private ArrayList<AccountOperation> accountOperations;
    
        public Account(){
            this.balance = BigDecimal.ZERO;
            this.accountOperations = new ArrayList<>();
        }
    
        public void addDeposit(BigDecimal addBalance){
            //TODO
        }
    
        public void withdraw(BigDecimal removeFromBalance){
            //TODO
        }
    
        public void getBankStatements(){
            //TODO
        }
    }
~~~
    public class Customer {
        private SavingsAccount savingsAccount;
        private CurrentAccount currentAccount;
    
        public Customer() {
        }
    
        public void createSavingsAccount(){
            //TODO
        }
    
        public void createCurrentAccount(){
            //TODO
        }
    }
~~~
~~~
    public class CurrentAccount extends Account{
    
    }
~~~
~~~
    public class SavingsAccount extends Account{
    
    }
~~~
~~~
    public record AccountOperation(LocalDate dateOfOperation, BigDecimal balance, String typeOfOperation, BigDecimal money) {
        @Override
        public String toString() {
            //TODO
            return null;
        }
    }
~~~