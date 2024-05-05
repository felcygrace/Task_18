import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DropandDrag {
	
	public DropandDrag() {
		//set system property for the chrome browser
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\FELCY\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			}
	public void drangAndDropFunction() {
		//initialize chrome driver 
		WebDriver driver = new ChromeDriver();
		//Maximizing the window 
				driver.manage().window().maximize();
				
				//Using ImplicitlyWait for page to wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			 
				//Navigating the URL
				driver.get("https://jqueryui.com/droppable/");
			
				//Using Actions for drag and drop
				Actions mouse =new Actions(driver);         
			
				//Using switchTo for index
				driver.switchTo().frame(0);
			
				//Finding dragged element
				WebElement drag = driver.findElement(By.id("draggable"));       
			
				//Finding dropped element
				WebElement drop = driver.findElement(By.id("droppable"));
				
				
				String BeforeColor = drop.getCssValue("background-color");
				System.out.println("Before Dragging: "+BeforeColor);
			
				//Performing drag and drop 
				mouse.dragAndDrop(drag, drop).perform(); 
				
				String afterColor = drop.getCssValue("background-color");
				System.out.println("After Dragging: " +afterColor);
				
				//Using getText to verify the action
				String droppedtext = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();  

				//Printing the message
				System.out.println(droppedtext);  
				
				if (droppedtext.equals("Dropped!") && afterColor.equals("rgba(255, 250, 144, 1)")) 
				{
					System.out.println("Drag & Drop Operation success");				
							
				} 
				else 
				{
					System.out.println("Drag & Drop Operation failed");
				}
					
				//Closing the driver
				driver.close();
		
	}
public static void main(String args[]) {
	DropandDrag dropanddrag = new DropandDrag();
	dropanddrag.drangAndDropFunction();
	
}
}