package fabioclmendonca.pageObject;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class DasaHome {

	private WebDriver driver;
	private String somosDasaMenu = "//div[contains(@class,'eWFgbM')]//a[@label='Somos Dasa']/div";
	private String optionNossasMarcas = "//a[@label='Nossas Marcas']";

	public DasaHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void mouseOverMenuSomosDasa() {
		WebElement menuSomosDasa = driver.findElement(By.xpath(somosDasaMenu));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(menuSomosDasa));
	}

	public void clickOnNossasMarcasOption() {
		WebElement menuSomosDasa = driver.findElement(By.xpath(somosDasaMenu));
		WebElement nossasMarcasOption = driver.findElement(By.xpath(optionNossasMarcas));
		Actions action = new Actions(driver);
		action.moveToElement(menuSomosDasa).moveToElement(nossasMarcasOption).click().perform();
	}
}
