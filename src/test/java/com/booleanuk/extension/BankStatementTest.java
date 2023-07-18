package com.booleanuk.extension;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankStatementTest {

    static SmsService smsService;
    BankStatement bankStatement;

    @BeforeAll
    static void beforeAll() {
//        smsService = TwilioService.getInstance();
        smsService = new MockSmsService();
    }

    @BeforeEach
    void setUp() {
        Account account = new CurrentAccount(new BankBranch());
        account.deposit(BigDecimal.valueOf(1000.00), LocalDate.of(2012, 1, 10));
        account.deposit(BigDecimal.valueOf(2000.00), LocalDate.of(2012, 1, 13));
        account.withdraw(BigDecimal.valueOf(500.00), LocalDate.of(2012, 1, 14));

        bankStatement = new BankStatement(account, smsService);
    }

    @Test
    void shouldPrintBankStatement() {
        Assertions.assertEquals("""
                date       || credit  || debit  || balance
                14/01/2012 ||         || 500.00 || 2500.00
                13/01/2012 || 2000.00 ||        || 3000.00
                10/01/2012 || 1000.00 ||        || 1000.00
                """, bankStatement.print());
    }

    @Test
    void shouldSendSmsWithoutThrowingAnyException() {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        String phoneNumber = dotenv.get("TWILIO_RECIPIENT_PHONE_NUMBER", "000000000");
        Assertions.assertDoesNotThrow(() -> bankStatement.sendStatement(phoneNumber));

        if(smsService instanceof MockSmsService service) {
            Assertions.assertEquals(phoneNumber, service.getPhoneNumber());
            Assertions.assertEquals("""
                date       || credit  || debit  || balance
                14/01/2012 ||         || 500.00 || 2500.00
                13/01/2012 || 2000.00 ||        || 3000.00
                10/01/2012 || 1000.00 ||        || 1000.00
                """, service.getMessage());
        }
    }
}
