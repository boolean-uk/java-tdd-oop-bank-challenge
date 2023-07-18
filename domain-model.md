#Bob's Bagles


| Classes           | Methods           | Scenario                                                              | Outputs                  |
|-------------------|-------------------|-----------------------------------------------------------------------|--------------------------|
| `CustomerAccount` | `transaction `    | if `isDeposit` is `true`: adds specified amount of money.             | updated 'balanceHistory' |
| `CustomerAccount` | `transaction `    | if `isDeposit` is `false`: removes specified amount of money.         | updated 'balanceHistory' |
| `CustomerAccount` | `totalBalance`    | calculates total amount of money on account                           | updated 'baglesInBasket' |
| `CustomerAccount` | `printStatement`  | prints statement containing history of transactions and total balance | updated 'baglesInBasket' |
| `Bank`            | `addAccount()`    | creates new account                                                   | `"Basket is full."`      |