package com.sandy.sbat.operation.verifyurl;

import org.openqa.selenium.WebDriver;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class VerifyURLSBATCommand implements SBATCommand {

	public SBATResponse execute(SBATRequest request) {
	    
		VerifyURLSBATRequest verifyURLSBATRequest = (VerifyURLSBATRequest)request;
		WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
		System.out.println("Verifying url");
		String expectedURL=verifyURLSBATRequest.getExpectedURL().trim();
		String actualURL=webDriver.getCurrentUrl().trim();
		
		if(actualURL.endsWith("/")){
		    actualURL=actualURL.substring(0,actualURL.length()-1);
		   
		}
		
		if(expectedURL.endsWith("/")){
		    expectedURL=expectedURL.substring(0, expectedURL.length()-1);
		}
		
		if ( actualURL.equals(expectedURL) ) {
		    System.out.println("URL is same as expected");
		}else{
		    System.out.println("URL is not as expected");
		}
		
		return new VerifyURLBATResponse();

	}

}
