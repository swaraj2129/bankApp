package registeration;

import account.Account;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Login {
    static final String NOT_EXIST= "Search Failed..account Not Exist..";
    static final String ENTER_ACCOUNT_NUMBER = "Enter account Number..";
    private final static Logger logger = Logger.getLogger(Login.class.getName());


    public String username;
    ArrayList<Account> accountArray = new ArrayList<>();
    static Scanner sc= new Scanner(System.in);

    public Login(String username) {
        this.username = username;
    }

   /*
   * To get user input to search ccount number*/
    public static void searchDisplay(ArrayList<Account> accountArray){
        logger.info("Enter Account No U Want to Search...: ");
        String acn = sc.next();
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

    public static void depositDisplay(ArrayList<Account> accountArray){
        logger.info(ENTER_ACCOUNT_NUMBER);
        String acn = sc.next();
        boolean found = false;
        for (int i = 0; i < accountArray.size(); i++) {
            found = accountArray.get(i).search(acn);
            if (found) {
                accountArray.get(i).deposit();
                break;
            }
        }
        if (!found) {
            logger.info(NOT_EXIST);
        }
    }

    /*To give options to user for interaction with app*/
    public void success() {

        logger.info("Welcome to Java Application");
        int ch;
        do {
            logger.info("Main Menu\n1.Add account \n 2. Search By account number\n 3. Deposit\n 4. Withdrawal\n 5.Remove\n 6.Exit");
            logger.info("Ur Choice :");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    try {
                        Account temp = new Account();
                        temp.addAccount();
                        accountArray.add(temp);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                    break;

                case 2:
                    searchDisplay(accountArray);
                    break;

                case 3:
                    try {
                        depositDisplay(accountArray);

                    }
                    catch (Exception e){
                        System.out.println(e);

                    }
                    break;

                case 4:
                    try {
                        withdrawDisplay(accountArray);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    removeDisplay();
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
    /*Get Input for removing account number*/
    private void removeDisplay() {
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
    private void withdrawDisplay(ArrayList<Account> accountArray) {
        logger.info(ENTER_ACCOUNT_NUMBER);
        String acn = sc.next();
        boolean found = false;
        for (Account  eachAccount: accountArray) {
            found = eachAccount.search(acn);
            if (found) {
                eachAccount.withdraw();
                break;
            }
        }
        if (!found) {
            logger.info(NOT_EXIST);
        }
    }
}
