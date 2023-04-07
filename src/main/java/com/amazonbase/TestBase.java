package com.amazonbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	FileInputStream fis;
	public static WebDriver driver;
	Properties prop;

	public void launchBrowser() {
		String fileName = ".\\src\\main\\resources\\config\\config.properties";

		try {
			fis = new FileInputStream(fileName);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		prop = new Properties();

		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();

	}

	public void navigateToURL() {

		driver.get(prop.getProperty("URL"));
	}

	public String captureScreenshort() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy_MM_dd_HH_mm_ss");
		String scrnShortName = "screenshot_" + sdf.format(date) + ".png";

		TakesScreenshot scrnShot = (TakesScreenshot) driver;
		File srcFile = scrnShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\Screenshots\\screenshot.png");

		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return scrnShortName;

	}

	public void wait(int msec) {

		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
