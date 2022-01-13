package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class OpenEmr {

	@Test
	public void CreatePatient() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.openemr.io/a/openemr");
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[1]/div[1]/div[4]/button/i")).click();
		Actions act = new Actions (driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/div/div[5]/div/div"))).perform();
		driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/div/div[5]/div/ul/li[2]/div")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"framesDisplay\"]/div[3]/iframe")));
		Select Sal = new Select(driver.findElement(By.id("form_title")));
		Sal.selectByValue("Ms.");
		driver.findElement(By.id("form_fname")).sendKeys("Firstname");
		driver.findElement(By.id("form_lname")).sendKeys("Lastname");
		driver.findElement(By.id("form_DOB")).sendKeys("2022-01-11");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/table/tbody/tr[3]/td[3]/div")).click();
		//driver.findElement(By.className("xdsoft_today")).click(); (Selecting date by classname)
		Select gender = new Select(driver.findElement(By.id("form_sex")));
		gender.selectByValue("Female");
		driver.findElement(By.id("create")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("modalframe")));
		driver.findElement(By.xpath("//*[@id=\"searchResultsHeader\"]/center/input")).click();
		driver.switchTo().defaultContent();
		//Thread.sleep(4000);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		//driver.switchTo().frame(driver.findElement(By.id("logoutinnerframe")));
		//driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[@id=\"bdayreminder\"]/div/div/div[1]")).click();
		act.moveToElement(driver.findElement(By.id("username"))).perform();
		Thread.sleep(3000);
		//driver.switchTo().frame(driver.findElement(By.id("logoutinnerframe")));
		driver.findElement(By.xpath("//*[@id=\"userdropdown\"]/li[4]")).click();
	}

	
}


