## User Stories


As a customer,
So I can safely store and use my money,
I want to create a current account.

Class Bank

| Member variables                            | Method                   | Scenario                       | Output                                                 |   |   |
|---------------------------------------------|--------------------------|--------------------------------|--------------------------------------------------------|---|---|
| Map<Customer, ArrayList<Account>> customers | newCustomer(String name) | Customer doesn't exist already | Create customer obj, add to customers map, return true |   |   |
|                                             |                          | Customer already exists in map | print error, return false                              |   |   |
|                                             |                          |                                |                                                        |   |   |


As a customer,
So I can save for a rainy day,
I want to create a savings account.

Class Bank

| Member variables                            | Method                                      | Scenario                       | Output                                                 |   |   |
|---------------------------------------------|---------------------------------------------|--------------------------------|--------------------------------------------------------|---|---|
| Map<Customer, ArrayList<Account>> customers | newAccount(String name, String accountType) | Customer doesn't exist already | Create customer obj, add to customers map, return true |   |   |
|                                             |                                             | Customer already exists in map | print error, return false                              |   |   |
|                                             |                                             |                                |                                                        |   |   |



As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

Class Account

| Member variables                    | Method       | Scenario                         | Output                                                    |   |   |
|-------------------------------------|--------------|----------------------------------|-----------------------------------------------------------|---|---|
| ArrayList<Transaction> transactions | getBalance() | No transactions for this account | print error, return false                                 |   |   |
|                                     |              | account has transactions         | print transaction history, return current account balance |   |   |
|                                     |              |                                  |                                                           |   |   |


As a customer,
So I can use my account,
I want to deposit and withdraw funds.

Class account

| Member variables                    | Method | Scenario                       | Output                                                 |   |   |
|-------------------------------------|----|--------------------------------|--------------------------------------------------------|---|---|
| ArrayList<Transaction> transactions |    | Customer doesn't exist already | Create customer obj, add to customers map, return true |   |   |
|                                     |    | Customer already exists in map | print error, return false                              |   |   |
|                                     |    |                                |                                                        |   |   |



## Acceptance Criteria

**Given** a client makes a deposit of 1000 on 10-01-2012  
**And** a deposit of 2000 on 13-01-2012  
**And** a withdrawal of 500 on 14-01-2012  
**When** she prints her bank statement  
**Then** she would see:

```
date       || credit  || debit  || balance
14/01/2012 ||         || 500.00 || 2500.00
13/01/2012 || 2000.00 ||        || 3000.00
10/01/2012 || 1000.00 ||        || 1000.00
```

## Extensions

```
As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.
```

## Test Output

![](./assets/run-a-test.PNG)

When you run a test, it's either going to pass or fail. When it fails, you'll be presented with a big red stream of text. This is called a stack trace and, though intimidating, does contain some useful information.

One of the core skills of a developer is debugging stack traces like this. The stack trace details in which classes & files the failure happened, and gives you a line number at the end. Most of the lines in the stack trace are irrelevant most of the time, you want to try and identify the files that you're actually working with.

In the sample screenshot below, we've tried to complete the first step of the exercise but provided an invalid value. Then we run the test associated with it, and we see a big red stack trace, a test failure.

At the top, we see `expected: <32> but was: <33>`. This means the test expected the value to be 32, but the value the student provided was 33. We can see this in the code snippets at the top of the screenshot.

In the stack trace itself, we see this line: `at app//com.booleanuk.core.ExerciseTest.shouldBeAged32(ExerciseTest.java:20)`. This is helpful! This tells us the exact line in the ExerciseTest.java file (line 20) where the failure happened, as well as the method name (shouldBeAged32), helping us to identify where the issue began. This is the kind of thing you need to look for; a relevant file name, method name, class name and line number to give you a good starting point for debugging.

![](./assets/test-failure.PNG)
