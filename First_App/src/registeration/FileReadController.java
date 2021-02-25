package registeration;

import PropertiesFileRead.FileRead;
import main.Main;

import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

public class FileReadController implements ReaderLogin {
    private final static Logger logger = Logger.getLogger(FileReadController.class.getName());

    public void read(ArrayList<Register> reg, ArrayList<AfterLogin>loginArray){
        try {
            Properties prop;
            prop = FileRead.readPropertiesFile("resources/input_file.properties");
            String user = prop.getProperty("username");
            String pass = prop.getProperty("password");
            Register person = new Register(user,pass);
            boolean personAdded = person.addPerson(reg,user,pass);
            if(personAdded){
                logger.info("Registered");
                LoginCheck checker = new LoginCheck();

                checker.loginDisplay(reg,loginArray,user,pass);
            }
            else {
                logger.info("Not Registered");
            }
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }
    }
}
