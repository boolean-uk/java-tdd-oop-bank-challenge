public class Account {
BigDecimal amount;

    public Account(BigDecimal amount) {
        this.amount = amount;
    }

    void deposit(BigDecimal deposit){
    
    }
    void withdraw(BigDecimal withdraw){
       
    }

}
public class CurrentAccount extends Account{

    public CurrentAccount(BigDecimal amount) {
        super(amount);
    }
}
public class SavingAccount extends Account{
    
    public SavingAccount(BigDecimal amount) {
        super(amount);
    }
}
public class Bank {
CurrentAccount currentAccount;
SavingAccount savingAccount;
List<Transaction> transactions;

    public Bank() {
        this.currentAccount = new CurrentAccount(BigDecimal.valueOf(0));
        this.savingAccount = new SavingAccount(BigDecimal.valueOf(0));
        transactions = new ArrayList<>();
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
            this.savingAccount.deposit(bigDecimal);
        } else {
            this.savingAccount.withdraw(bigDecimal.abs());
        }
    }

    public void setCurrentAccount(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
            this.currentAccount.deposit(bigDecimal);
        } else {
            this.currentAccount.withdraw(bigDecimal.abs());
        }
    }

    public String makeNewTransaction(BigDecimal transactionAmount, Transaction.accountType type) {
        transactions.add(new Transaction(transactionAmount, type));
       
    }
    public BigDecimal getBalance(){
    return getCurrentAccount().amount.add(getSavingAccount().amount);
    }

    public  String generateTransactionsSummary() {
       
    }
}
public class Transaction {
BigDecimal amount;
LocalDateTime dateTime;
accountType type;
enum accountType{
CREDIT,
DEBET
}

    public Transaction(BigDecimal amount,accountType type) {
        this.amount = amount;
        this.dateTime=LocalDateTime.now();
        this.type=type;
    }
}