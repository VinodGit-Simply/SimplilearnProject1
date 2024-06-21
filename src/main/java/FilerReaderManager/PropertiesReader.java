package FilerReaderManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    // *** this class not in use *** //
  private  static String configProperties_path = "src/main/resources/config.properties";
    public Properties ReadProperties() throws IOException {

        Properties prop = new Properties();
        File fil = new File(configProperties_path);
        FileInputStream fis = new FileInputStream(fil);
        prop.load(fis);
        fis.close();

        return  prop;

    }


}
