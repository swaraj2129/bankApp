package account;
import exception.*;

import java.util.Scanner;
import java.util.logging.Logger;

public class Account {
    private String accno;
    private String name;
    private long balance;
    Scanner sc = new Scanner(System.in);
    private static final String GREATER_THAN_ZERO="Enter value > 0";
    private final static Logger logger = Logger.getLogger(Account.class.getName());

    public void addAccount(String accno,String name ,long balance) {

        long i = Long.parseLong(accno);
        if (i <= 0){
            throw new InValidInputException(GREATER_THAN_ZERO);
        }
        else {
            this.accno = accno;
            this.name = name;
            this.balance = balance;
            logger.info("Account Created");
            AccountDetails();
        }
    }


    public void deposit(long amt) {
        if (amt < 0){

            throw new InValidInputException(GREATER_THAN_ZERO);
        }
        else
            balance = balance + amt;
    }

    public void withdraw(long amt) {

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
