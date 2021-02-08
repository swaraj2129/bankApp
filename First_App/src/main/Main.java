package main;
import exception.InValidInputException;
import registeration.Login;
import registeration.Register;
import java.util.regex.*;

import java.util.Scanner;
import java.util.ArrayList;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void startDisplay(){
        System.out.println("Select 1 for Register");
        System.out.println("Select 2 for login");
        System.out.println("Select 3 for Exit");
    }

    public static void registerDisplay(ArrayList<Register> reg){
        String regex = "^[A-Za-z]\\w{4,8}$";
        Pattern username_check = Pattern.compile(regex);

        System.out.println("Enter userName with at least 4 letters and at most 8 letter");
        String user = sc.nextLine();
        Matcher m = username_check.matcher(user);
        if(!m.matches()){
            try {
                throw new InValidInputException("Enter a Valid UserName");
            }
            catch (InValidInputException e){
                System.out.println(e);
            }
        }
        else {
            System.out.println("Enter Password");
            String pass = sc.nextLine();
            reg.add(new Register(user, pass));

            System.out.println("Registerd");
        }
    }

    public static void loginDisplay(ArrayList<Register> reg,ArrayList<Login>loginArray){
        System.out.println("Enter userName");
        String user = sc.nextLine();
        System.out.println("Enter Password");
        String pass = sc.nextLine();
        if(reg.isEmpty()){
            System.out.println("No user Exist");
        }
        boolean exist = false;//exist is used for remembering the user if it has login successfully
                                // and its object will be present in main memory stored in loginArray so that when user logout out
                                // and again come back data is not deleted
         boolean enter = false;
        for (int i = 0; i < reg.size(); i++) {


            //System.out.println(reg.get(i).getUsername());
            //System.out.println(reg.get(i).getPassword());

            if(reg.get(i).getUsername().equals(user)  && reg.get(i).getPassword().equals(pass)){
                System.out.println("Entered");
                enter = true;
                for (int j  = 0;j<loginArray.size();j++) {
                    if (loginArray.get(j).username.equals(user)){
                        exist = true;
                        loginArray.get(j).success();
                        break;
                    }
                }
                if(!exist){
                    Login lotemp = new Login(user);
                    lotemp.success();
                    loginArray.add(lotemp);

                }

            }
            else if(reg.get(i).getUsername().equals(user)  && !reg.get(i).getPassword().equals(pass)){
                enter = true;
                System.out.println("IncorrectPassword");
            }

            if (i== reg.size()-1 && !enter){
                System.out.println("UserNotRegistered");
            }

        }
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
                    registerDisplay(reg);
                    break;
                case 2:
                    loginDisplay(reg,loginArray);
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