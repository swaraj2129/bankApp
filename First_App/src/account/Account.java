package account;
import exception.*;
import registeration.Login;

import java.util.Scanner;
import java.util.logging.Logger;

public class Account {
    private String accno;
    private String name;
    private long balance;
    Scanner sc = new Scanner(System.in);
    private static final String GREATER_THAN_ZERO="Enter value > 0";
    private final static Logger logger = Logger.getLogger(Login.class.getName());

    public void addAccount() {
        logger.info("Enter Account No: ");


        accno = sc.next();
        int i = Integer.parseInt(accno);
        if (i <= 0){
            throw new InValidInputException(GREATER_THAN_ZERO);
        }
        else {
            logger.info("Enter Name: ");
            name = sc.next();
            logger.info("Enter Balance: ");
            balance = sc.nextLong();
        }
    }


    public void deposit() {
        long amt;

        logger.info("Enter Amount : ");
        amt = sc.nextLong();
        if (amt < 0){

            throw new InValidInputException(GREATER_THAN_ZERO);
        }
        else
            balance = balance + amt;
    }

    public void withdraw() {
        long amt;
        logger.info("Enter Amount : ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
        } else {

            throw new InSufficientFundException(String.format(
                    "Current balance %d is less than requested amount %d",
                    balance, amt));
        }
    }
    public boolean search(String acn) {
        if (accno.equals(acn)) {
            AccountDetails();
            return (true);
        }
        return (false);
    }

    public void AccountDetails() {
        logger.info(accno + "," + name + "," + balance);
    }




}
