package autoread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AutoRead {
    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream("abc");
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
