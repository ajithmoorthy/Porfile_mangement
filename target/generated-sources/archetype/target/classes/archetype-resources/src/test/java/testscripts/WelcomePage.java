#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.testscripts;

import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ${package}.constants.FileConstants;
import ${package}.helper.ActionHelper;
import ${package}.logreports.LogReporter;
import ${package}.pages.KonakartPage;
import ${package}.testbase.TestBase;
import ${package}.utils.ExcelReader;
import ${package}.utils.PropertiesReader;

public class WelcomePage extends TestBase {
	LogReporter log=new LogReporter();
	ActionHelper help=new ActionHelper();
	KonakartPage konakart=new KonakartPage();
	PropertiesReader propread=new PropertiesReader();
	ExcelReader excelread=new ExcelReader();
	@DataProvider(name = "welcomedata")
	public String[][] getValidationData() throws IOException {
		String Excelarray[][] = null;
		Excelarray = excelread.excelDataProviderArray(FileConstants.TEST_PATH);
		return Excelarray;
	}
	@Test(dataProvider="welcomedata")
	public void validateKonakart(String[] data) throws IOException, InterruptedException {
		Properties prop=propread.KeyValueLoader(FileConstants.WELCOME_PATH);
		logger=extentObject.startTest("validate konakart");
		driver.manage().window().maximize();
		konakart.konakartValidate(driver, prop,data);
	}
}
