package fabioclmendonca.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DasaNossasMarcas {

	private WebDriver driver;
	private final String REGION_SELECT = "//select[@name='locations']";
	
	@FindBy(xpath = REGION_SELECT)
    private WebElement regiaoSelect;
	
	@FindBy(xpath =  "//h3[text()='São Paulo']")
	private WebElement saoPauloHeader;
	
	@FindBy(xpath =  "//picture//ancestor::div[@tabindex=0]/a")
	private List<WebElement> brands;
	
	private String dynamicBrand = "//picture//ancestor::div[@tabindex=0]/a[contains(@href,\'{0}\')]";

	public DasaNossasMarcas(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectOption(String option) {
		WebDriverWait wait = new WebDriverWait(this.driver, 10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REGION_SELECT)));
		Select region = new Select(regiaoSelect);
		region.selectByValue(option);
	}

	public List<WebElement> GetBrands() {
		return brands;
	}

	public void selectCompany(String url) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saoPauloHeader);
		WebElement brand = driver.findElement(By.xpath(dynamicBrand.replace("{0}", url)));
		brand.click();
	}
}
