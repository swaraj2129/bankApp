package registeration;

import exception.InValidInputException;
import main.Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Register {

    Scanner sc= new Scanner(System.in);

    private String username;
    private String password;

    private final static Logger logger = Logger.getLogger(Register.class.getName());

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param reg is to store registered users in array
     *            this method asks user to enter username and password
     */
    public boolean addPerson(ArrayList<Register> reg,String user,String pass){


        //String user = sc.nextLine();
        if(!Validation.validUsernameCheck(user)){

            throw new InValidInputException("Enter a Valid UserName");

        }
        else {
            logger.info("Enter Password with at least 5 letters and at most 8 letter");
            //  String pass = sc.nextLine();
            if (!Validation.validPasswordCheck(pass)){

                throw new InValidInputException("Enter a Valid PassWord");
            }


            else {
                reg.add(new Register(user, pass));

                logger.info("Registerd");
                return true;
            }
        }
    }
}
