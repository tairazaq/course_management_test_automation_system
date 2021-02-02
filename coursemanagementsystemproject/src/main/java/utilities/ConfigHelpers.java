package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigHelpers {

     public String loadEnvProfileData(String Field) throws IOException {

         String profileData = " ";

         try {
             FileInputStream InputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/configurations/dev_env.properties");

             Properties properties = new Properties();
             properties.load(InputStream);

             profileData = properties.getProperty(Field);

         }catch (IOException e){
             System.out.print(e.getMessage());
             throw new RuntimeException("...... some issue while loading config properties");
         }
             return profileData;
     }

}
