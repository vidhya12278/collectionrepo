package practice;

import org.testng.annotations.DataProvider;

public class Maintaing {
	@DataProvider(name="search")
	public static  Object[][] data()
	{
	return new Object[][] {
	{"sling bag for girls"},
	{"laptop bags for women"}
	};
	}
}
