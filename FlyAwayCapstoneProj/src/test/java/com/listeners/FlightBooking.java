package com.listeners;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightBooking {
	 WebDriver driver;
		@Test
		public void Registrationpage() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jsahani\\install\\Selenium\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/FlyAway/signup");
			driver.manage().window().maximize();
		}
		@Test(dependsOnMethods = "Registrationpage")
		public void Clicks_signup() {
			WebElement email_id1 = driver.findElement(By.name("email_id"));
			email_id1.sendKeys("jsahanii@user.com");
			WebElement password = driver.findElement(By.name("pwd"));
			password.sendKeys("user");
			WebElement password2 = driver.findElement(By.name("pwd2"));
			password2.sendKeys("user");
			WebElement name1 = driver.findElement(By.name("name"));
			name1.sendKeys("jashwant");
			WebElement address1 = driver.findElement(By.name("address"));
			address1.sendKeys("Nerul4");
			WebElement city1 = driver.findElement(By.name("city"));
			city1.sendKeys("Navi-Mumbai");	
			driver.findElement(By.xpath("//button[text()='Signup']")).click();
		}
		@Test(dependsOnMethods = "Clicks_signup")
		public void homepage() {
			driver.findElement(By.xpath("//a[contains(text(), 'Login to continue checking flights')]")).click();
			
			}
		@Test(dependsOnMethods = "homepage")
		public void login_successfully() {
			driver.findElement(By.name("email_id")).sendKeys("user@user.com");
			driver.findElement(By.name("pwd")).sendKeys("user");
			driver.findElement(By.xpath("//button[text()='Login']")).click();
		}
		@Test(dependsOnMethods = "login_successfully")
		public void Flight_Booking_Details() {
			driver.findElement(By.xpath("//a[text()='Home']")).click();
			driver.findElement(By.xpath("//html/body/table/tbody/tr[3]/td[6]/a")).click();
			driver.findElement(By.xpath("//a[text()='Click to complete booking']")).click();
			driver.findElement(By.xpath("//a[text()='See Your Bookings']")).click();
		
	
		}
}
