package StepDefn;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlyawayBookingsteps {

	public static WebDriver driver;

	@Given("Sam is on Registration page")
	public void sam_is_on_registration_page() {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jsahani\\install\\Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/FlyAway/signup");
		driver.manage().window().maximize();
		System.out.println("Sam is on the SignUp page");

	}

	@When("Sam enters {string},{string}, {string}, {string}, {string} and {string}")
	public void sam_enters_and(String emailid, String pwd, String pwd2, String name, String address, String city) {
		// Write code here that turns the phrase above into concrete actions
		WebElement email_id1 = driver.findElement(By.name("email_id"));
		email_id1.sendKeys(emailid);
		WebElement password = driver.findElement(By.name("pwd"));
		password.sendKeys(pwd);
		WebElement password2 = driver.findElement(By.name("pwd2"));
		password2.sendKeys(pwd2);
		WebElement name1 = driver.findElement(By.name("name"));
		name1.sendKeys(name);
		WebElement address1 = driver.findElement(By.name("address"));
		address1.sendKeys(address);
		WebElement city1 = driver.findElement(By.name("city"));
		city1.sendKeys(city);
		System.out.println("Sam Enters Registrations Details");

	}

	@When("Sam clicks on Signup")
	public void sam_clicks_on_signup() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Sam clicks on Signup");
		WebElement signup = driver.findElement(By.tagName("button"));
		signup.click();

	}

	@When("Sam should be able to check {string}")
	public void sam_should_be_able_to_check(String string) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Sam is able to Register successfully");
		List<WebElement> listLogin = driver.findElements(By.linkText("Login/Signup"));
		Assert.assertTrue(listLogin.size() > 0);
	}

	@Then("Sam should be navigated to booking")
	public void sam_should_be_navigated_to_booking() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Sam is navigated to home page");
		String strTitle = driver.getTitle();
		System.out.println(strTitle);

	}

	@Given("Sam is on the login page")
	public void sam_is_on_the_login_page() {
		// Write code here that turns the phrase above into concrete actions

		System.setProperty("webdriver.chrome.driver","C:\\Users\\jsahani\\install\\Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/FlyAway/login");
		driver.manage().window().maximize();
		System.out.println("Sam is on the login page");
	}

	@When("Sam enters {string} and {string}")
	public void sam_enters_and(String un, String pwd) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Sam Enters UN and PWD");
		WebElement username = driver.findElement(By.name("email_id"));
		username.sendKeys(un);
		WebElement password = driver.findElement(By.name("pwd"));
		password.sendKeys(pwd);
	}

	@When("Sam clicks on Login")
	public void sam_clicks_on_login() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Sam clicks on Login");
		WebElement login = driver.findElement(By.tagName("button"));
		login.click();
	}

	@When("Sam should be able to validate {string}")
	public void sam_should_be_able_to_validate(String string) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Sam should be able to login successfully");
		List<WebElement> listLogout = driver.findElements(By.linkText("Logout"));
		Assert.assertTrue(listLogout.size() > 0);
	}

	@Then("Sam should be navigated to homepage")
	public void sam_should_be_navigated_to_homepage() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Sam should navigate to home page");
		String strTitle = driver.getTitle();
		System.out.println(strTitle);
	}

	@Given("Sam has login with {string} and {string}")
	public void sam_has_login_with_and(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jsahani\\install\\Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/FlyAway/login");
		driver.manage().window().maximize();
		driver.findElement(By.name("email_id")).sendKeys(string);
		driver.findElement(By.name("pwd")).sendKeys(string2);
		driver.findElement(By.tagName("button")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Logout")));
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int listLogout = driver.findElements(By.linkText("Logout")).size();
		Assert.assertTrue(listLogout > 0);

	}

	@Given("Same has open home page")
	public void same_has_open_home_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Home")).click();

	}

	@When("Sam selects {string} as source and {string} as destination")
	public void sam_selects_as_source_and_as_destination(String Source, String Destination) {
		// Write code here that turns the phrase above into concrete actions
		Select selectsrc = new Select(driver.findElement(By.name("source")));
		Select selectDest = new Select(driver.findElement(By.name("destination")));
		selectsrc.selectByVisibleText(Source);
		selectDest.selectByVisibleText(Destination);
	}

	@When("Sam clicks on submit")
	public void sam_clicks_on_submit() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.tagName("button")).click();

	}

	@Then("Sam is able to validate for flight id {string} with msg {string}")
	public void sam_is_able_to_validate_for_flight_id_with_msg(String flightNo, String expMessage) {
		// Write code here that turns the phrase above into concrete actions
		List<WebElement> lstFlights = driver.findElements(By.linkText("Book Flight"));
		String actMsg = "Flight Not Present";
		for (WebElement flight : lstFlights) {
			System.out.println(flight.getAttribute("href"));
			System.out.println("Sam is able to validate for flight id");
			if (flight.getAttribute("href").contains("bookflight?id=" + flightNo)) {
				actMsg = "Flight Present";
				break;
			}
		}
        
		
	}
	
	
}



