package com.selenium.grid.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Main {

	private WebDriver driver;
	private DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

	@Parameters("browserName")
	@BeforeTest
	public void launch(String browserName) throws MalformedURLException {

		if (browserName.equals("chrome")) {
			desiredCapabilities.setPlatform(Platform.ANY);
			desiredCapabilities.setBrowserName(browserName);

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.merge(desiredCapabilities);
		} else if (browserName.equals("MicrosoftEdge")) {
			desiredCapabilities.setPlatform(Platform.ANY);
			desiredCapabilities.setBrowserName(browserName);

			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.merge(desiredCapabilities);
		}

		driver = new RemoteWebDriver(new URL("http://10.0.0.164:4444"), desiredCapabilities);
		driver.get("https://www.google.com");

	}

	@Test
	public void testCase01() {
		String title = driver.getTitle();
		Assert.assertEquals("Google", title);

	}

}
