package com.apex.samples;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.samples.core.ApexBaseChromeTest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ECommerceLoginPageTest_NG extends ApexBaseChromeTest implements EcommerceLoginConstant {

	
	@DataProvider(name = "dp1")
	public Object[][] getSignonSuccessfuldata_DP() throws Exception {
		// String[][] data = { { "user1", "pwd1" }, { "user2", "pwd2" }, { "", "pwd1" },
		// { "user1", "" }, { "", "" } };
		// return data;

		Object[][] retObjArr = getTableArray("C:\\Working\\shubhrata\\google_ids.xls", "Sheet1", "GoogleIds");
		return (retObjArr);
	}

	@Test (dataProvider = "dp1")
	public void testwithBlankCredentials(String emailid, String pwdd) {
		driver.findElement(By.name(EMAIL_NAME_LOCATOR)).sendKeys(emailid);
		driver.findElement(By.name(PASSWORD_NAME_LOCATOR)).sendKeys(pwdd);
		driver.findElement(By.linkText(LOGIN_LINK_LOCATOR)).click();

		Assert.assertEquals(driver.getTitle(), "Ez Shop Online");
		Assert.assertEquals(driver.getCurrentUrl(), "http://ecommerce.saipratap.net/customerlogin.php?cond=1");
	}

	@Test
	public void testwithBlankCredentials() {
		driver.findElement(By.name(EMAIL_NAME_LOCATOR)).sendKeys(TEST2_EMAIL_ID);
		driver.findElement(By.name(PASSWORD_NAME_LOCATOR)).sendKeys(PASSWORD_NAME_LOCATOR);
		driver.findElement(By.linkText(LOGIN_LINK_LOCATOR)).click();

		Assert.assertEquals(driver.getTitle(), "Ez Shop Online");
		Assert.assertEquals(driver.getCurrentUrl(), LOGIN_FAILURE_LINK_LOCATOR);
	}

	@Test
	public void testwithBlankUserId() {
		driver.findElement(By.name(EMAIL_NAME_LOCATOR)).sendKeys("");
		driver.findElement(By.name(PASSWORD_NAME_LOCATOR)).sendKeys(PASSWORD_NAME_LOCATOR);
		driver.findElement(By.linkText(LOGIN_LINK_LOCATOR)).click();

		Assert.assertEquals(driver.getTitle(), "Ez Shop Online");
		Assert.assertEquals(driver.getCurrentUrl(), LOGIN_FAILURE_LINK_LOCATOR);
	}

	@Test
	public void testwithBlankPassword() {
		driver.findElement(By.name(EMAIL_NAME_LOCATOR)).sendKeys("lockeduserid@gmail.com");
		driver.findElement(By.name(PASSWORD_NAME_LOCATOR)).sendKeys("");
		driver.findElement(By.linkText(LOGIN_LINK_LOCATOR)).click();

		Assert.assertEquals(driver.getTitle(), "Ez Shop Online");
		Assert.assertEquals(driver.getCurrentUrl(), LOGIN_FAILURE_LINK_LOCATOR);
	}

	@Test
	public void testwithLockedUserId() {
		driver.findElement(By.name(EMAIL_NAME_LOCATOR)).sendKeys(TEST2_EMAIL_ID);
		driver.findElement(By.name(PASSWORD_NAME_LOCATOR)).sendKeys(PASSWORD_NAME_LOCATOR);
		driver.findElement(By.linkText(LOGIN_LINK_LOCATOR)).click();

		Assert.assertEquals(driver.getTitle(), "Ez Shop Online");
		Assert.assertEquals(driver.getCurrentUrl(), LOGIN_FAILURE_LINK_LOCATOR);
	}

	public String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception {
		String[][] tabArray = null;

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		int startRow, startCol, endRow, endCol, ci, cj;
		Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();

		Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);

		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		System.out.println(
				"startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol + ", endCol=" + endCol);
		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;

		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}

		return (tabArray);
	}

}
