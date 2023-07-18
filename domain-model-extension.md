# Domain Model - Core exercise

```java

@RequiredArgsConstructor
@Getter
public abstract class Account {
    protected final List<Transaction> transactions = new ArrayList<>();
    protected final SwiftCode swiftCode;

    public void deposit(BigDecimal amount) {
    }

    public void withdraw(BigDecimal amount) {
    }

    public String generateStatement() {
        return "";
    }

    public void sendStatementAsSms() {
    }
}
```

```java
public record Transaction(
        Type type,
        BigDecimal amount,
        Status status,
        ZonedDateTime timestamp
) {
    public static Transaction of(Type type, BigDecimal amount, Status status) {
        return new Transaction(type, amount, status, ZonedDateTime.now());
    }

    @RequiredArgsConstructor
    @Getter
    public enum Type {
        Deposit(1),
        Withdrawal(-1);

        private final int modifier;
    }

    @RequiredArgsConstructor
    @Getter
    public enum Status {
        Accepted(true),
        Rejected(false);

        private final boolean status;
    }
}
```

```java
public class CurrentAccount extends Account {
    private boolean overdraftAllowed = false;

    public CurrentAccount(SwiftCode swiftCode) {
        super(swiftCode);
    }

    public void requestOverdraft() {
    }

    public void reviewOverdraftRequest(boolean approve) {
    }
}
```

```java
public class SavingsAccount extends Account {
    public SavingsAccount(SwiftCode swiftCode) {
        super(swiftCode);
    }
}
```

```java
public class TwilioService {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
    private static final String PHONE_NUM = dotenv.get("TWILIO_PHONE_NUM");

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public static void sendSms(String recipientNumber, String sms) {
    }
}
```
