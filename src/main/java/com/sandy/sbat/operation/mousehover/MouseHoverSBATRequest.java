package com.sandy.sbat.operation.mousehover;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class MouseHoverSBATRequest implements SBATRequest {

    private String targetElementXPath;

    public SBATCommand getCommand() {
        return new MouseHoverSBATCommand();
    }

    public void initialize(String requestString) {
        targetElementXPath=requestString.trim();
    }

    public String getTargetElementXPath() {
        return targetElementXPath;
    }
    
}
