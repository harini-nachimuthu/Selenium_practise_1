package newtours_demoaut.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newtours_demoaut {
	protected static String url="https://demo.guru99.com/test/newtours/";
	WebDriver driver;
  @Test(priority=1)
  public void f() throws InterruptedException {
	  System.out.println("Title of page : "+driver.getTitle());
	  System.out.println("URL of page : "+driver.getCurrentUrl());
	  WebElement sigin_check=driver.findElement(By.xpath("//a[@href='login.php']"));
	  if(sigin_check.isEnabled()) {
		  System.out.println("Yes link is visible");
	  }else {
		  System.out.println("No,link is not visible");
	  }
	  WebElement register_check=driver.findElement(By.xpath("//a[@href='register.php']"));
	  if(register_check.isEnabled()) {
		  System.out.println("Yes register link is visible");
	  }else {
		  System.out.println("No,register link is not visible");
	  }
	  WebElement support_check=driver.findElement(By.xpath("//a[.='SUPPORT']"));
	  if(support_check.isEnabled()) {
		  System.out.println("Yes support link is visible");
	  }else {
		  System.out.println("No,support link is not visible");
	  }
	  WebElement contact_check=driver.findElement(By.xpath("//a[.='CONTACT']"));
	  if(contact_check.isEnabled()) {
		  System.out.println("Yes contact link is visible");
	  }else {
		  System.out.println("No,contact link is not visible");
	  }
	  register_check.click();
	  WebElement firstname=driver.findElement(By.name("firstName"));
	  firstname.sendKeys("Vaishnavi");
	  WebElement lastname=driver.findElement(By.name("lastName"));
	  lastname.sendKeys("Sridhar");
	  WebElement phone=driver.findElement(By.name("phone"));
	  phone.sendKeys("6589203454");
	  WebElement email=driver.findElement(By.name("userName"));
	  email.sendKeys("Vaishnavi@gmail.com");
	  WebElement address=driver.findElement(By.name("address1"));
	  address.sendKeys("No-1 First street");
	  WebElement city=driver.findElement(By.name("city"));
	  city.sendKeys("Chennai");
	  WebElement state=driver.findElement(By.name("state"));
	  state.sendKeys("TamilNadu");
	  WebElement postalCode=driver.findElement(By.name("postalCode"));
	  postalCode.sendKeys("600 025");
	  WebElement country=driver.findElement(By.name("country"));
	  country.click();
	  WebElement country_option=driver.findElement(By.xpath("//option[@value='INDIA']"));
	  country_option.click();
	  WebElement username=driver.findElement(By.name("email"));
	  username.sendKeys("Vaishnavi@gmail.com");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("newtours@1234");
	  WebElement confirm_password=driver.findElement(By.name("confirmPassword"));
	  confirm_password.sendKeys("newtours@1234");
	  WebElement submit=driver.findElement(By.name("submit"));
	  submit.click();
	  WebElement status=driver.findElement(By.xpath("//body//div[@style='margin-left:20px;']//table//tbody//tr//td[2]//table//tbody//tr[4]//td//table//tbody//tr//td[2]//table//tbody//tr[3]//td"));
	  String output=status.getText();
	  System.out.println(output);
	  System.out.println("================================");
	  Thread.sleep(3000);
  }
  @Test(priority=2)
  public void login() throws InterruptedException {
	  WebElement sigin_check=driver.findElement(By.xpath("//a[@href='login.php']"));
	  sigin_check.click();
	  WebElement username=driver.findElement(By.name("userName"));
	  username.sendKeys("Vaishnavi@gmail.com");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("newtours@1234");
	  WebElement submit=driver.findElement(By.name("submit"));
	  submit.click();
	  WebElement status=driver.findElement(By.xpath("//html//body//div//table//tbody//td[2]//table//tbody//tr[4]"));
	  String output=status.getText();
	  System.out.println(output);
	  System.out.println("================================");
	  System.out.println("Title of page : "+driver.getTitle());
	  System.out.println("URL of page : "+driver.getCurrentUrl());
	  WebElement home=driver.findElement(By.xpath("//a[.='Home']"));
	  home.click();
	  WebElement flight=driver.findElement(By.xpath("//a[.='Flights']"));
	  flight.click();
	  WebElement flight_finder=driver.findElement(By.xpath("//input[@name=\"findFlights\"]"));
	  flight_finder.click();
	  System.out.println("================================");
	  WebElement flight_status=driver.findElement(By.xpath("//html//body//div//table//tbody//td[2]//table//tbody//tr[4]"));
	  String flight_status_str=flight_status.getText();
	  System.out.println(flight_status_str);
	  System.out.println("================================");
	  WebElement backhome=driver.findElement(By.xpath("//img[@src=\"images/home.gif\"]"));
	  backhome.click();
	  WebElement sigin_feature=driver.findElement(By.xpath("//b[.='sign-in here']"));
	  if(sigin_feature.isSelected()) {
		  System.out.println("Yes feature is visible");
	  }else {
		  System.out.println("No,feature is not visible");
	  }
	  WebElement flight1=driver.findElement(By.xpath("//a[.='Flights']"));
	  flight1.click();
	  WebElement signoff=driver.findElement(By.xpath("//a[.='SIGN-OFF']"));
	  signoff.click();
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
