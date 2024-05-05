import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {
	public Facebook() {
		//set system property for the chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\FELCY\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	}
	public void launchFacebook() {
		//initialize chrome driver 
				WebDriver driver = new ChromeDriver();
				//open facebook url
				driver.get("https://www.facebook.com/");
				//maximize window
				driver.manage().window().maximize();
				// time wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				//the title of the page 
				String title = driver.getTitle();
				System.out.println("the current page title:  " +title);
				driver.findElements(By.linkText("Create new account"));
				//To find create a new account and click
				driver.findElement(By.linkText("Create new account")).click();
				
				//enter the First Name
				driver.findElement(By.name("firstname")).sendKeys("Felcy");			
				//enter theLast Name
				driver.findElement(By.name("lastname")).sendKeys("Singaraj");			
				//enter the Email
				driver.findElement(By.name("reg_email__")).sendKeys("felcygrace001@gmail.com");
				driver.findElement(By.name("reg_email_confirmation__")).sendKeys("felcygrace001@gmail.com");
				//enter the Password
				driver.findElement(By.id("password_step_input")).sendKeys("felcy@12s");
				
				//Using Select class to select the value
				WebElement day = driver.findElement(By.id("day"));     
				Select selectDay = new Select(day);
				selectDay.selectByVisibleText("12");		
				
				WebElement month = driver.findElement(By.id("month"));         
				Select selectMonth = new Select(month);
				selectMonth.selectByVisibleText("Dec");
			
				WebElement year = driver.findElement(By.id("year"));		
				Select selectYear = new Select(year);
				selectYear.selectByVisibleText("1998");
				
				//For clicking female radio button
				driver.findElement(By.xpath("//input[@name='sex'][1]")).click();
						 
				//Clicking submit button
				driver.findElement(By.name("websubmit")).click();
				// time wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				
			         
				    //To verify the page
					String verify = driver.findElement(By.xpath("//h2[@class='uiHeaderTitle' and text()='Enter security code']")).getText();			
					
					if (verify.equals("Enter security code")) 
					{
						System.out.println("Verification code sent to your registered Email");
					} 
					else 
					{
						System.out.println("Verification Failed");
					}
					
					//Closing the driver
					//driver.close();
						
	}

	public static void main(String[] args) {
		Facebook facebook = new Facebook();
		facebook.launchFacebook();

	}

}
