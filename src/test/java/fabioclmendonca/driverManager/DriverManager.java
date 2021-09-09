package fabioclmendonca.driverManager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void createDriver();

    public void quitDriver() {
        if (null != this.driver) {
        	this.driver.quit();
        	this.driver = null;
        }
    }

    public WebDriver getDriver() {
        if (null == this.driver) {
            createDriver();
        }
        return this.driver;
    }
}
