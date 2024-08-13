package proleed_academy_exercise_1;

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

public class proleed_academy_exercise_1 {
	protected static String url="https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php";
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	  System.out.println("title of page: "+driver.getTitle());
	  System.out.println("Page source : "+driver.getCurrentUrl());
	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys("Harini@gmail.com");
	  WebElement password=driver.findElement(By.id("password"));
	  password.sendKeys("Harini@12345");
	  WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].click();", submit);
	
	  WebElement aftersubmit=driver.findElement(By.xpath("//html//body//div[@class='row']//div[@class='col-md-8']"));
	  System.out.println("After submit : "+aftersubmit.getText());
	  WebElement back=driver.findElement(By.xpath("//a[normalize-space()='Back to Home Page']"));
	  back.click();
	  Thread.sleep(1000);
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
