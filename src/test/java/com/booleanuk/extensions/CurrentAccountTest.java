package com.booleanuk.extensions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CurrentAccountTest {

    @Test
    void shouldNotOverdraft(){
        CurrentAccount currentAccount = new CurrentAccount();

        Assertions.assertThrows(IllegalStateException.class, () -> currentAccount.withdraw(BigDecimal.valueOf(50)));
    }

    @Test
    void shouldOverdraftRequestForOverdraftAccepted(){
        CurrentAccount currentAccount = new CurrentAccount();

        while (!currentAccount.overdraft){
            currentAccount.askForOverDraft();
        }

        Assertions.assertDoesNotThrow(() -> currentAccount.withdraw(BigDecimal.valueOf(500)));
    }

    @Test
    void shouldNotOverdraftWithdrawOverMaxOverdraftAmount(){
        CurrentAccount currentAccount = new CurrentAccount();

        while (!currentAccount.overdraft){
            currentAccount.askForOverDraft();
        }

        Assertions.assertThrows(IllegalStateException.class, () -> currentAccount.withdraw(BigDecimal.valueOf(700)));
    }
}
