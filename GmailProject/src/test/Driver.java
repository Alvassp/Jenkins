package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    private static Properties properties = null;

    private static void setDriver(WebDriver driver){
        Driver.driver = driver;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void initDriver(){
        FileInputStream fis;
        try {
            fis = new FileInputStream("props.properties");
            properties.load(fis);
        }catch (IOException e){
            e.getCause();
        }

        Enumeration<String> enumeration = (Enumeration<String>)properties.propertyNames();
        while (enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
            System.setProperty(key, properties.getProperty(key));
        }
        Driver.setDriver(new FirefoxDriver());
        getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(System.
                getProperty("TIME_OUT")), TimeUnit.SECONDS);
    }

    public void tearDown(){
        getDriver().quit();
    }
}
