package com.saucelabs.rdc;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

@RunWith(RdcAppiumSuite.class)
@Rdc(apiKey = "7CDE94EFFE3E4EF4A773DB2728688C53", suiteId = 61)
public class RdcAppiumSuiteWatcherTest {

	@Rule
	public RdcAppiumSuiteWatcher watcher = new RdcAppiumSuiteWatcher();
	private AppiumDriver driver;

	@Before
	public void setup() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(RdcCapabilities.API_KEY, watcher.getApiKey());
		capabilities.setCapability(RdcCapabilities.TESTOBJECT_TEST_REPORT_ID, watcher.getTestReportId());

		driver = new AndroidDriver(watcher.getAppiumEndpointURL(), capabilities);
		watcher.setRemoteWebDriver(driver);

		printUsefulLinks();
	}

	@Test
	public void getPageSource() {
		System.out.println(driver.getPageSource());
	}

	private void printUsefulLinks() {
		System.out.println("Live view: " + driver.getCapabilities().getCapability(RdcCapabilities.TEST_LIVE_VIEW_URL));
		System.out.println("Test report: " + driver.getCapabilities().getCapability(RdcCapabilities.TEST_REPORT_URL));
	}
}

