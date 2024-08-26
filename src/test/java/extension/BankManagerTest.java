package extension;

import com.booleanuk.core.BankManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankManagerTest {

    @Test
    public void makeABankManager() {
        BankManager bankManager = new BankManager();
        String branch = "Stockholm";
        int id = 0;

        bankManager.addCurrentAccount(500, branch);

        Assertions.assertEquals(500, bankManager.getCurrentAccountWithIDInBranch(branch, id).getBalance());
    }
}
