package registeration;

import PropertiesFileRead.FileRead;
import account.Account;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

public class AfterLoginController implements ReaderAfterLogin {

    static final String NOT_EXIST= "Search Failed..account Not Exist..";
    static final String ENTER_ACCOUNT_NUMBER = "Enter account Number..";
    private final static Logger logger = Logger.getLogger(AfterLoginController.class.getName());
    Scanner sc = new Scanner(System.in);
    ReaderAfterLogin reader = new AfterLoginFileRead();

    Properties prop;
    public String username;
    ArrayList<Account> accountArray = new ArrayList<>();
    public void setProp(Properties prop){
        this.prop = prop;
    }
    public void read(){
        int ch;
        do {
            logger.info("Main Menu\n1.Add account \n 2. Search By account number\n 3. Deposit\n" +
                    " 4. Withdrawal\n 5.Remove\n 6.Logout\n");
            logger.info("Ur Choice :");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    try {
                        addDisplay(accountArray,false);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                    break;

                case 2:
                    searchDisplay(accountArray,false);
                    break;

                case 3:
                    try {
                        depositDisplay(accountArray,false);

                    }
                    catch (Exception e){
                        System.out.println(e);

                    }
                    break;

                case 4:
                    try {
                        withdrawDisplay(accountArray,false);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    removeDisplay(false);
                    break;
                case 6:
                    logger.info("Logout");
                    break;

                default:
                    logger.info("Incorrect number entered");
            }
        }
        while (ch != 6);
    }
    public void addDisplay(ArrayList<Account> accountArray, boolean forautoread) {
        String accNumber,name;
        long balance;
        String tempstring ;
        String[] words = {};
        long amt;
        if(forautoread){
            tempstring = prop.getProperty("addAccount1");
            words = tempstring.split(" ");
            accNumber = words[0];
            name = words[1];
            balance = Long.parseLong(words[2]);
        }
        else {
            logger.info("Enter Account No: ");
            accNumber = sc.next();
            logger.info("Enter Name: ");
            name = sc.next();
            logger.info("Enter Balance: ");
            balance = sc.nextLong();
        }

        Account temp = new Account();
        temp.addAccount(accNumber,name,balance);
        accountArray.add(temp);
    }



    /*Get Input for removing account number*/

    public void removeDisplay(boolean forauotoread) {

        logger.info(ENTER_ACCOUNT_NUMBER);
        String acn = sc.next();
        boolean found = false;
        for (int i = 0; i < accountArray.size(); i++) {
            found = accountArray.get(i).search(acn);
            if (found) {
                accountArray.remove(i);
                break;
            }
        }
        if (!found) {
            System.out.println(NOT_EXIST);
        }
    }
    /*To get input for withdrawl from account*/

    public void withdrawDisplay(ArrayList<Account> accountArray,boolean forautoread) {
        String acn,tempstring ;
        String[] words = {};
        long amt;
        if(forautoread){
            tempstring = prop.getProperty("withdraw1");
            words = tempstring.split(" ");
            acn = words[0];
        }
        else {
            logger.info(ENTER_ACCOUNT_NUMBER);
            acn = sc.next();
        }
        boolean found = false;
        for (Account  eachAccount: accountArray) {
            found = eachAccount.search(acn);
            if (found) {
                if (forautoread){
                    amt = Long.parseLong(words[1]);
                }
                else {
                    logger.info("Enter Amount : ");
                    amt = sc.nextLong();
                }
                eachAccount.withdraw(amt);

                break;
            }
        }
        if (!found) {
            logger.info(NOT_EXIST);
        }
    }
    public void searchDisplay(ArrayList<Account> accountArray,boolean forautoread){
        String acn;

        if(forautoread){
            acn = prop.getProperty("search1");
        }
        else {
            logger.info("Enter Account No U Want to Search...: ");
            acn = sc.next();
        }
        boolean found = false;
        for (int i = 0; i < accountArray.size(); i++) {
            found = accountArray.get(i).search(acn);
            if (found) {
                break;
            }
        }
        if (!found) {
            logger.info(NOT_EXIST);
        }
    }

    /*
     * To get user input for depositing the amount
     * */

    public void depositDisplay(ArrayList<Account> accountArray,boolean forautoread){
        String acn,tempstring ;
        String[] words = {};
        long amt;
        if(forautoread){
            tempstring = prop.getProperty("deposit1");
            words = tempstring.split(" ");
            acn = words[0];
        }
        else {
            logger.info(ENTER_ACCOUNT_NUMBER);
            acn = sc.next();
        }
        boolean found = false;
        for (int i = 0; i < accountArray.size(); i++) {
            found = accountArray.get(i).search(acn);
            if (found) {
                if (forautoread){
                    amt = Long.parseLong(words[1]);
                }
                else {
                    logger.info("Enter Amount : ");
                    amt = sc.nextLong();
                }
                accountArray.get(i).deposit(amt);

                break;
            }
        }
        if (!found) {
            logger.info(NOT_EXIST);
        }
    }
}
