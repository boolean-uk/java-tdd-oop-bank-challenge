### Bank challenge domain model

```
1. As a customer,
So I can safely store and use my money,
I want to create a current account.
```
Bank Class

| Methods()                          | Member Variables | Scenario                                                  | Result/Output       |
|------------------------------------|------------------|-----------------------------------------------------------|---------------------|
| createCurrAcc(Customer,int choice) | int branchNr     | Get the customer object and check if                      | return confirmation |
|                                    |                  | it exists, then ask if they want saving- or               |                     |
|                                    |                  | current account. Send parameters and create               |                     |
|                                    |                  | an account based on the choice, connected to the Customer |                     |

```
2. As a customer,
So I can save for a rainy day,
I want to create a savings account.
```
Bank Class

| Methods()                          | Member Variables | Scenario                                                  | Result/Output       |
|------------------------------------|------------------|-----------------------------------------------------------|---------------------|
| createSaveAcc(Customer,int choice) | int branchNr     | Get the customer object and check if                      | return confirmation |
|                                    |                  | it exists, then ask if they want saving- or               |                     |
|                                    |                  | current account. Send parameters and create               |                     |
|                                    |                  | an account based on the choice, connected to the Customer |                     |
```
3. As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, 
amounts, and balance at the time of transaction.

```
Bank Class

| Methods()                            | Member Variables | Scenario                                 | Result/Output |
|--------------------------------------|------------------|------------------------------------------|---------------|
| seeTransactions(Customer,int choice) | int branchNr     | Check the customer if they have account. | return output |
|                                      |                  | Choose account based on their choice     |               |
|                                      |                  | Print out the data for the customer      |               |
|                                      |                  |                                          |               |

```
4. As a customer,
So I can use my account,
I want to deposit and withdraw funds.
```
Bank Class

| Methods()                                         | Member Variables | Scenario                                                                | Result/Output       |
|---------------------------------------------------|------------------|-------------------------------------------------------------------------|---------------------|
| makeDeposit(Customer,int choice,double amount)    | int branchNr     | Check if customer exists, choose account based on choice.               | return confirmation |
|                                                   |                  | Get the current value in the account and add the amount + dateTime      |                     |
|                                                   |                  |                                                                         |                     |
| makeWithdraw(Customer, int choice, double amount) |                  | Same as above, just subtraction, check if the amount doesn't overextend |                     |