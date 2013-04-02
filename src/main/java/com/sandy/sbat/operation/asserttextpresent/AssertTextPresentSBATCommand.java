package com.sandy.sbat.operation.asserttextpresent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class AssertTextPresentSBATCommand implements SBATCommand {

    private static boolean textPresentFlag;
    
    public SBATResponse execute(SBATRequest request) {
        AssertTextPresentSBATRequest assertTextPresentSBATRequest = (AssertTextPresentSBATRequest)request;
        System.out.println("asserting text present '" +  assertTextPresentSBATRequest.getTextToVerify()+ "'");
        WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        textPresentFlag = webDriver.getPageSource().contains(assertTextPresentSBATRequest.getTextToVerify());
        System.out.println("Text Present :: " + textPresentFlag);
        return new AssertTextPresentSBATResponse();
    }

    public boolean getTextPresentFlag() {
        return textPresentFlag;
    }
}