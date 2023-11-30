package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.TestListeners;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentSparkReporter spark;
	public static ExtentTest testcase;
	public static ExtentReports extentreport;

	public static WebDriver openBrowser(String browser) {

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			throw new WebDriverException("Invalid Browser: " + browser);

		}

		return driver;

	}

	public static ExtentReports createInstance() {

		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter(".//Myproject.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("MCaaS");
		extentreport.attachReporter(spark);
		extentreport.setSystemInfo("Project", "FrameworkCreation");
		extentreport.setSystemInfo("Operating System", "Windows 10");
		extentreport.setSystemInfo("Browser and Version", "Chrome 98");
		extentreport.setSystemInfo("Tester", "Varun");
		return extentreport;
	}

	public static void getScreenshots() {

		String timestamp = new SimpleDateFormat("MM_dd__hh_mm_ss").format(new Date());
		TakesScreenshot sourcefile = ((TakesScreenshot) driver);
		File srcFile = sourcefile.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".//Screenshots//" + timestamp + ".png");
		try {
			FileHandler.copy(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		TestListeners.extentTest.get().addScreenCaptureFromPath(".//Screenshots//" + timestamp + ".png");

	}

}
