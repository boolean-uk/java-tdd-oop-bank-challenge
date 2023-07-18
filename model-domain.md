# Bank Application

| Classes        | Members | Methods | Scenario | Outputs |
|----------------|---------|---------|----------|---------|
| CurrentAccount |         |         |          |         |
|                |         |         |          |         |

| Classes        | Members | Methods | Scenario | Outputs |
|----------------|---------|---------|----------|---------|
| SavingsAccount |         |         |          |         |
|                |         |         |          |         |

| Classes | Members          | Methods | Scenario | Outputs |
|---------|------------------|---------|----------|---------|
| Client  | String name      |         |          |         |
|         | String lastName  |         |          |         |
|         | String birthDate |         |          |         |
|         |                  |         |          |         |

| Classes | Members                    | Methods                                                  | Scenario                           | Outputs   |
|---------|----------------------------|----------------------------------------------------------|------------------------------------|-----------|
| Bank    | List<Client> clientsOfBank | register(String name, String lastName, String birthDate) | if birthDate doesn't contains dots | Exception |
|         |                            | checkIfClientRegistered(Client client)                   | if client registered in bank       | true      |
|         |                            |                                                          | if client not registered in bank   | false     |

| Classes | Members                        | Methods                                               | Scenario                                                                              | Outputs |
|---------|--------------------------------|-------------------------------------------------------|---------------------------------------------------------------------------------------|---------|
| Account | LocalDateAndTime date          | createAccount(Client client)                          | if client exists generate account number                                              | String  |
|         | HashMap<String, double> credit |                                                       | if client does not exists return String "To create account you need to be registered" | String  |
|         | HashMap<String, double>  debit | generateBankStatements(HashMap credit, HashMap debit) | create String statement                                                               | String  |
|         |                                |                                                       |                                                                                       |         |
|         |                                | deposit(double amount, LocalDateAndTime date)         | if amount and date given                                                              | HashMap |
|         |                                |                                                       | if amount given and date not set current date                                         | HashMap |
|         |                                |                                                       | if amount and date not given or date given without amount                             | HashMap |
|         |                                | withdraw(double amount, LocalDateAndTime date)        | if amount and date given                                                              | HashMap |
|         |                                |                                                       | if amount given and date not set current date                                         | HashMap |
|         |                                |                                                       | if amount and date not given or date given without amount                             | HashMap |
|         |                                | countBalance(HashMap credit, HashMap debit)           | if credit and debit is not empty                                                      | double  |
|         |                                |                                                       | if credit and debit is empty                                                          | 0.00    |