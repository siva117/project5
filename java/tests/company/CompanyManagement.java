package tests.company;

import java.io.IOException;
import java.util.HashMap;

import com.aventstack.extentreports.Status;

import framework.DataUtil;
import framework.Driver;
import framework.GlobalVariables;
import framework.ReporterUtil;
import pages.ILoginPage;
import pages.impl.LoginPage;

public class CompanyManagement {

	public static void main(String[] args) throws Exception {
		
		createNewCompany_public();

	}
	
	
	public static void createNewCompany_public() {
		ReporterUtil reportUtil = new ReporterUtil();
		DataUtil dt = new DataUtil();
		
		reportUtil.initializeReport("RegressionExecution", "Regression");
		
		reportUtil.createTest("createNewCompany_public");
		
		HashMap <String,String> execConfig = dt.getPropertiesData(GlobalVariables.EXECUTION_CONFIG_FILE);
		HashMap <String,String> envInfo  =dt.getPropertiesData(dt.getEnvConfigFile(execConfig.get("env")));
		Driver.createInstace(execConfig.get("browser"), envInfo.get("url"));
		
		ILoginPage loginPage = new LoginPage(Driver.get());
		
		try {
			if (loginPage.isLoginPageDisplayed()) {
				reportUtil.writeLog(Status.PASS, "Application is launched sucessfully.");
			} else {
				reportUtil.writeLog(Status.FAIL, "Application is not launched", "LaunchApp");
				throw new Exception("Login page is not displayed.");
			}
			
			boolean isLoginSuccess = loginPage.login(envInfo.get("username"), envInfo.get("password"));
			
			if (isLoginSuccess) {
				reportUtil.writeLog(Status.PASS, "Successfully logged in.", "Loginpage");
			} else {
				reportUtil.writeLog(Status.FAIL, "Failed to Login.", "Loginpage");
			}
			
			
			
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Driver.quitDriver();
			reportUtil.finalizeReport();
		}
		
		
		
		
		
		
		
		
	}

}
