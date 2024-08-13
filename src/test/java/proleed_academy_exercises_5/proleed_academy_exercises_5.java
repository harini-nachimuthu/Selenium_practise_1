package proleed_academy_exercises_5;

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

public class proleed_academy_exercises_5 {
	protected static String url="https://proleed.academy/exercises/selenium/hotel-reservation-form-for-practice.php";
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  WebElement firstname=driver.findElement(By.id("firstname"));
	  firstname.sendKeys("Harini");
	  
	  WebElement lastname=driver.findElement(By.id("lastname"));
	  lastname.sendKeys("N");
	  
	  WebElement address1=driver.findElement(By.name("address1"));
	  address1.sendKeys("No-1 Street anna1 nagar");
	  
	  WebElement address2=driver.findElement(By.name("address2"));
	  address2.sendKeys("No-2 Street anna2 nagar");
	  
	  WebElement city=driver.findElement(By.id("city"));
	  city.sendKeys("Chennai");
	  
	  WebElement state=driver.findElement(By.id("state"));
	  state.sendKeys("Tamil Nadu");
	  
	  WebElement zipcode=driver.findElement(By.id("zipcode"));
	  zipcode.sendKeys("600 024");
	  
	  WebElement phone=driver.findElement(By.id("phone"));
	  phone.sendKeys("6005402499");
	  
	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys("Harini@gmail.com");
	  
	  WebElement checkdate=driver.findElement(By.id("checkindate"));
	  checkdate.sendKeys("19-08-2024");
	  
	  WebElement checktime=driver.findElement(By.id("checkintime"));
	  checktime.sendKeys("20:00");
	  
	  WebElement checkoutdate=driver.findElement(By.id("checkoutdate"));
	  checkoutdate.sendKeys("22-08-2024");
	  
	  WebElement checkouttime=driver.findElement(By.id("checkouttime"));
	  checkouttime.sendKeys("20:00");
	  
	  WebElement room=wait.until(ExpectedConditions.elementToBeClickable(By.id("deluxe")));
	  js.executeScript("arguments[0].click()", room);
	 
	  Select adults=new Select(driver.findElement(By.name("adults")));
	  adults.selectByVisibleText("4");
	  
	  Select child=new Select(driver.findElement(By.name("children")));
	  child.selectByVisibleText("4");
	  
	  WebElement proof=driver.findElement(By.id("idproof"));
	  proof.sendKeys("C:\\Users\\harin\\OneDrive\\Pictures\\id_proof.jpeg");
	  
	  WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.id("add")));
	  js.executeScript("arguments[0].click()", submit);
	  
	  Alert al=driver.switchTo().alert();
	  System.out.println("Alert text: "+al.getText());
	  if(al.getText().trim().equalsIgnoreCase("Thanks! Your booking is confirmed.")) {
		  System.out.println("Yes booking confirmed");
	  }else {
		  System.out.println("No booking not confirmed");
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
