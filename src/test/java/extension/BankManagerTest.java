package extension;

import com.booleanuk.core.BankManager;
import org.junit.jupiter.api.Test;

public class BankManagerTest {

    @Test
    public void makeABankManager() {
        BankManager bankManager = new BankManager();

        bankManager.addAccount(500);
    }
}
