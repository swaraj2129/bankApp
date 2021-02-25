package registeration;

import PropertiesFileRead.FileRead;
import account.Account;

import java.util.ArrayList;
import java.util.Properties;

public class AfterLoginFileRead implements ReaderAfterLogin {
    ArrayList<Account> accountArray = new ArrayList<>();

    public void read() {
        Properties prop = null;

        try {
            prop = FileRead.readPropertiesFile("resources/input_file.properties");

        } catch (Exception e) {
            System.out.println(e);
        }
        AfterLoginController controller = new AfterLoginController();
        controller.setProp(prop);
        controller.addDisplay(accountArray,true);
        controller.depositDisplay(accountArray, true);
        controller.searchDisplay(accountArray, true);
        controller.withdrawDisplay(accountArray, true);
        controller.searchDisplay(accountArray, true);

    }
    public Properties getProp(Properties prop){
        return prop;
    }
}
