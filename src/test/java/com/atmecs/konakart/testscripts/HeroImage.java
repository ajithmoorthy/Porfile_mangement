package com.atmecs.konakart.testscripts;

import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.konakart.constants.FileConstants;
import com.atmecs.konakart.helper.ActionHelper;
import com.atmecs.konakart.logreports.LogReporter;
import com.atmecs.konakart.pages.HeroPage;
import com.atmecs.konakart.testbase.TestBase;
import com.atmecs.konakart.utils.ExcelReader;
import com.atmecs.konakart.utils.PropertiesReader;

public class HeroImage extends TestBase {
	LogReporter log=new LogReporter();
	ActionHelper help=new ActionHelper();
	ExcelReader excelread=new ExcelReader();
	HeroPage hero=new HeroPage();
	PropertiesReader propread=new PropertiesReader();
	int a=0;
	@DataProvider(name = "productdata")
	public String[][] getValidationData() throws IOException {
		String Excelarray[][] = null;
		Excelarray = excelread.excelDataProviderArray(FileConstants.PROD_TEST_PATH);
		return Excelarray;
	}
	@Test(dataProvider="productdata")
	public void validateHeroImage(String[] proddata) throws IOException, InterruptedException, ParseException {
		Properties prop=propread.KeyValueLoader(FileConstants.HERO_PATH);
		logger=extentObject.startTest("Validate hero img");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		while(a<1) {
		a=hero.validateHeropPage(driver, prop,proddata,a);
		}
	}
}
