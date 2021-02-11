package main;
import exception.InValidInputException;
import registeration.Login;
import registeration.Register;
import registeration.Validation;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void startDisplay(){
        logger.info("Select 1 for Register");
        //System.out.println("Select 1 for Register");
        logger.info("Select 2 for login");
       // System.out.println("Select 2 for login");
        logger.info("Select 3 for Exit");
    }

    /**
     * @param reg is to store registered users in array
     *            this method asks user to enter username and password
     */
    public static void registerDisplay(ArrayList<Register> reg){

        logger.info("Enter userName with at least 5 letters and at most 8 letter");


        String user = sc.nextLine();
        if(!Validation.validUsernameCheck(user)){

                throw new InValidInputException("Enter a Valid UserName");

        }
        else {
            logger.info("Enter Password with at least 5 letters and at most 8 letter");
            String pass = sc.nextLine();
            if (!Validation.validPasswordCheck(pass)){

                    throw new InValidInputException("Enter a Valid PassWord");
                }


            else {
                reg.add(new Register(user, pass));

                logger.info("Registerd");
            }
        }
    }

    /**
     * this method asks user to enter username and password and sends to passWordCheck method to
     * to check whether user has registered or not
     */
    public static void loginDisplay(ArrayList<Register> reg,ArrayList<Login>loginArray){

        logger.info("Enter UserName");
        String user = sc.nextLine();
        logger.info("Enter Password");
        String pass = sc.nextLine();
        if(reg.isEmpty()){
            logger.info("No user Exist");
        }

        passWordCheck(user,pass,reg,loginArray);
    }

    /**
     * This method checks whether username and password exists in reg array and if user has once
     * logged in we pushed the login object in login array to remember the user in main memory
     * else its data would be lost if he logs out
     */
    public static void passWordCheck(String user, String pass, ArrayList<Register> reg, ArrayList<Login> loginArray){
        boolean exist = false;//exist is used for remembering the user if it has login successfully
        // and its object will be present in main memory stored in loginArray so that when user logout out
        // and again come back data is not deleted
        boolean enter = false;
        for (int i = 0; i < reg.size(); i++) {

            if(reg.get(i).getUsername().equals(user)  && reg.get(i).getPassword().equals(pass)){
                logger.info("Entered");
                enter = true;
                exist = userOnceloggedIn(user,loginArray);

                if(!exist){
                    Login temp_login = new Login(user);
                    temp_login.success();
                    loginArray.add(temp_login);

                }

            }
            else if(reg.get(i).getUsername().equals(user)  && !reg.get(i).getPassword().equals(pass)){
                enter = true;
                logger.info("IncorrectPassword");
            }

            if (i== reg.size()-1 && !enter){
                logger.info("UserNotRegistered");
            }

        }
    }

    /**
     * this method returns true if once any user login for first time
     */
    private static boolean userOnceloggedIn(String user,ArrayList<Login> loginArray) {
        boolean exist = false;
        for (int j  = 0;j<loginArray.size();j++) {
            if (loginArray.get(j).username.equals(user)){
                exist = true;
                loginArray.get(j).success();
                break;
            }
        }
        return exist;
    }

    public static void main(String[] args) {
        ArrayList<Register> reg = new ArrayList<>();
        ArrayList<Login> loginArray = new ArrayList<>();


        Scanner sc= new Scanner(System.in);

        int ch;

        do {
            startDisplay();
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    try {
                        registerDisplay(reg);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        loginDisplay(reg, loginArray);
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