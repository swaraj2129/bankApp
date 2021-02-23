package registeration;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class ManualDisplayView {
Scanner sc = new Scanner(System.in);
    private final static Logger logger = Logger.getLogger(ManualDisplayView.class.getName());

    public void startDisplay(){
        logger.info("Select 1 for Register");
        logger.info("Select 2 for login");
        logger.info("Select 3 for Exit");
    }

    public void loginDisplayInput(ArrayList<Register> reg, ArrayList<AfterLogin>loginArray){
        logger.info("Enter UserName");
        String user = sc.nextLine();
        logger.info("Enter Password");
        String pass = sc.nextLine();
        LoginCheck checker = new LoginCheck();

        checker.loginDisplay(reg,loginArray,user,pass);

    }

    public void registerDisplayInput(ArrayList<Register> reg){
        logger.info("Enter userName with at least 5 letters and at most 8 letter");
        String user = sc.nextLine();
        logger.info("Enter Password with at least 5 letters and at most 8 letter");
        String pass = sc.nextLine();
        Register person = new Register(user,pass);
        boolean personAdded = person.addPerson(reg,user,pass);
        if(personAdded){
            logger.info("Registered");
        }
        else {
            logger.info("Not Registered");
        }
    }

    public void display(ArrayList<Register> reg,ArrayList<AfterLogin>loginArray){
        int ch;
        do {
            startDisplay();
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    try {
                        registerDisplayInput(reg);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        loginDisplayInput(reg, loginArray);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                case 3:
                    exit(-1);
                    break;

                default:
                    exit(-1);
                    break;
            }
        }
        while (true) ;
    }
}
