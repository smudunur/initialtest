package initialtest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class browser {

	
	
		@Test
		public void browserinvocating() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Nagaraju Mudunuri\\Desktop\\IPod\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.homedepot.com/");
		driver.findElement(By.xpath(".//*[@id='headerSearch']")).sendKeys("hammer");
		Thread.sleep(3000L);
		WebDriverWait wd = new WebDriverWait(driver,10);
		//wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='typeAheadFlyOut']/div[1]/ul/li[2]/a/b")));
		//driver.findElement(By.xpath(".//*[@id='headerSearch']")).sendKeys(Keys.ENTER);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath(".//*[@id='headerSearchButton']"))).click().build().perform();
		wd.until(ExpectedConditions.titleContains("Search Results"));
		int count= driver.findElements(By.xpath(".//*[@class='alert-inline alert-inline--warning']")).size();
		System.out.println(count);
		//driver.findElement(By.id("typeAheadFlyOut")).click();
		// 
		for(int i=1;i<24;i++){
			//System.out.println(driver.findElement(By.xpath(".//*[@id='products']/div/div["+i+"]")).getText());
			if(driver.findElement(By.xpath(".//*[@id='products']/div/div["+i+"]")).getText().contains("Not at your store")){
				
				driver.findElement(By.xpath(".//*[@id='products']/div/div["+i+"]/div/div[11]/div/a/span")).click();
				break;
				
			}
			
		}
		//Thread.sleep(3000L);
		int countoframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println(countoframes);
		driver.switchTo().frame(countoframes-1);
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='root']/div/div/div/header/div/div[2]/div/div[1]/a")));
		driver.findElement(By.xpath(".//*[@id='root']/div/div/div/header/div/div[2]/div/div[1]/a")).click();
		
		Thread.sleep(3000L);
		driver.switchTo().defaultContent();
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='headerCart']")));
		driver.findElement(By.xpath(".//*[@id='headerCart']")).click();
		wd.until(ExpectedConditions.titleContains("Shopping Cart"));
		int pricedisplayed=driver.findElements(By.className("price")).size();
		if(pricedisplayed==1){
			
			System.out.println("Price is displayed");
		}
		
		
		

		}
		

	

}
