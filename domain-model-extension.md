## User stories and domain models

```
As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.
```

| Class   | Method                          | Return value | Class variable                       | Description                                     |
|---------|---------------------------------|--------------|--------------------------------------|-------------------------------------------------|
| Account | requestOverdraft(double amount) | void         | int balance<br/>int maximumOverdraft | Either approves or denies the account overdraft |