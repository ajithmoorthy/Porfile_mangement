#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.testscripts;

import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ${package}.constants.FileConstants;
import ${package}.helper.ActionHelper;
import ${package}.logreports.LogReporter;
import ${package}.pages.HeroPage;
import ${package}.testbase.TestBase;
import ${package}.utils.ExcelReader;
import ${package}.utils.PropertiesReader;

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
		while(a<1) {
		a=hero.validateHeropPage(driver, prop,proddata,a);
		}
	}
}
