package registeration;

import account.Account;

import java.util.Scanner;
import java.util.ArrayList;

public class Login {
    static final String NOT_EXIST= "Search Failed..account Not Exist..";
    static final String ENTER_ACCOUNT_NUMBER = "Enter account Number..";


    public String username;
    ArrayList<Account> accountArray = new ArrayList<>();
    static Scanner sc= new Scanner(System.in);

    public Login(String username) {
        this.username = username;
    }

   /*
   * To get user input to search ccount number*/
    public static void searchDisplay(ArrayList<Account> accountArray){
        System.out.print("Enter Account No U Want to Search...: ");
        String acn = sc.next();
        boolean found = false;
        for (int i = 0; i < accountArray.size(); i++) {
            found = accountArray.get(i).search(acn);
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println(NOT_EXIST);
        }
    }

    /*
    * To get user input for depositing the amount
    * */

    public static void depositDisplay(ArrayList<Account> accountArray){
        System.out.print(ENTER_ACCOUNT_NUMBER);
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
            System.out.println(NOT_EXIST);
        }
    }

    /*To give options to user for interaction with app*/
    public void success() {

        System.out.println("Welcome to Java Application");
        int ch;
        do {
            System.out.println("Main Menu\n1.Add accountArray \n 2. Search By accountArray\n 3. Deposit\n 4. Withdrawal\n 5.Remove\n 6.Exit");
            System.out.println("Ur Choice :");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    accountArray.add(new Account());
                    accountArray.get(accountArray.size()-1).addAccount();

                    break;

                case 2:
                    searchDisplay(accountArray);
                    break;

                case 3:
                    depositDisplay(accountArray);
                    break;

                case 4:
                    withdrawDisplay(accountArray);
                    break;
                case 5:
                    removeDisplay();
                    break;
                case 6:
                    System.out.println("Logout");
                    break;
                default:
                    System.out.println("Incorrect number entered");
            }
        }
        while (ch != 6);

    }
    /*Get Input for removing account number*/
    private void removeDisplay() {
        System.out.print(ENTER_ACCOUNT_NUMBER);
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
        System.out.print(ENTER_ACCOUNT_NUMBER);
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
            System.out.println(NOT_EXIST);
        }
    }
}
