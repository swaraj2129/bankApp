package registeration;

import account.Account;

import java.util.Properties;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Logger;

public class AfterLogin {
    static final String NOT_EXIST= "Search Failed..account Not Exist..";
    static final String ENTER_ACCOUNT_NUMBER = "Enter account Number..";
    private final static Logger logger = Logger.getLogger(AfterLogin.class.getName());
    Properties prop;

    public String username;
    ArrayList<Account> accountArray = new ArrayList<>();
    static Scanner sc= new Scanner(System.in);

    public AfterLogin(String username) {
        this.username = username;
    }

   /*
   * To get user input to search account number*/
    /*To give options to user for interaction with app*/

    public void success() {

        logger.info("Welcome to Java Application");
        logger.info("Select 1 for ManualInput\nSelect 2 for FileInput");
        int ch = sc.nextInt();
        if(ch==1){
            manualInput();
        }
        else if(ch == 2){
            fileInput();
        }

    }
    public void manualInput(){
        ReaderAfterLogin reader = new AfterLoginController();
        reader.read();
    }

    private void fileInput() {
        ReaderAfterLogin reader = new AfterLoginFileRead();
        reader.read();
    }

}
