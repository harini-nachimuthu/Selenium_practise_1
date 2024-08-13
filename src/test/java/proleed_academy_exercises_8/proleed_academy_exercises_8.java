package proleed_academy_exercises_8;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class proleed_academy_exercises_8 {
	protected static String url="https://proleed.academy/exercises/selenium/online-payment-form-for-selenium-automation-practice.php";
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  
	  WebElement accountbalance=driver.findElement(By.id("accountBalance"));
	  String acntbalance=accountbalance.getAttribute("value");
	  System.out.println("account balance is :: "+acntbalance);
	  
	  WebElement paymentamount=driver.findElement(By.id("paymentAmount"));
	  paymentamount.sendKeys("45000");
	  
	  WebElement pay=wait.until(ExpectedConditions.elementToBeClickable(By.id("payButton")));
	  js.executeScript("arguments[0].click()", pay);
	  
	  
	  WebElement message=driver.findElement(By.id("message"));
	  String messagestr=message.getText();
	  System.out.println("Message recieved :: "+messagestr);
	  
	  WebElement paymentamountafter=driver.findElement(By.id("paymentAmount"));
	  paymentamountafter.clear();
	  paymentamountafter.sendKeys("450");
	  
	  WebElement payafter=wait.until(ExpectedConditions.elementToBeClickable(By.id("payButton")));
	  js.executeScript("arguments[0].click()", payafter);
	  
	  WebElement messageafter=driver.findElement(By.id("message"));
	  String messagestafterr=messageafter.getText();
	  System.out.println("Message recieved :: "+messagestafterr);
	  Thread.sleep(1000);
  }
  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
//	  ChromeOptions options = new ChromeOptions();
//	  options.addArguments("--disable-notifications");
//	  options.addArguments("--disable-popup-blocking");
//	  options.addArguments("--no-sandbox");
//	  options.addArguments("--disable-dev-shm-usage");
//	  options.addArguments("--remote-debugging-port=9222");
//	  driver = new ChromeDriver(options);
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @BeforeClass
  public void beforclass() {
	  driver.get(url);
  }

  @AfterSuite
  public void afterSuite() {
//	  if(driver!=null) {
//		  driver.quit();
//	  }
  }
}
