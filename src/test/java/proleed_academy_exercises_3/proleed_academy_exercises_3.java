package proleed_academy_exercises_3;

import java.time.Duration;

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

public class proleed_academy_exercises_3 {
	protected static String url="https://proleed.academy/exercises/selenium/automation-practice-form-with-radio-button-check-boxes-and-drop-down.php";
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	  JavascriptExecutor js=(JavascriptExecutor) driver;
//	  js.executeScript("arguments[0].click()",prefix);	  
//	  WebElement prefixselect=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='ms.']")));
//	  js.executeScript("arguments[0].click()",prefixselect);
	  Select prefix=new Select(driver.findElement(By.xpath("//select[@id='prefix']")));
	  prefix.selectByVisibleText("Ms.");
	  
	  WebElement firstname=driver.findElement(By.id("firstname"));
	  firstname.sendKeys("Harini");
	  
	  WebElement lastname=driver.findElement(By.id("lastname"));
	  lastname.sendKeys("N");
	  
	  WebElement saving=wait.until(ExpectedConditions.elementToBeClickable(By.id("saving")));
	  js.executeScript("arguments[0].click()",saving);	
	  
	  WebElement fathername=driver.findElement(By.xpath("//input[@name='fathername']"));
	  fathername.sendKeys("Mani");
	  
	  WebElement mothername=driver.findElement(By.xpath("//input[@name='mothername']"));
	  mothername.sendKeys("latha");
	  
	  WebElement studentid=driver.findElement(By.id("studentid"));
	  js.executeScript("arguments[0].click()",studentid);
	  WebElement studentidnumber=driver.findElement(By.id("identity_number"));
	  studentidnumber.sendKeys("1028210011");
	  
	  WebElement gender=driver.findElement(By.id("female"));
	  js.executeScript("arguments[0].click()",gender);
	  
	  Select dobmonth=new Select(driver.findElement(By.id("dob_month")));
	  dobmonth.selectByVisibleText("November");
	  
	  Select dobdate=new Select(driver.findElement(By.id("dob_date")));
	  dobdate.selectByVisibleText("12");
	  
	  Select dobyear=new Select(driver.findElement(By.id("dob_year")));
	  dobyear.selectByVisibleText("2000");
	  
	  WebElement maritalstatus=driver.findElement(By.id("single"));
	  js.executeScript("arguments[0].click()",maritalstatus);
	 
	  Select country_code=new Select(driver.findElement(By.id("country_code")));
	  country_code.selectByVisibleText("India (+91)");
	  
	  WebElement mobilenumber=driver.findElement(By.id("mobile"));
	  mobilenumber.sendKeys("6589432312");
	  
	  Select nationalityselect=new Select(driver.findElement(By.id("nationality")));
	  nationalityselect.selectByVisibleText("Indian");
	  
	  WebElement address=driver.findElement(By.name("address"));
	  address.sendKeys("No-1 Street ,anna nagar");
	  
	  WebElement state=driver.findElement(By.id("state"));
	  state.sendKeys("Tamil Nadu");
	  
	  Select country=new Select(driver.findElement(By.id("country")));
	  country.selectByVisibleText("India");
	  
	  WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div[3]//div//div[2]//div//form//div[15]//div[2]//input[@value='Submit']")));
	  js.executeScript("arguments[0].click()",submit);
	  
	  String text=driver.findElement(By.xpath("//html/body//div[3]//div[2]")).getText();
	  System.out.println("After submit text : "+text);
	 
	  Thread.sleep(2000);
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
