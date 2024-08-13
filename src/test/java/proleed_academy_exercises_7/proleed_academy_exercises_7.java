package proleed_academy_exercises_7;

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

public class proleed_academy_exercises_7 {
	protected static String url="https://proleed.academy/exercises/selenium/emi-calculator-for-home-loan.php";
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  
	  WebElement loanamount=driver.findElement(By.id("loanamount"));
	  loanamount.sendKeys("100000");
	  
	  WebElement loaninterest=driver.findElement(By.id("loaninterest"));
	  loaninterest.sendKeys("2%");
	  
	  WebElement loanterm=driver.findElement(By.id("loanterm"));
	  loanterm.sendKeys("12");
	  
	  WebElement calculate=wait.until(ExpectedConditions.elementToBeClickable(By.id("calculator")));
	  js.executeScript("arguments[0].click()", calculate);
	  
	  
	  WebElement emi=wait.until(ExpectedConditions.elementToBeClickable(By.id("emi")));
	  String emivalue=emi.getAttribute("value");
	  System.out.println("The value is ::"+emivalue);
	  
	  String expected="8424";
	  
	  if(emivalue.equals(expected)) {
		  System.out.println("Pass");
	  }else {
		  System.out.println("Fail");
	  }
	  
	  Thread.sleep(2000);
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
	  if(driver!=null) {
		  driver.quit();
	  }
  }
}
