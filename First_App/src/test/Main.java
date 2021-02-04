package test;
import registeration.Login;
import registeration.Register;

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
        System.out.println("Enter userName");
        String user = sc.nextLine();
        System.out.println("Enter Password");
        String pass = sc.nextLine();
        reg.add(new Register(user,pass));

        System.out.println("Registerd");

    }

    public static void loginDisplay(ArrayList<Register> reg,ArrayList<Login>loginArray){
        System.out.println("Enter userName");
        String user = sc.nextLine();
        System.out.println("Enter Password");
        String pass = sc.nextLine();
        if(reg.isEmpty()){
            System.out.println("UserNotRegistered");;
        }
        for (int i = 0; i < reg.size(); i++) {

            boolean exist = false;
            boolean enter = false;
            System.out.println(reg.get(i).getUsername());
            System.out.println(reg.get(i).getPassword());

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