package extension;

import com.booleanuk.core.BankManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankManagerTest {

    @Test
    public void makeABankManagerTest() {
        BankManager bankManager = new BankManager();
        String branch = "Stockholm";
        String typeOfAccounts = "currentAccounts";
        int id = 0;

        bankManager.addCurrentAccount(500, branch);

        Assertions.assertEquals(500, bankManager.getCurrentAccountWithIDInBranch(branch,typeOfAccounts, id).getBalance());
    }

    @Test
    public void makeASavingAccountTest() {
        BankManager bankManager = new BankManager();
        String branch = "Oslo";
        String typeOfAccounts = "savingAccounts";
        int id = 0;

        bankManager.addSavingAccount(500, branch);

        Assertions.assertEquals(500, bankManager.getCurrentAccountWithIDInBranch(branch, typeOfAccounts, id).getBalance());
    }
}
