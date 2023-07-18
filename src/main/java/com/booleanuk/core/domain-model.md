| Classes    | Methods                                  | Scenario                               | Outputs                                                     |
|------------|------------------------------------------|----------------------------------------|-------------------------------------------------------------|
| `Account`  | `addDeposit(BigDecimal addBalance)`      | Adds `addBalance` to balance           | Balance updated : `balance`                                 |
|            | `addDeposit(BigDecimal addBalance)`      | If `addBalance` is negative            | Throw Exception `You cannot add negative balance`           |
|            | `withdraw(BigDecimal removeFromBalance)` | Subtract balance - `removeFromBalance` | Balance updated : `balance`                                 |
|            | `withdraw(BigDecimal removeFromBalance)` | If `balance - removeFromBalance` < 0   | Throw Exception `You cannot overdraft`                      |                                                   |
| `Customer` | `createSavingsAccount()`                 | Create SavingsAccount                  | Savings account created                                     |
|            | `createSavingsAccount()`                 | If savingsAccount exist                | Throw Exception `Savings account has already been created.` |
|            | `createCurrentAccount()`                 | Create CurrentAccount                  | Current account created                                     |
|            | `createCurrentAccount()`                 | If currentAccount exist                | Throw Exception `Current account has already been created.` |
|            | `addBalanceToSavingsAccount`             | If savings Account Exist add balance   |                                                             | 
|            | `addBalanceToSavingsAccount`             | If savings Account Does Not Exist      | Savings account does not exist                              | 
|            | `addBalanceToCurrentAccount`             | If current Account Exist add balance   |                                                             | 
|            | `addBalanceToCurrentAccount`             | If current Account Does Not Exist      | Current account does not exist                              |
|            | `withDrawFromSavingsAccount`             | If savings Account Exist withdraw      |                                                             | 
|            | `withDrawFromSavingsAccount`             | If savings Account Does Not Exist      | Savings account does not exist                              | 
|            | `withDrawFromCurrentAccount`             | If current Account Exist withdraw      |                                                             | 
|            | `withDrawFromCurrentAccount`             | If current Account Does Not Exist      | Current account does not exist                              |




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