# Domain Model - Core exercise

```java
public record Transaction(
        Type type,
        BigDecimal amount,
        ZonedDateTime timestamp
) {
    @RequiredArgsConstructor
    @Getter
    public enum Type {
        Deposit(1),
        Withdrawal(-1);

        private final int modifier;
    }
}
```

```java
public abstract class Account {
    protected BigDecimal balance;
    protected List<Transaction> transactions;

    void deposit(BigDecimal amount) {
    }

    void withdraw(BigDecimal amount) {
    }

    String generateStatement() {
        return "";
    }
}
```

```java
public class CurrentAccount extends Account {
}
```

```java
public class SavingsAccount extends Account {
}
```
