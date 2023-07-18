package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AccountTest {

    @Test
    public void generateAccountNumberIfClientIsNullTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        Client client = null;
        String message = account.generateAccountNumber(client);
        Assertions.assertEquals("", message);
    }

    @Test
    public void generateAccountNumberIfClientIsNotNullWithOneNameTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        Client client = new Client("John", "Smith", "01.01.1998", "234");
        StringBuilder sb = new StringBuilder();
        sb.append(client.name.toUpperCase().trim());
        sb.append(client.lastName.toUpperCase());
        sb.append(client.birthDate.replaceAll(".", ""));
        sb.append(client.id.toUpperCase());
        String accountNumber = sb.toString();
        String message = account.generateAccountNumber(client);
        Assertions.assertEquals(accountNumber, message);
    }

    @Test
    public void generateAccountNumberIfClientIsNotNullWithTwoNamesTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        Client client = new Client("John Andrew", "Smith", "01.01.1998", "234");
        StringBuilder sb = new StringBuilder();
        sb.append(client.name.toUpperCase().trim());
        sb.append(client.lastName.toUpperCase());
        sb.append(client.birthDate.replaceAll(".", ""));
        sb.append(client.id.toUpperCase());
        String accountNumber = sb.toString();
        String message = account.generateAccountNumber(client);
        Assertions.assertEquals(accountNumber, message);
    }

    @Test
    public void createAccountIfClientExistsTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        Client client = new Client("John", "Smith", "01.01.1998", "234");
        String message = account.createAccount(client);
        Assertions.assertEquals(account.generateAccountNumber(client), message);
    }

    @Test
    public void createAccountIfClientDoesNotExistTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        Client client = new Client("John", "Smith", "01.01.1998", "123");
        String message = account.createAccount(client);
        Assertions.assertEquals("To create account you need to be registered", message);
    }

    @Test
    public void depositAmountAndDateGivenTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amount = 2000;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("01/12/2020", dateFormat);
        Assertions.assertEquals("Money added to deposit", account.deposit(amount, date));
        Assertions.assertTrue(account.getCreditList().containsKey(date));
        Assertions.assertEquals(account.getCreditList().get(date).get(0), amount);
    }

    @Test
    public void depositAmountAndDateGivenThreeTimesInOneDayTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amount1 = 2000;
        double amount2 = 1000;
        double amount3 = 500;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("01/12/2020", dateFormat);

        Assertions.assertEquals("Money added to deposit", account.deposit(amount1, date));
        Assertions.assertEquals("Money added to deposit", account.deposit(amount2, date));
        Assertions.assertEquals("Money added to deposit", account.deposit(amount3, date));
        Assertions.assertTrue(account.getCreditList().containsKey(date));
        Assertions.assertEquals(account.getCreditList().get(date).stream().filter(e -> e.equals(amount1)).findFirst().get(), amount1);
        Assertions.assertEquals(account.getCreditList().get(date).stream().filter(e -> e.equals(amount2)).findFirst().get(), amount2);
        Assertions.assertEquals(account.getCreditList().get(date).stream().filter(e -> e.equals(amount3)).findFirst().get(), amount3);
    }

    @Test
    public void depositAmountGivenAndDateNotTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amount = 2000;
        LocalDate date = LocalDate.now();
        Assertions.assertEquals("Money added to deposit", account.deposit(amount));
        Assertions.assertTrue(account.getCreditList().containsKey(date));
        Assertions.assertEquals(account.getCreditList().get(date).get(0), amount);
    }

    @Test
    public void depositDateGivenAndAmountNotCorrectTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("01/12/2020", dateFormat);
        Assertions.assertEquals("No money to add to deposit", account.deposit(-220.20, date));
    }

    @Test
    public void depositDateNotGivenAndAmountEquals0Test() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        Assertions.assertEquals("No money to add to deposit", account.deposit(0.00));
    }

    @Test
    public void withdrawAmountAndDateGivenTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amount = 500;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("01/12/2020", dateFormat);
        Assertions.assertEquals("Money withdrew", account.withdraw(amount, date));
        Assertions.assertTrue(account.getDebitList().containsKey(date));
        Assertions.assertEquals(account.getDebitList().get(date).get(0), amount);
    }

    @Test
    public void withdrawAmountAndDateGivenThreeTimesInOneDayTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amount1 = 500;
        double amount2 = 1500;
        double amount3 = 700;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("01/12/2020", dateFormat);

        Assertions.assertEquals("Money withdrew", account.withdraw(amount1, date));
        Assertions.assertEquals("Money withdrew", account.withdraw(amount2, date));
        Assertions.assertEquals("Money withdrew", account.withdraw(amount3, date));
        Assertions.assertTrue(account.getDebitList().containsKey(date));
        Assertions.assertEquals(account.getDebitList().get(date).stream().filter(e -> e.equals(amount1)).findFirst().get(), amount1);
        Assertions.assertEquals(account.getDebitList().get(date).stream().filter(e -> e.equals(amount2)).findFirst().get(), amount2);
        Assertions.assertEquals(account.getDebitList().get(date).stream().filter(e -> e.equals(amount3)).findFirst().get(), amount3);
    }

    @Test
    public void withdrawAmountGivenAndDateNotTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amount = 500;
        Assertions.assertEquals("Money withdrew", account.withdraw(amount));
    }

    @Test
    public void withdrawDateGivenAndAmountEquals0Test() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("01/12/2020", dateFormat);
        Assertions.assertEquals("No money to withdraw from deposit", account.withdraw(0.00, date));
    }

    @Test
    public void withdrawDateNotGivenAndAmountIncorrectTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        Assertions.assertEquals("No money to withdraw from deposit", account.withdraw(-200.90));
    }

    @Test
    public void countBalanceTestExample1() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amountToDeposit = 1000;
        double amountToWithdraw = 700;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse("01/12/2020", dateFormat);
        LocalDate date2 = LocalDate.parse("02/12/2020", dateFormat);
        account.deposit(amountToDeposit, date1);
        account.withdraw(amountToWithdraw, date2);

        Assertions.assertEquals(300.00, account.countBalanceTotal(account.getCreditList(), account.getDebitList()));
    }

    @Test
    public void countBalanceTestExample2() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amountToDeposit1 = 1000;
        double amountToDeposit2 = 1500;
        double amountToWithdraw = 700;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse("01/12/2020", dateFormat);
        LocalDate date2 = LocalDate.parse("02/12/2020", dateFormat);
        LocalDate date3 = LocalDate.parse("03/12/2020", dateFormat);
        account.deposit(amountToDeposit1, date1); //1000
        account.deposit(amountToDeposit1, date1); //2000
        account.withdraw(amountToWithdraw, date2); //1300
        account.deposit(amountToDeposit2, date3); //2800

        Assertions.assertEquals(2800.00, account.countBalanceTotal(account.getCreditList(), account.getDebitList()));
    }
    @Test
    public void countBalanceTestExample3() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amountToDeposit = 1000;
        double amountToWithdraw = 700;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse("01/12/2020", dateFormat);
        LocalDate date2 = LocalDate.parse("02/12/2020", dateFormat);
        account.deposit(amountToDeposit, date1);
        account.withdraw(amountToWithdraw, date2);
        account.withdraw(300, date2);
        account.withdraw(amountToWithdraw, date2);

        Assertions.assertEquals(-700.00, account.countBalanceTotal(account.getCreditList(), account.getDebitList()));
    }

    @Test
    public void countBalanceTestExample4() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amountToDeposit = 1000;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse("01/12/2020", dateFormat);
        LocalDate date2 = LocalDate.parse("02/12/2020", dateFormat);
        account.deposit(amountToDeposit, date1);
        account.deposit(amountToDeposit, date1);
        account.deposit(amountToDeposit, date2);

        Assertions.assertEquals(3000.00, account.countBalanceTotal(account.getCreditList(), account.getDebitList()));
    }

    @Test
    public void countBalanceTestExample5() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amountToWithdraw = 700;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse("01/12/2020", dateFormat);
        LocalDate date2 = LocalDate.parse("02/12/2020", dateFormat);
        account.withdraw(amountToWithdraw, date1);
        account.withdraw(amountToWithdraw, date2);

        Assertions.assertEquals(-1400.00, account.countBalanceTotal(account.getCreditList(), account.getDebitList()));
    }

    @Test
    public void countBalanceForEmptyAccountTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);

        Assertions.assertEquals(00, account.countBalanceTotal(account.getCreditList(), account.getDebitList()));
    }

    public double countBalanceTotal(HashMap<LocalDate, ArrayList<Double>> creditList, HashMap<LocalDate, ArrayList<Double>> debitList){
        double balance = 0.00;
        for (List<Double> creditAmounts : creditList.values()) {
            for (double credit : creditAmounts) {
                balance += credit;
            }
        }

        for (List<Double> debitAmounts : debitList.values()) {
            for (double debit : debitAmounts) {
                balance -= debit;
            }
        }
        return balance;
    }

    public String generateBankStatementsForTest(HashMap<LocalDate, ArrayList<Double>> creditList, HashMap<LocalDate, ArrayList<Double>> debitList){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        HashMap<LocalDate, ArrayList<Double>> tmpCreditList = creditList;
        HashMap<LocalDate, ArrayList<Double>> tmpDebitList = debitList;
        double balance = countBalanceTotal(creditList, debitList);

        StringBuilder sb = new StringBuilder();
        sb.append("date       || ");
        sb.append("credit  || ");
        sb.append("debit  || ");
        sb.append("balance \n");

        List<LocalDate> allDates = new ArrayList<>();
        allDates.addAll(tmpCreditList.keySet());
        allDates.addAll(tmpDebitList.keySet());
        Collections.sort(allDates, Collections.reverseOrder());

        for (LocalDate date : allDates) {
            double previousValue = balance;
            sb.append(date.format(dateFormat));
            sb.append(" || ");
            if (tmpCreditList.containsKey(date)) {
                for (double d : tmpCreditList.get(date)) {
                    sb.append(d + "  ||        || ");
                    balance -= d;
                }
                tmpCreditList.remove(date);
            }
            if (tmpDebitList.containsKey(date)) {
                for (double d : tmpDebitList.get(date)) {
                    sb.append("        || ");
                    sb.append(d + "  || ");
                    balance += d;
                }
                tmpDebitList.remove(date);
            }
            sb.append(previousValue + "\n");
        }

        return sb.toString();
    }

    @Test
    public void generateBankStatementsTestExample1() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amountToDeposit = 1000;
        double amountToWithdraw = 700;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse("01/12/2020", dateFormat);
        LocalDate date2 = LocalDate.parse("02/12/2020", dateFormat);
        account.deposit(amountToDeposit, date1);
        account.withdraw(amountToWithdraw, date2);
        System.out.println(account.generateBankStatements(account.getCreditList(), account.getDebitList()));
        HashMap<LocalDate, ArrayList<Double>> creditList = account.getCreditList();
        HashMap<LocalDate, ArrayList<Double>> debitList = account.getDebitList();

        Assertions.assertEquals(generateBankStatementsForTest(creditList, debitList), account.generateBankStatements(account.getCreditList(), account.getDebitList()));
    }

    @Test
    public void generateBankStatementsTestExample2() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amountToDeposit1 = 1000;
        LocalDate date1 = LocalDate.parse("10/01/2012", dateFormat);
        account.deposit(amountToDeposit1, date1);
        double amountToDeposit2 = 2000;
        LocalDate date2 = LocalDate.parse("13/01/2012", dateFormat);
        account.deposit(amountToDeposit2, date2);
        double amountToWithdraw = 500;
        LocalDate date3 = LocalDate.parse("14/12/2020", dateFormat);
        account.withdraw(amountToWithdraw, date3);
        System.out.println(account.generateBankStatements(account.getCreditList(), account.getDebitList()));
        HashMap<LocalDate, ArrayList<Double>> creditList = account.getCreditList();
        HashMap<LocalDate, ArrayList<Double>> debitList = account.getDebitList();

        Assertions.assertEquals(generateBankStatementsForTest(creditList, debitList), account.generateBankStatements(account.getCreditList(), account.getDebitList()));
    }

}
