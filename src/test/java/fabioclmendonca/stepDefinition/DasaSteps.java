package fabioclmendonca.stepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fabioclmendonca.driverManager.DriverManager;
import fabioclmendonca.driverManager.DriverManagerFactory;
import fabioclmendonca.driverManager.DriverType;
import fabioclmendonca.pageObject.DasaHome;
import fabioclmendonca.pageObject.DasaNossasMarcas;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DasaSteps {

	DriverManager driverManager;
	private WebDriver driver;
	private DasaHome home;
	private DasaNossasMarcas nossasMarcas;

	@Before
	public void setup() {
		this.driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		this.driver = this.driverManager.getDriver();
		this.home = new DasaHome(driver);
		this.nossasMarcas = new DasaNossasMarcas(driver);
	}

	@After
	public void teardown() {
		this.driverManager.quitDriver();
	}

	@Given("I Navigate To {string}")
	public void navigateToDasaPage(String url) {
		this.driver.get(url);
	}

	@Given("I Navigate To Companies Page")
	public void navigateToCompaniesPage() {
		home.mouseOverMenuSomosDasa();
		home.clickOnNossasMarcasOption();
	}

	@When("I Select {string} As Region")
	public void selectRegion(String option) throws Exception {
		nossasMarcas.selectOption(option);
	}

	@Then("I Print Filtered Companies URLs on console")
	public void printCompaniesURL() {
		for (WebElement brand : nossasMarcas.GetBrands()) {
			System.out.println(brand.getAttribute("href"));
		}
	}

	@When("I Select {string} Company")
	public void selectCompany(String url) throws InterruptedException {
		nossasMarcas.selectCompany(url);
	}

	@Then("I verify if I navigated to {string}")
	public void verifyLink(String url) throws InterruptedException {
		List<String> companyTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(companyTab.get(1));
		assert (url.equals(driver.getCurrentUrl()));
	}
}
