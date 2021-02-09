package account;
import exception.*;

import java.util.Scanner;

public class Account {
    private String accno;
    private String name;
    private long balance;
    Scanner sc = new Scanner(System.in);
    private static final String GREATER_THAN_ZERO="Enter value > 0";

    public void addAccount() {
        System.out.print("Enter Account No: ");

        try {
            accno = sc.next();
            int i = Integer.parseInt(accno);
            if (i <= 0){
                throw new InValidInputException(GREATER_THAN_ZERO);
            }
            else {
                System.out.print("Enter Name: ");
                name = sc.next();
                System.out.print("Enter Balance: ");
                balance = sc.nextLong();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public void deposit() {
        long amt;

        System.out.println("Enter Amount : ");
        amt = sc.nextLong();
        if (amt < 0){
            try {
                throw new InValidInputException(GREATER_THAN_ZERO);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else
        balance = balance + amt;
    }

    public void withdraw() {
        long amt;
        System.out.println("Enter Amount : ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
        } else {
            try {
                throw new InSufficientFundException(String.format(
                        "Current balance %d is less than requested amount %d",
                        balance, amt));
            }
            catch (RuntimeException e) {
                System.out.println(e);

            }
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
        System.out.println(accno + "," + name + "," + balance);
    }




}
