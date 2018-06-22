package com.saucelabs.rdc;

import java.net.MalformedURLException;
import java.net.URL;

public class RdcEndpoints {

	public static final String DEFAULT_API_ENDPOINT = "https://app.testobject.com/api";
	public static final String APPIUM_REST_PATH = "/rest/v2/appium";

	public static final URL DEFAULT_API_ENDPOINT_URL = getURL(DEFAULT_API_ENDPOINT);
	public static final URL US_ENDPOINT = getURL("https://us1.appium.testobject.com/wd/hub");
	public static final URL EU_ENDPOINT = getURL("https://eu1.appium.testobject.com/wd/hub");

	private static URL getURL(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
