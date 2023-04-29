package basepackage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Timeutils;

import org.openqa.selenium.chrome.ChromeOptions;

public class BaseHRMClass {

	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	//Step 1 create constructor 
	public BaseHRMClass() {
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\16472\\eclipse-workspace\\HRManagemenet\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);
}
		catch(FileNotFoundException e) {
			System.out.println("We will be back-1");
	}
		catch(IOException a) {
			System.out.println("We will be back-2");
			
}}
		//Step2 
		public static void initiation() {
		String browsername=	prop.getProperty("browser");
			
		/*
		 * if(browsername.equals("Firefox")) {
		 * System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); driver=new
		 * FirefoxDriver(); }
		 */
			
		 if (browsername.equals("chrome"))  {
				System.setProperty("webdriver.chrome.driver","chrome.exe");
				driver=new ChromeDriver();
				ChromeOptions op=new ChromeOptions();
				op.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(op);
				
}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Timeutils.timepage, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
		}
		public static void screenshots(String Filename) {
	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	FileUtils.copyFile(file, new File("C:\\Users\\16472\\eclipse-workspace\\HRManagemenet\\src\\test\\java\\screenshot\\Screenshots"+Filename+".jpg"));
	
		}
	catch(IOException e) {
		e.printStackTrace();
	}
}}