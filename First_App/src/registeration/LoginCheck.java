package registeration;

import java.util.ArrayList;
import java.util.logging.Logger;

public class LoginCheck {


    private final static Logger logger = Logger.getLogger(LoginCheck.class.getName());

    /**
     * this method asks user to enter username and password and sends to passWordCheck method to
     * to check whether user has registered or not
     */

    public void loginDisplay(ArrayList<Register> reg, ArrayList<AfterLogin>loginArray, String user, String pass){


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
    public void passWordCheck(String user, String pass, ArrayList<Register> reg, ArrayList<AfterLogin> loginArray){
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
                    AfterLogin temp_login = new AfterLogin(user);
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
    private  boolean userOnceloggedIn(String user,ArrayList<AfterLogin> loginArray) {
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
}
