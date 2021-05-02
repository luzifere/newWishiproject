package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader
{
    private Properties properties;

    //private final String propertyFilePath= "configs//ConfigurationProd.properties";
    private final String propertyFilePath = System.getProperty("user.dir") +"/src/main/java/configs/Configuration.properties";

    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }
    public String getStylistName(){
        String driverPath = properties.getProperty("Stylist");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("Stylist not specified in the Configuration.properties file.");
    }
    public String getCardNumber(){
        String driverPath = properties.getProperty("cardnumber");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("cardnumber not specified in the Configuration.properties file.");
    }
    public String getCardDate(){
        String driverPath = properties.getProperty("date");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("carddate not specified in the Configuration.properties file.");
    }
    public String getCardCVC(){
        String driverPath = properties.getProperty("cvc");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("cvc not specified in the Configuration.properties file.");
    }
    public String getcopun(){
        String driverPath = properties.getProperty("cupon");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("cvc not specified in the Configuration.properties file.");
    }
    public String getnewusermaile(){
        String driverPath = properties.getProperty("newusermaile");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("cvc not specified in the Configuration.properties file.");
    }
    public String getnewusername(){
        String driverPath = properties.getProperty("username");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("cvc not specified in the Configuration.properties file.");
    }
    public String getpassword(){
        String driverPath = properties.getProperty("password");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("cvc not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

}
