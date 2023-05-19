# Bank challenge

## From the user stories below, the domain model will change. The user stories are:


```
1.
As a customer,
So I can safely store use my money,
I want to create a current account.

2.
As a customer,
So I can save for a rainy day,
I want to create a savings account.

3.
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

4.
As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```
## User story 1

| Class name | Attributes                       | Methods      | Scenarios                           | Outcome                                                                                                          |      
|------------|----------------------------------|--------------|-------------------------------------|------------------------------------------------------------------------------------------------------------------|
| Balance    | int intPart                      |              |                                     |                                                                                                                  |
|            | int decimalPart                  |              |                                     |                                                                                                                  |
|            |                                  |              |                                     |                                                                                                                  |
| Account    | Balance balance                  |              |                                     |                                                                                                                  |
|            |                                  |              |                                     |                                                                                                                  |
| Customer   | Account account                  | setUpAccount | The user wants to create an account | The account attribute is initialized with the users initial deposit. The initial deposit should be more than $5. |
|            | String fullName                  |              |                                     |                                                                                                                  |
|            | String address                   |              |                                     |                                                                                                                  |
|            | String dateOfBirth               |              |                                     |                                                                                                                  |
|            | int taxpayerIdentificationNumber |              |                                     |                                                                                                                  |

### On all classes the getters/setters are implied, except for:
#### The setters for the intPart and decimalPart of the Balance class, and the setters for balance in the Account class