package extension;

import com.booleanuk.extension.Bank;
import com.booleanuk.extension.CurrentAccount;
import com.booleanuk.extension.SavingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void Add2AccountsToTheBank() {
        Bank bank = new Bank();
        bank.getAccounts().add(new CurrentAccount());
        bank.getAccounts().add(new SavingAccount());

        Assertions.assertEquals(2,bank.getAccounts().size());
    }
}
