package com.LottomaniaAdmin.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.LottomaniaAdmin.qa.util.EventListener;
import com.LottomaniaAdmin.qa.util.TestUtil;


public class TestBase {

		
		public static WebDriver driver;
		public static Properties prop;
		public static EventFiringWebDriver e_driver;
		public static EventListener eventListner;

		public TestBase(){
			 try {
				prop = new Properties();
				 FileInputStream ip = new FileInputStream("C:\\Users\\akashd\\Test\\src\\main\\java\\com\\"
				 		+ "LottomaniaAdmin\\qa\\config\\config.prop");
				 prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void initialization() {
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")){
					System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
					driver = new ChromeDriver();
			}else if(browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "D://Selenium//Mozilla Driver//geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
			}else if(browserName.equals("IE")) {
				System.setProperty("webdriver.ie.driver", "D:\\Selenium\\IE Driver\\IEDriverServer.exe");
				WebDriver driver = new InternetExplorerDriver();
			}
			
			e_driver = new EventFiringWebDriver(driver);
			eventListner = new EventListener();
			e_driver.register(eventListner);
			driver = e_driver;
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
	}

