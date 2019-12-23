package testtask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (threadDriver.get() == null) {
            initDriver();
        }
        return threadDriver.get();
    }

    private static void initDriver() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--incognito");
            WebDriverManager.chromedriver().setup();
            threadDriver.set(new ChromeDriver(options));
        }
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            threadDriver.set(new FirefoxDriver());
        }
        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            threadDriver.set(new EdgeDriver());
        }

        threadDriver.get().manage().window().fullscreen();
        threadDriver.get().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        threadDriver.get().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }



    public static void killDriver() {
        threadDriver.get().close();
        threadDriver.remove();
    }
}

