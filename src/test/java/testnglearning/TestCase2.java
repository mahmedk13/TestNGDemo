package testnglearning;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {

	@Test
	public void testValidateTitles() {

		String actual_title = "Yahoo.com";// driver.getTitle();
		String expected_title = "Gmail.com";

		System.out.println("Beginning");
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual_title, expected_title);
		softAssert.assertTrue(false, "Element not found");
		softAssert.fail("Failing the test case");
		/*try {
			Assert.assertEquals(actual_title, expected_title);
		} catch (Throwable t) {
			Assert.fail(t.getMessage());
		}

		try {
			Assert.assertTrue(false, "Element not found");
		} catch (Throwable t) {
			Assert.fail(t.getMessage());
		}
		try {
			Assert.fail("Failing the test case");
		} catch (Throwable t) {
			Assert.fail(t.getMessage());
		}
*/
		System.out.println("Ending");
		softAssert.assertAll();

		// isElementPresent(); //True or false

		/*
		 * if(actual_title.equals(expected_title)) {
		 * 
		 * System.out.println("Test case pass"); }else {
		 * 
		 * System.out.println("Test case fail"); }
		 */

	}
}
