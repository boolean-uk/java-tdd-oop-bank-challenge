package com.booleanuk.extension.user;

import com.booleanuk.core.exception.BankAccountNotOpenedException;
import com.booleanuk.core.exception.EmergencyFundExceededException;
import com.booleanuk.core.user.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CustomerTest {

    @Test
    public void shouldIncreaseEmergencyFund() {
        Customer customer = new Customer();
        customer.openCurrentAccount();
        BigDecimal increaseAmount = BigDecimal.valueOf(500);

        customer.changeEmergencyFund(increaseAmount);

        BigDecimal emergencyFund = customer.getCurrentAccount().getEmergencyFund();
        Assertions.assertEquals(increaseAmount, emergencyFund);
    }

    @Test
    public void shouldThrowAccountNotOpenedWhenIncreaseEmergencyFundWithoutCurrentAccount() {
        Customer customer = new Customer();
        BigDecimal increaseAmount = BigDecimal.valueOf(500);

        BankAccountNotOpenedException bankAccountNotOpenedException = Assertions.assertThrows(BankAccountNotOpenedException.class, () -> customer.changeEmergencyFund(increaseAmount));
        Assertions.assertEquals("Current Account not opened", bankAccountNotOpenedException.getMessage());
    }

    @Test
    public void shouldThrowEmergencyFundExceeded() {
        Customer customer = new Customer();
        customer.openCurrentAccount();
        BigDecimal increaseAmount = BigDecimal.valueOf(500);

        customer.changeEmergencyFund(increaseAmount);

        EmergencyFundExceededException emergencyFundExceededException = Assertions.assertThrows(EmergencyFundExceededException.class, () -> customer.withdrawCurrentAccount(BigDecimal.valueOf(1000)));
        Assertions.assertEquals("Your emergency fund exceeded", emergencyFundExceededException.getMessage());

    }

}
