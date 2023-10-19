package utility;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Utility {

    public static String path = System.getProperty("user.dir");

    public static Properties loadProp(){
        Properties prop = new Properties();
        try {
            InputStream inputStream = Files.newInputStream(Paths.get("C:\\Users\\PNT\\eclipse-workspace\\Aug2023SeleniumProject1\\src\\config.properties"));
            prop.load(inputStream);
            inputStream.close();
        }catch (Exception e){
            throw new RuntimeException();
        }
        return prop;
    }

    public static void main(String[] args) {

        Properties prop = Utility.loadProp();
        System.out.println(prop.getProperty("password"));
    }
}
