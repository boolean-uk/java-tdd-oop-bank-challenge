package extension;

import com.booleanuk.core.Account;
import com.booleanuk.core.BankManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankManagerTest {

    @Test
    public void makeABankManagerTest() {
        BankManager bankManager = new BankManager();
        String branch = "Stockholm";
        String typeOfAccount = "currentAccount";
        int id = 0;

        bankManager.addAccount(500, typeOfAccount, branch);

        Assertions.assertEquals(500, bankManager.getCurrentAccountWithIDInBranch(branch,typeOfAccount, id).getBalance());
    }

    @Test
    public void makeASavingAccountTest() {
        BankManager bankManager = new BankManager();
        String branch = "Oslo";
        String typeOfAccount = "savingAccount";
        int id = 0;

        bankManager.addAccount(500, typeOfAccount, branch);

        Assertions.assertEquals(500, bankManager.getCurrentAccountWithIDInBranch(branch, typeOfAccount, id).getBalance());
    }

    @Test
    public void overdraftTest() {
        BankManager bankManager = new BankManager();
        String branch = "Oslo";
        String typeOfAccount = "currentAccount";
        int id = 0;

        bankManager.addAccount(500, "currentAccount", branch);

        Account account = bankManager.getCurrentAccountWithIDInBranch(branch, typeOfAccount, id);

        Assertions.assertFalse(bankManager.withdrawFromAccount(account, 1000));

        Assertions.assertTrue(bankManager.withdrawFromAccount(account, 250));

        //Should be under the limit of overdraft and return true
        Assertions.assertTrue(bankManager.withdrawFromAccount(account, 500));

    }
}
