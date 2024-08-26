package extension;

import com.booleanuk.core.BankManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankManagerTest {

    @Test
    public void makeABankManager() {
        BankManager bankManager = new BankManager();

        bankManager.addCurrentAccount(500, "Stockholm");


        Assertions.assertEquals(500, bankManager.getAccountWithIDInBranch("Stockholm", 0));
    }
}
