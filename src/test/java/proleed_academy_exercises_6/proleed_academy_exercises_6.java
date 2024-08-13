package proleed_academy_exercises_6;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class proleed_academy_exercises_6 {
	protected static String url="https://proleed.academy/exercises/selenium/online-job-application-form.php";
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  WebElement name=driver.findElement(By.id("name"));
	  name.sendKeys("Harini N");
	  
	  WebElement email=driver.findElement(By.id("email"));
	  email.clear();
	  email.sendKeys("Harini@gmail.com");
	  
	  WebElement phone=driver.findElement(By.id("phone"));
	  phone.sendKeys("9845321065");
	  
	  Select position=new Select(driver.findElement(By.name("position")));
	  position.selectByVisibleText("Quality Analyst");
	  
	  WebElement unemployed=wait.until(ExpectedConditions.elementToBeClickable(By.id("unemployed")));
	  js.executeScript("arguments[0].scrollIntoView(true)", unemployed);
	  js.executeScript("arguments[0].click()", unemployed);
	  
	  
	  WebElement resume=wait.until(ExpectedConditions.elementToBeClickable(By.id("resume")));
	  resume.sendKeys("C:\\Users\\harin\\OneDrive\\Pictures\\rough_resume.jpg");
	  
	  Select platform=new Select(driver.findElement(By.name("platform")));
	  platform.selectByVisibleText("Google Search");
	  
	  WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.id("add")));
	  js.executeScript("arguments[0].click()", submit);
	  
	  Alert al=driver.switchTo().alert();
	  System.out.println("Alert message received:: "+al.getText());
	  
	  if(al.getText().trim().equalsIgnoreCase("Your application has been submitted")) {
		  System.out.println("Yes,application submitted...");
	  }else {
		  System.out.println("No,application not submitted...");
	  }
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
	  if(driver!=null) {
		  driver.quit();
	  }
  }
}
