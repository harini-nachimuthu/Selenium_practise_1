package proleed_academy_exercises_4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class proleed_academy_exercises_4 {
	protected static String url="https://proleed.academy/exercises/selenium/automate-the-signup-form-using-selenium-webdriver.php";
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  WebElement firstname=driver.findElement(By.name("firstname"));
	  firstname.sendKeys("Harini");
	  
	  WebElement lastname=driver.findElement(By.name("lastname"));
	  lastname.sendKeys("N");
	  
	  WebElement gender=wait.until(ExpectedConditions.elementToBeClickable(By.id("female")));
	  js.executeScript("arguments[0].click()",gender);	  
	  
	  
	  Select experience=new Select(driver.findElement(By.name("experience")));
	  experience.selectByVisibleText("1");
	  
	  WebElement date=driver.findElement(By.id("date"));
	  date.sendKeys("19-06-2024");
	  
	  WebElement tester=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body//div[3]//div[2]//div//form//div[6]//div//div[2]//input")));
	  js.executeScript("arguments[0].click()",tester);	 	  
	  
	  List<WebElement> skills=driver.findElements(By.name("skills"));
	  System.out.println("check boxes :: "+skills.size());
	  
	  for(int i=0;i<skills.size();i++) {
		  if(i>=3 &&i<=5) {
			  WebElement skill=skills.get(i);
			  js.executeScript("arguments[0].scrollIntoView(true)", skill);
			  wait.until(ExpectedConditions.elementToBeClickable(skill));
			  js.executeScript("arguments[0].click()", skill);
		  }
		  
	  }
	  
	  Select country=new Select(driver.findElement(By.name("country")));
	  country.selectByVisibleText("India");
	  
	  WebElement picture=driver.findElement(By.id("photo"));
	  picture.sendKeys("C:\\Users\\harin\\OneDrive\\Pictures\\hello.jpeg");
	  
	  WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.id("add")));
	  js.executeScript("arguments[0].click()", submit);
	  
	  Alert al=driver.switchTo().alert();
	  System.out.println(al.getText());
	  
	  if(al.getText().trim().equalsIgnoreCase("Form submitted")) {
		  System.out.println("Yes alert msg is same");
	  }else {
		  System.out.println("No alert msg is not same");
	  }
	  al.accept();
	  Thread.sleep(3000);
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
