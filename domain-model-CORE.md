| Class          	| Fields                          	| Methods                                 	| Output 	| Explanation                                        	|
|----------------	|---------------------------------	|-----------------------------------------	|--------	|----------------------------------------------------	|
| Account        	| accountNumber:String            	| deposit(amount: double)                 	| void   	| Customer can deposit money into account            	|
|                	| balance: double                 	| withdraw(amount: double)                	| void   	| Customer can withdraw money from the account       	|
|                	|                                 	| getBalance()                            	| double 	| Method to get the current balance from the account 	|
| CurrentAccount 	| overdraftLimit: double          	|                                         	|        	| Inherits from the Account class                    	|
| SavingsAccount 	| interestRate: double            	|                                         	|        	| Inherits from the Account class                    	|
| Transcation    	| transactionDate: DateTime       	|                                         	|        	|                                                    	|
|                	| amount: double                  	|                                         	|        	|                                                    	|
|                	| transactionType: string         	|                                         	|        	|                                                    	|
| Statement      	| transactions: List<Transaction> 	| addTransaction(Transaction transaction) 	| void   	| Add's single transaction to a statement            	|
|                	|                                 	| generateStatement()                     	| String 	|                                                    	|
|                	|                                 	|                                         	|        	|                                                    	|
