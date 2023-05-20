package com.booleanuk.core.model;

import com.booleanuk.core.model.enumerations.OVERDRAFT_STATE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Locale;

public class CurrentAccountTest {
    private static Customer customer;
    private static BankManager bankManager;

    @BeforeAll
    public static void globalSetup() {
        Locale locale = new Locale("el", "GR");
        bankManager = new BankManager();
        Bank bank = new Bank("EuroBank", "100", locale, bankManager);
        Branch branch = new Branch("Athens", "2555", bank);
        customer = new Customer("GR123456789", "AT12345", "Dimitris",
                "Tsimaras", LocalDate.parse("1992-04-04"), branch);
    }

    @Test
    public void checkConstructor_IllegalArguments() {
        Assertions.assertDoesNotThrow(() -> new CurrentAccount(new BigDecimal(BigInteger.TEN), customer));

        Assertions.assertThrows(NullPointerException.class,
                () -> new CurrentAccount(null, customer));

        Assertions.assertThrows(NullPointerException.class,
                () -> new CurrentAccount(new BigDecimal(BigInteger.TEN), null));
    }

    @Test
    public void checkOverdraftRequest() {
        Account account = new CurrentAccount(new BigDecimal("500"), customer);

        CurrentAccount currentAccount = null;
        if (account instanceof CurrentAccount) {
            currentAccount = (CurrentAccount) account;
        }

        Assertions.assertNotNull(currentAccount);
        Assertions.assertEquals(0, currentAccount.getOverdraftRequests().size());

        currentAccount.requestOverdraft(new BigDecimal("1000"));
        Assertions.assertEquals(1, currentAccount.getOverdraftRequests().size());


        var request = currentAccount.getOverdraftRequests().get(0);

        bankManager.processOverdraftRequest(request, OVERDRAFT_STATE.DENIED);
        Assertions.assertEquals(new BigDecimal("500"), currentAccount.getBalance().getAmount());

        currentAccount.overdraft(request);
        Assertions.assertEquals(new BigDecimal("500"), currentAccount.getBalance().getAmount());

        bankManager.processOverdraftRequest(request, OVERDRAFT_STATE.PENDING);
        currentAccount.overdraft(request);
        Assertions.assertEquals(new BigDecimal("500"), currentAccount.getBalance().getAmount());

        bankManager.processOverdraftRequest(request, OVERDRAFT_STATE.APPROVED);
        currentAccount.overdraft(request);
        Assertions.assertEquals(new BigDecimal("-500"), currentAccount.getBalance().getAmount());
    }
}
