package Practise_10_08.selenium_practise_10;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public class verizon_signin {
	protected static String url="https://www.verizon.com/";
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	  System.out.println("Title of the page : "+driver.getTitle());
	  System.out.println("Page url : "+driver.getCurrentUrl());
	  WebElement myaccount=driver.findElement(By.xpath("(//button[@class='gnav20-sign-in gnav20-hasDropdown  '])[1]"));
	  myaccount.click();
	  WebElement signaccount=driver.findElement(By.xpath("//a[normalize-space()='Sign in to My Account']"));
	  signaccount.click();
	  WebElement newuser=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='registerLink']")));
	  newuser.click();
//	  WebElement mobile5GHome = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Mobile & 5G Home')]")));
//	  mobile5GHome.click();
	  Thread.sleep(3000);
  }
  @BeforeClass
  public void beforeClass() {
	  driver.get(url);
  }

  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterSuite
  public void afterSuite() {
	  if(driver!=null) {
		  driver.quit();
	  }
  }

}
