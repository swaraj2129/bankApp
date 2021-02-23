package PropertiesFileRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class FileRead {
    private final static Logger logger = Logger.getLogger(FileRead.class.getName());

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            logger.info(fnfe.getMessage());
        } catch(IOException ioe) {
            logger.info(ioe.getMessage());
        } finally {
            fis.close();
        }
        return prop;
    }
}
