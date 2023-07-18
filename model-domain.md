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
|         | int id           |         |          |         |

| Classes | Members                    | Methods                                                          | Scenario                           | Outputs   |
|---------|----------------------------|------------------------------------------------------------------|------------------------------------|-----------|
| Bank    | List<Client> clientsOfBank | register(String name, String lastName, String birthDate, int id) | if birthDate doesn't contains dots | Exception |
|         |                            | checkIfClientRegistered(Client client)                           | if client registered in bank       | true      |
|         |                            |                                                                  | if client not registered in bank   | false     |
|         |                            | getClientByID(String id)                                         | if client exists in bank           | Client    |
|         |                            |                                                                  | if client does not exist in bank   | null      |

| Classes | Members                                   | Methods                                               | Scenario                                                                              | Outputs |
|---------|-------------------------------------------|-------------------------------------------------------|---------------------------------------------------------------------------------------|---------|
| Account | LocalDate date                            | createAccount(Client client)                          | if client exists generate account number                                              | String  |
|         | HashMap<String, ArrayList<Double>> credit |                                                       | if client does not exists return String "To create account you need to be registered" | String  |
|         | HashMap<String, ArrayList<Double>> debit  | generateBankStatements(HashMap credit, HashMap debit) | create String statement                                                               | String  |
|         | String accountNumber                      |                                                       |                                                                                       |         |
|         | List<String> accounts                     | deposit(double amount, LocalDate date)                | if amount and date given                                                              | String  |
|         |                                           |                                                       | if amount given and date not set current date                                         | String  |
|         |                                           |                                                       | if amount equals 0                                                                    | String  |
|         |                                           | withdraw(double amount, LocalDate date)               | if amount and date given                                                              | String  |
|         |                                           |                                                       | if amount given and date not set current date                                         | String  |
|         |                                           |                                                       | if amount and date not given or date given without amount                             | String  |
|         |                                           | countBalance(HashMap credit, HashMap debit)           | if credit and debit is not empty                                                      | double  |
|         |                                           |                                                       | if credit and debit is empty                                                          | 0.00    |
|         |                                           | generateAccountNumber(Client client)                  | if client is not null create account number                                           | String  |
|         |                                           |                                                       | if client is null return empty String                                                 | String  |