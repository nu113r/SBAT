package com.sandy.sbat.operation.mousehover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class MouseHoverSBATCommand implements SBATCommand {

    public SBATResponse execute(SBATRequest request) {
        MouseHoverSBATRequest mouseHoverSBATRequest = (MouseHoverSBATRequest)request;
        System.out.println("Performing mouse hover on element whose xpath is"+mouseHoverSBATRequest.getTargetElementXPath());
        WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        WebElement targetElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(mouseHoverSBATRequest.getTargetElementXPath())));
        Actions builder = new Actions(webDriver);
        builder.moveToElement(targetElement).build().perform();
        return new MouseHoverSBATResponse();
    }

}
