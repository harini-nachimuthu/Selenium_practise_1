package proleed.academy_exercise_2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class proleed_academy_exercise_2 {
	protected static String url="https://proleed.academy/exercises/selenium/selenium-element-locators-practice-form.php";
	WebDriver driver;
  @Test
  public void f() {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	  WebElement fullname=driver.findElement(By.xpath("//input[@type='text']"));
	  fullname.sendKeys("Harini N");
	  WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
	  email.sendKeys("Harini@gmail.com");
	  WebElement message=driver.findElement(By.xpath("//textarea[@type='text']"));
	  message.sendKeys("proleed academy selenium practise questions...");
	  WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("arguments[0].click()",submit);
	  
  }
  @BeforeClass
  public void beforeClass() {
	  driver.get(url);
  }

  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions option = new ChromeOptions();
      option.addArguments("--disable-notifications");
      option.addArguments("--disable-popup-blocking");
      driver = new ChromeDriver(option);
//	  driver=new ChromeDriver();
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
